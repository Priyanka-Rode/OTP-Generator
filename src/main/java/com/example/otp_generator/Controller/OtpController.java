package com.example.otp_generator.Controller;

import com.example.otp_generator.Service.EmailService;
import com.example.otp_generator.Service.OtpService;
import com.example.otp_generator.Service.SmsService;
import com.example.otp_generator.dto.OtpRequestDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/otp")
public class OtpController {

    private final OtpService otpService;
    private final EmailService emailService;
    private final SmsService smsService;

    public OtpController(OtpService otpService,
                         EmailService emailService,
                         SmsService smsService) {
        this.otpService = otpService;
        this.emailService = emailService;
        this.smsService = smsService;
    }

    @PostMapping("/send")
    public ResponseEntity<String> sendOtp(@RequestBody OtpRequestDto request) {

        String otp = otpService.generateOtp(request.getEmail());

        emailService.sendOtpEmail(request.getEmail(), otp);
        smsService.sendOtpSms(request.getMobile(), otp);

        return ResponseEntity.ok("OTP sent successfully to Email and Mobile");
    }

    // 📌 Verify OTP
    @PostMapping("/verify")
    public ResponseEntity<String> verifyOtp(@RequestBody OtpRequestDto request) {

        boolean isValid = otpService.verifyOtp(
                request.getEmail(),
                request.getOtp()
        );

        if (isValid) {
            return ResponseEntity.ok("OTP verified successfully");
        } else {
            return ResponseEntity.badRequest().body("Invalid or Expired OTP");
        }
    }
}

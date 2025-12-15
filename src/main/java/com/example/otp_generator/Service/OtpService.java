package com.example.otp_generator.Service;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class OtpService {

    // Store OTP with expiry time (in-memory)
    private final Map<String, OtpData> otpStorage = new ConcurrentHashMap<>();

    private static final int OTP_EXPIRY_MINUTES = 5;

    // Generate OTP
    public String generateOtp(String key) {
        String otp = String.valueOf((int)(Math.random() * 900000) + 100000);
        LocalDateTime expiryTime = LocalDateTime.now().plusMinutes(OTP_EXPIRY_MINUTES);

        otpStorage.put(key, new OtpData(otp, expiryTime));
        return otp;
    }

    // Verify OTP
    public boolean verifyOtp(String key, String userOtp) {
        OtpData otpData = otpStorage.get(key);

        if (otpData == null) {
            return false;
        }

        if (LocalDateTime.now().isAfter(otpData.expiryTime())) {
            otpStorage.remove(key);
            return false;
        }

        boolean isValid = otpData.otp().equals(userOtp);

        if (isValid) {
            otpStorage.remove(key); // OTP used once
        }

        return isValid;
    }

    // Inner record to store OTP data
    private record OtpData(String otp, LocalDateTime expiryTime) {
    }
}

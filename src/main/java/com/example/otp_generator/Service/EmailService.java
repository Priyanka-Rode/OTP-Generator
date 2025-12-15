package com.example.otp_generator.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    // Send OTP to Email
    public void sendOtpEmail(String toEmail, String otp) {

        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(toEmail);
        message.setSubject("Your OTP Code");
        message.setText(
                "Dear User,\n\n" +
                        "Your OTP is: " + otp + "\n" +
                        "This OTP is valid for 5 minutes.\n\n" +
                        "Please do not share your OTP with anyone.\n\n" +
                        "Regards,\nOTP Team"
        );

        mailSender.send(message);
    }
}

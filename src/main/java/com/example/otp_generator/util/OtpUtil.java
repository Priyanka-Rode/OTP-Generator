package com.example.otp_generator.util;

import java.security.SecureRandom;

public class OtpUtil {
    private static final SecureRandom secureRandom = new SecureRandom();
    private static final int OTP_LENGTH = 6;

    private OtpUtil() {
        // Prevent object creation
    }

    // Generate 6-digit OTP
    public static String generateOtp() {

        int bound = (int) Math.pow(10, OTP_LENGTH);
        int otp = secureRandom.nextInt(bound);

        return String.format("%0" + OTP_LENGTH + "d", otp);
    }
}

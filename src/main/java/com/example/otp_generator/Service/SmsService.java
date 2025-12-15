package com.example.otp_generator.Service;


import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import java.util.HashMap;
import java.util.Map;

@Service
public class SmsService {

     //  Send OTP to Mobile via SMS
    public void sendOtpSms(String mobileNumber, String otp) {
        // Here, you would integrate with an actual SMS gateway API
        // For demonstration, we'll just print the OTP to the console
        System.out.println("Sending OTP " + otp + " to mobile number: " + mobileNumber);
    }


}

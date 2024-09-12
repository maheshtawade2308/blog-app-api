package com.bank.project.service;

import com.bank.project.model.Otp;
import com.bank.project.repository.OtpRepository;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.time.LocalDateTime;
import java.util.Random;

@Service
public class OtpService {

    @Value("${twilio.phone.number}")
    private String twilioPhoneNumber;

    private final OtpRepository otpRepository;
    private final Random random = new SecureRandom();

    public OtpService(OtpRepository otpRepository) {
        this.otpRepository = otpRepository;
    }

    
    public String generateOtp(String phoneNumber) {
        String otp = String.format("%04d", random.nextInt(10000));
        Otp otpEntity = new Otp();
        otpEntity.setPhoneNumber(phoneNumber);
        otpEntity.setOtp(otp);
        otpEntity.setCreatedAt(LocalDateTime.now());
        otpRepository.save(otpEntity);

        // Send OTP via Twilio
        sendOtpViaSms(phoneNumber, otp);

        return otp;
    }

    private void sendOtpViaSms(String phoneNumber, String otp) {
        Message.creator(
                new PhoneNumber(phoneNumber),
                new PhoneNumber(twilioPhoneNumber),
                "Your OTP is: " + otp
        ).create();
    }

    public boolean validateOtp(String phoneNumber, String otp) {
        Otp otpEntity = otpRepository.findByPhoneNumber(phoneNumber);
        if (otpEntity != null && otpEntity.getOtp().equals(otp)) {
            return otpEntity.getCreatedAt().isAfter(LocalDateTime.now().minusMinutes(5));
        }
        return false;
    }
}

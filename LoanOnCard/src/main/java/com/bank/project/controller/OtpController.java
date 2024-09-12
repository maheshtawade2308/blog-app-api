package com.bank.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.bank.project.service.OtpService;

@RestController
@RequestMapping("/api/otp")
public class OtpController {

    @Autowired
    private OtpService otpService;

    @PostMapping("/generate")
    public String generateOtp(@RequestParam String phoneNumber) {
        return otpService.generateOtp(phoneNumber);
    }

    @PostMapping("/validate")
    public boolean validateOtp(@RequestParam String phoneNumber, @RequestParam String otp) {
        return otpService.validateOtp(phoneNumber, otp);
    }
}


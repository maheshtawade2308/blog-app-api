package com.bank.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bank.project.model.Otp;

public interface OtpRepository extends JpaRepository<Otp, Long> {

	Otp findByPhoneNumber(String phoneNumber);
}

package com.bank.project.model;


import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Otp {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String phoneNumber;
    private String otp;
    private LocalDateTime createdAt;
    
    
    
	/**
	 * 
	 */
	public Otp() {
	
	}
	/**
	 * @param id
	 * @param phoneNumber
	 * @param otp
	 * @param createdAt
	 */
	public Otp(Long id, String phoneNumber, String otp, LocalDateTime createdAt) {
		super();
		this.id = id;
		this.phoneNumber = phoneNumber;
		this.otp = otp;
		this.createdAt = createdAt;
	}
	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * @return the phoneNumber
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}
	/**
	 * @param phoneNumber the phoneNumber to set
	 */
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	/**
	 * @return the otp
	 */
	public String getOtp() {
		return otp;
	}
	/**
	 * @param otp the otp to set
	 */
	public void setOtp(String otp) {
		this.otp = otp;
	}
	/**
	 * @return the createdAt
	 */
	public LocalDateTime getCreatedAt() {
		return createdAt;
	}
	/**
	 * @param createdAt the createdAt to set
	 */
	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}
	@Override
	public String toString() {
		return "Otp [id=" + id + ", phoneNumber=" + phoneNumber + ", otp=" + otp + ", createdAt=" + createdAt + "]";
	}

    
    
}


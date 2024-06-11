package com.comptask.userManagement.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

// model ==> Repo ==> Service ==> controller

@Entity
@Table(name="User_details")
public class User {
	
	@Id
	@GeneratedValue
	private Integer userId;
	
	@Column(name="USER_NAME")
	private String userName;
	
	@Column(name="USER_EMAIL")
	private String userEmail;
	
	@Column(name="USER_PHONE")
	private int userPhone;
	
	
	//in realtime below fields are added to db created date and updated date
	@Column(name="CREATED_DATE", updatable = false)  // updatable false rakhna hota hai Qki ek bar created date bad me change nhi karti aani chahiye
	private LocalDate createdDate;
	
	@Column(name="UPDATED_DATE", insertable = false)   
	private LocalDate updatedDate;
	
	
	//soft delete ke liye use kiya jata hai
	@Column(name="IS_ACTIVE")
	private Character isActive;
	
	
	
	

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}



	public User(Integer userId, String userName, String userEmail, LocalDate createdDate, LocalDate updatedDate,
			Character isActive) {
		
//		super();  remove super keyword ye company me use nhi hota
		this.userId = userId;
		this.userName = userName;
		this.userEmail = userEmail;
		this.createdDate = createdDate;
		this.updatedDate = updatedDate;
		this.isActive = isActive;
	}



	/**
	 * @return the userId
	 */
	public Integer getUserId() {
		return userId;
	}



	/**
	 * @param userId the userId to set
	 */
	public void setUserId(Integer userId) {
		this.userId = userId;
	}



	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}



	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}



	/**
	 * @return the userEmail
	 */
	public String getUserEmail() {
		return userEmail;
	}



	/**
	 * @param userEmail the userEmail to set
	 */
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}



	/**
	 * @return the createdDate
	 */
	public LocalDate getCreatedDate() {
		return createdDate;
	}



	/**
	 * @param createdDate the createdDate to set
	 */
	public void setCreatedDate(LocalDate createdDate) {
		this.createdDate = createdDate;
	}



	/**
	 * @return the updatedDate
	 */
	public LocalDate getUpdatedDate() {
		return updatedDate;
	}



	/**
	 * @param updatedDate the updatedDate to set
	 */
	public void setUpdatedDate(LocalDate updatedDate) {
		this.updatedDate = updatedDate;
	}



	/**
	 * @return the isActive
	 */
	public Character getIsActive() {
		return isActive;
	}



	/**
	 * @param isActive the isActive to set
	 */
	public void setIsActive(Character isActive) {
		this.isActive = isActive;
	}



	/**
	 * @return the userPhone
	 */
	public int getUserPhone() {
		return userPhone;
	}



	/**
	 * @param userPhone the userPhone to set
	 */
	public void setUserPhone(int userPhone) {
		this.userPhone = userPhone;
	}



	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", userEmail=" + userEmail + ", userPhone="
				+ userPhone + ", createdDate=" + createdDate + ", updatedDate=" + updatedDate + ", isActive=" + isActive
				+ "]";
	}



	
	
	
	
}

package com.comptask.userManagement.config;

import org.apache.logging.log4j.util.StringBuilders;

/**
 * Description: Sending mail with help of google mail provider
 *
 * Feature: Mail sending with gmail providers
 * feature means agar hamare pass bahot sari stories hai to ye kis category ka hai wo mension hota hai
 * 
 * Story : B-4534533 Creating API for sending mail
 * 
 * @author Mahesh Tawade [325245 this is company id]
 * 
 * @since 12  May 2024
 * 
 * @version 1.1
 * 
 *
 */
public class EmailDto {
	
	private Integer id;
	
	private String to;
	
	private String from;
	
	private String subject;
	
	private String text;
	
	

	/**
	 * 
	 */
	public EmailDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	/**
	 * @param id
	 * @param to
	 * @param from
	 * @param subject
	 * @param text
	 */
	public EmailDto(Integer id, String to, String from, String subject, String text) {
		super();
		this.id = id;
		this.to = to;
		this.from = from;
		this.subject = subject;
		this.text = text;
	}


	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the to
	 */
	public String getTo() {
		return to;
	}

	/**
	 * @param to the to to set
	 */
	public void setTo(String to) {
		this.to = to;
	}

	/**
	 * @return the from
	 */
	public String getFrom() {
		return from;
	}

	/**
	 * @param from the from to set
	 */
	public void setFrom(String from) {
		this.from = from;
	}

	/**
	 * @return the subject
	 */
	public String getSubject() {
		return subject;
	}

	/**
	 * @param subject the subject to set
	 */
	public void setSubject(String subject) {
		this.subject = subject;
	}

	/**
	 * @return the text
	 */
	public String getText() {
		return text;
	}

	/**
	 * @param text the text to set
	 */
	public void setText(String text) {
		this.text = text;
	}

	@Override
//	public String toString() {
//		return "EmailDto [id=" + id + ", to=" + to + ", from=" + from + ", subject=" + subject + ", text=" + text + "]";
//	}
	
	// this toString is used in companies
	public String toString() {
		
		StringBuilder stringBuilder = new StringBuilder(); 
		stringBuilder.append("EmailDto [id=" + id);
		stringBuilder.append(", to=" + to);
		stringBuilder.append(", from=" + from);
		stringBuilder.append(", subject=" + subject);
		stringBuilder.append(", text=" + text);
		stringBuilder.append("]");
		return stringBuilder.toString();
	}
	

}

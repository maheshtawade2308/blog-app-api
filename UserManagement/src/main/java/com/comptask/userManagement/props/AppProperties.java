package com.comptask.userManagement.props;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@EnableConfigurationProperties
@ConfigurationProperties("aap1")
@Configuration
public class AppProperties {

	private Map<String,String> messages = new HashMap<>();

	/**
	 * 
	 */
	public AppProperties() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param messages
	 */
	public AppProperties(Map<String, String> messages) {
		super();
		this.messages = messages;
	}

	/**
	 * @return the messages
	 */
	public Map<String, String> getMessages() {
		return messages;
	}

	/**
	 * @param messages the messages to set
	 */
	public void setMessages(Map<String, String> messages) {
		this.messages = messages;
	}
	
	
}

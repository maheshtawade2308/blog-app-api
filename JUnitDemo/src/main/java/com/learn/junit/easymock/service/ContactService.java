package com.learn.junit.easymock.service;

import java.util.List;

import com.learn.junit.easymock.model.Contact;


public interface ContactService {

	public String getNameById(Integer id);
	
	public List<String> getAllContactName();
	
	public Contact getContactById(Integer id);
}

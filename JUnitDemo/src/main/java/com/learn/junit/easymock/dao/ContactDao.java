package com.learn.junit.easymock.dao;

import java.util.List;

import com.learn.junit.easymock.model.Contact;

public interface ContactDao {

	public String findNameById(Integer id);
	
	public List<String> findNames();
	
	public Contact findById(Integer id);
}

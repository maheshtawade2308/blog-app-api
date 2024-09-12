package com.learn.junit.easymock.service;

import java.util.List;

import com.learn.junit.easymock.dao.ContactDao;
import com.learn.junit.easymock.model.Contact;

public class ContactServiceImpl implements ContactService {

	//it is setter injection
	private ContactDao contactDao;
	
	public void setContactDao(ContactDao contactDao) {
		this.contactDao = contactDao;
	}
	
	@Override
	public String getNameById(Integer id) {
		String name = contactDao.findNameById(id);
		String formattedName = name.toUpperCase();
		return formattedName;
	}

	@Override
	public List<String> getAllContactName() {
		List<String> names = contactDao.findNames();
		
		if(names==null) {
			System.out.println("no data found");
		}
		return names;
	}

	@Override
	public Contact getContactById(Integer id) {
		Contact contact = contactDao.findById(id);

		if(contact==null) {
			System.out.println("no data found");
		}
		return contact;
		
	} 

}

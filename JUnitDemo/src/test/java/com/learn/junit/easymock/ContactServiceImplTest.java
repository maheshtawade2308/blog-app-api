package com.learn.junit.easymock;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.easymock.EasyMock;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.learn.junit.easymock.dao.ContactDao;
import com.learn.junit.easymock.model.Contact;
import com.learn.junit.easymock.service.ContactServiceImpl;

class ContactServiceImplTest {
	
	public static ContactServiceImpl contactServiceImpl = null;
	/**
	 * for initializing data before any test case this init folder is created
	 */
	@BeforeAll
	public static void init() {
		
	}
	
	@Test
	public void contactsActualNameSizeServiceImplTest() {
		//created proxy of ContacDao.class
		ContactDao daoProxy = EasyMock.createMock(ContactDao.class);
		
		List<String> names = new ArrayList<>();
		names.add("Mahesh");
		names.add("Ganesh");
		
		EasyMock.expect(daoProxy.findNames()).andReturn(names);
		
		EasyMock.replay(daoProxy);
		
		ContactServiceImpl contactServiceImpl = new ContactServiceImpl();
		contactServiceImpl.setContactDao(daoProxy);
		
		List<String> listNames = contactServiceImpl.getAllContactName();
		
		int expectedNamesSize = 2;
		int actualNamesSize = listNames.size();
		assertEquals(expectedNamesSize, actualNamesSize);
		
	}
	
	@Test
	public void getContactByIdTest() {
		//repo
		ContactDao daoproxy = EasyMock.createMock(ContactDao.class);
		
		Contact contact = new Contact();
		contact.setContactId(101);
		contact.setContactName("Mahesh");
		contact.setContactNumber(957089541);
		
		EasyMock.expect(daoproxy.findById(101)).andReturn(contact);
		EasyMock.replay(daoproxy);
		
		//service
		ContactServiceImpl contactServiceImpl = new ContactServiceImpl();
		contactServiceImpl.setContactDao(daoproxy);
		
		Contact newContact = contactServiceImpl.getContactById(101);
		
		assertEquals(101, newContact.getContactId());
		assertEquals("Mahesh", newContact.getContactName());
		assertEquals(957089541, newContact.getContactNumber());
		
		
	}
	
	@Test
	public void getNameByIdTest() {
		
		ContactDao daoproxy = EasyMock.createMock(ContactDao.class);
		int id = 101;
		String name = "Mahesh";
		EasyMock.expect(daoproxy.findNameById(id)).andReturn(name);
		
		EasyMock.replay(daoproxy);
		
		ContactServiceImpl contactServiceImpl = new ContactServiceImpl();
		contactServiceImpl.setContactDao(daoproxy);
		
		String newName = contactServiceImpl.getNameById(101);
		
		assertEquals("Mahesh", newName);
				
	
	}
	
}

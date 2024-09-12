package com.learn.junit.jmockito.dao;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import org.easymock.Mock;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;

import com.learn.junit.jmockito.entity.Country;
import com.learn.junit.jmockito.service.CountryServiceImpl;

@SpringBootTest(classes = {CountryControllerTest.class})
class CountryControllerTest {
	
	@Mock
	private CountryServiceImpl countryService;
	
	@InjectMocks
	private CountryController controller;

	@Test
	public void addCountryTest() {

		Country country = new Country(1, "India", "Maharashtra");
		when(countryService.addCountry(country)).thenReturn(country);
	}

}

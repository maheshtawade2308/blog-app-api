package com.learn.junit.jmockito.service;



import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.learn.junit.jmockito.entity.Country;

@SpringBootTest(classes = {CountryServiceImplTest.class})
class CountryServiceImplTest {

	@Mock
	private CountryRepository countryRepo;
	
	@InjectMocks
	private CountryServiceImpl serviceImpl;
	
	@Test
	public void getAllCountries() {
		List<Country> list = new ArrayList<>();
		
		list.add(new Country(1, "India", "Maharashtra"));
		list.add(new Country(2, "Canada", "Barrie"));
		
		when(countryRepo.findAll()).thenReturn(list);
		
		
		assertEquals("India", list.get(0).getCountryName());
		assertEquals("Maharashtra", list.get(0).getStateName());
	}
	
	@Test
	public void getCountryByIdTest() {
		List<Country> list = new ArrayList<>();
		
		list.add(new Country(1, "India", "Maharashtra"));
		list.add(new Country(2, "Canada", "Barrie"));
		
		when(countryRepo.findAll()).thenReturn(list);
		
		Country country = serviceImpl.getCountryById(1);
		assertEquals("India", country.getCountryName());
		
	}

	@Test
	public void addCountryTest() {
		
		Country country = new Country(1, "India", "Maharashtra");
		
		when(countryRepo.save(country)).thenReturn(country);
		
		Country country2 = serviceImpl.addCountry(country);
		
		assertEquals(1, country2.getId());
		
	}

// for delete method which returns void we use verify and in time 
// we set how many time that method should be called
	/*
	 * 	Country country = new Country(1, "India", "Maharashtra");
	 * serviceImpl.deleteCountry(country);
	 * 
	 * verify(countryRepo, times(1)).delete(country);
	 */
	

}

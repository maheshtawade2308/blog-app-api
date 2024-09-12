package com.learn.junit.jmockito.service;

import java.util.List;

import com.learn.junit.jmockito.entity.Country;

public interface CountryService {

	public List<Country> getAllCountries();
	
	public Country getCountryById(Integer id);
	
	public Country getCountryByName(String countryName);
	
	public Country addCountry(Country country);
	
	public void deleteCountry(Country country, Integer id);
}

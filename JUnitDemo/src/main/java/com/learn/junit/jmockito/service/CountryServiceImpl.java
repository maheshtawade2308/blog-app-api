package com.learn.junit.jmockito.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learn.junit.jmockito.entity.Country;

@Service
public class CountryServiceImpl implements CountryService {

	@Autowired
	private CountryRepository countryRepo;
	@Override
	public List<Country> getAllCountries() {

		return countryRepo.findAll();
	}

	@Override
	public Country getCountryById(Integer id) {
	List<Country> all= this.countryRepo.findAll();
	
	Country country = null;
	
	for(Country con: all) {
		if(con.getId()==id)
			country = con;
	}
		return country;
	}

	@Override
	public Country getCountryByName(String countryName) {
		// TODO Auto-generated method stub
		return null;
	}

	public Country addCountry(Country country) {
		Country save = countryRepo.save(country);
		return save;
	}

	@Override
	public void deleteCountry(Country country, Integer id) {
		countryRepo.delete(country);
		
	}

}

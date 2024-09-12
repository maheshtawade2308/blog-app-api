package com.learn.junit.jmockito.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.learn.junit.jmockito.entity.Country;
import com.learn.junit.jmockito.service.CountryServiceImpl;

@RestController
public class CountryController {
	
	@Autowired
	private CountryServiceImpl countryService;
	
	@PostMapping("/save")
	public ResponseEntity<Country> addCountry(@RequestBody Country country){
	
		if(country == null) {
			throw new RuntimeException();
		}
		else {
			Country savedCountry = countryService.addCountry(country);
			return new ResponseEntity<Country>(savedCountry, HttpStatus.CREATED);
		}
	}

}

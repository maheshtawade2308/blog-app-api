package com.learn.junit.jmockito.service;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learn.junit.jmockito.entity.Country;

public interface CountryRepository extends JpaRepository<Country, Integer> {

}

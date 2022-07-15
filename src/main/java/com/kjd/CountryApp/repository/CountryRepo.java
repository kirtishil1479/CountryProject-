package com.kjd.CountryApp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kjd.CountryApp.model.CountryApp;


public interface CountryRepo extends JpaRepository<CountryApp, Integer> {
	
	
	public List<CountryApp> findByCountryName(String Name);

}

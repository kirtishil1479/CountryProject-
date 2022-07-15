package com.kjd.CountryApp.service;

import java.util.List;

import com.kjd.CountryApp.model.CountryApp;

public interface ServiceI {
	
	public boolean saveCountry(CountryApp country);
	
	public List<CountryApp> getAllcountries();
	
	public CountryApp getCountryById(Integer id);

	public boolean updateCountry(CountryApp country);

	public List<CountryApp> findByCountryName(String countryName);
	
	public boolean deleteCountry(Integer id);
	

}

package com.kjd.CountryApp.service;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kjd.CountryApp.model.CountryApp;
import com.kjd.CountryApp.repository.CountryRepo;



@Service
public class ServiceImpl implements ServiceI{
	
	@Autowired
	private CountryRepo countryRepo;

	@Override
	public boolean saveCountry(CountryApp country) {
		CountryApp save = this.countryRepo.save(country);
		if(country!=null) {
			return true;
		}
		
		return false;
	}

	@Override
	public List<CountryApp> getAllcountries() {
	    List<CountryApp> list = this.countryRepo.findAll();
		
		return list;
	}



	@Override
	public CountryApp getCountryById(Integer id) {
		Optional<CountryApp> findById = this.countryRepo.findById(id);
		if(findById.isPresent()) {
			CountryApp countryApp = findById.get();
			return countryApp;
		}
		return null;
	}
	

	

	@Override
	public boolean updateCountry(CountryApp country) {
		CountryApp updated = this.countryRepo.save(country);
		if(updated!=null) {
			updated.setId(country.getId());
			updated.setCountryName(country.getCountryName());
			updated.setCountryCapital(country.getCountryCapital());
			
			CountryApp save = this.countryRepo.save(updated);
			return true;
		}
		return false;
	}

	@Override
	public boolean deleteCountry(Integer id) {
		Optional<CountryApp> findById = this.countryRepo.findById(id);
		if(findById.isPresent()) {
			this.countryRepo.deleteById(id);
			return true;
		}
		return false;
	}

	@Override
	public List<CountryApp> findByCountryName(String countryName) {
	    List<CountryApp> name = this.countryRepo.findByCountryName(countryName);
	    if(name!=null) {
	      return name;
	    }
	    
		return null;
	}

	
	}
	
	
	


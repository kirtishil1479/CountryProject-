package com.kjd.CountryApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.kjd.CountryApp.model.CountryApp;
import com.kjd.CountryApp.service.ServiceI;

@RestController
public class Controller {
	
	@Autowired
	private ServiceI serviceI;
	
	@PostMapping("/addnewcountry")
	public ResponseEntity<CountryApp> addNewCountry(@RequestBody CountryApp country){
		boolean save = this.serviceI.saveCountry(country);
		if(save==true) {
			String msg="Successfully Saved";
			
			return new ResponseEntity(msg,HttpStatus.CREATED);
		}
		String msg="Save To Failed";
		return new ResponseEntity(msg,HttpStatus.BAD_REQUEST);	
	}
	
	@GetMapping("/getAllcountries")
	public ResponseEntity<List<CountryApp>> getAllCountries(){
		  List<CountryApp> list = this.serviceI.getAllcountries();
		  if(!list.isEmpty()) {
		
	    	return new ResponseEntity<List<CountryApp>>(list,HttpStatus.OK);
		  }
		    return new ResponseEntity<List<CountryApp>>(HttpStatus.OK);   
	}
	
	@GetMapping("/getByName/{countryName}")
	public ResponseEntity<CountryApp> getByName(@PathVariable String countryName){
		List<CountryApp> CountryName = this.serviceI.findByCountryName(countryName);
		if(CountryName!=null) {
			
		 return new ResponseEntity(CountryName,HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	@GetMapping("/getById/{id}")
	public ResponseEntity<CountryApp> getById(@PathVariable   Integer id){
		CountryApp byId = this.serviceI.getCountryById(id);
		if(byId!=null) {
			return new ResponseEntity<>(byId,HttpStatus.OK);
		}
		
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
	}
	
	@PutMapping("/updateCountry")
	public ResponseEntity<CountryApp> updateCountry(@RequestBody CountryApp country){
		boolean updateCountry = this.serviceI.updateCountry(country);
		if(updateCountry==true) {
			return new ResponseEntity(updateCountry,HttpStatus.OK);
		}
		
		return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
	}
	
	@DeleteMapping("/deleteCountryById/{id}")
	public ResponseEntity<String> deleteCountry(@PathVariable Integer id){
		boolean deleteCountry = this.serviceI.deleteCountry(id);
		if(deleteCountry==true) {
			String msg="Delete Successfully";
		 return new ResponseEntity<>(msg,HttpStatus.OK);
		}
		String msg="Failed to Delete";
		return new ResponseEntity<>(msg,HttpStatus.BAD_REQUEST);
	}
	
	
	
	

}

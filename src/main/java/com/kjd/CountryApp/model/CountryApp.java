package com.kjd.CountryApp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name="COUNTRY_APP")
public class CountryApp {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="COUNTRY_ID")
	private int id;
	
	@Column(name="COUNTRY_NAME")
	private String countryName;
	
	@Column(name="COUNTRY_CAPITAL")
	private String countryCapital;

}

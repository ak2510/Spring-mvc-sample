package com.demo.model.entity.base.ext;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.demo.model.entity.base.BaseEntity;

/**
 * The Class AddressMaster.
 * 
 * @author bsingh4
 */
@Entity
@Table(name = "address_master")
public class AddressMaster extends BaseEntity {

    public long getId() {
	return id;
    }

    public void setId(long id) {
	this.id = id;
    }

    public String getIdentifier() {
	return identifier;
    }

    public void setIdentifier(String identifier) {
	this.identifier = identifier;
    }

    public String getHouseNumber() {
	return houseNumber;
    }

    public void setHouseNumber(String houseNumber) {
	this.houseNumber = houseNumber;
    }

    public String getStreetName() {
	return streetName;
    }

    public void setStreetName(String streetName) {
	this.streetName = streetName;
    }

    public String getLocality() {
	return locality;
    }

    public void setLocality(String locality) {
	this.locality = locality;
    }

    public String getCity() {
	return city;
    }

    public void setCity(String city) {
	this.city = city;
    }

    public String getState() {
	return state;
    }

    public void setState(String state) {
	this.state = state;
    }

    public String getCountry() {
	return country;
    }

    public void setCountry(String country) {
	this.country = country;
    }

    public String getZipCode() {
	return zipCode;
    }

    public void setZipCode(String zipCode) {
	this.zipCode = zipCode;
    }

    public boolean isDefaultAddress() {
	return defaultAddress;
    }

    public void setDefaultAddress(boolean defaultAddress) {
	this.defaultAddress = defaultAddress;
    }


    public AddressMaster() {
	super();
	this.identifier = "";
	this.houseNumber = "";
	this.streetName = "";
	this.locality = "";
	this.city = "";
	this.state = "";
	this.country = "";
	this.zipCode = "";
	this.defaultAddress = false;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "address_master_id")
    private long id = 0;
    @Column(name = "identifier", length = 50, nullable = false)
    private String identifier;
    @Column(name = "house_number", length = 10, nullable = false)
    private String houseNumber;
    @Column(name = "street_name", length = 100, nullable = false)
    private String streetName;
    @Column(name = "locality", length = 50, nullable = false)
    private String locality;
    @Column(name = "city", length = 128, nullable = false)
    private String city;
    @Column(name = "province", length = 50, nullable = false)
    private String state;
    @Column(name = "country", length = 128, nullable = false)
    private String country;
    @Column(name = "zip_code", length = 10, nullable = false)
    private String zipCode;
    @Column(name = "default_address")
    private boolean defaultAddress;
  
}

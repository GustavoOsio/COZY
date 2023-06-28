package com.Cozy.BakendCozy.Entity;

import java.util.List;

public class JsonRealEstate {

public	List<Real_estate>jsonRealEstates;
public	List<Real_estate_amenities>jsonRealEstatesAmenities;
public List<Real_estate> getJsonRealEstates() {
	return jsonRealEstates;
}
public void setJsonRealEstates(List<Real_estate> jsonRealEstates) {
	this.jsonRealEstates = jsonRealEstates;
}
public List<Real_estate_amenities> getJsonRealEstatesAmenities() {
	return jsonRealEstatesAmenities;
}
public void setJsonRealEstatesAmenities(List<Real_estate_amenities> jsonRealEstatesAmenities) {
	this.jsonRealEstatesAmenities = jsonRealEstatesAmenities;
}
public void setRealEstate(Real_estate realEstate) {
	// TODO Auto-generated method stub
	
}
public void setAmenities(List<Real_estate_amenities> relatedAmenities) {
	// TODO Auto-generated method stub
	
}


	
}

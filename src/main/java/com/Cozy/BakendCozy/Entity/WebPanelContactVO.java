package com.Cozy.BakendCozy.Entity;
import java.util.List;

public class WebPanelContactVO {
	
	String name;
	String cellPhone;
	String email;
	String intentions;
	Integer realEstateId;

	List<Intention>interest;
	
	
	public Integer getRealEstateId() {
		return realEstateId;
	}

	public void setRealEstateId(Integer realEstateId) {
		this.realEstateId = realEstateId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCellPhone() {
		return cellPhone;
	}

	public void setCellPhone(String cellPhone) {
		this.cellPhone = cellPhone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getIntentions() {
		return intentions;
	}

	public void setIntentions(String intentions) {
		this.intentions = intentions;
	}

	public List<Intention> getInterest() {
		return interest;
	}

	public void setInterest(List<Intention> interest) {
		this.interest = interest;
	}
	
	
	
	

}

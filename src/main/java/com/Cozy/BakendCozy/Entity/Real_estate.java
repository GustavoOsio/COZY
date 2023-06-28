package com.Cozy.BakendCozy.Entity;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;


@Entity
@Table(name="REAL_ESTATE")
public class Real_estate {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "real_estate_id")
	private Integer realEstateId;
	
	@Column(name = "user_id")
	private Integer userId;
	

	@Column(name = "title")
	@NotEmpty
	private String title;
	
	@Column(name = "description")
	@NotEmpty
	private String description;
	
	@Column(name = "real_estate_type")
	@NotEmpty
	private String realEstateType;
	
	@Column(name = "location")
	@NotEmpty
	private String location;
	
	@Column(name = "price")
	private Double price;
	
	@Column(name = "address")
	@NotEmpty
	private String address;
	
	@Column(name = "session_id")
	private Integer sessionId;
	
	@Column(name = "created_at")
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdAt = new Date(System.currentTimeMillis());
	
	@Column(name = "updated_at")
	@Temporal(TemporalType.TIMESTAMP)
	private Date updatedAt = new Date(System.currentTimeMillis());

	
	
	public Integer getSessionId() {
		return sessionId;
	}

	public void setSessionId(Integer sessionId) {
		this.sessionId = sessionId;
	}

	public Integer getRealEstateId() {
		return realEstateId;
	}

	public void setRealEstateId(Integer realEstateId) {
		this.realEstateId = realEstateId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}




	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}



	public String getRealEstateType() {
		return realEstateType;
	}

	public void setRealEstateType(String realEstateType) {
		this.realEstateType = realEstateType;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	
	
	

}

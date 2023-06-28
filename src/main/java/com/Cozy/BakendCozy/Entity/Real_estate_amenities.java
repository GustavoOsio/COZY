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
@Table(name = "REAL_ESTATE_AMENITIES")
public class Real_estate_amenities {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "amenity_id")
	private Integer amenityId;

	@Column(name = "real_estate_id")
	private Integer realEstateId;

	@Column(name = "name")
	@NotEmpty
	private String name;

	@Column(name = "description")
	@NotEmpty
	private String description;

	@Column(name = "type ")
	@NotEmpty
	private String type;

	@Column(name = "spam ")
	@NotEmpty
	private String spam;
	
	@Column(name = "status")
	@NotEmpty
	private String status;


	
	@Column(name = "created_at")
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdAt = new Date(System.currentTimeMillis());
	
	@Column(name = "updated_at")
	@Temporal(TemporalType.TIMESTAMP)
	private Date updatedAt = new Date(System.currentTimeMillis());
	
	@Column(name = "session_id")
	private Integer sessionId;
	
	

	public Integer getSessionId() {
		return sessionId;
	}



	public void setSessionId(Integer sessionId) {
		this.sessionId = sessionId;
	}



	public Integer getAmenityId() {
		return amenityId;
	}

	
	
	public void setAmenityId(Integer amenityId) {
		this.amenityId = amenityId;
	}

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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
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



	public String getSpam() {
		return spam;
	}



	public void setSpam(String spam) {
		this.spam = spam;
	}
	
	
	
	

}

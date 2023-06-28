package com.Cozy.BakendCozy.Entity;

import java.sql.Time;
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
@Table(name = "SHEDULLE")
public class Shedulle {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "shedulle_id")
	private Integer shedulleId;

	@Column(name = "real_estate_id")
	private Integer realEstateId;
		
	@Column(name = "user_id")
	private Integer userId;
	
	@Column(name = "realestate_interest_prospect_id")
	private Integer prospectId;
	
	@Column(name = "date")
	private Date dateF;
	
	@Column(name = "time")
	private Time timeT;
	
	@Column(name = "status")
	@NotEmpty
	private String status;
	
	@Column(name = "created_at")
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdAt = new Date(System.currentTimeMillis());
	
	@Column(name = "updated_at")
	@Temporal(TemporalType.TIMESTAMP)
	private Date updatedAt = new Date(System.currentTimeMillis());

	public Integer getShedulleId() {
		return shedulleId;
	}

	public void setShedulleId(Integer shedulleId) {
		this.shedulleId = shedulleId;
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



	public Integer getProspectId() {
		return prospectId;
	}

	public void setProspectId(Integer prospectId) {
		this.prospectId = prospectId;
	}

	public Date getDateF() {
		return dateF;
	}

	public void setDateF(Date dateF) {
		this.dateF = dateF;
	}

	public Time getTimeT() {
		return timeT;
	}

	public void setTimeT(Time timeT) {
		this.timeT = timeT;
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
	
	

}

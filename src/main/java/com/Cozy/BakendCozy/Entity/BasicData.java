package com.Cozy.BakendCozy.Entity;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import java.sql.Timestamp;
import java.util.Date;

@Entity
@Table(name = "BASIC_DATA")
public class BasicData {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "name", length = 255)
    private String name;

    @Column(name = "last_name", length = 255)
    private String lastName;

    @Column(name = "birth_date")
    private Date birthDate;

    @Column(name = "birth_country", length = 255)
    private String birthCountry;

    @Column(name = "birth_city", length = 255)
    private String birthCity;

    @Column(name = "entry_origin", length = 255)
    private String entryOrigin;

    @Column(name = "entry_date")
    private Date entryDate;

    @Column(name = "identification_type", length = 255)
    private String identificationType;

    @Column(name = "identification_number", length = 255)
    private String identificationNumber;

    @Column(name = "status", length = 255)
    private String status;

    @Column(name = "cozy_code", length = 255)
    private String cozyCode;

    @Column(name = "created_at")
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdAt = new Date(System.currentTimeMillis());
	
	@Column(name = "updated_at")
	@Temporal(TemporalType.TIMESTAMP)
	private Date updatedAt = new Date(System.currentTimeMillis());

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public String getBirthCountry() {
		return birthCountry;
	}

	public void setBirthCountry(String birthCountry) {
		this.birthCountry = birthCountry;
	}

	public String getBirthCity() {
		return birthCity;
	}

	public void setBirthCity(String birthCity) {
		this.birthCity = birthCity;
	}

	public String getEntryOrigin() {
		return entryOrigin;
	}

	public void setEntryOrigin(String entryOrigin) {
		this.entryOrigin = entryOrigin;
	}

	public Date getEntryDate() {
		return entryDate;
	}

	public void setEntryDate(Date entryDate) {
		this.entryDate = entryDate;
	}

	public String getIdentificationType() {
		return identificationType;
	}

	public void setIdentificationType(String identificationType) {
		this.identificationType = identificationType;
	}

	public String getIdentificationNumber() {
		return identificationNumber;
	}

	public void setIdentificationNumber(String identificationNumber) {
		this.identificationNumber = identificationNumber;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCozyCode() {
		return cozyCode;
	}

	public void setCozyCode(String cozyCode) {
		this.cozyCode = cozyCode;
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

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

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

@Entity
@Table(name = "realestate_interest_prospect")
public class RealEstateInterestProspect {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "id")
	private Integer id;

    @Column(name = "real_estate_id")
    private int realEstateId;

    @Column(name = "user_id")
    private int userId;


    @Column(name = "intention_type", length = 100)
    private String intentionType;

    @Column(name = "apartment_house", length = 100)
    private String apartmentHouse;

    @Column(name = "co_ownership", length = 100)
    private String coOwnership;

    @Column(name = "city_location", length = 150)
    private String cityLocation;

    @Column(name = "country_location", length = 100)
    private String countryLocation;

    @Column(name = "address_location", length = 100)
    private String addressLocation;

    @Column(name = "budget", precision = 10, scale = 2)
    private BigDecimal budget;

    @Column(name = "intention_message", columnDefinition = "text")
    private String intentionMessage;

    @Column(name = "comment", columnDefinition = "text")
    private String comment;

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

	public int getRealEstateId() {
		return realEstateId;
	}

	public void setRealEstateId(int realEstateId) {
		this.realEstateId = realEstateId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}


	public String getIntentionType() {
		return intentionType;
	}

	public void setIntentionType(String intentionType) {
		this.intentionType = intentionType;
	}

	public String getApartmentHouse() {
		return apartmentHouse;
	}

	public void setApartmentHouse(String apartmentHouse) {
		this.apartmentHouse = apartmentHouse;
	}

	public String getCoOwnership() {
		return coOwnership;
	}

	public void setCoOwnership(String coOwnership) {
		this.coOwnership = coOwnership;
	}

	public String getCityLocation() {
		return cityLocation;
	}

	public void setCityLocation(String cityLocation) {
		this.cityLocation = cityLocation;
	}

	public String getCountryLocation() {
		return countryLocation;
	}

	public void setCountryLocation(String countryLocation) {
		this.countryLocation = countryLocation;
	}

	public String getAddressLocation() {
		return addressLocation;
	}

	public void setAddressLocation(String addressLocation) {
		this.addressLocation = addressLocation;
	}

	public BigDecimal getBudget() {
		return budget;
	}

	public void setBudget(BigDecimal budget) {
		this.budget = budget;
	}

	public String getIntentionMessage() {
		return intentionMessage;
	}

	public void setIntentionMessage(String intentionMessage) {
		this.intentionMessage = intentionMessage;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
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


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
@Table(name = "CONTACT_USER")
public class ContactUser {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "id")
	private Integer id;
	
	 @Column(name = "cellphone", length = 20)
	    private String cellphone;

	    @Column(name = "email", length = 100)
	    private String email;

	    @Column(name = "residence_city", length = 100)
	    private String residenceCity;

	    @Column(name = "residence_country", length = 100)
	    private String residenceCountry;

	    @Column(name = "residence_address", length = 100)
	    private String residenceAddress;

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

		public String getCellphone() {
			return cellphone;
		}

		public void setCellphone(String cellphone) {
			this.cellphone = cellphone;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getResidenceCity(String string) {
			return residenceCity;
		}

		public void setResidenceCity(String residenceCity) {
			this.residenceCity = residenceCity;
		}

		public String getResidenceCountry() {
			return residenceCountry;
		}

		public void setResidenceCountry(String residenceCountry) {
			this.residenceCountry = residenceCountry;
		}

		public String getResidenceAddress() {
			return residenceAddress;
		}

		public void setResidenceAddress(String residenceAddress) {
			this.residenceAddress = residenceAddress;
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

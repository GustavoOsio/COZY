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
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;



@Entity
@Table(name = "USER")
public class User {
	 	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "user_id")
	private Integer userId;
	
	@Column(name = "id_rol")
	private Integer idRol;
	
	@Column(name = "basic_data_id")
	private Integer idBasicData;
	
	@Column(name = "contact_user_id")
	private Integer idContact;
		
	@Column(name = "user")
	@NotEmpty
	private String user;
	
	@Column(name = "password")
	@NotEmpty
	private String password;
	
	@Column(name = "status")
	@NotEmpty
	private String status;

		
	@Column(name = "created_at")
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdAt = new Date(System.currentTimeMillis());
	
	@Column(name = "updated_at")
	@Temporal(TemporalType.TIMESTAMP)
	private Date updatedAt = new Date(System.currentTimeMillis());

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	
	

	public Integer getIdRol() {
		return idRol;
	}

	public void setIdRol(Integer idRol) {
		this.idRol = idRol;
	}



	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
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

	public Integer getIdBasicData() {
		return idBasicData;
	}

	public void setIdBasicData(Integer idBasicData) {
		this.idBasicData = idBasicData;
	}

	public Integer getIdContact() {
		return idContact;
	}

	public void setIdContact(Integer idContact) {
		this.idContact = idContact;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}


	
	
	

}

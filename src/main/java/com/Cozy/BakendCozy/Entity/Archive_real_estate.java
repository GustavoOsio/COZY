package com.Cozy.BakendCozy.Entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="ARCHIVE_REAL_ESTATE")
public class Archive_real_estate {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "id")
	private Integer id;

	@Column(name = "real_estate_id")
	private Integer realEstateId;

	@Column(name = "archive_id")
	private Integer archiveId;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getRealEstateId() {
		return realEstateId;
	}

	public void setRealEstateId(Integer realEstateId) {
		this.realEstateId = realEstateId;
	}

	public Integer getArchiveId() {
		return archiveId;
	}

	public void setArchiveId(Integer archiveId) {
		this.archiveId = archiveId;
	}
	
	
	
	

}

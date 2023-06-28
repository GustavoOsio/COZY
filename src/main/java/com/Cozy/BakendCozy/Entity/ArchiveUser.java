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
@Table(name = "ARCHIVE_USER")
public class ArchiveUser {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "id")
	private Integer id;
	
	
	@Column(name = "user_id")
    private int userId;

    @Column(name = "archive_id")
    private int archiveId;

    @Column(name = "type", length = 30)
    private String type;

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

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getArchiveId() {
		return archiveId;
	}

	public void setArchiveId(int archiveId) {
		this.archiveId = archiveId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
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

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
@Table(name="SESSION")
public class Session {

    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "session_id")
	private Integer sessionId;

    @Column(name="user_id")
    private Integer userId;

    @Column(name="start_date_time")
    private Date startDateTime = new Date(System.currentTimeMillis());

    @Column (name="end_date_time")
    private Date endDateTime;

    @Column(name="duration")
    private Time duration;

    @Column(name="ip")
    private String ipConexion;

	public Integer getSessionId() {
		return sessionId;
	}

	public void setSessionId(Integer sessionId) {
		this.sessionId = sessionId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Date getStartDateTime() {
		return startDateTime;
	}

	public void setStartDateTime(Date startDateTime) {
		this.startDateTime = startDateTime;
	}

	public Date getEndDateTime() {
		return endDateTime;
	}

	public void setEndDateTime(Date endDateTime) {
		this.endDateTime = endDateTime;
	}

	public Time getDuration() {
		return duration;
	}

	public void setDuration(Time duration) {
		this.duration = duration;
	}

	public String getIpConexion() {
		return ipConexion;
	}

	public void setIpConexion(String ipConexion) {
		this.ipConexion = ipConexion;
	}

  

    
   

    
}

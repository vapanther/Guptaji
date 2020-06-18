package com.tvu.Metadata_BE.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "sources", catalog = "tvu")
public class Sources implements java.io.Serializable{

	@Id
	private String id;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "sessionid")
	private Session session;
	@Column(name="name")
	private String Name;
	@Column(name="starttime")
	private Long StartTime;
	@Column(name="endtime")
	private Long StopTime;
	@Column(name="status")
	private Integer status;


	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Session getSession() {
		return session;
	}
	public void setSession(Session session) {
		this.session = session;
	}



	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}

	public Long getStartTime() {
		return StartTime;
	}
	public void setStartTime(Long Long) {
		StartTime = Long;
	}

	public Long getStopTime() {
		return StopTime;
	}
	public void setStopTime(Long stopTime) {
		StopTime = stopTime;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer integer) {
		this.status = integer;
	}

}

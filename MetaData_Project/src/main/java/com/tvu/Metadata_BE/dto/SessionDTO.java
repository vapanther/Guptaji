package com.tvu.Metadata_BE.dto;

public class SessionDTO implements java.io.Serializable{
	private String id;
	private String Title;
	private String Description;
	private String ProducedBy;
	private Integer Status;
	private Long StartTime;
	private Long EndTime;
	private String PlaceRootPath;

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitle() {
		return Title;
	}
	public void setTitle(String title) {
		Title = title;
	}

	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}

	public Integer getStatus() {
		return Status;
	}

	public String getProducedBy() {
		return ProducedBy;
	}
	public void setProducedBy(String producedBy) {
		ProducedBy = producedBy;
	}
	public void setStatus(Integer integer) {
		Status = integer;
	}

	public Long getStartTime() {
		return StartTime;
	}
	public void setStartTime(Long long1) {
		StartTime = long1;
	}

	public Long getEndTime() {
		return EndTime;
	}
	public void setEndTime(Long date) {
		EndTime = date;
	}
	public String getPlaceRootPath() {
		return PlaceRootPath;
	}
	public void setPlaceRootPath(String placeRootPath) {
		PlaceRootPath = placeRootPath;
	}
}

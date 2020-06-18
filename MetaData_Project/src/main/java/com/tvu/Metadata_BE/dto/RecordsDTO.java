package com.tvu.Metadata_BE.dto;

import java.util.Date;

public class RecordsDTO {
	private String ID;
	private String Title;
	private String Tags;
	private Long StartTimeStamp;
	private Long EndTimeStamp;
	
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public String getTitle() {
		return Title;
	}
	public void setTitle(String title) {
		Title = title;
	}
	public String getTags() {
		return Tags;
	}
	public void setTags(String tags) {
		Tags = tags;
	}
	public Long getStartTimeStamp() {
		return StartTimeStamp;
	}
	public void setStartTimeStamp(Long startTimeStamp) {
		StartTimeStamp = startTimeStamp;
	}
	public Long getEndTimeStamp() {
		return EndTimeStamp;
	}
	public void setEndTimeStamp(Long endTimeStamp) {
		EndTimeStamp = endTimeStamp;
	}
	

}

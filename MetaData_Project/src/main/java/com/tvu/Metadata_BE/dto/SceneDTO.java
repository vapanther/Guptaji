package com.tvu.Metadata_BE.dto;

public class SceneDTO {
	private String AssociatedSource;
	private Long StartTimeStamp;
	private Long EndTimeStamp; 

	public String getAssociatedSource() {
		return AssociatedSource;
	}
	public void setAssociatedSource(String associatedSource) {
		AssociatedSource = associatedSource;
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

package com.tvu.Metadata_BE.dto;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonAutoDetect(fieldVisibility=JsonAutoDetect.Visibility.ANY, getterVisibility=JsonAutoDetect.Visibility.NONE,
setterVisibility=JsonAutoDetect.Visibility.NONE, creatorVisibility=JsonAutoDetect.Visibility.NONE)
public class SceneDTO {
	@JsonProperty("AssociatedSource")
	private String AssociatedSource;
	@JsonProperty("StartTimestamp")
	private Long StartTimeStamp;
	@JsonProperty("EndTimestamp")
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

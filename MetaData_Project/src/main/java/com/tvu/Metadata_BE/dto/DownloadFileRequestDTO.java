package com.tvu.Metadata_BE.dto;

public class DownloadFileRequestDTO {

	private String sessionid;
	private String recordid;
	public String getSessionid() {
		return sessionid;
	}
	public void setSessionid(String sessionid) {
		this.sessionid = sessionid;
	}
	public String getRecordid() {
		return recordid;
	}
	public void setRecordid(String recordid) {
		this.recordid = recordid;
	}



}

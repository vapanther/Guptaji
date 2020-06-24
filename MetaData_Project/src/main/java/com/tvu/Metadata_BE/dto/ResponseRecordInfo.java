package com.tvu.Metadata_BE.dto;

import java.util.List;

public class ResponseRecordInfo {
	private String Sessionid;
	private String ErrorCode;
	private String ErrorMessage;
	private List<RecordsDTO> records;
	
	public String getSessionid() {
		return Sessionid;
	}
	public void setSessionid(String sessionid) {
		Sessionid = sessionid;
	}
	public String getErrorCode() {
		return ErrorCode;
	}
	public void setErrorCode(String errorCode) {
		ErrorCode = errorCode;
	}
	public String getErrorMessage() {
		return ErrorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		ErrorMessage = errorMessage;
	}
	public List<RecordsDTO> getRecords() {
		return records;
	}
	public void setRecords(List<RecordsDTO> records) {
		this.records = records;
	}
	
	

}

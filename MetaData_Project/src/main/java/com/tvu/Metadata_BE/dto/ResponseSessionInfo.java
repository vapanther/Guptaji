package com.tvu.Metadata_BE.dto;

import java.util.List;

public class ResponseSessionInfo {

	private String userid;
	private String ErrorCode;
	private String ErrorMessage;
	private Integer count;
	private List<SessionDTO> sessionInfo;
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer i) {
		this.count = i;
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
	public List<SessionDTO> getSessionInfo() {
		return sessionInfo;
	}
	public void setSessionInfo(List<SessionDTO> sessionInfo) {
		this.sessionInfo = sessionInfo;
	}

}

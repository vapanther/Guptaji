package com.tvu.Metadata_BE.dto;

import java.util.List;

public class ResponseSessionInfo {

	private String userid;
	private String ErrorCode;
	private String ErrorMessage;
	private String SessionId;
	private List<SessionDTO> sessionInfo;
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
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
	public String getSessionId() {
		return SessionId;
	}
	public void setSessionId(String sessionId) {
		SessionId = sessionId;
	}
	public List<SessionDTO> getSessionInfo() {
		return sessionInfo;
	}
	public void setSessionInfo(List<SessionDTO> sessionInfo) {
		this.sessionInfo = sessionInfo;
	}

}

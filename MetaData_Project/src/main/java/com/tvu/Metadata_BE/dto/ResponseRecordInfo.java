package com.tvu.Metadata_BE.dto;

import java.util.List;

public class ResponseRecordInfo {
	private String userid;
	private List<RecordsDTO> records;
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public List<RecordsDTO> getRecords() {
		return records;
	}
	public void setRecords(List<RecordsDTO> records) {
		this.records = records;
	}
	
	

}

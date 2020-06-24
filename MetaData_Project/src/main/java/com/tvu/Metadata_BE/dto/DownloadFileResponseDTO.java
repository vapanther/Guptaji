package com.tvu.Metadata_BE.dto;

public class DownloadFileResponseDTO {
	
	private String cmdPath;
	private String bucketName;
	private String localSytemPath;
	private String path;
	private String starttimestamp;
	private String endtimestamp;
	private String filename;
	
	public String getCmdPath() {
		return cmdPath;
	}
	public void setCmdPath(String cmdPath) {
		this.cmdPath = cmdPath;
	}
	public String getBucketName() {
		return bucketName;
	}
	public void setBucketName(String bucketName) {
		this.bucketName = bucketName;
	}
	public String getLocalSytemPath() {
		return localSytemPath;
	}
	public void setLocalSytemPath(String localSytemPath) {
		this.localSytemPath = localSytemPath;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public String getStarttimestamp() {
		return starttimestamp;
	}
	public void setStarttimestamp(String starttimestamp) {
		this.starttimestamp = starttimestamp;
	}
	public String getEndtimestamp() {
		return endtimestamp;
	}
	public void setEndtimestamp(String endtimestamp) {
		this.endtimestamp = endtimestamp;
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	
}

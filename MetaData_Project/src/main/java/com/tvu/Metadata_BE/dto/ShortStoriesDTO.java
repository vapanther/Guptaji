package com.tvu.Metadata_BE.dto;

import java.util.List;

public class ShortStoriesDTO {
	
	private String ID;
	private String Title;
	private String Tags;
	private String Aurthor;
	private Long CreatedAt;
	private String FrontCover;
	private List<SceneDTO> Scenes;
	
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
	public String getAurthor() {
		return Aurthor;
	}
	public void setAurthor(String aurthor) {
		Aurthor = aurthor;
	}
	public Long getCreatedAt() {
		return CreatedAt;
	}
	public void setCreatedAt(Long createdAt) {
		CreatedAt = createdAt;
	}
	public String getFrontCover() {
		return FrontCover;
	}
	public void setFrontCover(String frontCover) {
		FrontCover = frontCover;
	}
	public List<SceneDTO> getScenes() {
		return Scenes;
	}
	public void setScenes(List<SceneDTO> scenes) {
		Scenes = scenes;
	}

}

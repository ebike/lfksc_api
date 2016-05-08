package com.lfksc.api.model;

public class SortsInfoModel {

	//分类ID
	private Long id;
	//分类名称
	private String name;
	//分类图片地址
	private String imageUrl;
	
	public SortsInfoModel() {
		super();
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	
}

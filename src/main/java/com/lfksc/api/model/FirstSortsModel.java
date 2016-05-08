package com.lfksc.api.model;

/**
 * 常见字段的类
 * 如：这个类有20个常用字段，需要用到其中一部分的时候就可以用该类。
 */
public class FirstSortsModel {

	//唯一标识
	private Long id;
	//名称
	private String name;
	
	public FirstSortsModel() {
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
	
}

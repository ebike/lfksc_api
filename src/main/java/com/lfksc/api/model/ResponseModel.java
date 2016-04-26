package com.lfksc.api.model;

public class ResponseModel<T> {
	//响应码：0代表失败，1代表成功
	private String code;
	//响应信息
	private String message;
	//返回的json数据
	private T data;
	
	public ResponseModel() {
		super();
	}
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	
	
}

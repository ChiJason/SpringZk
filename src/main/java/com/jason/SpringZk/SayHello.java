package com.jason.SpringZk;

public class SayHello {

	private String message;	
	private Integer count;
	
	public SayHello(String message, Integer count){
		this.message = message;
		this.count = count;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}
	
}

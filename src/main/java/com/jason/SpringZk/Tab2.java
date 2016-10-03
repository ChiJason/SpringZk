package com.jason.SpringZk;

import java.util.Date;

public class Tab2 {
	
	private String tb2Message;
	private Date date;
	private Users[] usersArray;
	
	public Tab2(){
		
	}
	
	public Tab2(String message){
		this.tb2Message = message;
	}

	public String getTb2Message() {
		return tb2Message;
	}

	public void setTb2Message(String tb2Message) {
		this.tb2Message = tb2Message;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Users[] getUsersArray() {
		return usersArray;
	}

	public void setUsersArray(Users[] usersArray) {
		this.usersArray = usersArray;
	}
}

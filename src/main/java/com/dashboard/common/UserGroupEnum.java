package com.dashboard.common;

public enum UserGroupEnum {

	SK(0);
	
	private int id;
	
	UserGroupEnum(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
	
}

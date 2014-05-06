package com.hcb.domains;

public abstract class PersonInfo extends BasicInfo {
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}

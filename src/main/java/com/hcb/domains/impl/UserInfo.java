package com.hcb.domains.impl;

import com.hcb.commons.Consts;
import com.hcb.domains.PersonInfo;

/**
 * User information<br />
 * 
 * @author range
 * 
 */
public class UserInfo extends PersonInfo {
	private int type;

	private String userName;

	private String password;

	private String mobile;

	private String email;

	private String address;

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder(
				"-------------- User Information --------------")
				.append(Consts.FILE_LINE_SEPARATOR);
		sb.append("User ID: ").append(this.getId())
				.append(Consts.FILE_LINE_SEPARATOR);
		sb.append("User name: ").append(this.getName())
				.append(Consts.FILE_LINE_SEPARATOR);
		sb.append("User type: ");
		int type = this.getType();
		if (type == Consts.USER_TYPE_CLERK)
			sb.append("clerk").append(Consts.FILE_LINE_SEPARATOR);
		else if (type == Consts.USER_TYPE_MANAGER)
			sb.append("manager").append(Consts.FILE_LINE_SEPARATOR);

		sb.append("User nickname: ").append(this.getUserName())
				.append(Consts.FILE_LINE_SEPARATOR);
		sb.append("User password: ").append(this.getPassword())
				.append(Consts.FILE_LINE_SEPARATOR);
		sb.append("User mobile: ").append(this.getMobile())
				.append(Consts.FILE_LINE_SEPARATOR);
		sb.append("User email").append(this.getEmail())
				.append(Consts.FILE_LINE_SEPARATOR);
		sb.append("User address: ").append(this.getAddress())
				.append(Consts.FILE_LINE_SEPARATOR);

		return sb.toString();
	}
}

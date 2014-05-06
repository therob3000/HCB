package com.hcb.domains.impl;

import com.hcb.commons.Consts;
import com.hcb.domains.PersonInfo;

/**
 * Customer information<br />
 * 
 * @author range
 * 
 */
public class MemberInfo extends PersonInfo {
	private String cardId;

	private double account;

	private String rentBookIdOne;

	private String rentBookIdTwo;

	public String getCardId() {
		return cardId;
	}

	public void setCardId(String cardId) {
		this.cardId = cardId;
	}

	public double getAccount() {
		return account;
	}

	public void setAccount(double account) {
		this.account = account;
	}

	public String getRentBookIdOne() {
		return rentBookIdOne;
	}

	public void setRentBookIdOne(String rentBookIdOne) {
		this.rentBookIdOne = rentBookIdOne;
	}

	public String getRentBookIdTwo() {
		return rentBookIdTwo;
	}

	public void setRentBookIdTwo(String rentBookIdTwo) {
		this.rentBookIdTwo = rentBookIdTwo;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder(
				"-------------- Member Information --------------")
				.append(Consts.FILE_LINE_SEPARATOR);
		sb.append("Member ID: ").append(this.getId())
				.append(Consts.FILE_LINE_SEPARATOR);
		sb.append("Member name: ").append(this.getName())
				.append(Consts.FILE_LINE_SEPARATOR);
		sb.append("Member card ID: ").append(this.getCardId())
				.append(Consts.FILE_LINE_SEPARATOR);
		sb.append("Member account: ").append(this.getAccount())
				.append(Consts.FILE_LINE_SEPARATOR);
		sb.append("Member book renting 1: ").append(this.getRentBookIdOne())
				.append(Consts.FILE_LINE_SEPARATOR);
		sb.append("Member book rentint 2: ").append(this.getRentBookIdTwo())
				.append(Consts.FILE_LINE_SEPARATOR);

		return sb.toString();
	}
}

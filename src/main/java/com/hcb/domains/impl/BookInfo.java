package com.hcb.domains.impl;

import com.hcb.commons.Consts;
import com.hcb.domains.BasicInfo;

/**
 * Book information<br />
 * 
 * @author range
 * 
 */
public class BookInfo extends BasicInfo {
	private String name;

	private double price;

	private int status;

	
	private int grade;

	private String date;
	
	private int duration;


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}


	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder(
				"-------------- Book Information --------------\n")
				.append(Consts.FILE_LINE_SEPARATOR);
		sb.append("Book ID: ").append(this.getId())
				.append(Consts.FILE_LINE_SEPARATOR);
		sb.append("Book Name: ").append(this.getName())
				.append(Consts.FILE_LINE_SEPARATOR);
		sb.append("Book price: ").append(this.getPrice())
				.append(Consts.FILE_LINE_SEPARATOR);
		sb.append("Book grade: ").append(this.grade).append(Consts.FILE_LINE_SEPARATOR);
		sb.append("Book status: ");
		int status = this.getStatus();
		if (status == Consts.STATUS_BOOK_AVAILABLE)
			sb.append("Available").append(Consts.FILE_LINE_SEPARATOR);
		else if (status == Consts.STATUS_BOOK_RENT_OUT)
			sb.append("Rented out").append(Consts.FILE_LINE_SEPARATOR);
		else if (status == Consts.STATUS_BOOK_SALE_OUT)
			sb.append("Sold out").append(Consts.FILE_LINE_SEPARATOR);

		sb.append("Book rented/sold out date: ").append(this.getDate())
				.append(Consts.FILE_LINE_SEPARATOR);
		if (status == Consts.STATUS_BOOK_RENT_OUT)
			sb.append("Book renting duration: ").append(this.getDuration()).append(Consts.FILE_LINE_SEPARATOR);

		return sb.toString();
	}
}

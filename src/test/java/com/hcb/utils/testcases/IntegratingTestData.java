package com.hcb.utils.testcases;

import java.util.*;

import static org.junit.Assert.*;

import org.junit.Test;

import com.hcb.commons.Consts;
import com.hcb.data.impl.BookDataRW;
import com.hcb.data.impl.MemberDataRW;
import com.hcb.data.impl.UserDataRW;
import com.hcb.domains.impl.*;

/**
 * Test of data reading and writing functions<br />
 * 
 * @author range
 * 
 */
public class IntegratingTestData {
//	@Test
	public void testUserDataReading() {
		Vector<UserInfo> users = new UserDataRW().readDataFromFile("data/user.data");
		
		for (UserInfo user : users) {
			System.out.println(user.toString());
		}
	}

	 @Test
	public void testMemberDataReading() {
		Vector<MemberInfo> members = new MemberDataRW()
				.readDataFromFile("data/member.data");

		for (MemberInfo member : members) {
			System.out.println(member.toString());
		}
	}

	// @Test
	public void testMemberDataWriting() {
		Vector<MemberInfo> members = new Vector<>();

		MemberInfo member = setMember("M1023", "Davis Millham", "C62007615",
				125.00, "", "");
		members.add(member);
		member = setMember("M1024", "Lingoes Gillingham", "C62247812", -20.00,
				"TP310410510", "TP310410511");
		members.add(member);
		member = setMember("M2048", "William Gillingham", "C62247811", 43.01,
				"TP310410512", "");
		members.add(member);
		member = setMember("M1039", "Diaos Diaosman", "C62001111", 11.11,
				"TP240011001", "");
		members.add(member);

		new MemberDataRW().writeDataToFile(members, "data/member.data");
	}

	private MemberInfo setMember(String id, String name, String cardId,
			double account, String rentBookIdOne, String rentBookIdTwo) {
		MemberInfo member = new MemberInfo();
		member.setId(id);
		member.setName(name);
		member.setCardId(cardId);
		member.setAccount(account);
		member.setRentBookIdOne(rentBookIdOne);
		member.setRentBookIdTwo(rentBookIdTwo);

		return member;
	}

//	 @Test
	public void testBookDataReading() {
		Vector<BookInfo> books = new BookDataRW()
				.readDataFromFile("data/book.data");

		for (BookInfo book : books) {
			System.out.println(book.toString());
		}

	}

//	 @Test
	public void testBookDataWriting() {
		Vector<BookInfo> books = new Vector<>();

		BookInfo bookNew = setBook("TP310113114", "C++ Primer", 2.99,
				Consts.STATUS_BOOK_RENT_OUT, 2, "2014-04-20", 30);
		books.add(bookNew);

		for (int i = 0; i < 4; i++) {
			BookInfo book = new BookInfo();
			book.setId("TP31041051" + i);
			book.setName("Data Mining: Methods and Implementation");
			book.setPrice(43.99);
			book.setStatus(Consts.STATUS_BOOK_AVAILABLE);
			book.setGrade(5);
			book.setDate("");
			book.setDuration(0);
			books.add(book);
		}

		for (int i = 0; i < 3; i++) {
			BookInfo book = setBook("TP24001100" + i, "The Spirit of Fire",
					20.99, Consts.STATUS_BOOK_RENT_OUT, 10, "2014-04-02", 23);
			books.add(book);
		}

		new BookDataRW().writeDataToFile(books, "data/book.data");
	}

	private BookInfo setBook(String id, String name, double price, int status, int grade,
			String date, int duration) {
		BookInfo book = new BookInfo();
		book.setId(id);
		book.setName(name);
		book.setPrice(price);
		book.setStatus(status);
		book.setGrade(grade);
		book.setDate(date);
		book.setDuration(duration);

		return book;
	}

}

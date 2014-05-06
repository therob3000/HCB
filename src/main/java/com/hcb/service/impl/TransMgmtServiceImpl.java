package com.hcb.service.impl;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import com.hcb.commons.Consts;
import com.hcb.commons.HcbData;
import com.hcb.commons.OprStatus;
import com.hcb.domains.impl.*;
import com.hcb.service.BookMgmtService;
import com.hcb.service.MemberMgmtService;
import com.hcb.service.TransMgmtService;

public class TransMgmtServiceImpl implements TransMgmtService {
	private static final DateFormat dateFormat = new SimpleDateFormat(
			"yyyyMMdd");

	// private static Calendar nowCalendar = Calendar.getInstance();

	private static BookMgmtService bookService = new BookMgmtServiceImpl();
	private static MemberMgmtService memberService = new MemberMgmtServiceImpl();

	@Override
	public int bookRenting(String bookId, String memberId, int duration) {
		// TODO Auto-generated method stub
		MemberInfo member = memberService.queryMember(memberId);
		BookInfo book = bookService.queryBook(bookId);

		double remainedAccount = member.getAccount();
		int bookGrade = book.getGrade();

		// negative user account, cannot borrow book for any duration until
		// re-charging
		if (remainedAccount < Consts.USER_ACCOUNT_MIN)
			return OprStatus.RENTING_INSUFFICIENT_USER_ACCOUNT;

		double rentDeposit = bookGrade * HcbData.rentDeposit * (duration - 1);

		// insufficient user account
		if (duration > 1 && remainedAccount < rentDeposit)
			return OprStatus.RENTING_INSUFFICIENT_USER_ACCOUNT;

		// it is not necessary to consider about users whose account is 0
		// borrowing books for only one day (for free)

		String bookOne = member.getRentBookIdOne();
		String bookTwo = member.getRentBookIdTwo();
		if (isStringNullOrEmpty(bookOne)) {
			member.setRentBookIdOne(bookId);
		} else if (isStringNullOrEmpty(bookTwo)) {
			member.setRentBookIdTwo(bookId);
		} else { // reach max available user book counts
			return OprStatus.RENTING_REACH_BOOKNUM_MAX;
		}

		// Account of HCB is considered here (earning the renting deposit and
		// reducing from user account)
		HcbData.hcbAccount += rentDeposit;
		member.setAccount(remainedAccount - rentDeposit);

		book.setStatus(Consts.STATUS_BOOK_RENT_OUT);
		book.setDuration(duration);
		book.setDate(getCurrentYmdStr());

		return memberService.modifyMember(memberId, member)
				+ bookService.modifyBook(bookId, book);
	}

	@Override
	public int bookSaling(String bookId, String memberId) {
		// TODO Auto-generated method stub
		// need to think about account
		MemberInfo member = memberService.queryMember(memberId);
		BookInfo book = bookService.queryBook(bookId);

		double remainedAccount = member.getAccount();
		double bookPrice = book.getPrice();
		
		if (remainedAccount < Consts.USER_ACCOUNT_MIN || remainedAccount < bookPrice)
			return OprStatus.RENTING_INSUFFICIENT_USER_ACCOUNT;
		
		HcbData.hcbAccount += bookPrice;
		member.setAccount(remainedAccount - bookPrice);
		
		book.setStatus(Consts.STATUS_BOOK_SALE_OUT);
		book.setDate(getCurrentYmdStr());
		
		return memberService.modifyMember(memberId, member)
				+ bookService.modifyBook(bookId, book);
	}

	@Override
	public int bookReturning(String bookId, String memberId) {
		// TODO Auto-generated method stub
		MemberInfo member = memberService.queryMember(memberId);
		BookInfo book = bookService.queryBook(bookId);

		String bookOneId = member.getRentBookIdOne();
		String bookTwoId = member.getRentBookIdTwo();

		if (bookId.equals(bookOneId))
			member.setRentBookIdOne(""); // Use `null` cautiously. When reseting
											// a string, it is usually better to
											// set it as "" (empty string).
		else if (bookId.equals(bookTwoId))
			member.setRentBookIdTwo("");
		else
			return OprStatus.RETURNING_NO_BOOKS_RENTED;

		/*
		 * 
		 * Need to Calculate account here, which adding remained renting deposit
		 * (if the book is returned before the deadline) to user account and
		 * minus that from HCB account.
		 * 
		 * Another situation is that member return the book late. How to
		 * alternate to solve this problem by penalty from member account or
		 * regardless of it?
		 */
		Calendar nowCalendar = Calendar.getInstance();
		Date nowDate = new Date();
		nowCalendar.setTime(nowDate); // day of returning
		String rentDateStr = book.getDate();
		int duration = book.getDuration();

		double memberAccount = member.getAccount();

		try {
			Date rentDate = dateFormat.parse(rentDateStr);
			Calendar rentCalendar = Calendar.getInstance();
			rentCalendar.setTime(rentDate);
			rentCalendar.add(Calendar.DATE, duration); // day of returning
														// deadline

			// compare the deadline to the day of returning the book
			Date dlReturn = rentCalendar.getTime();
			long msIntv = Math.abs(dlReturn.getTime() - nowDate.getTime());
			long daysIntv = (long) (msIntv / (1000 * 60 * 60 * 24) + 0.5);
			int dateCompResult = rentCalendar.compareTo(nowCalendar);
			
			if (dateCompResult == 1) { // return book early
				// deposit which should be returned into member's account
				// because of early returning
				double rentDepReturn = ((long) duration - daysIntv)
						* book.getGrade() * HcbData.rentDeposit;
				HcbData.hcbAccount -= rentDepReturn; // reduce from HCB account
				member.setAccount(memberAccount + rentDepReturn); // return
				
			} else if (dateCompResult == -1) { // return book late
				// TODO need to charge for penalty 
				// deposit which should be returned into member's account
				// because of early returning
				double rentDepReturn = daysIntv * book.getGrade(); // penalty !!!
				HcbData.hcbAccount += rentDepReturn; // reduce from HCB account
				member.setAccount(memberAccount - rentDepReturn); // return
			}
		} catch (ParseException e) {
			e.printStackTrace();
			return OprStatus.OPERATION_EXCEPTION;
		}

		// reset book information
		book.setStatus(Consts.STATUS_BOOK_AVAILABLE);
		book.setDate("");
		book.setDuration(0);

		return memberService.modifyMember(memberId, member)
				+ bookService.modifyBook(bookId, book);
	}

	@Override
	public int bookForwarding(BookInfo book,int distributorId) {
		// TODO Auto-generated method stub
		double bookPrice = book.getPrice();
		if(bookService.createBook(book) == OprStatus.OPERATION_SUCCEED){
			HcbData.hcbAccount -= bookPrice;
			return OprStatus.OPERATION_SUCCEED;
		}
		else
			return OprStatus.OPERATION_INTERNALL_ERROR;
		
	}

	/**
	 * Get current YMD in string<br />
	 * 
	 * @return yyyyMMdd
	 */
	private String getCurrentYmdStr() {
		Date now = new Date();
		return dateFormat.format(now);
	}

	/**
	 * Judge if a string is null or empty ""<br />
	 * 
	 * @param str
	 * @return
	 */
	private boolean isStringNullOrEmpty(String str) {
		return str == null || str.equals("");
	}

	/**
	 * Return operation status code in accordance with RW methods<br />
	 * 
	 * @return operation status
	 */
	@SuppressWarnings("unused")
	private int oprStatusReturning(boolean rwOprReturn) {
		if (rwOprReturn)
			return OprStatus.OPERATION_SUCCEED;
		else
			return OprStatus.OPERATION_INTERNALL_ERROR;
	}
}

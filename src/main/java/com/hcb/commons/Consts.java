package com.hcb.commons;

/**
 * Constants used in the program<br />
 * 
 * @author range
 * 
 */
public class Consts {
	//
	
	// File path
	public static final String PATH_BOOK = "data/book.data";
	public static final String PATH_MEMBER = "data/member.data";
	public static final String PATH_USER = "data/user.data";

	// File encoding while writing and reading
	public static final String FILE_ENCODING = "UTF-8";
	public static final String FILE_LINE_SEPARATOR = System.getProperty("line.separator");

	public static final String PATH_ACCOUNT = "data/account.data";
	public static final String PATH_RENT_DEPOSIT = "data/renting.data";


	// File split while reading and writing
	public static final String FILE_SPLIT_READING = "\\|\\|\\|";
	public static final String FILE_SPLIT_WRITING = " ||| ";

	// Data file path (please fill in the blanks)
	public static final String FILE_PATH_BOOKDATA = "";
	public static final String FILE_PATH_ACCOUNTDATA = "";
	public static final String FILE_PATH_MEMBERDATA = "";

	// Book status
	public static final int STATUS_BOOK_RENT_OUT = 1;
	public static final int STATUS_BOOK_AVAILABLE = 2;
	public static final int STATUS_BOOK_SALE_OUT = 3;
	public static final int STATUS_BOOK_NOT_AVAILABLE = 4; // book is currently
															// unavailable for
															// renting
	// User type
	public static final int USER_TYPE_CLERK = 1;
	public static final int USER_TYPE_MANAGER = 2;

	// User account minimum
	public static final double USER_ACCOUNT_MIN = 0;

}

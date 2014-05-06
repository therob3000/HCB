package com.hcb.commons;

/**
 * A class represents only operation status<br />
 * @author range
 *
 */
public class OprStatus {
	// General operation status
	public static final int OPERATION_SUCCEED = 0;
	public static final int OPERATION_INTERNALL_ERROR = 255;
	public static final int OPERATION_EXCEPTION = 127;
	
	// Creation operation status
	public static final int CREATE_OBJECT_IS_NULL = 1;
	
	// Renting status
	public static final int RENTING_INSUFFICIENT_USER_ACCOUNT = 1;
	public static final int RENTING_REACH_BOOKNUM_MAX = 2;
	
	// Returning status
	public static final int RETURNING_NO_BOOKS_RENTED = 1;
}

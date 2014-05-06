package com.hcb.service;

import java.util.*;

import com.hcb.domains.BasicInfo;
import com.hcb.domains.impl.UserInfo;

/**
 * User Interface<br />
 * Used by clerk and manager<br />
 * 
 * @author range
 * 
 */
public interface UserService {
	/**
	 * User login<br />
	 * 
	 * @param username
	 * @param password
	 * @return operation status
	 */
	boolean login(String username, String password);

	/**
	 * User logout<br />
	 * When a clerk logout from the system, it means the business activity of
	 * the whole day is over, all data in the memory must be written into
	 * specific files<br />
	 * But when a manager logout, it's not necessary<br />
	 * 
	 * @param userType
	 *            type of the user
	 * @return operation status
	 */
	boolean logout(int userType);

	/**
	 * Create a new clerk<br />
	 * 
	 * @param clerkId
	 *            clerk ID
	 * @param username
	 *            login user name
	 * @param password
	 *            login password
	 * @param mobile
	 *            cellular number
	 * @param email
	 *            email address
	 * @return operation status
	 */
	int createClerk(BasicInfo clerk);


	/**
	 * Remove a clerk<br />
	 * 
	 * @param clerkId
	 *            clerk ID

	 * @return operation status
	 */
	int removeClerk(String id);


	/**
	 * Modify password<br />
	 * 
	 * @param id
	 *            user ID
	 * @param originalPwdInput
	 *            original password input by the user
	 * @param newPwdInput
	 *            new password input by the user
	 * @return operation status
	 */
	int modifyClerk(String id, BasicInfo clerk);


	/**
	 * Query a clerk<br />
	 * 
	 * @param clerkId
	 *            clerk ID
	 * @return query result
	 */
	UserInfo queryClerk(String id);

	/**
	 * Query all clerks<br />
	 * 
	 * @return query results
	 */
	Vector<UserInfo> queryAllClerks();
}

package com.hcb.commons;

import java.util.*;

/**
 * Data in the memory as static, global variables<br />
 * 
 * @author range
 * @deprecated
 */
@Deprecated
public class Data {
	private static Map<String, Map<String, String>> bookData = null;

	private static Map<String, Map<String, String>> accountData = null;

	private static Map<String, Map<String, String>> memberData = null;

	private static Map<String, Map<String, String>> getInstance(
			Map<String, Map<String, String>> data) {
		if (data != null) // If data already exists
			return data;
		else
			// If data does not exist
			return new HashMap<>();
	}

	/**
	 * Get book data<br />
	 * 
	 * @return
	 * @deprecated
	 */
	@Deprecated
	public static Map<String, Map<String, String>> getBookData() {
		return getInstance(bookData);
	}

	/**
	 * Get account data<br />
	 * 
	 * @return
	 * @deprecated
	 */
	@Deprecated
	public static Map<String, Map<String, String>> getAccountData() {
		return getInstance(accountData);
	}

	/**
	 * Get member data<br />
	 * 
	 * @return
	 * @deprecated
	 */
	@Deprecated
	public static Map<String, Map<String, String>> getMemberData() {
		return getInstance(memberData);
	}
}

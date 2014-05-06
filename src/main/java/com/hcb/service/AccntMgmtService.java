package com.hcb.service;

/**
 * Account management<br />
 * 
 * @author range
 * 
 */
public interface AccntMgmtService {
	/**
	 * Get current account of HCB<br />
	 * 
	 * @return accounting sum
	 */
	double getHcbCurrentAccount();

	/**
	 * Get current account of a member<br />
	 * 
	 * @param memberId
	 *            member ID
	 * @return accounting sum
	 */
	double getMemberAccount(String memberId);

}

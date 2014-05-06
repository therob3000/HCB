package com.hcb.service;

import java.util.*;


import com.hcb.domains.BasicInfo;
import com.hcb.domains.impl.MemberInfo;

/**
 * Member management<br />
 * 
 * @author range
 * 
 */
public interface MemberMgmtService {
	/**
	 * Create a new member<br />
	 * 
	 * @param member
	 *            member information
	 * @return operation status
	 */
	int createMember(BasicInfo member);

	/**
	 * Remove a member<br />
	 * 
	 * @param id
	 *            member ID
	 * @return operation status
	 */
	int removeMember(String id);


	/**
	 * Modify information of a member<br />
	 * 
	 * @param id
	 *            member ID
	 * @param member
	 *            member information
	 * @return operation status
	 */
	int modifyMember(String id, BasicInfo member);

	/**
	 * Query a member<br />
	 * 
	 * @param memberId
	 *            member ID
	 * @return query result
	 */
	MemberInfo queryMember(String id);

	/**
	 * Query all members in the system<br />
	 * 
	 * @return query results
	 */
	Vector<MemberInfo> queryAllMembers();

}

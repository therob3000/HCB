package com.hcb.commons;

import java.util.*;

import com.hcb.data.impl.BookDataRW;
import com.hcb.data.impl.HcbAcntRW;
import com.hcb.data.impl.MemberDataRW;
import com.hcb.data.impl.UserDataRW;
import com.hcb.domains.impl.*;

/**
 * Data in the memory as static, global variables<br />
 * 
 * @author range
 */
public class HcbData {

	private static HcbAcntRW hcbAcntRw = new HcbAcntRW();
	public static double hcbAccount = hcbAcntRw.readHcbAccnt(Consts.PATH_ACCOUNT);
	public static double rentDeposit = hcbAcntRw.readHcbAccnt(Consts.PATH_RENT_DEPOSIT);


	public static Vector<BookInfo> bookData = new BookDataRW()
			.readDataFromFile(Consts.PATH_BOOK);

	public static Vector<UserInfo> userData = new UserDataRW()
			.readDataFromFile(Consts.PATH_USER);

	public static Vector<MemberInfo> memberData = new MemberDataRW()
			.readDataFromFile(Consts.PATH_MEMBER);
}

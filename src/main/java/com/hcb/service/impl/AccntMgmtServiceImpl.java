package com.hcb.service.impl;

import com.hcb.commons.HcbData;
import com.hcb.domains.impl.MemberInfo;
import com.hcb.service.AccntMgmtService;
import com.hcb.service.MemberMgmtService;

public class AccntMgmtServiceImpl implements AccntMgmtService {

	private static MemberMgmtService memberService = new MemberMgmtServiceImpl();
	@Override
	public double getHcbCurrentAccount() {
		// TODO Auto-generated method stub
		return HcbData.hcbAccount;
	}

	@Override
	public double getMemberAccount(String memberId) {
		// TODO Auto-generated method stub
		MemberInfo member = memberService.queryMember(memberId);
		return member.getAccount();
	}

}

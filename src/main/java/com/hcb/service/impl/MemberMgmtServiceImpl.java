package com.hcb.service.impl;

import java.util.Vector;
import com.hcb.commons.OprStatus;
import com.hcb.data.impl.MemberDataRW;
import com.hcb.domains.BasicInfo;
import com.hcb.domains.impl.MemberInfo;
import com.hcb.service.MemberMgmtService;

public class MemberMgmtServiceImpl implements MemberMgmtService {
	private static MemberDataRW rwMember = new MemberDataRW();

	@Override
	public int createMember(BasicInfo member) {
		// TODO Auto-generated method stub
		if (member == null)
			return OprStatus.CREATE_OBJECT_IS_NULL;
		else {
			if (rwMember.create(member))
				return OprStatus.OPERATION_SUCCEED;
			else
				return OprStatus.OPERATION_INTERNALL_ERROR;
		}
	}

	@Override
	public int removeMember(String id) {
		// TODO Auto-generated method stub
		if (rwMember.remove(id))
			return OprStatus.OPERATION_SUCCEED;
		else
			return OprStatus.OPERATION_INTERNALL_ERROR;
	}

	@Override
	public int modifyMember(String id, BasicInfo member) {
		// TODO Auto-generated method stub
		if (member == null)
			return OprStatus.CREATE_OBJECT_IS_NULL;
		else {
			if (rwMember.update(id, member))
				return OprStatus.OPERATION_SUCCEED;
			else
				return OprStatus.OPERATION_INTERNALL_ERROR;
		}
	}

	@Override
	public MemberInfo queryMember(String id) {
		// TODO Auto-generated method stub
		return rwMember.query(id);
	}

	@Override
	public Vector<MemberInfo> queryAllMembers() {
		// TODO Auto-generated method stub
		return rwMember.queryAll();
	}

}

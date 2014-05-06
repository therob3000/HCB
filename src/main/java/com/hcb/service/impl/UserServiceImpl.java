package com.hcb.service.impl;

import java.util.Vector;

import com.hcb.commons.OprStatus;
import com.hcb.data.impl.UserDataRW;
import com.hcb.domains.BasicInfo;
import com.hcb.domains.impl.UserInfo;
import com.hcb.service.UserService;

public class UserServiceImpl implements UserService {

	private static UserDataRW rwUser = new UserDataRW();
	@Override
	public boolean login(String username, String password) {
		// TODO Auto-generated method stub
		UserInfo user = rwUser.queryByname(username);
		if(user.getPassword().equals(password))
			return  true;
		return false;
	}

	@Override
	public boolean logout(int userType) {
		// TODO Auto-generated method stub
		
		return false;
	}

	@Override
	public int createClerk(BasicInfo clerk) {
		// TODO Auto-generated method stub
		if (clerk == null)
			return OprStatus.CREATE_OBJECT_IS_NULL;
		else {
			if (rwUser.create(clerk))
				return OprStatus.OPERATION_SUCCEED;
			else
				return OprStatus.OPERATION_INTERNALL_ERROR;
		}
	}

	@Override
	public int removeClerk(String id) {
		// TODO Auto-generated method stub
		if (rwUser.remove(id))
			return OprStatus.OPERATION_SUCCEED;
		else
			return OprStatus.OPERATION_INTERNALL_ERROR;
	}

	@Override
	public int modifyClerk(String id,BasicInfo clerk) {
		// TODO Auto-generated method stub
		if (clerk == null)
			return OprStatus.CREATE_OBJECT_IS_NULL;
		else {
			if (rwUser.update(id, clerk))
				return OprStatus.OPERATION_SUCCEED;
			else
				return OprStatus.OPERATION_INTERNALL_ERROR;
		}
	}

	@Override
	public UserInfo queryClerk(String id) {
		// TODO Auto-generated method stub
		return rwUser.query(id);
	}

	@Override
	public Vector<UserInfo> queryAllClerks() {
		// TODO Auto-generated method stub
		return rwUser.queryAll();
	}

}

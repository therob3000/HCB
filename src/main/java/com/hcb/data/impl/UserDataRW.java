package com.hcb.data.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import com.hcb.commons.Consts;
import com.hcb.commons.HcbData;
import com.hcb.domains.BasicInfo;
import com.hcb.domains.impl.UserInfo;
import com.hcb.utils.DataUtilsBasic;

public class UserDataRW extends BasicDataRW {

	@Override
	public Vector<UserInfo> readDataFromFile(String filePath) {
		Vector<UserInfo> info = new Vector<>();
		List<String> lines;
		try {
			lines = readFile(filePath);
			for (String line : lines) {
				String[] lineArr = line.split(Consts.FILE_SPLIT_READING);
				if (lineArr != null && lineArr.length == 8) {
					UserInfo user = new UserInfo();
					user.setId(lineArr[0].trim());
					user.setName(lineArr[1].trim());
					user.setType(Integer.parseInt(lineArr[2].trim()));
					user.setUserName(lineArr[3].trim());
					user.setPassword(lineArr[4].trim());
					user.setMobile(lineArr[5].trim());
					user.setEmail(lineArr[6].trim());
					user.setAddress(lineArr[7].trim());
					info.add(user);
				} else {
					throw new RuntimeException(
							"Data file error: malformed or wrong column numbers");
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}

		return info;
	}

	@Override
	public boolean writeDataToFile(Vector<? extends BasicInfo> data,
			String filePath) {
		List<String> lines = new ArrayList<>();
		for (BasicInfo info : data) {
			UserInfo user = (UserInfo) info;
			List<String> lineData = new ArrayList<>();
			lineData.add(user.getId());
			lineData.add(user.getName());
			lineData.add(Integer.toString(user.getType()));
			lineData.add(user.getUserName());
			lineData.add(user.getPassword());
			lineData.add(user.getMobile());
			lineData.add(user.getEmail());
			lineData.add(user.getAddress());
			String line = DataUtilsBasic.appendDataString(lineData,
					Consts.FILE_SPLIT_WRITING);
			lines.add(line);
		}

		try {
			writeFile(filePath, lines);
			return true;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean create(Object record) {
		// TODO Auto-generated method stub
		return HcbData.userData.add((UserInfo) record);
	}

	@Override
	public boolean update(String id, Object user) {
		// TODO Auto-generated method stub
		UserInfo oriUser = query(id);
		if (oriUser != null) {
			boolean isAdd = HcbData.userData.add((UserInfo) user);
			boolean isRm = HcbData.userData.remove(oriUser);
			return isAdd && isRm;
		}
		
		return false;
	}

	@Override
	public boolean remove(String id) {
		// TODO Auto-generated method stub
		UserInfo user = query(id);
		if (user != null)
			return HcbData.userData.remove(user);
		else 
			return false;
	}

	@Override
	public UserInfo query(String id) {
		// TODO Auto-generated method stub
		for (UserInfo user : HcbData.userData) {
			if (user.getId().equals(id))
				return user;
		}
		
		return null;
	}
	public UserInfo queryByname(String username) {
		// TODO Auto-generated method stub
		for (UserInfo user : HcbData.userData) {
			if (user.getName().equals(username))
				return user;
		}
		
		return null;
	}
	@Override
	public Vector<UserInfo> queryAll() {
		// TODO Auto-generated method stub
		return HcbData.userData;
	}
}

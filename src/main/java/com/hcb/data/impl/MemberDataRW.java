package com.hcb.data.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import com.hcb.commons.Consts;
import com.hcb.commons.HcbData;
import com.hcb.domains.BasicInfo;
import com.hcb.domains.impl.MemberInfo;
import com.hcb.utils.DataUtilsBasic;

public class MemberDataRW extends BasicDataRW {

	@Override
	public Vector<MemberInfo> readDataFromFile(String filePath) {
		// TODO Auto-generated method stub
		Vector<MemberInfo> info = new Vector<>();
		List<String> lines;
		try {
			lines = readFile(filePath);
			for (String line : lines) {
				String[] lineArr = line.split(Consts.FILE_SPLIT_READING);
				if (lineArr != null && lineArr.length == 6) {
					MemberInfo member = new MemberInfo();
					member.setId(lineArr[0].trim());
					member.setName(lineArr[1].trim());
					member.setCardId(lineArr[2].trim());
					member.setAccount(Double.parseDouble(lineArr[3].trim()));
					member.setRentBookIdOne(lineArr[4].trim());
					member.setRentBookIdTwo(lineArr[5].trim());
					info.add(member);
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
			MemberInfo member = (MemberInfo) info;
			List<String> lineData = new ArrayList<>();
			lineData.add(member.getId());
			lineData.add(member.getName());
			lineData.add(member.getCardId());
			lineData.add(Double.toString(member.getAccount()));
			lineData.add(member.getRentBookIdOne());
			lineData.add(member.getRentBookIdTwo());
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
		return HcbData.memberData.add((MemberInfo) record);
	}

	@Override
	public boolean update(String id, Object member) {
		// TODO Auto-generated method stub
		MemberInfo oriMember = query(id);
		if (oriMember != null) {
			boolean isAdd = HcbData.memberData.add((MemberInfo) member);
			boolean isRm = HcbData.memberData.remove(oriMember);
			return isAdd && isRm;
		}
		
		return false;
	}

	@Override
	public boolean remove(String id) {
		// TODO Auto-generated method stub
		MemberInfo member = query(id);
		if (member != null)
			return HcbData.memberData.remove(member);
		else 
			return false;
	}

	@Override
	public MemberInfo query(String id) {
		// TODO Auto-generated method stub
		for (MemberInfo member : HcbData.memberData) {
			if (member.getId().equals(id))
				return member;
		}
		
		return null;
	}

	@Override
	public Vector<MemberInfo> queryAll() {
		// TODO Auto-generated method stub
		return HcbData.memberData;
	}

}

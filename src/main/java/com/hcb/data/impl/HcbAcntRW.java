package com.hcb.data.impl;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

import com.hcb.commons.Consts;

/**
 * Read and write methods for HCB account<br />
 * 
 * @author range
 * 
 */
public class HcbAcntRW {
	/**
	 * Read account data<br />
	 * 
	 * @param filePath
	 * @return
	 */
	public double readHcbAccnt(String filePath) {

		try {
			double account = 0;
			String accntStr = FileUtils.readFileToString(new File(filePath),
					Consts.FILE_ENCODING);
			account = Double.parseDouble(accntStr);
			return account;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	/**
	 * Write account data<br />
	 * 
	 * @param account
	 * @param filePath
	 * @return
	 */
	public boolean writeHcbAccnt(double account, String filePath) {
		String accntStr = Double.toString(account);

		try {
			FileUtils.writeStringToFile(new File(filePath), accntStr,
					Consts.FILE_ENCODING, false);
			return true;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
}

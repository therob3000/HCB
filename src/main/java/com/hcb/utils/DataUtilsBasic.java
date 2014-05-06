package com.hcb.utils;

import java.io.*;
import java.util.*;

import org.apache.commons.io.FileUtils;

import com.hcb.commons.Consts;
import com.hcb.domains.BasicInfo;

/**
 * Tools for reading and writing files<br />
 * 
 * @author range
 * 
 */
// @Deprecated
public abstract class DataUtilsBasic {

	/**
	 * Append data to a string<br />
	 * 
	 * @param data
	 *            data strings
	 * @param split
	 *            splitter
	 * @return appended string
	 */
	public static String appendDataString(List<String> data, String split) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < data.size() - 1; i++) {
			sb.append(data.get(i)).append(split);
		}
		sb.append(data.get(data.size() - 1));

		return sb.toString();
	}
	

}
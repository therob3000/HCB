package com.hcb.data.impl;

import java.util.*;
import java.io.*;

import org.apache.commons.io.FileUtils;

import com.hcb.commons.Consts;
import com.hcb.data.DataFileRW;
import com.hcb.domains.*;

/**
 * Basic data read and write operations<br />
 * 
 * @author range
 * 
 */
public abstract class BasicDataRW implements DataFileRW {
	/**
	 * Read data into memory from a data file<br />
	 * 
	 * @param filePath
	 * @return data
	 * @throws IOException
	 */
	abstract public Vector<? extends BasicInfo> readDataFromFile(String filePath);

	/**
	 * Write memory data into a file<br />
	 * 
	 * @param data
	 * @param filePath
	 * @return is the writing successful
	 */
	abstract public boolean writeDataToFile(Vector<? extends BasicInfo> data,
			String filePath);

	/**
	 * Read lines from a file<br />
	 * 
	 * @param filePath
	 *            file path
	 * @return lines read from the file
	 * @throws IOException
	 */
	public static List<String> readFile(String filePath) throws IOException {
		List<String> lines = FileUtils.readLines(new File(filePath),
				Consts.FILE_ENCODING);

		return lines;
	}

	/**
	 * Write lines to a file<br />
	 * 
	 * @param filePath
	 *            file path
	 * @param lines
	 *            file lines
	 * @throws IOException
	 */
	public static void writeFile(String filePath, List<String> lines)
			throws IOException {
		FileUtils.writeLines(new File(filePath), Consts.FILE_ENCODING, lines,
				System.getProperty("line.separator"), false);
	}
}

package cn;

import java.util.*;
import java.io.*;

import org.apache.commons.io.FileUtils;

public class TestTest {
	public static void main(String[] args) throws IOException {
		List<String> lines = new ArrayList<>();
		lines.add("testline1==========");
		lines.add("==========testline2");
		lines.add("If you see this, that's the end of the test");
		
		
		FileUtils.writeLines(new File("sometest"), "UTF-8", lines,
				System.getProperty("line.separator"), false);
	}
}

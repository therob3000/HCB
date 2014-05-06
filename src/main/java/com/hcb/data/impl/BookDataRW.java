package com.hcb.data.impl;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.*;

import com.hcb.commons.Consts;
import com.hcb.commons.HcbData;
import com.hcb.domains.BasicInfo;
import com.hcb.domains.impl.BookInfo;
import com.hcb.utils.DataUtilsBasic;

public class BookDataRW extends BasicDataRW {

	@Override
	public Vector<BookInfo> readDataFromFile(String filePath) {
		// TODO Auto-generated method stub
		Vector<BookInfo> info = new Vector<>();
		List<String> lines;
		try {
			lines = readFile(filePath);
			for (String line : lines) {
				String[] lineArr = line.split(Consts.FILE_SPLIT_READING);

				if (lineArr != null && lineArr.length == 7) {

					BookInfo book = new BookInfo();
					book.setId(lineArr[0].trim());
					book.setName(lineArr[1].trim());
					book.setPrice(Double.parseDouble(lineArr[2].trim()));
					book.setStatus(Integer.parseInt(lineArr[3].trim()));

					book.setDate(lineArr[4].trim());
					book.setGrade(Integer.parseInt(lineArr[4].trim()));
					book.setDate(lineArr[5].trim());
					book.setDuration(Integer.parseInt(lineArr[6].trim()));
					info.add(book);
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
		// TODO Auto-generated method stub
		List<String> lines = new ArrayList<>();
		for (BasicInfo info : data) {
			BookInfo book = (BookInfo) info;
			List<String> lineData = new ArrayList<>();
			lineData.add(book.getId());
			lineData.add(book.getName());
			lineData.add(Double.toString(book.getPrice()));
			lineData.add(Integer.toString(book.getStatus()));
			lineData.add(Integer.toString(book.getGrade()));
			lineData.add(book.getDate());
			lineData.add(Integer.toString(book.getDuration()));

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

		if (record == null)
			return false;

		return HcbData.bookData.add((BookInfo) record);
	}

	@Override
	public boolean update(String id, Object book) {
		// TODO Auto-generated method stub
		BookInfo oriBook = query(id);
		if (oriBook != null) {
			boolean isAdd = HcbData.bookData.add((BookInfo) book);
			boolean isRm = HcbData.bookData.remove(oriBook);
			return isAdd && isRm;
		}

		return false;
	}

	@Override
	public boolean remove(String id) {
		// TODO Auto-generated method stub
		BookInfo book = query(id);
		if (book != null)
			return HcbData.bookData.remove(book);
		else
			return false;
	}

	@Override
	public BookInfo query(String id) {
		// TODO Auto-generated method stub
		for (BookInfo book : HcbData.bookData) {
			String bookId = book.getId();
			if (bookId.equals(id)) {
				return book;
			}
		}

		return null;
	}

	@Override
	public Vector<BookInfo> queryAll() {
		// TODO Auto-generated method stub
		return HcbData.bookData;
	}

	/**
	 * Remove all books with a specific name<br />
	 * 
	 * @param name
	 *            book name
	 * @return are the books removed successfully?
	 */
	public boolean removeBooksByName(String name) {
		Vector<BookInfo> rmBook = queryBooksByName(name);
		return HcbData.bookData.removeAll(rmBook);
	}

	/**
	 * Query all books with a name<br />
	 * 
	 * @param name
	 *            book name
	 * @return books with that name
	 */
	public Vector<BookInfo> queryBooksByName(String name) {
		Vector<BookInfo> books = new Vector<>();

		for (BookInfo book : HcbData.bookData) {
			String bookName = book.getName();
			if (bookName.equals(name)) {
				books.add(book);
			}
		}

		return books;
	}

	/**
	 * Query all books with a price<br />
	 * 
	 * @param price
	 * @return
	 */
	public Vector<BookInfo> queryBooksByPrice(double price) {
		Vector<BookInfo> books = new Vector<>();
		for (BookInfo book : HcbData.bookData) {
			double bookPrice = book.getPrice();

			if (new BigDecimal(Double.toString(bookPrice))
					.compareTo(new BigDecimal(Double.toString(price))) == 0) {

				books.add(book);
			}
		}

		return books;
	}

	/**
	 * Query all books in a status<br />
	 * 
	 * @param status
	 * @return
	 */
	public Vector<BookInfo> queryBooksByStatus(int status) {
		Vector<BookInfo> books = new Vector<>();
		for (BookInfo book : HcbData.bookData) {
			int bookStatus = book.getStatus();
			if (bookStatus == status) {
				books.add(book);
			}
		}

		return books;
	}

	/**
	 * Query all books renting in the same time<br />
	 * 
	 * @param date
	 * @return
	 */
	public Vector<BookInfo> queryBooksByRentTime(String date) {
		Vector<BookInfo> books = new Vector<>();
		for (BookInfo book : HcbData.bookData) {
			String bookDate = book.getDate();
			if (bookDate.equals(date)) {
				books.add(book);
			}
		}

		return books;
	}
}

package com.hcb.service.impl;

import java.util.*;

import com.hcb.service.BookMgmtService;
import com.hcb.domains.BasicInfo;
import com.hcb.domains.impl.BookInfo;
import com.hcb.data.impl.BookDataRW;
import com.hcb.commons.OprStatus;

public class BookMgmtServiceImpl implements BookMgmtService {
	private static BookDataRW rwBook = new BookDataRW();

	// private static
	@Override
	public int createBook(BasicInfo book) {
		// TODO Auto-generated method stub
		if (book == null)
			return OprStatus.CREATE_OBJECT_IS_NULL;
		else {
			if (rwBook.create(book))
				return OprStatus.OPERATION_SUCCEED;
			else
				return OprStatus.OPERATION_INTERNALL_ERROR;
		}
	}

	@Override
	public int modifyBook(String id, BasicInfo book) {
		// TODO Auto-generated method stub
		if (book == null)
			return OprStatus.CREATE_OBJECT_IS_NULL;
		else {
			if (rwBook.update(id, book))
				return OprStatus.OPERATION_SUCCEED;
			else
				return OprStatus.OPERATION_INTERNALL_ERROR;
		}

	}

	@Override
	public int removeBook(String id) {
		// TODO Auto-generated method stub
		if (rwBook.remove(id))
			return OprStatus.OPERATION_SUCCEED;
		else
			return OprStatus.OPERATION_INTERNALL_ERROR;

	}

	@Override
	public int removeBooks(String name) {
		// TODO Auto-generated method stub
		if (rwBook.removeBooksByName(name))
			return OprStatus.OPERATION_SUCCEED;
		else
			return OprStatus.OPERATION_INTERNALL_ERROR;
	}

	@Override
	public BookInfo queryBook(String id) {
		// TODO Auto-generated method stub
		return rwBook.query(id);
	}

	@Override
	public Vector<BookInfo> queryBooks(String name) {
		// TODO Auto-generated method stub
		return rwBook.queryBooksByName(name);
	}

	@Override
	public Vector<BookInfo> queryBooks(double price) {
		// TODO Auto-generated method stub
		return rwBook.queryBooksByPrice(price);
	}

	@Override
	public Vector<BookInfo> queryBooks(int status) {
		// TODO Auto-generated method stub
		return rwBook.queryBooksByStatus(status);
	}

	@Override
	public Vector<BookInfo> queryBooksRentTime(String time) {
		// TODO Auto-generated method stub
		return rwBook.queryBooksByRentTime(time);
	}

	@Override
	public Vector<BookInfo> queryAllBooks() {
		// TODO Auto-generated method stub
		return rwBook.queryAll();
	}

}

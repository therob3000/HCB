package com.hcb.service;

import java.util.*;
import com.hcb.domains.*;
import com.hcb.domains.impl.*;


/**
 * Book management<br />
 * 
 * @author range
 * 
 */
public interface BookMgmtService {
	/**
	 * Create a new book<br />
	 * 
	 * @param book
	 *            object of information of a book
	 * @return operation status
	 */
	int createBook(BasicInfo book);

	/**
	 * Modify the information of a book<br />
	 * 
	 * @param bookId
	 *            book ID
	 * @param book
	 *            object of information of a book
	 * @return operation status
	 */
	int modifyBook(String id, BasicInfo book);


	/**
	 * Remove a book<br />
	 * 
	 * @param bookId
	 *            book ID
	 * @return operation status
	 */
	int removeBook(String id);


	/**
	 * Remove books with the same name<br />
	 * 
	 * @param bookName
	 *            name of the book
	 * @return operation status
	 */
	int removeBooks(String name);


	/**
	 * Query a book<br />
	 * 
	 * @param bookId
	 *            book ID
	 * @return query result
	 */
	BookInfo queryBook(String id);


	/**
	 * Query books with the same name<br />
	 * 
	 * @param bookName
	 *            name of the book
	 * @return query results
	 */
	Vector<BookInfo> queryBooks(String name);


	/**
	 * Query books with the same price<br />
	 * 
	 * @param price
	 *            price of the book
	 * @param data
	 * @return query results
	 */

	Vector<BookInfo> queryBooks(double price);


	/**
	 * Query books with a specific status<br />
	 * 
	 * @param status
	 *            book status
	 * @return query results
	 */

	Vector<BookInfo> queryBooks(int status);


	/**
	 * Query books with a specific renting time<br />
	 * 
	 * @param time
	 *            renting time
	 * @return query results
	 */

	Vector<BookInfo> queryBooksRentTime(String time);


	/**
	 * Query all the books<br />
	 * 
	 * @return query results
	 */

	Vector<BookInfo> queryAllBooks();

}

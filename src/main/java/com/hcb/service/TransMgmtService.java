package com.hcb.service;

import com.hcb.domains.impl.BookInfo;

/**
 * Transaction management<br />
 * 
 * @author range
 * 
 */
public interface TransMgmtService {
	/**
	 * Rent a book<br />
	 * 
	 * @param bookId
	 *            book ID
	 * @param memberId
	 *            member ID renting the book
	 * @param duration
	 *            renting duration
	 * @return operation status
	 */
	int bookRenting(String bookId, String memberId, int duration);

	/**
	 * Sell a book<br />
	 * 
	 * @param bookId
	 *            book ID
	 * @param memberId
	 *            member ID buying the book

	 * @return operation status
	 */
	int bookSaling(String bookId, String memberId);


	/**
	 * Return a book to HCB<br />
	 * 
	 * @param bookId
	 *            book ID
	 * @param memberId
	 *            member ID returning the book
	 * @return operation status
	 */
	int bookReturning(String bookId, String memberId);


	/**
	 * Forward a book from a distributor to a member when the book is
	 * unavailable in HCB<br />
	 * 
	 * @param bookName
	 *            name of the book
	 * @param memberId
	 *            member ID
	 * @param distributorId
	 *            distributor ID
	 * @return operation status
	 */
	int bookForwarding(BookInfo book, int distributorId);
}

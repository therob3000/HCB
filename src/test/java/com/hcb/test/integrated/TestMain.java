package com.hcb.test.integrated;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

import com.hcb.commons.HcbData;
import com.hcb.domains.impl.BookInfo;
import com.hcb.domains.impl.MemberInfo;
import com.hcb.domains.impl.UserInfo;
import com.hcb.service.*;
import com.hcb.service.impl.*;

public class TestMain {
	private static TransMgmtService transService = new TransMgmtServiceImpl();

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		// welcome
		System.out
				.println("====================== WELCOME TO HARVARD COMIC BOOKS ======================");

		// test if the data in heap correct
		System.out.println("----------- STATISTICS -----------");
		System.out.println("CURRENT RENT DEPOSIT UNIT: " + HcbData.rentDeposit);
		System.out.println("CURRENT ACCOUNT OF HCB: " + HcbData.hcbAccount);

		System.out.println("_________ DATA OF BOOKS _________");
		for (BookInfo book : HcbData.bookData) {
			System.out.println(book.toString());
		}

		System.out.println("_________ DATA OF MEMBERS _________");
		for (MemberInfo member : HcbData.memberData) {
			System.out.println(member.toString());
		}

		System.out.println("_________ DATA OF USERS _________");
		for (UserInfo user : HcbData.userData) {
			System.out.println(user.toString());
		}

//		Scanner scanner = new Scanner(System.in);
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		while (true) {
			System.out
					.println("ALL THE DATA ARE CHECKED NOW, IF YOU WANT TO START, PRESS 1, EXIT PRESS 2");
			String opt = reader.readLine();

			if (opt.equals("1")) {
				w: while (true) {
					System.out.println("==== TRANSACTION MANAGEMENT ====");
					System.out.println("OPTIONS: ");
					System.out.println("PRESS 1 TO RENT A BOOK;");
					System.out.println("PRESS 2 TO BUY A BOOK;");
					System.out
							.println("PRESS 3 TO RETURN A BOOK THE MEMBER HAVE RENTED;");
					System.out.println("PRESS 4 BACK TO MAIN MENU;");
					String option = reader.readLine();
					switch (option) {
					case "1":
						System.out.println("PLEASE INPUT BOOK ID YOU WANT TO RENT:");
						String bookId = reader.readLine();
						System.out.println("PLEASE INPUT MEMBER ID:");
						String memberId = reader.readLine();
						System.out.println("PLEASE INPUT DURATION:");
						int duration = Integer.parseInt(reader.readLine());
						int oprstatus = transService.bookRenting(bookId, memberId, duration);
						System.out.println("OPERATION STATUS: " + oprstatus);
						System.out.println("_________ DATA OF BOOKS _________");
						for (BookInfo book : HcbData.bookData) {
							System.out.println(book.toString());
						}
						System.out.println("_________ DATA OF MEMBERS _________");
						for (MemberInfo member : HcbData.memberData) {
							System.out.println(member.toString());
						}
						break;
					case "2":
						System.out.println("TEMPRARILY NOT AVAILABLE");
						break;
					case "3":
//						System.out.println("TEMPRARILY NOT AVAILABLE");
						System.out.println("PLEASE INPUT BOOK ID YOU WANT TO RENT:");
						String bookId1 = reader.readLine();
						System.out.println("PLEASE INPUT MEMBER ID:");
						String memberId1 = reader.readLine();
						int oprs = transService.bookReturning(bookId1, memberId1);
						System.out.println("OPERATION STATUS: " + oprs);
						System.out.println("_________ DATA OF BOOKS _________");
						for (BookInfo book : HcbData.bookData) {
							System.out.println(book.toString());
						}
						System.out.println("_________ DATA OF MEMBERS _________");
						for (MemberInfo member : HcbData.memberData) {
							System.out.println(member.toString());
						}
						break;
					case "4":
						break w;

					default:
						System.out
								.println("INCORRECT OPTION CODE, PLEASE TRY AGAIN.");
						break;
					}
				}

			} else if (opt.equals("2")) {
				System.out.println("SYSTEM HAS EXITED WITH CODE 0");
				System.exit(0);
			} else {
				System.out.println("INCORRECT OPTION CODE, PLEASE TRY AGAIN.");
			}
		}
	}

}

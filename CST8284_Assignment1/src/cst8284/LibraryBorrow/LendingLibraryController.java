package cst8284.LibraryBorrow;

import java.util.Objects;

import java.util.Scanner;

/**
 * Class Name: CST8284-300 Assignment1
 * Author Name: Chunfang Song
 * Class Name: LendingLibraryController
 * Date: June 14,2021
 */

public class LendingLibraryController {
	private LendingLibrary bookLib;
	private static Scanner input = new Scanner(System.in);

	public LendingLibraryController() {
		bookLib = new LendingLibrary();
	}

	public void addUser() {
		System.out.println("New User Entry");
		String lastName = getResponseTo("Last Name: ");
		String firstName = getResponseTo("First Name: ");
		String tmpAge = getResponseTo("Age: ");
		int age = 0; // need to double check the age is not valid number, how to deal with it.
		
		while (true) {
			if (isValidNumber(tmpAge)) {
			age = Integer.valueOf(tmpAge);
			if (age > 0) {
				break;
			}
		}
			tmpAge = getResponseTo("Age: ");
			
		}

		String address = getResponseTo("Address: ");

		User user = new User(firstName, lastName, address, age);
		if (bookLib.addUser(user)) {
			System.out.println("User was added"); // what should i do if add fail
		} else {
			System.out.println("User was full, could not add this user!");
		}
	}

	public void changeUser() {
		System.out.println("Modify User address");
		String lastName = getResponseTo("Last Name: ");
		String firstName = getResponseTo("First Name: ");
		User user = bookLib.findUser(firstName, lastName);
		if (Objects.isNull(user)) {
			System.out.println("No user with this name!");
		}
		String newAddress = getResponseTo("New address: ");
		user.setAddress(newAddress);
	}

	public void findUser() {
		System.out.println("Find User");
		String lastName = getResponseTo("Last Name: ");
		String firstName = getResponseTo("First Name: ");
		User user = bookLib.findUser(firstName, lastName);
		if (Objects.isNull(user)) {
			System.out.println("No user with this name!");
		} else {
			System.out.println(user.toString());
		}
	}

	public void listUser() {
		User[] userReg = bookLib.getUserReg();
		for (int i = 0; i <= bookLib.getLastUserIndex(); i++) {
			System.out.println("User #" + (i + 1));
			System.out.println(userReg[i].toString());
		}
	}

	public void addBook() {
		System.out.println("New Book Entry");
		String title = getResponseTo("Title: ");
		String author = getResponseTo("Author: ");
		String pubDate = getResponseTo("Publication date (year in NNNN format): ");
		
		while (true) {
			if (pubDate.length() == 4 && isValidNumber(pubDate))
				break;
			pubDate = getResponseTo("Publication date (year in NNNN format): ");
		}
		
		String isbn = getResponseTo("ISBN number (10 digits): ");
		Book book = new Book(title, author, isbn, pubDate);



		while (true) {
			if (book.verifyISBNNumber(isbn))
				break;
			else {
				isbn = getResponseTo("ISBN number (10 digits): ");
				book.setIsbnNumber(isbn);
			}
		}

		if (bookLib.addBook(book)) {
			System.out.println("Book was added");
		} else {
			System.out.println("Library was full, could not add this book!");
		}
	}

	public void changeBook() {
		System.out.println("Modify Book information");
		String isbn = getResponseTo("ISBN number (10 digits): ");
		Book book = bookLib.findBook(isbn);
		if (Objects.isNull(book)) {
			System.out.println("Could not find a book with this isbn");
		} else {
			String title = getResponseTo("New title: ");
			book.setTitle(title);
			String author = getResponseTo("New author: ");
			book.setAuthor(author);
			String pubDate = getResponseTo("New publication date (year in NNNN format): ");
			while (true) {
				if (pubDate.length() == 4 && isValidNumber(pubDate))
					break;
				pubDate = getResponseTo("Publication date (year in NNNN format): ");
				book.setPubDate(pubDate);
			}
		} 
	}

	public void findBook() {
		System.out.println("Find Book");
		String isbn = getResponseTo("ISBN number (10 digits): ");
		Book book = bookLib.findBook(isbn);
		if (Objects.isNull(book)) {
			System.out.println("No book with this ISBN!");
		} else {
			System.out.println(book.toString());
		}
	}

	public void listBook() {
		Book[] bookReg = bookLib.getBookReg();
		for (int i = 0; i <= bookLib.getLastBookIndex(); i++) {
			System.out.println("Book #" + (i + 1));
			System.out.println(bookReg[i].toString());
		}
	}

	public void addBookLoan() {
		System.out.println("New Loan Entry");
		String lastName = getResponseTo("User last name:");
		String firstName = getResponseTo("User first name:");
		String isbn = getResponseTo("Book isbn number:");
		String dueDate = getResponseTo("Loan date (format yyyy-mm-dd): ");
		while (true) {
			if (dueDate.length() == 8 && isValidNumber(dueDate))
				break;
			dueDate = getResponseTo("Loan date (format yyyymmdd): ");
		}
		User user = bookLib.findUser(firstName, lastName);
		Book book = bookLib.findBook(isbn);
		if (Objects.isNull(user)) {
			System.out.println("No user with this name!");
		} else if (Objects.isNull(book)) {
			System.out.println("Could not find a book with this isbn!");
		} else if (bookLib.isBookLoaned(book)) {
			System.out.println("Book is already loaned");
		} else if (!(bookLib.userCanBorrow(user))) {
			System.out.println("This user is not allowed to borrow more books");
		} else {
			BookLoan bookLoan = new BookLoan(user, book, dueDate);
			if (bookLib.addLoan(bookLoan)) {
				System.out.println("Loan added");
				System.out.println(bookLoan.toString());
			} else {
				System.out.println("This lending library cannot add more book loan");
			}
		}

	}

	public void chageBookLoan() {
		System.out.println("Modify loan details.");
		String isbn = getResponseTo("ISBN number for the loan you want to modify:");
		BookLoan bookLoan = bookLib.findLoan(isbn);
		if (Objects.isNull(bookLoan)) {
			System.out.println("No book with this ISBN!");
		} else {
			System.out.println(bookLoan.toString());
			String dueDate = getResponseTo("Change due date (Hit Enter key for no change):");
			bookLoan.setDueDate(dueDate);
		}
	}

	public void findBookLoan() {
		String isbn = getResponseTo("Find a book loan. Enter ISBN number: ");
		BookLoan bookLoan = bookLib.findLoan(isbn);
		if (Objects.isNull(bookLoan)) {
			System.out.println("No book with this ISBN!");
		} else {
			System.out.println(bookLoan.toString());
		}
	}

	public void listBookLoans() {
		BookLoan[] loanReg = bookLib.getLoanReg();
		for (int i = 0; i <= bookLib.getLastLoanIndex(); i++) {
			System.out.println("Loan #" + (i + 1));
			System.out.println(loanReg[i].toString());
		}

	}

	private static String getResponseTo(String s) {
		System.out.print(s);
		return (input.nextLine());
	}

	/* to check if a string is numeric.
	 * code refer to below web site:
	 * https://stackoverflow.com/questions/1102891/how-to-check-if-a-string-is-numeric-in-java*/
	private static boolean isValidNumber(String s) {
		for (int i = 0; i < s.length(); i++) {
			if (!Character.isDigit(s.charAt(i))) {
				return false;
			}
		}
		return true;
	}

}

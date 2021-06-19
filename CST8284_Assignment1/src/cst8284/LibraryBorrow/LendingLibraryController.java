package cst8284.LibraryBorrow;

import java.util.Objects;

import java.util.Scanner;

/**
 * Class Name: CST8284-300 Assignment1 
 * Author Name: Chunfang Song 
 * Class Name: LendingLibraryController 
 * Date: June 18,2021
 */

/*
 * class LendingLibraryController has total 14 methods, it uses bookLib object
 * to access LendingLibrary object to do add/modify/find/list actions through
 * addXXX/changeXXX/findXXX/listXXX methods for User/Book/BookLoan objects.
 * getResponseTo method will interact with user input/output and return a
 * String. isValidNumber method to verify if a String input is pure digit and
 * return a boolean result
 */
public class LendingLibraryController {
	private LendingLibrary bookLib;
	private static Scanner input = new Scanner(System.in);

	public LendingLibraryController() {
		bookLib = new LendingLibrary();
	}

	/*
	 * addUser method to create a new user for user array will verify the age input
	 * is bigger than zero and will call isValidNumber method to verify age is pure
	 * digit
	 */
	public void addUser() {
		System.out.println("New User Entry");
		String lastName = getResponseTo("Last Name: ");
		String firstName = getResponseTo("First Name: ");
		String tmpAge = getResponseTo("Age: ");
		int age = 0;

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
		boolean addResult = bookLib.addUser(user);
		if (addResult) {
			System.out.println("User was added");
		} else {
			System.out.println("User was full, could not add this user!");
		}
	}

	/*
	 * changeUser method to modify the user address. user identified by first and
	 * last name, use bookLib object to call findUser method in LendingLibrary to
	 * traverse user in user array. use Object.isNull to check if the user object is
	 * null. code citation refer to the web site:
	 * https://www.delftstack.com/howto/java/java-check-if-object-is-null/
	 */
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

	/*
	 * findUser method to search a user by first and last name. use bookLib object
	 * to call findUser method in LendingLibrary to traverse user in user array. and
	 * use to String method to output the searching result. use Object.isNull to
	 * check if the user object is null.
	 * code citation refer to the web site:
	 * https://www.delftstack.com/howto/java/java-check-if-object-is-null/
	 */
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

	/*
	 * listUser method to list all the users in user array. use bookLib object to
	 * call getUserReg and getUserIndex method and use toString method to output all
	 * the information.
	 */
	public void listUser() {
		User[] userReg = bookLib.getUserReg();
		for (int i = 0; i <= bookLib.getLastUserIndex(); i++) {
			System.out.println("User #" + (i + 1));
			System.out.println(userReg[i].toString());
		}
	}

	/*
	 * addBook method to create a new book. and the new book information will be
	 * stored in a book array. will use two loops to verify the ISBN number and
	 * publication date input. the ISBN number must be 10 digits and publication
	 * date must be 4 digits.
	 */
	public void addBook() {
		System.out.println("New Book Entry");
		String title = getResponseTo("Title: ");
		String author = getResponseTo("Author: ");
		String pubDate = getResponseTo("Publication date (year in NNNN format): ");

		/* use isValidNumber method to verify the publication date is 4 digits */
		while (true) {
			if (pubDate.length() == 4 && isValidNumber(pubDate))
				break;
			pubDate = getResponseTo("Publication date (year in NNNN format): ");
		}

		String isbn = getResponseTo("ISBN number (10 digits): ");
		Book book = new Book(title, author, isbn, pubDate);

		/* use verifyISBNNumber method to verify ISBN number is 10 digits */
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

	/*
	 * changeBook method to modify the book information. Book identified by the ISBN
	 * number, use bookLib object to call findBook method in LendingLibrary to
	 * traverse book in book array. will verify the publication date is valid using
	 * isValidNumber method.
	 */
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

			/* use isValidNumber method to verify the publication date is 4 digits */
			while (true) {
				if (pubDate.length() == 4 && isValidNumber(pubDate))
					break;
				pubDate = getResponseTo("Publication date (year in NNNN format): ");
				book.setPubDate(pubDate);
			}
		}
	}

	/*
	 * findBook method to search a book by ISBN number. use bookLib object to call
	 * findBook method in LendingLibrary to traverse book in book array. and output
	 * the book information if founded
	 */
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

	/*
	 * listBook method to list all the books in book array. use bookLib object to
	 * call getBookReg and getBookIndex method and use toString method to output all
	 * the information.
	 */
	public void listBook() {
		Book[] bookReg = bookLib.getBookReg();
		for (int i = 0; i <= bookLib.getLastBookIndex(); i++) {
			System.out.println("Book #" + (i + 1));
			System.out.println(bookReg[i].toString());
		}
	}

	/*
	 * addBookLoan method to create a new loan. and the loan information will be
	 * stored in a bookLoan array. the entry will fail if 1. The ISBN number is
	 * invalid. 2. The user does not exist. 3. The book is already loaned. 4. The
	 * user has borrowed 2 books. 5. The bookLoan array is full.
	 */
	public void addBookLoan() {
		System.out.println("New Loan Entry");
		String lastName = getResponseTo("User last name:");
		String firstName = getResponseTo("User first name:");
		String isbn = getResponseTo("Book isbn number:");
		String dueDate = getResponseTo("Loan date (format yyyymmdd): ");
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

	/* changeBookLoan method to modify the due date using the ISBN number */
	public void chageBookLoan() {
		System.out.println("Modify loan details.");
		String isbn = getResponseTo("ISBN number for the loan you want to modify:");
		BookLoan bookLoan = bookLib.findLoan(isbn);
		if (Objects.isNull(bookLoan)) {
			System.out.println("No book with this ISBN!");
		} else {
			System.out.println(bookLoan.toString());
			String dueDate = getResponseTo("Change due date (Hit Enter key for no change):");
			if (!dueDate.isEmpty()) {
				while (true) {
					if (dueDate.length() == 8 && isValidNumber(dueDate))
						break;
					dueDate = getResponseTo("Change due date (format yyyymmdd): ");
				}
				bookLoan.setDueDate(dueDate);
			}
		}
	}

	/*
	 * findBookLoan method to search a book loan by ISBN number. use bookLib object
	 * to call findLoan method in LendingLibrary to traverse loan in bookLoan array.
	 * and output the loan information if founded.
	 */
	public void findBookLoan() {
		String isbn = getResponseTo("Find a book loan. Enter ISBN number: ");
		BookLoan bookLoan = bookLib.findLoan(isbn);
		if (Objects.isNull(bookLoan)) {
			System.out.println("No book with this ISBN!");
		} else {
			System.out.println(bookLoan.toString());
		}
	}

	/*
	 * list BookLoans method to output all the loan informations in the loanReg
	 * array
	 */
	public void listBookLoans() {
		BookLoan[] loanReg = bookLib.getLoanReg();
		for (int i = 0; i <= bookLib.getLastLoanIndex(); i++) {
			System.out.println("Loan #" + (i + 1));
			System.out.println(loanReg[i].toString());
		}

	}

	/*
	 * getResponseTo is a helper method that interactive with user, and then scans
	 * the input and returns the user’s response as a String. The purpose of the
	 * method is to make the code cleaner and improve code readability.
	 */
	private static String getResponseTo(String s) {
		System.out.print(s);
		return (input.nextLine());
	}

	/*
	 * isValidNumber method to check if a string is numeric. It will return a 
	 * boolean value depends on the verification result.
	 * code citation refer to below web site:
	 * https://stackoverflow.com/questions/1102891/how-to-check-if-a-string-is-
	 * numeric-in-java
	 */
	private static boolean isValidNumber(String s) {
		for (int i = 0; i < s.length(); i++) {
			if (!Character.isDigit(s.charAt(i))) {
				return false;
			}
		}
		return true;
	}

}

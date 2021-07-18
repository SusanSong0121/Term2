package library;

import java.util.ArrayList;
import java.util.Objects;

import java.util.Scanner;

/**
 * Class Name: CST8284-300 Assignment2 
 * Author Name: Chunfang Song 
 * Class Name: LendingLibraryController 
 * Date: July 15,2021
 */

/*
 * class LendingLibraryController has total 15 methods, it uses bookLib object
 * to access LendingLibrary object to do add/change/find/list/delete actions
 * through addXXX/changeXXX/findXXX/listXXX/deleteXXX methods for
 * User/Book/BookLoan objects. getResponseTo method will interact with user
 * input/output and return a String. isValidNumber method to verify if a String
 * input is pure digit and return a boolean result.verifyISBNNumber method to
 * verify isbn number is 10 digits.
 */
public class LendingLibraryController {
	private LendingLibrary bookLib;
	private static Scanner input = new Scanner(System.in);
	private final int PUB_DATE_LENGTH = 4; // constant 4 used in addBook & changeBook to verify user input
	private final int DUE_DATE_LENGTH = 8; // constant 8 used in addBookLoan & changeBookLoan to verify user input

	public LendingLibraryController() {
		bookLib = new LendingLibrary();
	}

	/*
	 * addUser method to create a new user for user array list, will verify the age
	 * input is bigger than zero and will call isValidNumber method to verify age is
	 * pure digit
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

		User user = bookLib.findUser(firstName, lastName);
		if (user != null) {
			System.out.println("This user already exists");
		} else {
			User user2 = new User(firstName, lastName, address, age);
			boolean addResult = bookLib.addUser(user2);
			if (addResult) {
				System.out.println("User was added");
			} else {
				System.out.println("User already exists, could not add this user!");
			}
		}
	}

	/*
	 * changeUser method to modify the user address. user identified by first and
	 * last name, use bookLib object to call findUser method in LendingLibrary to
	 * traverse user in user array list. use Object.isNull to check if the user
	 * object is null. code citation refer to the web site:
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
	 * to call findUser method in LendingLibrary to traverse user in user array
	 * list. and use to String method to output the searching result. use
	 * Object.isNull to check if the user object is null. code citation refer to the
	 * web site: https://www.delftstack.com/howto/java/java-check-if-object-is-null/
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
	 * listUser method to list all the users in user array list. use bookLib object
	 * to call getUserReg and getUserIndex method and use toString method to output
	 * all the information.
	 */
	public void listUser() {
		ArrayList<User> userReg = bookLib.getUserReg();
		for (int i = 0; i < userReg.size(); i++) {
			System.out.println("User #" + (i + 1));
			System.out.println(userReg.get(i).toString());
		}
	}

	/*
	 * addBook method to create a new book. and the new book information will be
	 * stored in a book array list. will use two loops to verify the ISBN number and
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
			if (pubDate.length() == PUB_DATE_LENGTH && isValidNumber(pubDate))
				break;
			pubDate = getResponseTo("Publication date (year in NNNN format): ");
		}

		String isbn = getResponseTo("ISBN number (10 digits): ");
		Book book = new Book(title, author, isbn, pubDate);

		/* use verifyISBNNumber method to verify ISBN number is 10 digits */
		while (true) {
			if (verifyISBNNumber(isbn))
				break;
			else {
				isbn = getResponseTo("ISBN number (10 digits): ");
				book.setIsbnNumber(isbn);
			}
		}

		if (bookLib.addBook(book)) {
			System.out.println("Book was added");
		} else {
			System.out.println("Book already exists, could not add this book!");
		}
	}

	/*
	 * changeBook method to modify the book information. Book identified by the ISBN
	 * number, use bookLib object to call findBook method in LendingLibrary to
	 * traverse book in book array list. will verify the publication date is valid
	 * using isValidNumber method.
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
				if (pubDate.length() == PUB_DATE_LENGTH && isValidNumber(pubDate))
					break;
				pubDate = getResponseTo("Publication date (year in NNNN format): ");
				book.setPubDate(pubDate);
			}
		}
	}

	/*
	 * findBook method to search a book by ISBN number. use bookLib object to call
	 * findBook method in LendingLibrary to traverse book in book array list. and
	 * output the book information if founded
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
	 * listBook method to list all the books in book array list. use bookLib object
	 * to call getBookReg and getBookIndex method and use toString method to output
	 * all the information.
	 */
	public void listBook() {
		ArrayList<Book> bookReg = bookLib.getBookReg();
		for (int i = 0; i < bookReg.size(); i++) {
			System.out.println("Book #" + (i + 1));
			System.out.println(bookReg.get(i).toString());
		}
	}

	/*
	 * addBookLoan method to create a new loan. and the loan information will be
	 * stored in a bookLoan array list. the entry will fail if 1. The ISBN number is
	 * invalid. 2. The user does not exist. 3. The book is already loaned. 4. The
	 * user has borrowed 2 books.
	 */
	public void addBookLoan() {
		System.out.println("New Loan Entry");
		String lastName = getResponseTo("User last name:");
		String firstName = getResponseTo("User first name:");
		String isbn = getResponseTo("Book isbn number:");
		String dueDate = getResponseTo("Loan date (format yyyymmdd): ");
		while (true) {
			if (dueDate.length() == DUE_DATE_LENGTH && isValidNumber(dueDate))
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
				System.out.println("Could not add this loan!");
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
					if (dueDate.length() == DUE_DATE_LENGTH && isValidNumber(dueDate))
						break;
					dueDate = getResponseTo("Change due date (format yyyymmdd): ");
				}
				bookLoan.setDueDate(dueDate);
			}
		}
	}

	/*
	 * findBookLoan method to search a book loan by ISBN number. use bookLib object
	 * to call findLoan method in LendingLibrary to traverse loan in bookLoan array
	 * list. and output the loan information if founded.
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
	 * array list
	 */
	public void listBookLoans() {
		ArrayList<BookLoan> loanReg = bookLib.getLoanReg();
		for (int i = 0; i < loanReg.size(); i++) {
			System.out.println("Loan #" + (i + 1));
			System.out.println(loanReg.get(i).toString());
		}
	}

	/*
	 * deleteUser method to delete a user, depending on the user first name and last
	 * name.
	 */
	public void deleteUser() {
		System.out.println("Delete user:");
		String lastName = getResponseTo("Last Name: ");
		String firstName = getResponseTo("First Name: ");

		if (bookLib.deleteUser(firstName, lastName)) {
			System.out.println("User delete successfully!");
		} else {
			System.out.println("Can't delete this user!");
		}
	}

	/*
	 * deleteBook method to delete a book, depending on the isbn number.
	 */
	public void deleteBook() {
		System.out.println("Delete book:");
		String isbn = getResponseTo("Book isbn number:");

		if (bookLib.deleteBook(isbn)) {
			System.out.println("Book delete successfully!");
		} else {
			System.out.println("Can't delete this book!");
		}

	}

	/*
	 * deleteBookLoan method to delete a loan, depending on the isbn number.
	 */
	public void deleteBookLoan() {
		System.out.println("Delete loan:");
		String isbn = getResponseTo("Book isbn number:");

		if (bookLib.deleteLoan(isbn)) {
			System.out.println("Loan delete successfully!");
		} else {
			System.out.println("Can't find this loan!");
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
	 * boolean value depends on the verification result. code citation refer to
	 * below web site:
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

	/*
	 * verifyISBNNumber method is used to verify the ISBN is exactly 10 digits. It
	 * will return a boolean value depends on the verification result.
	 */
	public boolean verifyISBNNumber(String s) {
		if (s.length() != 10) {
			return false;
		}

		for (int i = 0; i < s.length(); i++) {
			if (!Character.isDigit(s.charAt(i))) {
				return false;
			}
		}
		return true;
	}

}

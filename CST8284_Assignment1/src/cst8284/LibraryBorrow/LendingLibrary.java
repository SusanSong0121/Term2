package cst8284.LibraryBorrow;

/**
 * Class Name: CST8284-300 Assignment1
 * Author Name: Chunfang Song 
 * Class Name: LendingLibrary 
 * Date: June 14,2021
 */

public class LendingLibrary {
	private static final int MAX_BOOK_NUMBER = 10, MAX_USER_NUMBER = 5, MAX_LOAN_NUMBER = 5, MAX_LOAN_PER_USER = 2;
	private static int lastBookIndex;
	private static int lastUserIndex;
	private static int lastLoanIndex;
	private Book[] bookReg;
	private User[] userReg;
	private BookLoan[] loanReg;

	public LendingLibrary() {
		lastBookIndex = -1;
		lastUserIndex = -1;
		lastLoanIndex = -1;
		bookReg = new Book[MAX_BOOK_NUMBER];
		userReg = new User[MAX_USER_NUMBER];
		loanReg = new BookLoan[MAX_LOAN_NUMBER];
	}

	public User makeUser(String firstName, String lastName, String address, int age, int id) {
		if (age <= 0) {
			return null;
		}

		return new User(firstName, lastName, address, age, id);
	}

	public boolean addUser(User u) {
		if (lastUserIndex >= MAX_USER_NUMBER - 1) {
			return false;
		}
		for (int i = 0; i <= lastUserIndex; i++) {
			boolean firstComparsion = u.getFirstName().equals(userReg[i].getFirstName());
			boolean lastComparion = u.getLastName().equals(userReg[i].getLastName());
			if (firstComparsion && lastComparion) {
				return false;
			}
		}
		lastUserIndex++;
		userReg[lastUserIndex] = u;
		return true;
	}

	public boolean addBook(Book b) {
		if (lastBookIndex >= MAX_BOOK_NUMBER - 1) {
			return false;
		}
		for (int i = 0; i <= lastBookIndex; i++) {
			if (b.getIsbnNumber().equals(bookReg[i].getIsbnNumber())) {
				return false;
			}
		}
		lastBookIndex++;
		bookReg[lastBookIndex] = b;
		return true;
	}

	public boolean addLoan(BookLoan l) {
		if (lastLoanIndex >= MAX_LOAN_NUMBER - 1) {
			return false;
		}
		for (int i = 0; i <= lastLoanIndex; i++) {
			String newLoanIsbn = l.getBook().getIsbnNumber();
			String oldLoanIsbn = bookReg[i].getIsbnNumber();
			if (newLoanIsbn.equals(oldLoanIsbn)) {
				return false;
			}
		}
		lastLoanIndex++;
		loanReg[lastLoanIndex] = l;
		return true;
	}

	public User findUser(String firstName, String lastName) {
		for (int i = 0; i <= lastUserIndex; i++) {
			if (userReg[i].getFirstName().equals(firstName) && userReg[i].getLastName().equals(lastName)) {
				return userReg[i];
			}
		}
		return null;
	}

	public Book findBook(String isbnNumber) {
		for (int i = 0; i <= lastBookIndex; i++) {
			if (bookReg[i].getIsbnNumber().equals(isbnNumber)) {
				return bookReg[i];
			}
		}
		return null;
	}

	public BookLoan findLoan(String isbnNumber) {
		for (int i = 0; i <= lastLoanIndex; i++) {
			if (loanReg[i].getBook().getIsbnNumber().equals(isbnNumber)) {
				return loanReg[i];
			}
		}
		return null;
	}

	public boolean userCanBorrow(User u) {
		int count = 0;
		for (int i = 0; i <= lastLoanIndex; i++) {
			if (loanReg[i].getUser() == u)
				count++;
		}
		if (count >= MAX_LOAN_PER_USER) {
			return false;
		}
		return true;
	}

	public boolean isBookLoaned(Book b) {
		for (int i = 0; i <= lastLoanIndex; i++) {
			if (loanReg[i].getBook().getIsbnNumber().equals(b.getIsbnNumber())) {
				return true;
			}
		}
		return false;
	}

	public int getLastBookIndex() {
		return lastBookIndex;
	}

//	public static void setLastBookIndex(int lastBookIndex) {
//		LendingLibrary.lastBookIndex = lastBookIndex;
//	}

	public int getLastUserIndex() {
		return lastUserIndex;
	}

//	public static void setLastUserIndex(int lastUserIndex) {
//		LendingLibrary.lastUserIndex = lastUserIndex;
//	}

	public int getLastLoanIndex() {
		return lastLoanIndex;
	}

//	public static void setLastLoanIndex(int lastLoanIndex) {
//		LendingLibrary.lastLoanIndex = lastLoanIndex;
//	}

	public Book[] getBookReg() {
		return bookReg;
	}

	public void setBookReg(Book[] bookReg) {
		this.bookReg = bookReg;
		lastBookIndex = bookReg.length - 1;
	}

	public User[] getUserReg() {
		return userReg;
	}

	public void setUserReg(User[] userReg) {
		this.userReg = userReg;
		lastUserIndex = userReg.length - 1;
	}

	public BookLoan[] getLoanReg() {
		return loanReg;
	}

	public void setLoanReg(BookLoan[] loanReg) {
		this.loanReg = loanReg;
		lastLoanIndex = loanReg.length - 1;
	}

}

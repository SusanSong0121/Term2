package cst8284.LibraryBorrow;

/**
 * Class Name: CST8284-300 Assignment1 
 * Author Name: Chunfang Song 
 * Class Name: LendingLibrary 
 * Date: June 18,2021
 */
/*
 * LendingLibray class includes makeUser, addUser, addBook, addLoan, findUser,
 * findBook, fingLoan, userCanBorrow, isBookLoaned methods. and its setters and
 * getters. and a constructor.
 */
public class LendingLibrary {
	private static final int MAX_BOOK_NUMBER = 10, 
			MAX_USER_NUMBER = 5, 
			MAX_LOAN_NUMBER = 5, 
			MAX_LOAN_PER_USER = 2;
	private static int lastBookIndex;
	private static int lastUserIndex;
	private static int lastLoanIndex;
	private Book[] bookReg;
	private User[] userReg;
	private BookLoan[] loanReg;

	/* default constructor */
	public LendingLibrary() {
		lastBookIndex = -1;
		lastUserIndex = -1;
		lastLoanIndex = -1;
		bookReg = new Book[MAX_BOOK_NUMBER];
		userReg = new User[MAX_USER_NUMBER];
		loanReg = new BookLoan[MAX_LOAN_NUMBER];
	}

	/*
	 * makerUser method to accept user input and return a new User object.
	 * 
	 * @parameters: firstName, lastName, address, age, id
	 */
	public User makeUser(String firstName, String lastName, String address, int age, int id) {
		if (age <= 0) {
			return null;
		}

		return new User(firstName, lastName, address, age, id);
	}

	/*
	 * addUser method is used to add a new user to the user array. and return a
	 * boolean value base on the addition result, if addition success will return
	 * true, otherwise return false. the new user will be stored in userReg array
	 */
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

	/*
	 * addBook method is used to add a new book. and return a boolean value base on
	 * the addition result, if addition success will return true, otherwise return
	 * false. the new book will be stored in bookReg array
	 */
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

	/*
	 * addLoan method is used to add a new loan. and return a boolean value base on
	 * the addition result, if addition success will return true, otherwise return
	 * false. the new loan will be stored in loanReg array
	 */
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

	/*
	 * findUser method is used to find a user by the first and last name. and will
	 * return a User object base on the result.
	 * 
	 * @parameters: firstName, lastName
	 */
	public User findUser(String firstName, String lastName) {
		for (int i = 0; i <= lastUserIndex; i++) {
			String oldFirstName = userReg[i].getFirstName();
			String oldLastName = userReg[i].getLastName();
			if (oldFirstName.equals(firstName) && oldLastName.equals(lastName)) {
				return userReg[i];
			}
		}
		return null;
	}

	/*
	 * findBook method is used to find a book by ISBN number. and will return a Book
	 * object base on the result.
	 * 
	 * @parameters: isbnNumber
	 */
	public Book findBook(String isbnNumber) {
		for (int i = 0; i <= lastBookIndex; i++) {
			if (bookReg[i].getIsbnNumber().equals(isbnNumber)) {
				return bookReg[i];
			}
		}
		return null;
	}

	/*
	 * findLoan method is used to find a loan by ISBN number. and will return a
	 * BookLoan object base on the result.
	 * 
	 * @parameters: isbnNumber
	 */
	public BookLoan findLoan(String isbnNumber) {
		for (int i = 0; i <= lastLoanIndex; i++) {
			if (loanReg[i].getBook().getIsbnNumber().equals(isbnNumber)) {
				return loanReg[i];
			}
		}
		return null;
	}

	/*
	 * userCanBorrow method to verifies that the user has not borrowed more than 2
	 * books. It will return a boolean value base on the result.
	 */
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

	/*
	 * isBookLoaned method is used for verify if the book already loaned. It will
	 * return a boolean value base on the result.
	 */
	public boolean isBookLoaned(Book b) {
		for (int i = 0; i <= lastLoanIndex; i++) {
			if (loanReg[i].getBook().getIsbnNumber().equals(b.getIsbnNumber())) {
				return true;
			}
		}
		return false;
	}

	/* accessor of lastBookIndex */
	public int getLastBookIndex() {
		return lastBookIndex;
	}

	/* accessor of lastUserIndex */
	public int getLastUserIndex() {
		return lastUserIndex;
	}

	/* accessor of lastLoanIndex */
	public int getLastLoanIndex() {
		return lastLoanIndex;
	}

	/* accessor of bookReg */
	public Book[] getBookReg() {
		return bookReg;
	}

	/* mutator of bookReg */
	public void setBookReg(Book[] bookReg) {
		this.bookReg = bookReg;
		lastBookIndex = bookReg.length - 1;
	}

	/* accessor of userReg */
	public User[] getUserReg() {
		return userReg;
	}

	/* mutator of userReg */
	public void setUserReg(User[] userReg) {
		this.userReg = userReg;
		lastUserIndex = userReg.length - 1;
	}

	/* accessor of loanReg */
	public BookLoan[] getLoanReg() {
		return loanReg;
	}

	/* mutator of loanReg */
	public void setLoanReg(BookLoan[] loanReg) {
		this.loanReg = loanReg;
		lastLoanIndex = loanReg.length - 1;
	}

}

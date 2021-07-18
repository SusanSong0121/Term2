package library;

import java.util.ArrayList;

/**
 * Class Name: CST8284-300 Assignment2 
 * Author Name: Chunfang Song 
 * Class Name: LendingLibrary 
 * Date: July 15,2021
 */
/*
 * LendingLibray class includes addUser, addBook, addLoan, findUser, findBook,
 * fingLoan, deleteUser, deleteBook, deleteLoan, userCanBorrow, isBookLoaned
 * methods. and its setters and getters. and a default constructor.
 */
public class LendingLibrary {
	private static final int MAX_LOAN_PER_USER = 2;

	private ArrayList<Book> bookReg;
	private ArrayList<User> userReg;
	private ArrayList<BookLoan> loanReg;

	/* default constructor */
	public LendingLibrary() {
		bookReg = new ArrayList<Book>();
		userReg = new ArrayList<User>();
		loanReg = new ArrayList<BookLoan>();
	}

	/*
	 * addUser method is used to add a new user to the user array. and return a
	 * boolean value base on the addition result, if addition success will return
	 * true, otherwise return false. the new user will be stored in userReg array
	 */
	public boolean addUser(User u) {
		for (User user : userReg) {
			if (user.equals(u))
				return false;
		}
		userReg.add(u);
		return true;
	}

	/*
	 * addBook method is used to add a new book. and return a boolean value base on
	 * the addition result, if addition success will return true, otherwise return
	 * false. the new book will be stored in bookReg array
	 */
	public boolean addBook(Book b) {
		for (Book book : bookReg) {
			if (book.equals(b))
				return false;
		}
		bookReg.add(b);
		return true;
	}

	/*
	 * addLoan method is used to add a new loan. and return a boolean value base on
	 * the addition result, if addition success will return true, otherwise return
	 * false. the new loan will be stored in loanReg array
	 */
	public boolean addLoan(BookLoan l) {
		for (BookLoan loan : loanReg) {
			if (loan.equals(l))
				return false;
		}
		loanReg.add(l);
		return true;
	}

	/*
	 * findUser method is used to find a user by the first and last name. and will
	 * return a User object base on the result.
	 * 
	 * @parameters: firstName, lastName
	 */
	public User findUser(String firstName, String lastName) {
		for (User user : userReg) {
			if (user.getFirstName().equals(firstName) && user.getLastName().equals(lastName))
				return user;
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
		for (Book book : bookReg) {
			if (book.getIsbnNumber().equals(isbnNumber))
				return book;
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
		for (BookLoan loan : loanReg) {
			if (loan.getBook().getIsbnNumber().equals(isbnNumber))
				return loan;
		}
		return null;
	}

	/*
	 * deleteUser method is used to delete a user by the first and last name. and
	 * will return boolean value base on the result. cannot delete a user if there
	 * is an existing book loan with that user
	 * 
	 * @parameters: firstName, lastName
	 */
	public boolean deleteUser(String firstName, String lastName) {
		User user = findUser(firstName, lastName);
		if (user != null) {
			for (BookLoan loan : loanReg) {
				if (loan.getUser().getFirstName().equals(firstName) && loan.getUser().getLastName().equals(lastName)) {
					return false;
				}
			}
			userReg.remove(user);
			return true;
		}
		return false;
	}

	/*
	 * deleteBook method is used to delete a book by ISBN number. and will return a
	 * boolean value base on the result. cannot delete a book if there if an
	 * existing book loan with that book
	 * 
	 * @parameters: isbnNumber
	 */
	public boolean deleteBook(String isbnNumber) {
		Book book = findBook(isbnNumber);
		if (book != null) {
			BookLoan loan = findLoan(isbnNumber);
			if (loan == null) {
				bookReg.remove(book);
				return true;
			}
		}
		return false;
	}

	/*
	 * deleteLoan method is used to delete a loan by ISBN number. and will return a
	 * boolean value base on the result.
	 * 
	 * @parameters: isbnNumber
	 */
	public boolean deleteLoan(String isbnNumber) {
		BookLoan loan = findLoan(isbnNumber);
		if (loan != null) {
			loanReg.remove(loan);
			return true;
		}
		return false;
	}

	/*
	 * userCanBorrow method to verifies that the user has not borrowed more than 2
	 * books. It will return a boolean value base on the result.
	 */
	public boolean userCanBorrow(User u) {
		int count = 0;
		for (BookLoan loan : loanReg) {
			if (loan.getUser().equals(u))
				count++;
		}
		return (count < MAX_LOAN_PER_USER);
	}

	/*
	 * isBookLoaned method is used for verify if the book already loaned. It will
	 * return a boolean value base on the result.
	 */
	public boolean isBookLoaned(Book b) {
		for (BookLoan loan : loanReg) {
			if (loan.getBook().equals(b))
				return true;
		}
		return false;
	}

	/* accessor of bookReg */
	public ArrayList<Book> getBookReg() {
		return bookReg;
	}

	/* mutator of bookReg */
	public void setBookReg(ArrayList<Book> bookReg) {
		this.bookReg = bookReg;
	}

	/* accessor of userReg */
	public ArrayList<User> getUserReg() {
		return userReg;
	}

	/* mutator of userReg */
	public void setUserReg(ArrayList<User> userReg) {
		this.userReg = userReg;
	}

	/* accessor of loanReg */
	public ArrayList<BookLoan> getLoanReg() {
		return loanReg;
	}

	/* mutator of loanReg */
	public void setLoanReg(ArrayList<BookLoan> loanReg) {
		this.loanReg = loanReg;
	}

}

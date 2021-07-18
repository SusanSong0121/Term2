package library;

/**
 * Class Name: CST8284-300 Assignment2 
 * Author Name: Chunfang Song 
 * Class Name: BookLoan 
 * Date: July 15,2021
 */

/*
 * BookLoan class with a constructor and getters/setters of all the fields. the
 * override toString method to generate a format of loan information, the equals
 * method to compare two book loans
 */
public class BookLoan {
	private User user;
	private Book book;
	private String dueDate;

	/*
	 * constructor with all the fields
	 * 
	 * @parameters: user, book, dueDate
	 */
	public BookLoan(User user, Book book, String dueDate) {
		this.user = user;
		this.book = book;
		this.dueDate = dueDate;
	}

	/* accessor of the user */
	public User getUser() {
		return user;
	}

	/* mutator of the user */
	public void setUser(User user) {
		this.user = user;
	}

	/* accessor of the book */
	public Book getBook() {
		return book;
	}

	/* mutator of the book */
	public void setBook(Book book) {
		this.book = book;
	}

	/* accessor of the dueDate */
	public String getDueDate() {
		return dueDate;
	}

	/* mutator of the dueDate */
	public void setDueDate(String dueDate) {
		this.dueDate = dueDate;
	}

	/*
	 * override toString method will return a string to generate a format of loan
	 * information
	 */
	@Override
	public String toString() {
		return String.format(
				"************ User name: %s %s\n************ Title: %s\n************ Author: %s\n************ ISBN: %s\n************ Due date: %s\n",
				user.getLastName(), user.getFirstName(), book.getTitle(), book.getAuthor(), book.getIsbnNumber(),
				getDueDate());
	}

	/*
	 * override equals() method to compare BookLoan. Two book loan equal if the
	 * book, the user, and the due date are equal
	 */
	@Override
	public boolean equals(Object o) {
		if (o instanceof BookLoan && o != null) {
			BookLoan loan = (BookLoan) o;
			return getBook().equals(loan.getBook()) && getUser().equals(loan.getUser())
					&& getDueDate().equals(loan.getDueDate());
		}

		return false;
	}

}
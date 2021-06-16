package cst8284.LibraryBorrow;

/**
 * Class Name: CST8284-300 Assignment1
 * Author Name: Chunfang Song
 * Class Name: BookLoan
 * Date: June 14,2021
 */

public class BookLoan {
	private User user;
	private Book book;
	private String dueDate;
	
	public BookLoan(User user, Book book, String dueDate) {
		this.user = user;
		this.book = book;
		this.dueDate = dueDate;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public String getDueDate() {
		return dueDate;
	}

	public void setDueDate(String dueDate) {
		this.dueDate = dueDate;
	}
	
	public String toString() {
		return String.format("************ User name: %s %s\n************ Title: %s\n************ Author: %s\n************ ISBN: %s\n************ Due date: %s\n", 
				   user.getLastName(), user.getFirstName(), book.getTitle(), book.getAuthor(), book.getIsbnNumber(), getDueDate());
	}

}

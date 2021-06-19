package cst8284.LibraryBorrow;

/**
 * Class Name: CST8284-300 Assignment1 
 * Author Name: Chunfang Song 
 * Class Name: Book 
 * Date: June 19,2021
 */

/*
 * Book class with a constructor and the getters/setters of all the fields, the
 * verifyISBNNumber method for the ISBN validation, and the toString method to
 * generate a format of book information
 */
public class Book {
	private String title;
	private String author;
	private String publicationDate;
	private String isbnNumber;

	/*
	 * constructor with all book fields.
	 * 
	 * @parameters: title, author, isbn, pubDate
	 */
	public Book(String title, String author, String isbn, String pubDate) {
		this.title = title;
		this.author = author;
		this.isbnNumber = isbn;
		this.publicationDate = pubDate;
	}

	/* accessor of the title */
	public String getTitle() {
		return title;
	}

	/* mutator of the title */
	public void setTitle(String title) {
		this.title = title;
	}

	/* accessor of the author */
	public String getAuthor() {
		return author;
	}

	/* mutator of the author */
	public void setAuthor(String author) {
		this.author = author;
	}

	/* accessor of the publicationDate */
	public String getPubDate() {
		return publicationDate;
	}

	/* mutator of the publicationDate */
	public void setPubDate(String pubDate) {
		this.publicationDate = pubDate;
	}

	/* accessor of the isbnNumber */
	public String getIsbnNumber() {
		return isbnNumber;
	}

	/* mutator of the isbnNumber */
	public void setIsbnNumber(String isbnNumber) {
		this.isbnNumber = isbnNumber;
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

	/*
	 * override toString method will return a String to generate a format of book
	 * information
	 */
	public String toString() {
		return String.format(
				"************ Title: %s\n************ Author: %s\n************ Publication Year: %s\n************ ISBN: %s\n",
				getTitle(), getAuthor(), getPubDate(), getIsbnNumber());
	}

}

package library;

/**
 * Class Name: CST8284-300 Assignment2 
 * Author Name: Chunfang Song 
 * Class Name: Book 
 * Date: July 15,2021
 */

/*
 * Book class with a constructor and the getters/setters of all the fields, the
 * toString method to generate a format of book information, the equals() method
 * to compare two books
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
	 * override toString() method will return a String to generate a format of book
	 * information
	 */
	@Override
	public String toString() {
		return String.format(
				"************ Title: %s\n************ Author: %s\n************ Publication Year: %s\n************ ISBN: %s\n",
				getTitle(), getAuthor(), getPubDate(), getIsbnNumber());
	}

	/*
	 * override equals() method to compare book. Two books equal if the title, the
	 * author, the isbn number, and the publication date are equal
	 */
	@Override
	public boolean equals(Object o) {
		if (o instanceof Book && o != null) {
			Book book = (Book) o;
			return this.getTitle().equals(book.getTitle()) && this.getAuthor().equals(book.getAuthor())
					&& this.getIsbnNumber().equals(book.getIsbnNumber()) && this.getPubDate().equals(book.getPubDate());
		}
		return false;
	}
}

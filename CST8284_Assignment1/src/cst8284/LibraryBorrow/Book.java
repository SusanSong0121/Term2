package cst8284.LibraryBorrow;

/**
 * Class Name: CST8284-300 Assignment1
 * Author Name: Chunfang Song
 * Class Name: Book
 * Date: June 14,2021
 */
public class Book {
	private String title;
	private String author;
	private String publicationDate;
	private String isbnNumber;
	
	public Book(String title, String author, String isbn, String pubDate) {
		this.title = title;
		this.author = author;
		this.isbnNumber = isbn;
		this.publicationDate = pubDate;		
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getAuthor() {
		return author;
	}
	
	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPubDate() {
		return publicationDate;
	}

	public void setPubDate(String pubDate) {
		this.publicationDate = pubDate;
	}

	public String getIsbnNumber() {
		return isbnNumber;
	}

	public void setIsbnNumber(String isbnNumber) {
		this.isbnNumber = isbnNumber;			
	}
	
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
	
	public String toString() {
		return String.format("************ Title: %s\n************ Author: %s\n************ Publication Year: %s\n************ ISBN: %s\n", 
				   getTitle(), getAuthor(), getPubDate(), getIsbnNumber());
	}

}

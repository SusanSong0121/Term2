package library.test;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import library.Book;

/**
 * Class Name: CST8284-300 Assignment2 
 * Author Name: Chunfang Song 
 * Class Name: Book 
 * Date: July 17,2021
 */
 
/*jUnit test for Book class. Includes 22 test methods */
public class BookTest {
	private final String DEFAULT_TITLE = "Big Java Early Objects";
	private final String DEFAULT_AUTHOR = "Horstmann Cay";
	private final String DEFAULT_ISBN = "9781119499";
	private final String DEFAULT_YEAR = "2018";
	
	private final String OTHER_TITLE = "My Book";
	private final String OTHER_AUTHOR = "Someone";
	private final String OTHER_ISBN = "0123456789";
	private final String OTHER_YEAR = "2021";
	
	Book book1;
	Book book2;
	Book book3;	

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		book1 = new Book(DEFAULT_TITLE, DEFAULT_AUTHOR, DEFAULT_ISBN, DEFAULT_YEAR);
		book2 = new Book(OTHER_TITLE, OTHER_AUTHOR, OTHER_ISBN, OTHER_YEAR);
	}

	@After
	public void tearDown() throws Exception {
	}

	//test constructor true
	@Test
	public void testBook_True() {
		String title = book1.getTitle();
		String author = book1.getAuthor();
		String isbn = book1.getIsbnNumber();
		String pubDate = book1.getPubDate();
		assertTrue(title.equals(DEFAULT_TITLE) && author.equals(DEFAULT_AUTHOR)
				&& isbn.equals(DEFAULT_ISBN) && pubDate.equals(DEFAULT_YEAR));
	}

	//test constructor false
	@Test
	public void testBook_False() {
		String title = book1.getTitle();
		String author = book1.getAuthor();
		String isbn = book1.getIsbnNumber();
		String pubDate = book1.getPubDate();
		assertFalse(title.equals(OTHER_TITLE) && author.equals(OTHER_AUTHOR)
				&& isbn.equals(OTHER_ISBN) && pubDate.equals(OTHER_YEAR));
	}
	
	//test getTitle() true
	@Test
	public void testGetTitle_True() {
		String title = book1.getTitle();
		assertTrue(title.equals(DEFAULT_TITLE));
	}
	
	//test getTitle() false
	@Test
	public void testGetTitle_False() {
		String title = book1.getTitle();
		assertFalse(title.equals(OTHER_TITLE));
	}

	//test setTitle() true
	@Test
	public void testSetTitle_True() {
		book1.setTitle(OTHER_TITLE);
		assertTrue(book1.getTitle().equals(OTHER_TITLE));
	}
	
	//test setTitle() false
	@Test
	public void testSetTitle_False() {
		book1.setTitle(OTHER_TITLE);
		assertFalse(book1.getTitle().equals(DEFAULT_TITLE));
	}

	//test getAuthor() true
	@Test
	public void testGetAuthor_True() {
		String author = book1.getAuthor();
		assertTrue(author.equals(DEFAULT_AUTHOR));
	}

	//test getAuthor() false
	@Test
	public void testGetAuthor_False() {
		String author = book1.getAuthor();
		assertFalse(author.equals(OTHER_AUTHOR));
	}
	
	//test setAuthor() true
	@Test
	public void testSetAuthor_True() {
		book1.setAuthor(OTHER_AUTHOR);
		assertTrue(book1.getAuthor().equals(OTHER_AUTHOR));
	}
	
	//test setAuthor() false
	@Test
	public void testSetAuthor_False() {
		book1.setAuthor(OTHER_AUTHOR);
		assertFalse(book1.getAuthor().equals(DEFAULT_AUTHOR));
	}

	//test getPubDate() true
	@Test
	public void testGetPubDate_True() {
		String pubDate = book1.getPubDate();
		assertTrue(pubDate.equals(DEFAULT_YEAR));
	}

	//test getPubDate() false
	@Test
	public void testGetPubDate_False() {
		String pubDate = book1.getPubDate();
		assertFalse(pubDate.equals(OTHER_YEAR));
	}

	//test setPubDate() true
	@Test
	public void testSetPubDate_True() {
		book1.setPubDate(OTHER_YEAR);
		assertTrue(book1.getPubDate().equals(OTHER_YEAR));
	}
	
	//test setPubDate() false
	@Test
	public void testSetPubDate_False() {
		book1.setPubDate(OTHER_YEAR);
		assertFalse(book1.getPubDate().equals(DEFAULT_YEAR));
	}

	//test getIsbnNumber() true
	@Test
	public void testGetIsbnNumber_True() {
		String isbn = book1.getIsbnNumber();
		assertTrue(isbn.equals(DEFAULT_ISBN));
	}
	
	//test getIsbnNumber() false
	@Test
	public void testGetIsbnNumber_False() {
		String isbn = book1.getIsbnNumber();
		assertFalse(isbn.equals(OTHER_ISBN));
	}

	//test setIsbnNumber() true
	@Test
	public void testSetIsbnNumber_True() {
		book1.setIsbnNumber(OTHER_ISBN);
		assertTrue(book1.getIsbnNumber().equals(OTHER_ISBN));
	}
	
	//test setIsbnNumber() false
	@Test
	public void testSetIsbnNumber_False() {
		book1.setIsbnNumber(OTHER_ISBN);
		assertFalse(book1.getIsbnNumber().equals(DEFAULT_ISBN));
	}

	//test the override toString() method
	@Test
	public void testToString_True() {
		String format = String.format(
				"************ Title: %s\n************ Author: %s\n************ Publication Year: %s\n************ ISBN: %s\n",
				book1.getTitle(), book1.getAuthor(), book1.getPubDate(), book1.getIsbnNumber());
		assertEquals(format, book1.toString());
	}
	
	//test the override toString() method
	@Test
	public void testToString_False() {
		String format = String.format(
				"************ Title: %s\n************ Author: %s\n************ Publication Year: %s\n************ ISBN: %s\n",
				book1.getTitle(), book1.getAuthor(), book1.getPubDate(), book1.getIsbnNumber());
		assertNotEquals(format, book2.toString());
	}

	//test the override equals method
	@Test
	public void testEqualsObject_True() {
		book3 = new Book(DEFAULT_TITLE, DEFAULT_AUTHOR, DEFAULT_ISBN, DEFAULT_YEAR);
		assertTrue(book1.equals(book3));
	}

	//test the override equals method
	@Test
	public void testEqualsObject_False() {
		assertFalse(book1.equals(book2));
	}
}

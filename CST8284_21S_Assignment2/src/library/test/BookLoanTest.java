package library.test;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import library.Book;
import library.BookLoan;
import library.User;

/**
 * Class Name: CST8284-300 Assignment2 
 * Author Name: Chunfang Song 
 * Class Name: BookLoanTest
 * Date: July 17,2021
 */

/*jUnit test for BookLoan class. Includes 18 test methods*/
public class BookLoanTest {
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
	
//	private final int FIRST_ID = 1000;
	private final String USER1_FIRST = "Peter";
	private final String USER1_LAST = "Pan";
	private final String USER1_ADDRESS = "11 main street";
	private final int USER1_AGE = 18;

	private final String USER2_FIRST = "Lily";
	private final String USER2_LAST = "Bell";
	private final String USER2_ADDRESS= "12 main road";
	private final int USER2_AGE = 20;
	
	User user1;
	User user2;
	
	private final String FIRST_DUE_DATE = "20210808";
	private final String SECOND_DUE_DATE = "20211224";
	
	BookLoan loan1;
	BookLoan loan2;
	BookLoan loan3;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	    user1 = new User(USER1_FIRST, USER1_LAST, USER1_ADDRESS, USER1_AGE);
	    user2 = new User(USER2_FIRST, USER2_LAST, USER2_ADDRESS, USER2_AGE);
		book1 = new Book(DEFAULT_TITLE, DEFAULT_AUTHOR, DEFAULT_ISBN, DEFAULT_YEAR);
		book2 = new Book(OTHER_TITLE, OTHER_AUTHOR, OTHER_ISBN, OTHER_YEAR);
		loan1 = new BookLoan(user1, book1, FIRST_DUE_DATE);
		loan2 = new BookLoan(user2, book2, SECOND_DUE_DATE);
	}

	@After
	public void tearDown() throws Exception {
	}

	//test constructor
	@Test
	public void testBookLoan_True() {
		User user = loan1.getUser();
		Book book = loan1.getBook();
		String dueDate = loan1.getDueDate();
		
		assertTrue(user.equals(user1) 
				&& book.equals(book1) 
				&& dueDate.equals(FIRST_DUE_DATE));
	}
	
	//test constructor
	@Test
	public void testBookLoan_False() {
		User user = loan1.getUser();
		Book book = loan1.getBook();
		String dueDate = loan1.getDueDate();
		
		assertFalse(user.equals(user2) 
				&& book.equals(book2) 
				&& dueDate.equals(SECOND_DUE_DATE));
	}

	//test getUser() method
	@Test
	public void testGetUser_True() {
		User user = loan1.getUser();
		assertEquals(user, user1);
	}
	
	//test getUser() method
	@Test
	public void testGetUser_False() {
		User user = loan1.getUser();
		assertNotEquals(user, user2);
	}

	//test setUser() method
	@Test
	public void testSetUser_True() {
		loan1.setUser(user2);
		assertEquals(loan1.getUser(), user2);
	}
	
	//test setUser() method
	@Test
	public void testSetUser_False() {
		loan1.setUser(user2);
		assertNotEquals(loan1.getUser(), user1);
	}

	//test getBook() method
	@Test
	public void testGetBook_True() {
		Book book = loan1.getBook();
		assertEquals(book, book1);
	}
	
	//test getBook() method
	@Test
	public void testGetBook_False() {
		Book book = loan1.getBook();
		assertNotEquals(book, book2);
	}

	//test setBook() method
	@Test
	public void testSetBook_True() {
		loan1.setBook(book2);
		assertEquals(loan1.getBook(), book2);
	}
	
	//test setBook() method
	@Test
	public void testSetBook_False() {
		loan1.setBook(book2);
		assertNotEquals(loan1.getBook(), book1);
	}

	//test getDueDate() method
	@Test
	public void testGetDueDate_True() {
		String dueDate = loan1.getDueDate();
		assertEquals(dueDate, FIRST_DUE_DATE);
	}
	
	//test getDueDate() method
	@Test
	public void testGetDueDate_False() {
		String dueDate = loan1.getDueDate();
		assertNotEquals(dueDate, SECOND_DUE_DATE);
	}

	//test setDueDate() method
	@Test
	public void testSetDueDate_True() {
		loan1.setDueDate(SECOND_DUE_DATE);
		assertEquals(loan1.getDueDate(), SECOND_DUE_DATE);
	}
	
	//test setDueDate() method
	@Test
	public void testSetDueDate_False() {
		loan1.setDueDate(SECOND_DUE_DATE);
		assertNotEquals(loan1.getDueDate(), FIRST_DUE_DATE);
	}

	//test override toString() method
	@Test
	public void testToString_True() {
		String string = String.format(
				"************ User name: %s %s\n************ Title: %s\n************ Author: %s\n************ ISBN: %s\n************ Due date: %s\n",
				user1.getLastName(), user1.getFirstName(), book1.getTitle(), book1.getAuthor(), book1.getIsbnNumber(),
				loan1.getDueDate());
		assertEquals(string, loan1.toString());
	}
	
	//test override toString() method
	@Test
	public void testToString_False() {
		String string = String.format(
				"************ User name: %s %s\n************ Title: %s\n************ Author: %s\n************ ISBN: %s\n************ Due date: %s\n",
				user1.getLastName(), user1.getFirstName(), book1.getTitle(), book1.getAuthor(), book1.getIsbnNumber(),
				loan1.getDueDate());
		assertNotEquals(string, loan2.toString());
	}

	//test override equals method
	@Test
	public void testEqualsObject_True() {
		loan3 = new BookLoan(user1, book1, FIRST_DUE_DATE);
		assertTrue(loan1.equals(loan3));
	}
	
	//test override equals method
	@Test
	public void testEqualsObject_False() {
		assertFalse(loan1.equals(loan2));
	}

}

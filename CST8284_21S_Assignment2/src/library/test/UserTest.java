package library.test;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import library.User;

/**
 * Class Name: CST8284-300 Assignment2 
 * Author Name: Chunfang Song 
 * Class Name: UserTest
 * Date: July 17,2021
 */

/* jUnit test for User class. Includes 30 test methods */
public class UserTest {
	private final int FIRST_ID = 1000;
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
	User user3;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	    user1 = new User(FIRST_ID, USER1_FIRST, USER1_LAST, USER1_ADDRESS, USER1_AGE);
	    user2 = new User(USER2_FIRST, USER2_LAST, USER2_ADDRESS, USER2_AGE);
	    user3 = new User(USER1_FIRST, USER1_LAST, USER1_ADDRESS);
	}

	@After
	public void tearDown() throws Exception {
	}

	//test the first constructor which has 5 parameters
	@Test
	public void testUserIntStringStringStringInt_True() {
		int id = user1.getId();
		String first = user1.getFirstName();
		String last = user1.getLastName();
		String address = user1.getAddress();
		int age = user1.getAge();
		
		assertTrue(id == FIRST_ID
				&& first.equals(USER1_FIRST) 
				&& last.equals(USER1_LAST)
				&& address.equals(USER1_ADDRESS)
				&& age == USER1_AGE);
	}
	
	//test the first constructor which has 5 parameters
	@Test
	public void testUserIntStringStringStringInt_False() {
		int id = user1.getId();
		String first = user1.getFirstName();
		String last = user1.getLastName();
		String address = user1.getAddress();
		int age = user1.getAge();
		
		assertFalse(id == (FIRST_ID + 1)
				&& first.equals(USER2_FIRST) 
				&& last.equals(USER2_LAST)
				&& address.equals(USER2_ADDRESS)
				&& age == USER2_AGE);
	}

	//test the second constructor which has 4 parameters
	@Test
	public void testUserStringStringStringInt_True() {
		String first = user2.getFirstName();
		String last = user2.getLastName();
		String address = user2.getAddress();
		int age = user2.getAge();
		
		assertTrue(first.equals(USER2_FIRST) 
				&& last.equals(USER2_LAST)
				&& address.equals(USER2_ADDRESS)
				&& age == USER2_AGE);
	}

	//test the second constructor which has 4 parameters
	@Test
	public void testUserStringStringStringInt_False() {
		String first = user2.getFirstName();
		String last = user2.getLastName();
		String address = user2.getAddress();
		int age = user2.getAge();
		
		assertFalse(first.equals(USER1_FIRST) 
				&& last.equals(USER1_LAST)
				&& address.equals(USER1_ADDRESS)
				&& age == USER1_AGE);
	}
	
	//test the third constructor which has 3 parameters
	@Test
	public void testUserStringStringString_True() {
		String first = user3.getFirstName();
		String last = user3.getLastName();
		String address = user3.getAddress();
		
		assertTrue(first.equals(USER1_FIRST) 
				&& last.equals(USER1_LAST)
				&& address.equals(USER1_ADDRESS));
	}
	
	//test the third constructor which has 3 parameters
	@Test
	public void testUserStringStringString_False() {
		String first = user3.getFirstName();
		String last = user3.getLastName();
		String address = user3.getAddress();
		
		assertFalse(first.equals(USER2_FIRST) 
				&& last.equals(USER2_LAST)
				&& address.equals(USER2_ADDRESS));
	}

	//test getId() method
	@Test
	public void testGetId_True() {
		int id = user1.getId();
		assertTrue(id == FIRST_ID);
	}
	
	//test getId() method
	@Test
	public void testGetId_False() {
		int id = user2.getId();
		assertFalse(id == FIRST_ID);
	}

	//test setId() method
	@Test
	public void testSetId_True() {
		user1.setId(FIRST_ID);
		assertTrue(user1.getId() == FIRST_ID);
	}
	
	//test setId() method
	@Test
	public void testSetId_False() {
		user1.setId(FIRST_ID);
		assertFalse(user1.getId() == (FIRST_ID + 1));
	}

	//test getFirstName() method
	@Test
	public void testGetFirstName_True() {
		String first = user1.getFirstName();
		assertTrue(first.equals(USER1_FIRST));
	}
	
	//test getFirstName() method
	@Test
	public void testGetFirstName_False() {
		String first = user1.getFirstName();
		assertFalse(first.equals(USER2_FIRST));
	}

	//test setFirstName() method
	@Test
	public void testSetFirstName_True() {
		user1.setFirstName(USER2_FIRST);
		assertTrue(user1.getFirstName().equals(USER2_FIRST));
	}
	
	//test setFirstName() method
	@Test
	public void testSetFirstName_False() {
		user1.setFirstName(USER2_FIRST);
		assertFalse(user1.getFirstName().equals(USER1_FIRST));
	}

	//test getLastName() method
	@Test
	public void testGetLastName_True() {
		String last = user1.getLastName();
		assertTrue(last.equals(USER1_LAST));
	}
	
	//test getLastName() method
	@Test
	public void testGetLastName_False() {
		String last = user1.getLastName();
		assertFalse(last.equals(USER2_LAST));
	}

	//test setLastName() method
	@Test
	public void testSetLastName_True() {
		user1.setLastName(USER2_LAST);
		assertTrue(user1.getLastName().equals(USER2_LAST));
	}
	
	//test setLastName() method
	@Test
	public void testSetLastName_False() {
		user1.setLastName(USER2_LAST);
		assertFalse(user1.getLastName().equals(USER1_LAST));
	}

	//test getAddress() method
	@Test
	public void testGetAddress_True() {
		String address = user1.getAddress();
		assertTrue(address.equals(USER1_ADDRESS));
	}

	//test getAddress() method
	@Test
	public void testGetAddress_False() {
		String address = user1.getAddress();
		assertFalse(address.equals(USER2_ADDRESS));
	}
	
	//test setAddress() method
	@Test
	public void testSetAddress_True() {
		user1.setAddress(USER2_ADDRESS);
		assertTrue(user1.getAddress().equals(USER2_ADDRESS));
	}
	
	//test setAddress() method
	@Test
	public void testSetAddress_False() {
		user1.setAddress(USER2_ADDRESS);
		assertFalse(user1.getAddress().equals(USER1_ADDRESS));
	}

	//test getAge() method
	@Test
	public void testGetAge_True() {
		int age = user1.getAge();
		assertTrue(age == USER1_AGE);
	}
	
	//test getAge() method
	@Test
	public void testGetAge_False() {
		int age = user1.getAge();
		assertFalse(age == USER2_AGE);
	}

	//test setAge() method
	@Test
	public void testSetAge_True() {
		user1.setAge(USER2_AGE);
		assertTrue(user1.getAge() == USER2_AGE);
	}

	//test setAge() method
	@Test
	public void testSetAge_False() {
		user1.setAge(USER2_AGE);
		assertFalse(user1.getAge() == USER1_AGE);
	}
	
	//test the override toString() method
	@Test
	public void testToString_True() {
		String string = String.format(
				"************ User id: %s\n************ User name: %s %s\n************ Age: %d\n************ Address: %s\n",
				user1.getId(), user1.getLastName(), user1.getFirstName(), user1.getAge(), user1.getAddress());
		assertEquals(string, user1.toString());
	}
	
	//test the override toString() method
	@Test
	public void testToString_False() {
		String string = String.format(
				"************ User id: %s\n************ User name: %s %s\n************ Age: %d\n************ Address: %s\n",
				user1.getId(), user1.getLastName(), user1.getFirstName(), user1.getAge(), user1.getAddress());
		assertNotEquals(string, user2.toString());
	}

	//test the override equals method
	@Test
	public void testEqualsObject_True() {
		assertTrue(user1.equals(user3));
	}
	
	//test the override equals method
	@Test
	public void testEqualsObject_False() {
		assertFalse(user1.equals(user2));
	}

}

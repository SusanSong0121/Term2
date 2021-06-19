package cst8284.LibraryBorrow;

/**
 * Class Name: CST8284-300 Assignment1 
 * Author Name: Chunfang Song 
 * Class Name: User 
 * Date: June 18,2021
 */

/*
 * User class with 3 constructors which chained one by one, getters and setters
 * of the fields and toString method to generate a format of user information
 */
public class User {
	private static int userNextId = 1000;
	private int id;
	private String firstName;
	private String lastName;
	private String address;
	private int age;

	/*
	 * constructor with all fields.
	 * 
	 * @parameters: firstName, lastName, address, age, id
	 */
	public User(String firstName, String lastName, String address, int age, int id) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.age = age;
		this.id = userNextId;
		userNextId++;
	}

	/*
	 * constructor that chained with last constructor which have 5 parameters.
	 * 
	 * @parameters: firstName, lastName, address, age
	 */
	public User(String firstName, String lastName, String address, int age) {
		this(firstName, lastName, address, age, userNextId);
	}

	/*
	 * constructor that chained with last constructor which have 4 parameters.
	 * 
	 * @parameters: firstName, lastName, address
	 */
	public User(String first, String last, String address) {
		this(first, last, address, 18, userNextId);
	}

	/* accessor of the id */
	public int getId() {
		return id;
	}

	/* mutator of the id */
	public void setId(int id) {
		this.id = id;
	}

	/* accessor of the firstName */
	public String getFirstName() {
		return firstName;
	}

	/* mutator of the firstName */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/* accessor of the lastName */
	public String getLastName() {
		return lastName;
	}

	/* mutator of the lastName */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/* accessor of the address */
	public String getAddress() {
		return address;
	}

	/* mutator of the address */
	public void setAddress(String address) {
		this.address = address;
	}

	/* accessor of the age */
	public int getAge() {
		return age;
	}

	/* mutator of the age */
	public void setAge(int age) {
		this.age = age;
	}

	/*
	 * override toString method will return a String to generate a format of user
	 * information
	 */
	public String toString() {
		return String.format(
				"************ User id: %s\n************ User name: %s %s\n************ Age: %d\n************ Address: %s\n",
				getId(), getLastName(), getFirstName(), getAge(), getAddress());
	}
}

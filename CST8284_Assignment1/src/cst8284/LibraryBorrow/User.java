package cst8284.LibraryBorrow;


/**
 * Class Name: CST8284-300 Assignment1
 * Author Name: Chunfang Song
 * Class Name: User
 * Date: June 14,2021
 */

public class User {
	private static int userNextId =1000;
	private int id;
	private String firstName;
	private String lastName;
	private String address;
	private int age;
	
	public User(String firstName, String lastName, String address, int age, int id) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.age = age;
		this.id = userNextId;
		userNextId++;
	}
	
	public User(String firstName, String lastName, String address, int age) {
		this(firstName, lastName, address, age, userNextId);
	}
	
	public User(String first, String last, String address) {
		this(first, last, address, 18, userNextId);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String toString() {
		return String.format("************ User id: %s\n************ User name: %s %s\n************ Age: %d\n************ Address: %s\n", 
				   getId(), getLastName(), getFirstName(), getAge(), getAddress());
	}
}

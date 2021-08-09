
package polylab;

//Programmer abstract superclass.
public abstract class Programmer {
	private final String firstName;
	private final String lastName;
	private final String socialSecurityNumber;
	private Date birthDate;

    //constructor
	public Programmer(String firstName, String lastName, String socialSecurityNumber, int month, int year) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.socialSecurityNumber = socialSecurityNumber;
		this.birthDate = new Date(month, year);
	}

    //return first name
	public String getFirstName() {
		return firstName;
	}

    //return last name
	public String getLastName() {
		return lastName;
	}

    //return social security number
	public String getSocialSecurityNumber() {
		return socialSecurityNumber;
	}

    //return birth date 
	public Date getBirthDate() {
		return birthDate;
	}

	// return String representation of Programmer object
	@Override
	public String toString() {
		return String.format("%s %s\n%s: %s\n%s: %s", getFirstName(), getLastName(), "social security number",
				getSocialSecurityNumber(), "birth month and year", getBirthDate());
	}

	/** abstract method must be overridden by concrete subclasses */

	public abstract double earnings(); /** No implementation here. DO YOU KNOW WHY? abstract method do not have a body */
}

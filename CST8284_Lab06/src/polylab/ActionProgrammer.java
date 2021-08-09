package polylab;

/*ActionProgrammer class is a subclass of Programmer*/
public class ActionProgrammer extends Programmer {
	private double wage;
	private double pieces;

	//constructor
	public ActionProgrammer(String firstName, String lastName, String socialSecurityNumber,
			                int month, int year, double wage, double pieces) {
		super(firstName, lastName, socialSecurityNumber, month, year);
		if (wage <= 0.0) { // validate 
			  throw new IllegalArgumentException(
			     "wage  must be > 0.0 ");
			}

			if (pieces < 0) { // validate
			  throw new IllegalArgumentException("pieces must be >= 0");
			}
		
		this.wage = wage;
		this.pieces = pieces;
	}
	
	//accessor of the wage
	public double getWage() {
		return wage;
	}

	//mutator of the wage
	public void setWage(double wage) {
		if (wage <= 0.0) { // validate 
			  throw new IllegalArgumentException(
			     "wage  must be > 0.0 ");
			}
		this.wage = wage;
	}

	//accessor of the pieces
	public double getPieces() {
		return pieces;
	}

	//mutator of the pieces
	public void setPieces(double pieces) {
		if (pieces < 0.0) { // validate
			  throw new IllegalArgumentException("pieces must be >= 0");
			}
		this.pieces = pieces;
	}

	//override earnings() method to compute the earning
	@Override
	public double earnings() {
		return getWage() * getPieces();
	}
	
	//override toString() method to output format information
	@Override
	public String toString() {
		return String.format("Action programmer: " + super.toString()
		                     + "\nwage per piece: $%.2f; pieces of apps created: %.2f", 
				              getWage(), getPieces());
	}

}

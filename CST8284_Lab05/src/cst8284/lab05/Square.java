package cst8284.lab05;

public class Square extends BasicShape {

	public Square() {
		this(minValue);
	}

	public Square(double width) {
		super(width);
	}

	public Square(Square square) {
		this(square.getWidth());
	}

	@Override
	public double getArea() {
		double area = getWidth() * getWidth();
		return area;
	}

	@Override
	public double getPerimeter() {
		double perimeter = 4 * getWidth();
		return perimeter;
	}

	@Override
	public String toString() {
		return "Square extends " + super.toString();
	}

	/*
	 * override equals() method to compare two Square objects code citation refer to
	 * below web site:
	 * https://www.geeksforgeeks.org/overriding-equals-method-in-java/
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof Square)) {
			return false;
		}

		Square square = (Square) obj;
		final double EPSILON = 1E-14;
		return Math.abs(getWidth() - square.getWidth()) <= EPSILON;
	}
}

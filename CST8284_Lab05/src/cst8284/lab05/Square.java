package cst8284.lab05;

/**
 * Class Name: CST8284-300 Lab05 
 * Author Name: Chunfang Song 
 * Class Name: Square
 * Date: July 6,2021
 */

/*
 * Square class is a subclass of BasicShape class, it has three constructors and
 * four override methods.
 */
public class Square extends BasicShape {

	/* default constructor */
	public Square() {
		this(minValue);
	}

	/* overload constructor with width */
	public Square(double width) {
		super(width);
	}

	/*
	 * copy constructor, will use a pre-existing Suqare object to create a new
	 * Square object
	 */
	public Square(Square square) {
		this(square.getWidth());
	}

	/*
	 * override getAres() method to use the formula to calculate the area of square
	 */
	@Override
	public double getArea() {
		double area = getWidth() * getWidth();
		return area;
	}

	/*
	 * override getPerimeter() method to use the formula to calculate the perimeter
	 * of square
	 */
	@Override
	public double getPerimeter() {
		double perimeter = 4 * getWidth();
		return perimeter;
	}

	/* override toString() method to format the output */
	@Override
	public String toString() {
		return "Square extends " + super.toString();
	}

	/*
	 * override equals() method to compare two objects, it will return true when
	 * they are same kind of object and have same width. code citation refer to
	 * below web site:
	 * https://www.geeksforgeeks.org/overriding-equals-method-in-java/
	 */
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Square) {
			return super.equals(obj);
		}

		return false;
	}

}

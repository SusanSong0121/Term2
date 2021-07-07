package cst8284.lab05;

/**
 * Class Name: CST8284-300 Lab05 
 * Author Name: Chunfang Song 
 * Class Name: Circle
 * Date: July 6,2021
 */
/*
 * Circle class is a subclass of BasicShape class, it has three constructors and
 * four override methods.
 */
public class Circle extends BasicShape {

	/* default constructor */
	public Circle() {
		this(minValue);
	}

	/* overload constructor with width */
	public Circle(double width) {
		super(width);
	}

	/*
	 * copy constructor, will use a pre-existing Circle object to create a new
	 * Circle object
	 */
	public Circle(Circle circle) {
		this(circle.getWidth());
	}

	/*
	 * override getAres() method to use the formula to calculate the area of circle
	 */
	@Override
	public double getArea() {
		double area = Math.PI * getWidth() * getWidth() / 4;
		return area;
	}

	/*
	 * override getPerimeter() method to use the formula to calculate the perimeter
	 * of circle
	 */
	@Override
	public double getPerimeter() {
		double perimeter = Math.PI * getWidth();
		return perimeter;
	}

	/* override toString() method to format the output */
	@Override
	public String toString() {
		return "Circle extends " + super.toString();
	}

	/*
	 * override equals() method to compare two objects, it will return true when
	 * they are same kind of object and have same width. code citation refer to
	 * below web site:
	 * https://www.geeksforgeeks.org/overriding-equals-method-in-java/
	 */
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Circle) {
			return super.equals(obj);
		}

		return false;
	}

}

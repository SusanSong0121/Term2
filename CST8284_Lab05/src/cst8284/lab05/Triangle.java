package cst8284.lab05;

/**
 * Class Name: CST8284-300 Lab05 
 * Author Name: Chunfang Song 
 * Class Name: Triangle
 * Date: July 6,2021
 */

/*
 * Triangle class is a subclass of BasicShape class, it has three constructors
 * and four override methods.
 */
public class Triangle extends BasicShape {

	/* default constructor */
	public Triangle() {
		this(minValue);
	}

	/* overload constructor with width */
	public Triangle(double width) {
		super(width);
	}

	/*
	 * copy constructor, will use a pre-existing Triangle object to create a new
	 * Triangle object
	 */
	public Triangle(Triangle triangle) {
		this(triangle.getWidth());
	}

	/*
	 * override getAres() method to use the formula to calculate the area of
	 * triangle
	 */
	@Override
	public double getArea() {
		double area = Math.sqrt(3) / 4 * getWidth() * getWidth();
		return area;
	}

	/*
	 * override getPerimeter() method to use the formula to calculate the perimeter
	 * of triangle
	 */
	@Override
	public double getPerimeter() {
		double perimeter = 3 * getWidth();
		return perimeter;
	}

	/* override toString() method to format the output */
	@Override
	public String toString() {
		return "Triangle extends " + super.toString();
	}

	/*
	 * override equals() method to compare two objects, it will return true when
	 * they are same kind of object and have same width. code citation refer to
	 * below web site:
	 * https://www.geeksforgeeks.org/overriding-equals-method-in-java/
	 */
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Triangle) {
			return super.equals(obj);
		}

		return false;
	}

}

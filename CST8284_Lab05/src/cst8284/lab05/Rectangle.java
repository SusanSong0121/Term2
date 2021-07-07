package cst8284.lab05;

/**
 * Class Name: CST8284-300 Lab05 
 * Author Name: Chunfang Song 
 * Class Name: Rectangle 
 * Date: July 6,2021
 */

/*
 * Rectangle class is a subclass of Square class, it has a height field and
 * getter/setter of the height and three constructors and four override methods.
 */
public class Rectangle extends Square {

	private double height;

	/* default constructor */
	public Rectangle() {
		this(minValue, minValue);
	}

	/* overload constructor with width and height */
	public Rectangle(double width, double height) {
		super(width);
		this.height = height;
	}

	/*
	 * copy constructor, will use a pre-existing Rectangle object to create a new
	 * Rectangle object
	 */
	public Rectangle(Rectangle rectangle) {
		this(rectangle.getWidth(), rectangle.getHeight());
	}

	/* accessor of the height */
	public double getHeight() {
		return height;
	}

	/* mutator of the height */
	public void setHeight(double height) {
		this.height = height;
	}

	/*
	 * override getAres() method to use the formula to calculate the area of
	 * rectangle
	 */
	@Override
	public double getArea() {
		return getWidth() * getHeight();
	}

	/*
	 * override getPerimeter() method to use the formula to calculate the perimeter
	 * of rectangle
	 */
	@Override
	public double getPerimeter() {
		return (getWidth() + getHeight()) * 2;
	}

	/*
	 * override equals() method to compare two objects. use the superclass equals()
	 * method to compare if the two objects are same type and have same width, if
	 * true, then compare if the two objects have same height.
	 */
	@Override
	public boolean equals(Object obj) {

		if (!super.equals(obj)) {
			return false;
		}
		if (obj instanceof Square) {
			return Double.compare(getHeight(), getWidth()) == 0;
		}

		if (obj instanceof Rectangle) {
			Rectangle bs = (Rectangle) obj;
			return Double.compare(getHeight(), bs.getHeight()) == 0;
		}
		return false;

	}

	/* override toString() method to format the output */
	@Override
	public String toString() {
		return "Square extends " + super.toString();
	}
}

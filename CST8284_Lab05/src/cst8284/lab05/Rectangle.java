package cst8284.lab05;

/**
 * Class Name: CST8284-300 Lab05 
 * Author Name: Chunfang Song 
 * Class Name: Rectangle 
 * Date: July 6,2021
 */

public class Rectangle extends Square {

	private double height;

	public Rectangle() {
		this(minValue, minValue);
	}

	public Rectangle(double width, double height) {
		super(width);
		this.height = height;
	}

	public Rectangle(Rectangle rectangle) {
		this(rectangle.getWidth(), rectangle.getHeight());
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	@Override
	public double getArea() {
		return getWidth() * getHeight();
	}

	@Override
	public double getPerimeter() {
		return (getWidth() + getHeight()) * 2;
	}

	/*
	 * override equals() method to compare two objects. use the superclass equals()
	 * method to compare if the two objects are same type and have same width, if
	 * true, then compare if the two objects have same height.
	 */
//	@Override
//	public boolean equals(BasicShape basicShape) {
//
//		if (!super.equals(basicShape)) {
//			return false;
//		}
//		
//		if (basicShape instanceof Square) {
//			return Double.compare(getHeight(), getWidth()) == 0;
//		}
//		
//		if (basicShape instanceof Rectangle) {
//			Rectangle bs = (Rectangle) basicShape;
//			return Double.compare(getHeight(), bs.getHeight()) == 0;
//		}
//        return false;
//	}

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

//		double h = ((Rectangle) obj).getHeight();
//		return Double.compare(getHeight(), h) == 0;
	}
}

package cst8284.lab05;

/**
 * Class Name: CST8284-300 Lab05 
 * Author Name: Chunfang Song 
 * Class Name: Circle
 * Date: July 6,2021
 */
/* Circle class is the subclass of BasicShape, */
public class Circle extends BasicShape {

	public Circle() {
		this(minValue);
	}

	public Circle(double width) {
		super(width);
	}

	public Circle(Circle circle) {
		this(circle.getWidth());
	}

	@Override
	public double getArea() {
		double area = Math.PI * getWidth() * getWidth() / 4;
		return area;
	}

	@Override
	public double getPerimeter() {
		double perimeter = Math.PI * getWidth();
		return perimeter;
	}

	@Override
	public String toString() {
		return "Circle extends " + super.toString();
	}

	/*
	 * override equals() method to compare two objects, it will return true when
	 * they are same kind of object and have same width. 
	 * code citation refer to below web site:
	 * https://www.geeksforgeeks.org/overriding-equals-method-in-java/
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (obj == null || !(obj instanceof Circle)) {
			return false;
		}

			Circle circle = (Circle) obj;
			return (Double.compare(getWidth(), circle.getWidth()) == 0);

	}
//	@Override
//	public boolean equals(BasicShape basicShape) {
//		if (basicShape instanceof Circle) {
//			return super.equals(basicShape);
//		}
//		
//		return false;
//	}

}

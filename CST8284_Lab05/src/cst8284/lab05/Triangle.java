package cst8284.lab05;

/**
 * Class Name: CST8284-300 Lab05 
 * Author Name: Chunfang Song 
 * Class Name: Triangle
 * Date: July 6,2021
 */
public class Triangle extends BasicShape {

	public Triangle() {
		this(minValue);
	}

	public Triangle(double width) {
		super(width);
	}

	public Triangle(Triangle triangle) {
		this(triangle.getWidth());
	}

	@Override
	public double getArea() {
		double area = Math.sqrt(3) / 4 * getWidth() * getWidth();
		return area;
	}

	@Override
	public double getPerimeter() {
		double perimeter = 3 * getWidth();
		return perimeter;
	}

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
		if (this == obj) {
			return true;
		}

		if (obj == null || !(obj instanceof Triangle)) {
			return false;
		}

			Triangle triangle = (Triangle) obj;
			return (Double.compare(getWidth(), triangle.getWidth()) == 0);
	}
	

//	@Override
//	public boolean equals(BasicShape basicShape) {
//		if (basicShape instanceof Triangle) {
//			return super.equals(basicShape);
//		}
//		
//		return false;
//	}

}

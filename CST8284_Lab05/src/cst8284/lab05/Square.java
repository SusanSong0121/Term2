package cst8284.lab05;

/**
 * Class Name: CST8284-300 Lab05 
 * Author Name: Chunfang Song 
 * Class Name: Square
 * Date: July 6,2021
 */
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

		if (obj == null || !(obj instanceof Square)) {
			return false;
		}

			Square square = (Square) obj;
			return (Double.compare(getWidth(), square.getWidth()) == 0);

	}
	
//	public boolean equals(BasicShape basicShape) {
//		if (basicShape instanceof Square) {
//			return super.equals(basicShape);
//		}
//		
//		return false;
//	}
}

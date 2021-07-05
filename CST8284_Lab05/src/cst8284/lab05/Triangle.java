package cst8284.lab05;

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
		double area = Math.sqrt(3)/4*getWidth()*getWidth();
		return area;
	}
	
	@Override
	public double getPerimeter() {
		double perimeter = 3*getWidth();
		return perimeter;
	}
	
	@Override
	public String toString() {
		return "Triangle extends " + super.toString();
	}
	
	/*override equals() method to compare two Triangle objects
	 *code citation refer to below web site:
	 *https://www.geeksforgeeks.org/overriding-equals-method-in-java/ */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		
		if (!(obj instanceof Triangle)) {
			return false;
		}
		
		Triangle triangle = (Triangle) obj;
		final double EPSILON = 1E-14;
		return Math.abs(getWidth() - triangle.getWidth()) <= EPSILON;
	}

}

package cst8284.lab05;

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
		double area = Math.PI*getWidth()*getWidth()/4;
		return area;
	}
	
	@Override
	public double getPerimeter() {
		double perimeter = Math.PI*getWidth();
		return perimeter;
	}
	
	@Override
	public String toString() {
		return "Circle extends " + super.toString();
	}
	
	/*override equals() method to compare two Circle objects
	 *code citation refer to below web site:
	 *https://www.geeksforgeeks.org/overriding-equals-method-in-java/ */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		
		if (!(obj instanceof Circle)) {
			return false;
		}
		Circle circle = (Circle) obj;
		final double EPSILON = 1E-14;
		return (Math.abs(getWidth() - circle.getWidth()) <= EPSILON);
	}

}

package cst8284.lab05;

public class BasicShape {

	private double width;
	public static double minValue = 1.0;

	protected BasicShape(double width) {
		setWidth(width);
	}

	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		this.width = width;
	}

	@Override
	public String toString() {
		return ("BasicShape extends " + super.toString());
	}

	public double getArea() {
		return 0.0;
	}

	public double getPerimeter() {
		return 0.0;
	}

	/*
	 * override equals() method to compare two objects, it will return true when
	 * they are same kind of object and have same width. code citation refer to
	 * below web site:
	 * https://www.geeksforgeeks.org/overriding-equals-method-in-java/
	 */
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof BasicShape) {
			BasicShape basicShape = (BasicShape) obj;
			return (Double.compare(getWidth(), basicShape.getWidth()) == 0);
		}
		return false;
	}

}

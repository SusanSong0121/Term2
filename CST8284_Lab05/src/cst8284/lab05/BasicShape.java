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
	
	@Override
	public boolean equals(Object obj) {
		return super.equals(obj);
	}
	
//	public boolean equals(BasicShape basicShape) {
//
//		return (Double.compare(getWidth(), basicShape.getWidth()) == 0);
//
//	}
	
	

}

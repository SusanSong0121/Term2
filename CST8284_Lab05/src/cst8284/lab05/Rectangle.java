package cst8284.lab05;

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
	
	@Override
	public boolean equals(Object obj) {
		
		if (!super.equals(obj)) {
			return false;
		}

		double h = ((Rectangle) obj).getHeight();
		return Double.compare(getHeight(), h) == 0;
	}

}

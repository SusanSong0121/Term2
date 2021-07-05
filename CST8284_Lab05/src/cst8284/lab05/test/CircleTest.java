package cst8284.lab05.test;

import cst8284.lab05.Circle;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import org.junit.Before;
import org.junit.Test;

public class CircleTest {

	private Circle circle;
	
	@Before
	public void initCircle() {
		circle = new Circle();
	}

	@Test
	public void testGetArea_True() {
		double area = circle.getArea();
		assertTrue(Double.compare(Math.PI/4, area) == 0);
	}
	
	@Test
	public void testGetArea_False() {
		double area = circle.getArea();
		assertFalse(Double.compare(Math.PI, area) == 0);
	}

	@Test
	public void testGetPerimeter_True() {
		double perimeter = circle.getPerimeter();
		assertTrue(Double.compare(Math.PI, perimeter) == 0);
	}
	
	@Test
	public void testGetPerimeter_False() {
		double perimeter = circle.getPerimeter();
		assertFalse(Double.compare(Math.PI/2, perimeter) == 0);
	}

}

package cst8284.lab05.test;

import cst8284.lab05.Circle;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import org.junit.Before;
import org.junit.Test;

public class CircleTest {

	private Circle circle;
	private final double WIDTH = 1.0;

	@Before
	public void initCircle() {
		circle = new Circle();
	}

	@Test
	public void testGetArea_True() {
		double area = circle.getArea();
		double area1 = Math.PI * WIDTH * WIDTH / 4;
		assertTrue(Double.compare(area1, area) == 0);
	}

	@Test
	public void testGetArea_False() {
		double area = circle.getArea();
		double area1 = Math.PI * WIDTH * WIDTH;
		assertFalse(Double.compare(area1, area) == 0);
	}

	@Test
	public void testGetPerimeter_True() {
		double perimeter = circle.getPerimeter();
		double perimeter1 = Math.PI * WIDTH;
		assertTrue(Double.compare(perimeter1, perimeter) == 0);
	}

	@Test
	public void testGetPerimeter_False() {
		double perimeter = circle.getPerimeter();
		double perimeter1 = Math.PI * WIDTH / 2;
		assertFalse(Double.compare(perimeter1, perimeter) == 0);
	}

}

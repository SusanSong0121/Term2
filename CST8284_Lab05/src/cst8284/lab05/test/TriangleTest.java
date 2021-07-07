package cst8284.lab05.test;

import cst8284.lab05.Triangle;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import org.junit.Before;
import org.junit.Test;

public class TriangleTest {

	private Triangle triangle;
	private final double WIDTH = 1.0;

	@Before
	public void initTriangle() {
		triangle = new Triangle();
	}

	@Test
	public void testGetArea_True() {
		double area = triangle.getArea();
		double area1 = Math.sqrt(3) / 4 * WIDTH * WIDTH;
		assertTrue(Double.compare(area1, area) == 0);
	}

	@Test
	public void testGetArea_False() {
		double area = triangle.getArea();
		double area1 = WIDTH * WIDTH;
		assertFalse(Double.compare(area1, area) == 0);
	}

	@Test
	public void testGetPerimeter_True() {
		double perimeter = triangle.getPerimeter();
		double perimeter1 = 3 * WIDTH;
		assertTrue(Double.compare(perimeter1, perimeter) == 0);
	}

	@Test
	public void testGetPerimeter_False() {
		double perimeter = triangle.getPerimeter();
		double perimeter1 = 4 * WIDTH;
		assertFalse(Double.compare(perimeter1, perimeter) == 0);
	}

}

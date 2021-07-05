package cst8284.lab05.test;

import cst8284.lab05.Triangle;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import org.junit.Before;
import org.junit.Test;

public class TriangleTest {
	
	private Triangle triangle;

	@Before
	public void initTriangle() {
		triangle = new Triangle();
	}

	@Test
	public void testGetArea_True() {
		double area = triangle.getArea();
		assertTrue(Double.compare(Math.sqrt(3)/4, area) == 0);
	}

	@Test
	public void testGetArea_False() {
		double area = triangle.getArea();
		assertFalse(Double.compare(Math.PI, area) == 0);
	}
	
	@Test
	public void testGetPerimeter_True() {
		double perimeter = triangle.getPerimeter();
		assertTrue(Double.compare(3, perimeter) == 0);
	}
	
	@Test
	public void testGetPerimeter_False() {
		double perimeter = triangle.getPerimeter();
		assertFalse(Double.compare(Math.PI, perimeter) == 0);
	}

}

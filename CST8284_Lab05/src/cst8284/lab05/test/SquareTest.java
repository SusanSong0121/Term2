package cst8284.lab05.test;

import cst8284.lab05.Square;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import org.junit.Before;
import org.junit.Test;

public class SquareTest {

	private Square square;
	private final double WIDTH = 1.0;
	
	@Before
	public void initSquare() {
		square = new Square();
	}

	@Test
	public void testGetArea_True() {
		double area = square.getArea();
		double area1 = WIDTH * WIDTH;
		assertTrue(Double.compare(area1, area) == 0);
	}

	@Test
	public void testGetArea_False() {
		double area = square.getArea();
		double area1 = Math.PI * WIDTH;
		assertFalse(Double.compare(area1, area) == 0);
	}
	
	@Test
	public void testGetPerimeter_True() {
		double perimeter = square.getPerimeter();
		double perimeter1 = 4 * WIDTH;
		assertTrue(Double.compare(perimeter1, perimeter) == 0);
	}
	
	@Test
	public void testGetPerimeter_False() {
		double perimeter = square.getPerimeter();
		double perimeter1 = 3 * WIDTH;
		assertFalse(Double.compare(perimeter1, perimeter) == 0);
	}

}

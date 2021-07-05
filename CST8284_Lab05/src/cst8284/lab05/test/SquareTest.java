package cst8284.lab05.test;

import cst8284.lab05.Square;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import org.junit.Before;
import org.junit.Test;

public class SquareTest {

	private Square square;
	
	@Before
	public void initSquare() {
		square = new Square();
	}

	@Test
	public void testGetArea_True() {
		double area = square.getArea();
		assertTrue(Double.compare(1, area) == 0);
	}

	@Test
	public void testGetArea_False() {
		double area = square.getArea();
		assertFalse(Double.compare(Math.PI, area) == 0);
	}
	
	@Test
	public void testGetPerimeter_True() {
		double perimeter = square.getPerimeter();
		assertTrue(Double.compare(4, perimeter) == 0);
	}
	
	@Test
	public void testGetPerimeter_False() {
		double perimeter = square.getPerimeter();
		assertFalse(Double.compare(Math.PI, perimeter) == 0);
	}

}

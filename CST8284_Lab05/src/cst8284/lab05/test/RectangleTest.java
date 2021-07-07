package cst8284.lab05.test;

import cst8284.lab05.Rectangle;
import cst8284.lab05.Square;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

public class RectangleTest {

	private Rectangle rectangle1;
	private Rectangle rectangle2;
	private Square square1;
	private Square square2;
	private final double EPSILON = 1e-12;

	@Before
	public void initObject() {
		rectangle1 = new Rectangle(2.0, 2.0);
		square1 = new Square(2.0);
		rectangle2 = new Rectangle();
		square2 = new Square();
	}

	@Test
	public void testPerimeter_True() {
		assertEquals(rectangle1.getPerimeter(), square1.getPerimeter(), EPSILON);
	}

	@Test
	public void testArea_True() {
		assertEquals(rectangle2.getArea(), square2.getArea(), EPSILON);
	}

}

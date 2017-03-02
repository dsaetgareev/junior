package ru.job4j.triangle;

import static org.hamcrest.number.IsCloseTo.closeTo;
import org.junit.Test;
//import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
*Class TriangleTest that testing area() method.
*distanceTo(Point point).
*@author Dinis Saetgareev (dinis0086@mail.ru)
*@version 1.0
*@since 27.02.2017
*/

public class TriangleTest {

	/**
	*method.
	*/
	@Test
	public void whenThreePointThenArea() {
		Point a = new Point(2, 3);
		Point b = new Point(5, 6);
		Point c = new Point(1, 1);
		Triangle trian = new Triangle(a, b, c);
		assertThat(trian.area(), closeTo(0.01, 1.49));
	}
}
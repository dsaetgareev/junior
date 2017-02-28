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
	Triangle trian = new Triangle(1, 1, 2, 4, 1, 3);
		assertThat(trian.area(), closeTo(1.0, 0.01));
	}
}
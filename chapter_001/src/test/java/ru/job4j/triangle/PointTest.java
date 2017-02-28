package ru.job4j.triangle;

import static org.hamcrest.number.IsCloseTo.closeTo;
import org.junit.Test;
//import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
*Class PointTest that testing distanceTo() method.
*distanceTo(Point point).
*@author Dinis Saetgareev (dinis0086@mail.ru)
*@version 1.0
*@since 27.02.2017
*/

public class PointTest {

	/**
	*method.
	*/
	@Test
	public void whenPointThenDistance() {
		Point point1 = new Point(1, 1);
		Point point2 = new Point(2, 2);
		assertThat(point1.distanceTo(point2), closeTo(1.44, 0.01));
	}
}
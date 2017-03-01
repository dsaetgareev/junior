package ru.job4j.paint;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
*Class PaintTest checking method piramid(int h)
*that create piramid.
*@author Dinis Saetgareev (dinis0086@mail.ru)
*@version 1.0
*@since 28.02.2017
*/

public class PaintTest {

	/**
	*method whenHThenPiramid().
	*/
	@Test
	public void whenHThenPiramid() {
		Paint paint = new Paint();
		assertThat(paint.piramid(2), is("  ^\n ^ ^\n"));
	}
}
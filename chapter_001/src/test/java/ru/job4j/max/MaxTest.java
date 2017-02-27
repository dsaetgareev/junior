package ru.job4j.max;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
*Class MaxTest checking double max() method.
*@author Dinis Saetgareev (dinis0086@mail.ru)
*@version 1.0
*@since 27.02.2017
*/

public class MaxTest {

	/**method whenTwoValuesThenMax().
	*/
	@Test
	public void whenTwoValuesThenMax() {
		Max value = new Max();
		assertThat(value.max(3, 4), is(4.0));
	}
}
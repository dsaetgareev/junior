package ru.job4j.factorial;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
*Class FactorialTest checking
*method int calcFactorial(int value).
*@author Dinis Saetgareev (dinis0086@mail.ru)
*@version 1.0
*@since 27.02.2017
*/

public class FactorialTest {

	/**
	*method whenValueThenFactorial().
	*/
	@Test
	public void whenValueThenFactorial() {
		Factorial factor = new Factorial();
		assertThat(factor.calcFactorial(3), is(6));
	}
}
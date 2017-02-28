package ru.job4j.counter;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
*Class CounterTest checking method int add(int start, int finish).
*@author Dinis Saetgareev (dinis0086@mail.ru)
*@version 1.0
*@since 28.02.2017
*/

public class CounterTest {

	/**
	*method whenStartAndFinishThenSum().
	*/
	@Test
	public void whenStartAndFinishThenSum() {
		Counter counter = new Counter();
		assertThat(counter.add(1, 7), is(12));
	}
}
package ru.job4j.task63;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
*Class ContainsTest checking class contains method boolean contains().
*@author Dinis Saetgareev (dinis0086@mail.ru)
*@version 1.0
*@since 07.03.2017
*/
public class ContainsTest {
	/**
	*method whenStringOriginAndSubThenOriginContainsSub().
	*/
	@Test
	public void whenStringOriginAndSubThenOriginContainsSub() {
		Contains cont = new Contains();
		String origin = "contains";
		String sub = "ins";
		assertThat(cont.contains(origin, sub), is(true));
	}
}
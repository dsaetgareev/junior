package ru.job4j.task53;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
*Class RemoveDublTest checking threads
*String[] dublNull(String[] array);
*String[] sortNull(String[] array);
*String[] arrayNoDubl(String[] array).
*@author Dinis Saetgareev (dinis0086@mail.ru)
*@version 2.0
*@since 04.03.2017
*/

public class RemoveDublTest {

	/**
	*thread whenArrayWithDublicatesThenArrayWithoutDublibcates()
	*checking String[] dublNull(String[] array).
	*/
	@Test
	public void whenArrayWithDublicatesThenArrayWithoutDublibcates() {
		RemoveDubl obj = new RemoveDubl();
		String[] array = {"Hi", "Hi", "World", "and", "and", "City"};
		String[] afterAr = {"Hi", null, "World", "and", null, "City"};
		assertThat(obj.dublNull(array), is(afterAr));
	}

	/**
	*thread whenArraayWithNullThenArraySortNull()
	*checking String[] sortNull(String[] array).
	*/
	@Test
	public void whenArraayWithNullThenArraySortNull() {
		RemoveDubl obj = new RemoveDubl();
		String[] array = {"Hi", null, "World", "and", null, "City"};
		String[] afterArraySortNull = {"Hi", "World", "and", "City", null, null};
		assertThat(obj.sortNull(array), is(afterArraySortNull));
	}

	/**
	*thread whenArrayWithNullThenArrayWithoutNull()
	*checking String[] arrayNoDubl(String[] array).
	*/
	@Test
	public void whenArrayWithNullThenArrayWithoutNull() {
		RemoveDubl obj = new RemoveDubl();
		String[] array = new String[] {"Hi", "World", "and", "City", null, null};
		String[] afterArrayNoDubl = new String[] {"Hi", "World", "and", "City"};
		assertThat(obj.arrayNoDubl(array), is(afterArrayNoDubl));
	}
}
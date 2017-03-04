package ru.job4j.sorting;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
*Class SortingTest checking thread sort() class Sorting.
*@author Dinis Saetgareev (dinis0086@mail.ru)
*@version 1.0
*@since 03.03.2017
*/

public class SortingTest {

	/**
	*thread void whenArrayThenSortArray().
	*/
	@Test
	public void whenArrayThenSortArray() {
		Sorting obj = new Sorting();
		int[] array = {2, 1, 3};
		int[] afterSort = {1, 2, 3};
		assertThat(obj.sort(array), is(afterSort));
	}
	/**
	*thread void whenArrayThenSortOptimArray().
	*/
	@Test
	public void whenArrayThenSortOptimArray() {
		Sorting obj = new Sorting();
		int[] array = {2, 1, 3};
		int[] afterSort = {1, 2, 3};
		assertThat(obj.sortOptim(array), is(afterSort));
	}
}
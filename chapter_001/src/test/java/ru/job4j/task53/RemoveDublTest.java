package ru.job4j.task53;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
*Class RemoveDublTest checking threads
*String[] removeDuble(String[] array).
*@author Dinis Saetgareev (dinis0086@mail.ru)
*@version 3.0
*@since 05.03.2017
*/

public class RemoveDublTest {

	/**
	*thread whenArrayWithDublicatesThenArrayWithoutDublibcates()
	*checking String[] dublNull(String[] array).
	*/
	@Test
	public void whenArrayWithDublicatesThenArrayWithoutDublibcates() {
		RemoveDubl obj = new RemoveDubl();
		String[] array = {"1", "1", "2", "3", "2", "3"};
		String[] afterAr = {"1", "3", "2"};
		assertThat(obj.removeDuble(array), is(afterAr));
	}
}
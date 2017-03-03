package ru.job4j.turn;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
*Class TurnTest cheking method back().
*@author Dinis Saetgareev (dinis0086@mail.ru)
*@version 1.0
*@since 28.02.2017
*/

public class TurnTest {

	/**
	*method whenArrayThenBackArray().
	*/
	@Test
	public void whenArrayThenBackArray() {
		Turn turn = new Turn();
		int[] array = {1, 2, 3};
		assertThat(turn.back(array), is(new int[] {3, 2, 1}));
	}
}
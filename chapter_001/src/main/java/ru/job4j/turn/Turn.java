package ru.job4j.turn;

/**
*Class Turn has method back()
*that back array.
*@author Dinis Saetgareev (dinis0086@mail.ru)
*@version 1.0
*@since 28.02.2017
*/

public class Turn {

	/**
	*method back(int[] array) back array.
	*@param array - array
	*@return array - array
	*/
	public int[] back(int[] array) {
		/**
		*int var
		*/
		int var;
		for (int i = 0; i < array.length / 2; i++) {
			var = array[i];
			array[i] = array[array.length - 1 - i];
			array[array.length - 1 - i] = var;
		}
		return array;
	}
}
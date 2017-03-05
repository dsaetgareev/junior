package ru.job4j.task53;

import java.util.Arrays;
/**
*Class RemoveDubl has threads
*that remove dublicates.
*@author Dinis Saetgareev (dinis0086@mail.ru)
*@version 3.0
*@since 05.03.2017
*/

public class RemoveDubl {

	/**
	*thread String[] removeDuble(String[] array),
	*draws dublicates null.
	*@param array - array
	*@return array
	*/
	public String[] removeDuble(String[] array) {
		int end = array.length;
		int count = 0;
		for (int i = 0; i < end - 1; i++) {
			for (int j = i + 1; j < array.length; j++) {
				if (array[i].equals(array[j])) {
					String var;
					var = array[j];
					array[j] = array[end - 1];
					array[end - 1] = var;
					end--;
					count++;
				}
			}
		}
		int aLength = array.length - count;
		String[] arCopy = Arrays.copyOf(array, aLength);
		return arCopy;
	}
}
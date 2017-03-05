package ru.job4j.task53;

import java.util.Arrays;
/**
*Class RemoveDubl has threads
*that remove dublicates.
*@author Dinis Saetgareev (dinis0086@mail.ru)
*@version 2.0
*@since 04.03.2017
*/

public class RemoveDubl {

	/**
	*thread String[] dublNull(String[] array),
	*draws dublicates null.
	*@param array - array
	*@return array
	*/
	public String[] dublNull(String[] array) {
		for (int i = 0; i != array.length; i++) {
			for (int j = i + 1; j != array.length; j++) {
				if (array[i] != null && array[j] != null && array[i].equals(array[j])) {
					array[j] = null;
				}
			}
		}
		return array;
	}

	/**
	*thread String[] sortNull(String[] array)
	*bubble null.
	*@param array - array
	*@return array
	*/
	public String[] sortNull(String[] array) {
		for (int j = array.length - 1; j >= 0; j--) {
			for (int i = 0; i < j; i++) {
				if (array[i] == null) {
					array[i] = array[i + 1];
					array[i + 1] = null;
				}
			}
		}
		return array;
	}

	/**
	*thread String[] arrNoDubl(String[] array)
	*remove null.
	*@param array - array
	*@return array
	*/
	public String[] arrayNoDubl(String[] array) {
		int count = 0;
		for (String elem : array) {
			if (elem == null) {
				count++;
			}
		}
		int aLength = array.length - count;
		String[] arrNoDubl = Arrays.copyOf(array, aLength);
		return arrNoDubl;
	}
}
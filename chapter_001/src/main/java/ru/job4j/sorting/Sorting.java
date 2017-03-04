package ru.job4j.sorting;

/**
*Class Sorting has thread int[] sort(int[] value).
*@author Dinis Saetgareev (dinis0086@mail.ru)
*@version 2.0
*@since 04.03.2017
*/

public class Sorting {
	 /**
	 *thread int[] sort(int[] value).
	 *@param value - int[]
	 *@return value - array
	 */
	 public int[] sort(int[] value) {
		 /**
		 *int var - temporary variable.
		 */
		 int var;
		 for (int j = value.length - 1; j >= 0; j--) {
			 for (int i = 0; i < j; i++) {
				 if (value[i] > value[i + 1]) {
				 var = value[i];
				 value[i] = value[i + 1];
				 value[i + 1] = var;
				 }
			 }
		 }
		 return value;
	 }
}
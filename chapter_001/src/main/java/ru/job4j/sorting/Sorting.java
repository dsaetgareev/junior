package ru.job4j.sorting;

/**
*Class Sorting has thread int[] sort(int[] value).
*@author Dinis Saetgareev (dinis0086@mail.ru)
*@version 1.0
*@since 03.03.2017
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
		 for (int j = 0; j != value.length - 1; j++) {
			 for (int i = 0; i != value.length - 1; i++) {
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
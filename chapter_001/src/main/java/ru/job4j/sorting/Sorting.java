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

	 /**
	 *thread int[] sortOptim(int[] value)
	 *sorting array by "Bubble".
	 *@param value - int[]
	 *@return value - array
	 */
	 public int[] sortOptim(int[] value) {
		 int var;
		for (int k = 0; k < value.length / 2; k++) {
		 for (int i = 0; i != value.length - 1; i++) {
			if (value[i] > value[i + 1]) {
				 var = value[i];
				 value[i] = value[i + 1];
				 value[i + 1] = var;
				 }
		 }
		 for (int j = value.length - 1; j > 0; j--) {
			 if (value[j] < value[j - 1]) {
				 var = value[j];
				 value[j] = value[j - 1];
				 value[j - 1] = var;
			 }
		 }
		}
		 return value;
	 }
}
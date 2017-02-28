package ru.job4j.counter;

/**
*Class Counter has method int add(int start, int finish).
*@author Dinis Saetgareev (dinis0086@mail.ru)
*@version 1.0
*@since 28.02.2017
*/

public class Counter {

	/**
	*method int add(int start, int finish).
	*@param start - value
	*@param finish - value
	*@return sum - value
	*/
	public int add(int start, int finish) {
		/**
		*int sum.
		*/
		int sum = 0;
		while (start < finish) {
			if (start % 2 == 0) {
				sum += start;
			}
			start++;
		}
		return sum;
	}
}
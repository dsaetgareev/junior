package ru.job4j.factorial;

/**
*Class Factorial calculate factorial
*method int calcFactorial(int value).
*@author Dinis Saetgareev (dinis0086@mail.ru)
*@version 1.0
*@since 27.02.2017
*/

public class Factorial {

	/**
	*method int calcFactorial(int value).
	*@param value - value
	*@return mult - factorial
	*/
	public int calcFactorial(int value) {
		int mult = 1;
		for (int i = 0; i < value; i++) {
			mult *= (i + 1);
		}
		return mult;
	}
}
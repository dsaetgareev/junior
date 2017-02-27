package ru.job4j.max;

/**
*Class Max has method ddouble max(double first, double second)
*and return double max.
*@author Dinis Saetgareev (dinis0086@mail.ru)
*@version 1.0
*@since 27.02.2017
*/

public class Max {

	/**method max return max value.
	*@param first - value
	*@param second - value
	*@return max
	*/
	public double max(double first, double second) {
		return (first > second ? first : second);
	}
}
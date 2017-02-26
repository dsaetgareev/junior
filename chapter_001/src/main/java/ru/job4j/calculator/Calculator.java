package ru.job4j.calculator;

/**
*Class Calculator that has a field double result and
*methods add(double first, double second)
*substruct(double first, double second);
*div(double first, double second);
*multiple(double first, double second);
*getResult().
*@author Dinis Saetgareev (dinis0086@mail.ru)
*@since 26.02.2017
*@version 1.0
*/

public class Calculator {

	/**
	*internal field double result.
	*/
	private double result;

	/**
	*method double getResult()
	*that return this.result.
	*@return result
	*/
	public double getResult() {
		return this.result;
	}
	/**
	*method add(double first, double second)
	*that adds two value.
	*@param first - value
	*@param second - value
	*/
	public void add(double first, double second) {
		this.result = first + second;
		getResult();
	}

	/**
	*method substruct(double first, double second)
	*that substructs two value.
	*@param first - value
	*@param second - value
	*/
	public void substruct(double first, double second) {
		this.result = first - second;
		getResult();
	}

	/**
	*method div(double first, double second)
	*that divs ferst on second.
	*@param first - value
	*@param second - value
	*/
	public void div(double first, double second) {
		if (second != 0) {
			this.result = first / second;
		}
		getResult();
	}

	/**
	*method multiple(double first, double second)
	*that multiplies two value.
	*@param first - value
	*@param second - value
	*/
	public void multiple(double first, double second) {
		this.result = first * second;
		getResult();
	}
}
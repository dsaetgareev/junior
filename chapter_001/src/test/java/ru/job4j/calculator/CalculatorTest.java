package ru.job4j.calculator;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
*Class CalculatorTest checking methods
*class Calculator.
*methods add(double first, double second)
*substruct(double first, double second);
*div(double first, double second);
*multiple(double first, double second);
*getResult().
*@author Dinis Saetgareev (dinis0086@mail.ru)
*@since 26.02.2017
*@version 1.0
*/

public class CalculatorTest {

	/**
	*Test method add(double first, double second).
	*/
	@Test
	public void whenAddTwoThenAnswer() {
		Calculator calc = new Calculator();
		calc.add(1, 2);
		calc.getResult();
		assertThat(calc.getResult(), is(3.0));
		}

		/**
	*Test method substruct(double first, double second).
	*/
	@Test
	public void whenSubstructThenAnswer() {
		Calculator calc = new Calculator();
		calc.substruct(5, 2);
		calc.getResult();
		assertThat(calc.getResult(), is(3.0));
	}

	/**
	*Test method div(double first, double second).
	*/
	@Test
	public void whenDivThenAnswer() {
		Calculator calc = new Calculator();
		calc.div(6, 2);
		calc.getResult();
		assertThat(calc.getResult(), is(3.0));
	}

	/**
	*Test method multiple(double first, double second).
	*/
	@Test
	public void whenMultipleThenAnswer() {
		Calculator calc = new Calculator();
		calc.multiple(6, 2);
		calc.getResult();
		assertThat(calc.getResult(), is(12.0));
	}
}
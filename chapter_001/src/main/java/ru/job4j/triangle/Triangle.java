package ru.job4j.triangle;

/**
*Class Triangle has method public Triangle()
*and double area() that calculate the triangle area.
*@author Dinis Saetgareev (dinis0086@mail.ru)
*@version 1.0
*@since 27.02.2017
*/

public class Triangle {
	/**
	*Point a.
	*/
	private Point a;
	/**
	*Point b.
	*/
	private Point b;
	/**
	*Point c.
	*/
	private Point c;

	/**
	*public Triangle(Point a, Point b, Point c)
	*create a triangle.
	*@param a - Point
	*@param b - Point
	*@param c - Point
	*/
	public Triangle(Point a, Point b, Point c) {
	this.a = a;
	this.b = b;
	this.c = c;
	}

	/**
	*double area() finds triangle area.
	*@return areaTriangle
	*/
	public double area() {
	//calculate the triangle area
	double areaTriangle = 0;
	double sideA = a.distanceTo(b);
	double sideB = b.distanceTo(c);
	double sideC = c.distanceTo(a);
	double per = (sideA + sideB + sideC) / 2;
	if (sideA + sideB > sideC && sideB + sideC > sideA && sideC + sideA > sideB) {
		areaTriangle = Math.sqrt(per * (per - sideA) * (per - sideB) * (per - sideC));
	}
		return areaTriangle;
	}
}
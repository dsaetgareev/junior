package ru.job4j.triangle;

/**
*Class Point has two point and method
*distanceTo(Point point).
*@author Dinis Saetgareev (dinis0086@mail.ru)
*@version 1.0
*@since 27.02.2017
*/

public class Point {
/**
*TODO.
*/
private double x;
/**
*TODO.
*/
private double y;

	/**
	*method point(double x, double y).
	*@param x -value
	*@param y -value
	*/
	Point(double x, double y) {
	this.x = x;
	this.y = y;
	}

	/**
	*method public double distanceTo(Point point)
	*calculate distance between two points.
	*@param point - Point
	*@return distance
	*/
	public double distanceTo(Point point) {
	//calculate distance between two points
	return Math.sqrt(Math.pow(point.y - this.y, 2) + Math.pow(point.x - this.x, 2));
	}
}

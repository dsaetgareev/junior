package ru.job4j.square;

import java.util.ArrayList;

/**
 * builds and defines a figure.
 * @author Dinis Saetgareev (dinis0086@mail.ru)
 * @since 11.05.2017
 * @version 1.0
 */
public class Figure {
    /**
     * point.
     */
    private Point a;
    /**
     * point.
     */
    private Point b;
    /**
     * point.
     */
    private Point c;
    /**
     * point.
     */
    private Point d;
    /**
     * point A.
     */
    private Point aA;
    /**
     * point B.
     */
    private Point bB;
    /**
     * point C.
     */
    private Point cC;
    /**
     * point D.
     */
    private Point dD;
    /**
     * side A.
     */
    private double sideA;
    /**
     * side B.
     */
    private double sideB;
    /**
     * side C.
     */
    private double sideC;
    /**
     * side D.
     */
    private double sideD;
    /**
     * diagonal.
     */
    private double diag1;
    /**
     * diagonal.
     */
    private double diag2;

    /**
     * constructor.
     * @param a - new point
     * @param b - new point
     * @param c - new point
     * @param d - new point
     */
    public Figure(Point a, Point b, Point c, Point d) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }

    /**
     * fills list.
     * @return list
     */
    public ArrayList<Point> fillPoints() {
        ArrayList<Point> list = new ArrayList<>();
        list.add(this.a);
        list.add(this.b);
        list.add(this.c);
        list.add(this.d);
        return list;
    }

    /**
     * puts points in places.
     */
    public void constPoints() {
        this.aA = min(min(this.a, this.b), min(this.c, this.d));
        this.cC = max(max(this.a, this.b), max(this.c, this.d));
        ArrayList<Point> list = fillPoints();
        for (Point point : list) {
            for (Point point1 : list) {
                if (point != this.aA && point != this.cC && point1 != this.aA && point1 != this.cC
                        && point.getX() < point1.getX()) {
                    this.bB = point;
                    this.dD = point1;
                }
            }
        }
    }

    /**
     * min Point.
     * @param a - point
     * @param b - point
     * @return min point
     */
    public Point min(Point a, Point b) {
        return (a.getX() + a.getY()) < (b.getX() + b.getY()) ? a : b;
    }

    /**
     * max point.
     * @param a - point
     * @param b - point
     * @return max point
     */
    public Point max(Point a, Point b) {
        return (a.getX() + a.getY()) > (b.getX() + b.getY()) ? a : b;
    }

    /**
     * calculates the hypotenuse.
     * @param a - point
     * @param b - point
     * @return hypotenuse
     */
    public double calcHypotenuse(Point a, Point b) {
        return Math.sqrt(Math.pow((a.getX() - b.getX()), 2) + Math.pow((b.getY() - a.getY()), 2));
    }

    /**
     * calculates sides of figure.
     */
    public void calcSides() {
        this.sideA = calcHypotenuse(this.aA, this.bB);
        this.sideB = calcHypotenuse(this.bB, this.cC);
        this.sideC = calcHypotenuse(this.cC, this.dD);
        this.sideD = calcHypotenuse(this.dD, this.aA);
    }

    /**
     * calculates diagonals of figure.
     */
    public void calcDiagonal() {
        this.diag1 = Math.sqrt(Math.pow((this.cC.getX() - this.aA.getX()), 2)
                + Math.pow((this.cC.getY() - this.aA.getY()), 2));
        this.diag2 = Math.sqrt(Math.pow((this.dD.getX() - this.bB.getX()), 2)
                + Math.pow((this.dD.getY() - this.bB.getY()), 2));
    }

    /**
     * identify the figure.
     * @return String identify
     */
    public String identifyFigure() {
        String result;
        constPoints();
        calcSides();
        calcDiagonal();
        if (this.sideA == this.sideB && this.sideB == this.sideC && this.sideC == this.sideD
                && this.diag1 == this.diag2) {
            result = "The figure is square.";
        } else {
            if (this.sideA == this.sideC && this.sideB == this.sideD && this.diag1 == this.diag2) {
                result = "The figure is rectangle.";
            } else {
                if (this.sideA == this.sideB && this.sideC == this.sideD && this.diag1 != this.diag2) {
                    result = "The figure is rhombus.";
                } else {
                    result = "This figure is an irregular quadrilateral.";
                }
            }
        }
        System.out.println(result);
        return result;
    }
}

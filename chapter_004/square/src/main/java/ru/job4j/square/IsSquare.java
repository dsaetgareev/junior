package ru.job4j.square;

import java.util.ArrayList;
import java.util.TreeSet;

/**
 * check whether the figure is square.
 * @author Dinis Saetgareev (dinis0086@mail.ru)
 * @since 14.05.2017
 * @version 1.0
 */
public class IsSquare extends Figure {
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
     * constructor.
     * @param a - new point.
     * @param b - new point.
     * @param c - new point.
     * @param d - new point.
     */
    public IsSquare(Point a, Point b, Point c, Point d) {
        super(a, b, c, d);
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }

    /**
     * check whether the figure is square.
     * @return - boolean
     */
    public boolean isSquare() {
        ArrayList<Point> listPoint = super.fillPoints();
        TreeSet<Double> treeA = fillInTree(this.a, listPoint);
        TreeSet<Double> treeB = fillInTree(this.b, listPoint);
        TreeSet<Double> treeC = fillInTree(this.c, listPoint);
        TreeSet<Double> treeD = fillInTree(this.d, listPoint);
        return treeA.size() == 2 && treeA.equals(treeB) && treeB.equals(treeC) && treeC.equals(treeD);
    }

    /**
     * fills points to tree.
     * @param a - point.
     * @param list - list points
     * @return TreeSet<Double>
     */
    public TreeSet<Double> fillInTree(Point a, ArrayList<Point> list) {
        TreeSet<Double> tree = new TreeSet<>();
        for (Point point : list) {
            if (a != point) {
                tree.add(super.calcHypotenuse(a, point));
            }
        }
        return tree;
    }
}

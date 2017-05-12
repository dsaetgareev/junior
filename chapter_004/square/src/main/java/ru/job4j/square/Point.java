package ru.job4j.square;

/**
 * class Point describes point of a square.
 * @author Dinis Saetgareev (dinis0086@mail.ru)
 * @since 11.05.2017
 * @version 1.0
 */
public class Point {
    /**
     * coordinate x.
     */
    private int x;
    /**
     * coordinate y.
     */
    private int y;

    /**
     * constructor.
     * @param x - new x
     * @param y - new y
     */
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * gets x.
     * @return this.x
     */
    public int getX() {
        return this.x;
    }

    /**
     * gets y.
     * @return this.y
     */
    public int getY() {
        return this.y;
    }
}

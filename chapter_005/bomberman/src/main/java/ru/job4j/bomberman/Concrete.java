package ru.job4j.bomberman;

/**
 * Concrete.
 * @author Dinis Saetgareev (dinis0086@mail.ru)
 * @since 19.06.2017
 * @version 1.0
 */
public class Concrete extends GameObject {
    /**
     * x.
     */
    private int x;
    /**
     * y.
     */
    private int y;
    /**
     * boolean detonated.
     */
    private boolean detonated;

    /**
     * constructor.
     * @param x - x
     * @param y - y
     * @param detonated - detonated
     */
    public Concrete(int x, int y, boolean detonated) {
        super(x, y);
        this.x = x;
        this.y = y;
        this.detonated = detonated;
    }

    /**
     * gets x.
     * @return - this.x
     */
    public int getX() {
        return this.x;
    }

    /**
     * gets y.
     * @return - this.y
     */
    public int getY() {
        return this.y;
    }

    /**
     * is detonated.
     * @return - this.detonated
     */
    public boolean getDetonated() {
        return this.detonated;
    }

}

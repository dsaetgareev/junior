package ru.job4j.bomberman;

/**
 * Game object.
 * @author Dinis Saetgareev (dinis0086@mail.ru)
 * @since 19.06.2017
 * @version 1.0
 */
public class GameObject {
    /**
     * x.
     */
    private int x;
    /**
     * y.
     */
    private int y;

    /**
     * constructor.
     * @param x - x
     * @param y - y
     */
    public GameObject(int x, int y) {
        this.x = x;
        this.y = y;
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
     * equals.
     * @param o - Object
     * @return - boolean
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        GameObject that = (GameObject) o;

        if (this.x != that.x) {
            return false;
        }
        return this.y == that.y;
    }

    /**
     * hachCode().
     * @return int
     */
    @Override
    public int hashCode() {
        int result = x;
        result = 31 * result + y;
        return result;
    }
}

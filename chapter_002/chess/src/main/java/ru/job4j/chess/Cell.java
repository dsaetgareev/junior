package ru.job4j.chess;

/**
 * class Cell describes board's cells.
 *
 * @author Dinis Saetgareev (dinis0086@mail.ru)
 * @version 1.0
 * @since 24.03.2017
 */
public class Cell {
    /**
     * int vertical - board's vertical cells.
     */
    private int vertical;
    /**
     * int horizontal - board's horizontal cells.
     */
    private int horizontal;

    /**
     * Constructor Cell(int vertical, int horizontal).
     * @param vertical - int
     * @param horizontal - int
     */
    public Cell(int vertical, int horizontal) {
        this.vertical = vertical;
        this.horizontal = horizontal;
    }

    /**
     * getVertical().
     * @return vertical - int
     */
    public int getVertical() {
        return this.vertical;
    }

    /**
     * getHorizontal().
     * @return horizontal - int
     */
    public int getHorizontal() {
        return this.horizontal;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Cell)) {
            return false;
        }

        Cell cell = (Cell) o;

        if (getVertical() != cell.getVertical()) {
            return false;
        }
        return getHorizontal() == cell.getHorizontal();
    }

    @Override
    public int hashCode() {
        int result = getVertical();
        result = 31 * result + getHorizontal();
        return result;
    }
}

package ru.job4j.chess;

/**
 * class Figure - describes chess Figures.
 * @author Dinis Saetgareev (dinis0086@mail.ru)
 * @version 1.0
 * @since 24.03.2017
 */
public abstract class Figure {
    /**
     * Cell position - position of the figure.
     */
    private final Cell position;

    /**
     * Constructor Figure(Cell position).
     * @param position - cell position
     */
    public Figure(Cell position) {
        this.position = position;
    }

    /**
     * getPosition().
     * @return this.position - Cell
     */
    public Cell getPosition() {
        return this.position;
    }
    /**
     * Cell[] way(Cell dist) - describes way figure.
     *
     * @param dist - target cell
     * @return Cell[] - way's array
     * @throws ImpossibleMoveException - throws
     */
    abstract Cell[] way(Cell dist) throws ImpossibleMoveException;

    /**
     * creates a clone of a figure.
     * @param dist - new position
     * @return new Figure - new figure
     */
    abstract Figure clone(Cell dist);
}

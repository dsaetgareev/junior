package ru.job4j.chess;


/**
 * class Elephant extends Figure describes a figure elephant.
 *
 * @author Dinis Saetgareev (dinis0086@mail.ru)
 * @version 1.0
 * @since 24.03.2017
 */
public class Elephant extends Figure {
    /**
     * Cell position - position of the figure.
     */
    private Cell position;

    /**
     * Constructor Elephant(Cell position).
     *
     * @param position - start position.
     */
    public Elephant(Cell position) {
        super(position);
        this.position = position;
    }

    /**
     * Cell[] way(Cell dist) - describes way figure.
     *
     * @param dist - target cell
     * @return Cell[] - way's array
     * @throws ImpossibleMoveException - throws
     */
    public Cell[] way(Cell dist) throws ImpossibleMoveException {
        int range = Math.abs(this.position.getVertical() - dist.getVertical());
        Cell[] result = new Cell[range];
        for (int i = 0; i < range; i++) {
            if (this.position.getVertical() < dist.getVertical()
                    && this.position.getHorizontal() < dist.getHorizontal()) {
                result[i] = new Cell(this.position.getVertical() + i + 1,
                        this.position.getHorizontal() + i + 1);
            }
            if (this.position.getVertical() > dist.getVertical()
                    && this.position.getHorizontal() < dist.getHorizontal()) {
                result[i] = new Cell(this.position.getVertical() + i - 1,
                        this.position.getHorizontal() + i + 1);
            }
            if (this.position.getVertical() > dist.getVertical()
                    && this.position.getHorizontal() > dist.getHorizontal()) {
                result[i] = new Cell(this.position.getVertical() + i - 1,
                        this.position.getHorizontal() + i - 1);
            }
            if (this.position.getVertical() < dist.getVertical()
                    && this.position.getHorizontal() > dist.getHorizontal()) {
                result[i] = new Cell(this.position.getVertical() + i + 1,
                        this.position.getHorizontal() + i - 1);
            }
        }
        if (result[range - 1].equals(dist)) {
            return result;
        } else {
            throw new ImpossibleMoveException();
        }
    }

    /**
     * creates a clone of a figure.
     * @param dist - new position
     * @return new Elephant - new figure
     */
    public Figure clone(Cell dist) {
        return new Elephant(dist);
    }
}

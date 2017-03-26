package ru.job4j.chess;

/**
 * class Board - implements chess board.
 *
 * @author Dinis Saetgareev (dinis0086@mail.ru)
 * @version 1.0
 * @since 24.03.2017
 */
public class Board {
    /**
     * figures - array of the figures.
     */
    private Figure[] figures;

    /**
     * Constructor Board(Figure[] figures).
     *
     * @param figures - array of the figures
     */
    public Board(Figure[] figures) {
        this.figures = figures;
    }

    /**
     * method move(Cell source, Cell dist) - checks the progress.
     *
     * @param source - source Cell
     * @param dist   - target of the figure
     * @return checking - boolean
     * @throws ImpossibleMoveException - throws
     * @throws OccupiedWayException    - throws
     * @throws FigureNotFoundException - throws
     */
    public boolean move(Cell source, Cell dist) throws ImpossibleMoveException, OccupiedWayException, FigureNotFoundException {
        boolean checking = false;
        for (int i = 0; i < figures.length; i++) {
            if (figures[i].getPosition().equals(source)) {
                for (int j = 0; j < figures[i].way(dist).length; j++) {
                    for (int k = 0; k < figures.length; k++) {
                        if (figures[i].way(dist)[j].equals(figures[k].getPosition())) {
                            throw new OccupiedWayException();
                        }
                    }
                }
            } else {
                throw new FigureNotFoundException();
            }
            figures[i] = figures[i].clone(dist);
            checking = true;
            break;
        }

        return checking;
    }
}

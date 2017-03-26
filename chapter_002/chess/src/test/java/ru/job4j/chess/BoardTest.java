package ru.job4j.chess;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Class BoardTest - testing class Board.
 * @author Dinis Saetgareev (dinis0086@mail.ru)
 * @version 1.0
 * @since 24.03.2017
 */
public class BoardTest {
    /**
     * whenElephantWalkThenPositionOfTheFigure() - testing method way() of class Elephant.
     */
    @Test
    public void whenFigureThenMove() {
        try {
            Figure[] figures = new Figure[]{new Elephant(new Cell(3, 1)),
                    new Elephant(new Cell(6, 4)),
                    new Elephant(new Cell(4, 3))};
            Board board = new Board(figures);
            boolean test = true;
            assertThat(board.move(new Cell(3, 1), new Cell(5, 3)), is(test));
        } catch (FigureNotFoundException fne) {
            System.out.println("In the cell no find a figure!!!");
        } catch (OccupiedWayException owe) {
            System.out.println("Occupied way!!!");
        } catch (ImpossibleMoveException ime) {
            System.out.println("This figure can not so walk!!");
        }
    }
}

package ru.job4j.chess;


import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Class ElephantTest - testing class Elephant.
 * @author Dinis Saetgareev (dinis0086@mail.ru)
 * @version 1.0
 * @since 24.03.2017
 */
public class ElephantTest {
    /**
     * whenElephantWalkThenPositionOfTheFigure() - testing method way() of class Elephant.
     */
    @Test
    public void whenElephantWalkThenPositionOfTheFigure() {
        try {
            Elephant elephant = new Elephant(new Cell(3, 1));
            Cell[] anotherCells = new Cell[] {new Cell(4, 2), new Cell(5, 3)};
             assertThat(elephant.way(new Cell(5, 3)), is(anotherCells));
        } catch (ImpossibleMoveException ime) {
            System.out.println("\"This figure can not so walk!!\"");
        }
    }

}

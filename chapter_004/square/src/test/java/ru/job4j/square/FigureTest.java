package ru.job4j.square;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * testing methods of class Figure.
 * @author Dinis Saetgareev (dinis0086@mail.ru)
 * @since 11.05.2017
 * @version 1.0
 */
public class FigureTest {
    /**
     * testing method identifyFigure().
     */
    @Test
    public void whenPointThenIdentifyFigure() {
        Point a = new Point(2, 10);
        Point b = new Point(2, 2);
        Point c = new Point(10, 10);
        Point d = new Point(10, 2);
        Figure figure = new Figure(a, b, c, d);

        assertThat(figure.identifyFigure(), is("The figure is square."));

        Point a1 = new Point(2, 10);
        Point b1 = new Point(2, 2);
        Point c1 = new Point(5, 10);
        Point d1 = new Point(5, 2);
        Figure figure1 = new Figure(a1, b1, c1, d1);

        assertThat(figure1.identifyFigure(), is("The figure is rectangle."));

        Point a2 = new Point(2, 5);
        Point b2 = new Point(4, 0);
        Point c2 = new Point(4, 10);
        Point d2 = new Point(6, 5);
        Figure figure2 = new Figure(a2, b2, c2, d2);

        assertThat(figure2.identifyFigure(), is("The figure is rhombus."));

        Point a3 = new Point(2, 5);
        Point b3 = new Point(4, 20);
        Point c3 = new Point(7, 10);
        Point d3 = new Point(6, 5);
        Figure figure3 = new Figure(a3, b3, c3, d3);

        assertThat(figure3.identifyFigure(), is("This figure is an irregular quadrilateral."));
    }

    /**
     * testing methods min and max.
     */
    @Test
    public void whenPointThenMinMax() {
        Point a = new Point(2, 3);
        Point b = new Point(5, 7);
        Point c = new Point(4, 3);
        Point d = new Point(5, 5);
        Figure figure = new Figure(a, b, c, d);

        assertThat(figure.min(a, b), is(a));
        assertThat(figure.max(a, b), is(b));
    }

    /**
     * testing methods calcHypotenuse().
     */
    @Test
    public void whenFigureThenHypotenuse() {
        Point a = new Point(2, 3);
        Point b = new Point(5, 7);
        Point c = new Point(4, 3);
        Point d = new Point(5, 5);
        Figure figure = new Figure(a, b, c, d);

        assertThat(figure.calcHypotenuse(a, b), is(5.0));
    }
}
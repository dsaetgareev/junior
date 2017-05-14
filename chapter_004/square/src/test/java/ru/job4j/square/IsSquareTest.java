package ru.job4j.square;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * testing methods of class IsSquare.
 * @author Dinis Saetgareev (dinis0086@mail.ru)
 * @since 14.05.2017
 * @version 1.0
 */
public class IsSquareTest {
    /**
     * testing method isSquare().
     */
    @Test
    public void whenPointsThenIsSquareBoolean() {
        Point a = new Point(2, 10);
        Point b = new Point(2, 2);
        Point c = new Point(10, 10);
        Point d = new Point(10, 2);
        IsSquare square = new IsSquare(a, b, c, d);

        assertThat(square.isSquare(), is(true));

        Point a1 = new Point(2, 10);
        Point b1 = new Point(2, 2);
        Point c1 = new Point(5, 10);
        Point d1 = new Point(5, 2);
        IsSquare square1 = new IsSquare(a1, b1, c1, d1);

        assertThat(square1.isSquare(), is(false));
    }

}
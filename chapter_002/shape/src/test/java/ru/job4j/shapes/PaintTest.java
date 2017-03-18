package ru.job4j.shapes;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * class PaintTest checking methods of class Shape.
 * @author Dinis Saetgareev (dinis0086@mail.ru)
 * @since 17.03.2017
 * @version 1.0
 */
public class PaintTest {
    /**
     * void whenDrawTriangleThenOutputToConsole()
     * testing method draw() of class Triangle.
     */
    @Test
    public void whenDrawTriangleThenOutputToConsole() {
        Shape shape = new Triangle(2);
        assertThat(shape.draw(), is("  ^\n ^ ^\n"));
    }
    /**
     * void whenDrawTriangleThenOutputToConsole()
     * testing method draw() of class Triangle.
     */
    @Test
    public void whenDrawSquareThenOutputToConsole() {
        Shape shape = new Square(2);
        assertThat(shape.draw(), is("8888\n8888\n"));
    }
}

package ru.job4j.even;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;

/**
 * tests methods of class IteratorEven.
 * @author Dinis Saetgareev (dinis0086@mail.ru)
 * @since 10.04.2017
 * @version 1.0
 */
public class IteratorEvenTest {
    /**
     * testing method next() of class IteratorEven.
     */
    @Test
    public void whenListThenIteratorNext() {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(3);
        list.add(2);
        list.add(5);
        list.add(4);
        IteratorEven it = new IteratorEven(list);

        assertThat(it.next(), is(2));
        assertThat(it.next(), is(4));
    }

    /**
     * testing method hasNext().
     */
    @Test
    public void whenNextThenHasNext() {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(3);
        list.add(2);
        list.add(5);
        list.add(4);
        IteratorEven it = new IteratorEven(list);

        it.next();
        it.hasNext();
        assertThat(it.hasNext(), is(true));

        it.next();
        assertThat(it.hasNext(), is(false));

    }
}

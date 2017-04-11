package ru.job4j.simple;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;



/**
 * tests methods of class IteratorSimple.
 * @author Dinis Saetgareev (dinis0086@mail.ru)
 * @since 10.04.2017
 * @version 1.0
 */
public class IteratorSimpleTest {
    /**
     * testing method next() of class IteratorSimple.
     */
    @Test
    public void whenListThenIteratorSimpleNext() {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(6);
        list.add(3);
        list.add(2);
        list.add(5);
        list.add(4);
        IteratorSimple it = new IteratorSimple(list);


        assertThat(it.next(), is(3));
        assertThat(it.next(), is(2));
        assertThat(it.next(), is(5));
    }
}

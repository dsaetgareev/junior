package ru.job4j.simpleararylist;

import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * testing methods of class SimpleArrayList.
 * @author Dinis Saetgareev (dinis0086@mail.ru)
 * @since 16.04.2017
 * @version 1.0
 */
public class SimpleArrayListTest {
    /**
     * testing method add() and get().
     */
    @Test
    public void thenAddElementThenArrayValues() {
        SimpleArrayList<String> values = new SimpleArrayList<String>(4);

        values.add("a");
        values.add("b");
        values.add("c");
        values.add("e");

        assertThat(values.get(3), is("e"));

        for (int i = 0; i < 10; i++) {
            values.add("d");
        }

        assertThat(values.get(10), is("d"));
    }

    /**
     * testing method remove(int index).
     */
    @Test
    public void whenRemoveByPositionThenArrayValue() {
        String[] objects = new String[]{"a", "b", "c", "e"};
        SimpleArrayList<String> values = new SimpleArrayList<String>(objects);

        assertThat(values.get(1), is("b"));

        values.remove(1);

        assertThat(values.get(1), is("c"));

        values.remove(2);
        System.out.println(values.get(2) + " " + values.get(3));
        assertThat(values.size(), is(2));
    }

    /**
     * testing method size().
     */
    @Test
    public void whenAddThenSize() {
        String[] objects = new String[]{"a", "b", "c", "e"};
        SimpleArrayList<String> values = new SimpleArrayList<String>(objects);

        assertThat(values.size(), is(4));

        values.remove(0);

        assertThat(values.size(), is(3));
    }

    /**
     * testing method Iterator hasNext().
     */
    @Test
    public void whenIteratorHasNextThenBoolean() {
        String[] objects = new String[]{"a", "b", "c", "e"};
        SimpleArrayList<String> values = new SimpleArrayList<String>(objects);

        assertThat(values.size(), is(4));

        Iterator<String> iterator = values.iterator();

        iterator.next();
        assertThat(iterator.hasNext(), is(true));

        iterator.next();
        iterator.next();
        iterator.next();
        assertThat(iterator.hasNext(), is(false));
    }

    /**
     * testing method Iterator next().
     */
    @Test
    public void whenIteratorNextThenNextElement() {
        String[] objects = new String[]{"a", "b", "c", "e"};
        SimpleArrayList<String> values = new SimpleArrayList<String>(objects);

        Iterator<String> iterator = values.iterator();

        assertThat(iterator.next(), is("a"));
        assertThat(iterator.next(), is("b"));
        assertThat(iterator.next(), is("c"));
        assertThat(iterator.next(), is("e"));
    }
}
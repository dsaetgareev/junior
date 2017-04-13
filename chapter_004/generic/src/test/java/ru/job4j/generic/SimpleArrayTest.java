package ru.job4j.generic;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;


/**
 * tests methods of class SimpleArray<T>.
 *
 * @author Dinis Saetgareev (dinis0086@mail.ru)
 * @version 1.0
 * @since 13.04.2017
 */
public class SimpleArrayTest {
    /**
     * testing method add() and get().
     */
    @Test
    public void thenAddElementThenArrayValues() {
        SimpleArray<String> values = new SimpleArray<String>(4);

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
     * testing method update().
     */
    @Test
    public void whenUpdateThenArrayValue() {
        String[] objects = new String[]{"a", "b", "c", "e"};
        SimpleArray<String> values = new SimpleArray<String>(objects);

        values.update(3, "E");

        assertThat(values.get(3), is("E"));
    }

    /**
     * testing method delete(int position).
     */
    @Test
    public void whenDeleteByPositionThenArrayValue() {
        String[] objects = new String[]{"a", "b", "c", "e"};
        SimpleArray<String> values = new SimpleArray<String>(objects);

        assertThat(values.get(1), is("b"));

        values.delete(1);

        assertThat(values.get(1), is("c"));
    }

    /**
     * testing method delete(T value).
     */
    @Test
    public void whenDeleteByValueThenArrayValue() {
        String[] objects = new String[]{"a", "b", "c", "e"};
        SimpleArray<String> values = new SimpleArray<String>(objects);

        assertThat(values.get(1), is("b"));

        values.delete("b");

        assertThat(values.get(1), is("c"));
    }
}

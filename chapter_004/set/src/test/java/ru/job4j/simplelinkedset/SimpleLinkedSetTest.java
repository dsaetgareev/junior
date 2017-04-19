package ru.job4j.simplelinkedset;

import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * testing methods of class SimpleLinkedSet.
 * @author Dinis Saetgareev (dinis0086@mail.ru)
 * @since 19.04.2017
 * @version 1.0
 */
public class SimpleLinkedSetTest {
    /**
     * testing method add(E e).
     */
    @Test
    public void whenAddThenSize() {
        SimpleLinkedSet<String> set = new SimpleLinkedSet<>();

        set.add("a");
        set.add("b");
        set.add("c");
        set.add("c");
        set.add("c");

        assertThat(set.size(), is(3));
    }

    /**
     * testing method iterator().
     */
    @Test
    public void whenIteratorHasNextThenBoolean() {
        SimpleLinkedSet<String> set = new SimpleLinkedSet<>();

        set.add("a");
        set.add("b");
        set.add("c");

        assertThat(set.size(), is(3));

        Iterator<String> iterator = set.iterator();

        iterator.next();

        assertThat(iterator.hasNext(), is(true));

        iterator.next();
        iterator.next();

        assertThat(iterator.hasNext(), is(false));
    }
}
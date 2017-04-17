package ru.job4j.simplestack;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * testing methods of class SimpleStack.
 * @author Dinis Saetgareev (dinis0086@mail.ru)
 * @since 16.04.2017
 * @version 1.0
 */
public class SimpleStackTest {
    /**
     * testing method push(E e).
     */
    @Test
    public void whenAddsToListThenList() {
        SimpleStack<String> queues = new SimpleStack<>();

        queues.push("a");

        assertThat(queues.size(), is(1));
    }
    /**
     * testing method poll().
     */
    @Test
    public void whenPollOutListThenListSize() {
        SimpleStack<String> queues = new SimpleStack<>();

        queues.push("a");
        queues.push("b");
        queues.push("c");
        assertThat(queues.size(), is(3));

        queues.poll();
        assertThat(queues.size(), is(2));
        assertThat(queues.getFirst(), is("a"));
        assertThat(queues.getLast(), is("b"));
    }
}
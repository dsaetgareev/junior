package ru.job4j.simplelinkedlist;

import org.junit.Test;
import ru.job4j.simplecontainer.SimpleContainer;

import java.util.Iterator;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * testing methods of class SimpleLinkedList.
 *  @author Dinis Saetgareev (dinis0086@mail.ru)
 * @since 16.04.2017
 * @version 1.0
 */
public class SimpleLinkedListTest {
    /**
     * testing method add(E e).
     * @throws Exception exception
     */
    @Test
    public void whenAddThenContainerSize() throws Exception {
        SimpleContainer<String> container = new SimpleLinkedList<>();

        container.add("element1");
        container.add("element2");

        assertThat(container.size(), is(2));
        assertThat(container.get(1), is("element2"));
    }

    /**
     * testing method get().
     * @throws Exception - exception
     */
    @Test
    public void whenAddThenContainerGet() throws Exception {
        SimpleContainer<String> container = new SimpleLinkedList<>();

        container.add("element1");
        container.add("element2");

        assertThat(container.get(0), is("element1"));
        assertThat(container.get(1), is("element2"));
    }

    /**
     * testing method remove(int index).
     * @throws Exception - exception
     */
    @Test
    public void whenRemoveThenContainer() throws Exception {
        SimpleContainer<String> container = new SimpleLinkedList<>();

        container.add("element1");
        container.add("element2");
        container.add("element3");

        container.remove(1);

        assertThat(container.get(1), is("element3"));
        assertThat(container.size(), is(2));
    }

    /**
     * testing method next of iterator.
     * @throws Exception exception
     */
    @Test
    public void iterator() throws Exception {
        SimpleContainer<String> container = new SimpleLinkedList<>();

        container.add("element1");
        container.add("element2");
        container.add("element3");

        Iterator<String> iterator = container.iterator();

        iterator.next();

        assertThat(iterator.next(), is("element2"));
    }
    /**
     * testing method hasNext() of iterator.
     */
    @Test
    public void whenHasNextThenBoolesn() {
        SimpleContainer<String> container = new SimpleLinkedList<>();

        container.add("element1");
        container.add("element2");
        container.add("element3");

        Iterator<String> iterator = container.iterator();

        iterator.next();

        assertThat(iterator.hasNext(), is(true));

        iterator.next();
        iterator.next();
        assertThat(iterator.hasNext(), is(false));
    }
    /**
     * testing method remove() of iterator.
     */
    @Test
    public void whenIteratorRemoveThenContainer() {
        SimpleContainer<String> container = new SimpleLinkedList<>();

        container.add("element1");
        container.add("element2");
        container.add("element3");

        Iterator<String> iterator = container.iterator();

        iterator.next();
        iterator.next();
        iterator.remove();

        assertThat(container.get(1), is("element3"));
    }
}
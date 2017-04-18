package ru.job4j.simplearrayset;

import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * testing methods of SimpleArraySetTest.
 * @author Dinis Saetgareev (dinis0086@mail.ru)
 * @version 1.0
 * @since 18.04.2017
 */
public class SimpleArraySetTest {
    /**
     * testing methods add(E e), hasDuplicate(E e),increaseArray(), size().
     */
    @Test
    public void whenAddThenSetSize() {
        SimpleArraySet<String> arraySet = new SimpleArraySet<String>();

        arraySet.add("a");
        arraySet.add("b");
        arraySet.add("c");
        arraySet.add("a");

        assertThat(arraySet.size(), is(3));

        for (int i = 0; i < 10; i++) {
            arraySet.add("d" + i);
        }

        assertThat(arraySet.size(), is(13));
    }

    /**
     * testing methods hasNext(), next().
     */
    @Test
    public void whenIteratorHasNextThenBoolean() {
        String[] strings = new String[] {"a", "b", "c"};
        SimpleArraySet<String> arraySet = new SimpleArraySet<String>(strings);

        Iterator<String> iterator = arraySet.iterator();

        iterator.next();

        assertThat(iterator.hasNext(), is(true));

        iterator.next();
        iterator.next();

        assertThat(iterator.hasNext(), is(false));
    }

}
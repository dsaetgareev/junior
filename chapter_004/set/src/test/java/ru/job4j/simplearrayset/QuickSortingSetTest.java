package ru.job4j.simplearrayset;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * testing methods of class QuickSortSet.
 * @author Dinis Saetgareev (dinis0086@mail.ru)
 * @since 23.04.2017
 * @version 1.0
 */
public class QuickSortingSetTest {

    /**
     * testing method add(E e).
     * @throws Exception - exception
     */
    @Test
    public void whenAddThenSetSize() throws Exception {
        QuickSet<String> set = new QuickSortingSet<>();
        set.add("a");

        assertThat(set.size(), is(1));

        set.add("b");
        set.add("j");
        set.add("c");

        assertThat(set.size(), is(4));

        set.add("a");
        set.add("a");


        assertThat(set.size(), is(4));

    }

    /**
     * testing method hasDuplicate(E e, int index).
     * @throws Exception - exception
     */
    @Test
    public void whenAddDuplicateThenBoolean() throws Exception {
        QuickSet<String> set =  new QuickSortingSet<>();
        set.add("a");
        assertThat(set.size(), is(1));
        set.add("b");
        set.add("j");
        set.add("i");

        int index = set.indexSearch("c");
        assertThat(set.hasDuplicate("c", index), is(true));

        set.add("c");

        int index2 = set.indexSearch("c");
        assertThat(set.hasDuplicate("c", index2), is(false));
    }

    /**
     * testing method indexSearch(E e).
     */
    @Test
    public void whenIndexSearchThenIndex() {
        QuickSet<String> set = new QuickSortingSet<>();
        set.add("a");
        set.add("b");
        set.add("j");

        assertThat(set.size(), is(3));

        assertThat(set.indexSearch("a"), is(0));
    }

}
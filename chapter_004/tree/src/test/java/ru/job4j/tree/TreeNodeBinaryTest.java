package ru.job4j.tree;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * testing methods of class TreeNodeBinary.
 * @author Dinis Saetgareev (dinis0086@mail.ru)
 * @since 04.05.2017
 * @version 1.0
 */
public class TreeNodeBinaryTest {
    /**
     * testing method add(E value).
     */
    @Test
    public void whenAddThenSize() {
        TreeNodeBinary<Integer> tree = new TreeNodeBinary<>();

        tree.add(8);

        assertThat(tree.size(), is(1));

        tree.add(10);
        tree.add(5);

        assertThat(tree.size(), is(3));

        tree.add(5);

        assertThat(tree.size(), is(3));

        tree.add(7);

        assertThat(tree.size(), is(4));
        tree.add(7);
        assertThat(tree.size(), is(4));
    }

}
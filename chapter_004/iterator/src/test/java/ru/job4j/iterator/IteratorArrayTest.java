package ru.job4j.iterator;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * tests methods of class IteratorArray.
 * @author Dinis Saetgareev (dinis0086@mail.ru)
 * @since 09.04.2017
 * @version 1.0
 */
public class IteratorArrayTest {
    /**
     * testing method next() of IteratorArray.
     */
    @Test
    public void whenArrayThenIterator() {
        IteratorArray<Integer> arrayIt = new IteratorArray<>(new int[][] {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        });
        int j = 0;
        for (int i = 0; i < 5; i++) {
           j = arrayIt.next();
        }
        assertThat(j, is(5));
    }
}

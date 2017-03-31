package ru.job4j.convertion;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import java.util.Arrays;
import java.util.List;

/**
 * testing methods of class ConvertList.
 *
 * @author Dinis Saetgareev (dinis0086@mail.ru)
 * @version 1.0
 * @since 29.03.2017
 */
public class ConvertListTest {
    /**
     * void whenArrayThenList() tests method toList() of class ConvertList.
     */
    @Test
    public void whenArrayThenList() {
        ConvertList convertList = new ConvertList();
        int[][] array = new int[][]{
                {1, 2, 3}, {4, 5, 6}, {7, 8, 9}
        };
        List<Integer> arrayList = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        assertThat(convertList.toList(array), is(arrayList));
    }

    /**
     * void whenListThenArray() tests method  toArray() of class ConvertList.
     */
    @Test
    public void whenListThenArray() {
        ConvertList convertList = new ConvertList();
        List<Integer> arrayList = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        int[][] array = new int[][]{
                {1, 2, 3}, {4, 5, 6}, {7, 8, 9}
        };
        assertThat(convertList.toArray(arrayList, 3), is(array));
    }
}

package ru.job4j.convert;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * tests methods class IteratorIterator.
 * @author Dinis Saetgareev (dinis0086@mail.ru)
 * @since 11.04.2017
 * @version 1.0
 */
public class IteratorIteratorTest {
    /**
     * testing method Iterator<Integer> convert(Iterator<Iterator<Integer>> it).
     */
    @Test
    public void whenIteratorIteratorThenIterator() {
        IteratorIterator iter = new IteratorIterator();
        ArrayList<Integer> list1 = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            list1.add(i);
        }
        ArrayList<Integer> list2 = new ArrayList<>();
        for (int i = 5; i < 10; i++) {
            list2.add(i);
        }
        ArrayList<Integer> list3 = new ArrayList<>();
        for (int i = 10; i < 15; i++) {
            list3.add(i);
        }
        Iterator<Integer> it1 = list1.iterator();
        Iterator<Integer> it2 = list2.iterator();
        Iterator<Integer> it3 = list3.iterator();
        ArrayList<Iterator<Integer>> list = new ArrayList<>();
        list.add(it1);
        list.add(it2);
        list.add(it3);
        Iterator<Iterator<Integer>> it = list.iterator();

        ArrayList<Integer> anotherList = new ArrayList<>();
        for (int i = 0; i < 15; i++) {
            anotherList.add(i);
        }
        Iterator<Integer> afterConvertIt = anotherList.iterator();

        assertThat(iter.convert(it).next(), is(afterConvertIt.next()));
    }
}

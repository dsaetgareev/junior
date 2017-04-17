package ru.job4j.cycle;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;


/**
 * testing methods of class CycleList.
 * @author Dinis Saetgareev (dinis0086@mail.ru)
 * @since 17.04.2017
 * @version 1.0
 */
public class CycleListTest {
    /**
     * testing method add(T t).
     */
    @Test
    public void whenAddNewElementThenCycleListSize() {
        CycleList<Integer> list = new CycleList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);

        assertThat(list.size(), is(4));
    }
    /**
     * testing method hasCycle(Note first).
     */
    @Test
    public void whenAddNewElementThenHasCycleReturn() {
        CycleList<Integer> list = new CycleList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);

        assertThat(list.size(), is(4));

        assertThat(list.hasCycle(), is(true));
    }
}
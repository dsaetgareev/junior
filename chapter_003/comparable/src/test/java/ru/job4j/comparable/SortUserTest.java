package ru.job4j.comparable;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import java.util.ArrayList;
import java.util.Iterator;


/**
 * tests methods of class SortUser.
 * @author Dinis Saetgareev (dinis0086@mail.ru)
 * @version 1.0
 * @since 02.04.2017
 */
public class SortUserTest {
    /**
     * testing method sort() of class SortUser.
     */
    @Test
    public void whenUserListThenTreeSet() {
        SortUser sort = new SortUser();
        ArrayList<User> list = new ArrayList<>();
        list.add(new User("A", 12));
        list.add(new User("B", 11));
        Iterator<User> iterator = sort.sort(list).iterator();
        assertThat(iterator.next().getName(), is("B"));
    }
}

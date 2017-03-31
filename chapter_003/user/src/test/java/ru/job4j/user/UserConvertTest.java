package ru.job4j.user;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * tests method process of class UserConvert.
 * @author Dinis Saetgareev (dinis0086@mail.ru)
 * @version 1.0
 * @since 31.03.2017
 */
public class UserConvertTest {
    /**
     * void whenListUserThatMapUser() - tests method process of class UserConvert.
     */
    @Test
    public void whenListUserThatMapUser() {
        UserConvert uc = new UserConvert();
        User user1 = new User(1, "A", "A");
        User user2 = new User(2, "B", "B");
        List<User> list = new ArrayList<>();
        list.add(user1);
        list.add(user2);
        HashMap<Integer, User> map = new HashMap<Integer, User>();
        User user4 = new User(1, "A", "A");
        User user5 = new User(2, "B", "B");
        map.put(user4.getId(), user4);
        map.put(user5.getId(), user5);
        assertThat(uc.process(list), is(map));
    }
}

package ru.job4j.map;

import org.junit.Test;

import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

/**
 * testing Users.
 * @author Dinis Saetgareev (dinis0086@mail.ru)
 * @since 24.04.2017
 * @version 1.0
 */
public class UserTest {
    /**
     * testing class User.
     */
    @Test
    public void userTestNoEqualsNoHashCode() {
        User user1 = new User("user", 1, new GregorianCalendar(1986, 01, 01));
        User user2 = new User("user", 1, new GregorianCalendar(1986, 01, 01));

        Map<User, Object> map = new HashMap<>();
        Object object = new Object();

        map.put(user1, object);
        map.put(user2, object);

        System.out.println(map);
    }

    /**
     * testing class UserNoEquals.
     */
    @Test
    public void userTestNoEquals() {
        UserNoEquals user1 = new UserNoEquals("user", 1, new GregorianCalendar(1986, 01, 01));
        UserNoEquals user2 = new UserNoEquals("user", 1, new GregorianCalendar(1986, 01, 01));

        Map<UserNoEquals, Object> map = new HashMap<>();
        Object object = new Object();

        map.put(user1, object);
        map.put(user2, object);

        System.out.println(map);
    }

    /**
     * testing class UserNoHashCode.
     */
    @Test
    public void userTestNoHashCode() {
        UserNoHashCode user1 = new UserNoHashCode("user", 1, new GregorianCalendar(1986, 01, 01));
        UserNoHashCode user2 = new UserNoHashCode("user", 1, new GregorianCalendar(1986, 01, 01));

        Map<UserNoHashCode, Object> map = new HashMap<>();
        Object object = new Object();

        map.put(user1, object);
        map.put(user2, object);

        System.out.println(map);
    }

    /**
     * testing class UserEqualsAndHashCode.
     */
    @Test
    public void userTestEqualsAndHashCode() {
        UserEqualsAndHashCode user1 = new UserEqualsAndHashCode("user", 1, new GregorianCalendar(1986, 01, 01));
        UserEqualsAndHashCode user2 = new UserEqualsAndHashCode("user", 1, new GregorianCalendar(1986, 01, 01));

        Map<UserEqualsAndHashCode, Object> map = new HashMap<>();
        Object object = new Object();

        map.put(user1, object);
        map.put(user2, object);

        System.out.println(map);
    }
}
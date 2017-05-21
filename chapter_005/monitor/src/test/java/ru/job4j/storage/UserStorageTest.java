package ru.job4j.storage;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * testing methods of class UserStorage.
 * @author Dinis Saetgareev (dinis0086@mail.ru)
 * @since 21.05.2017
 * @version 1.0
 */
public class UserStorageTest {
    /**
     * testing method addNewUser.
     */
    @Test
    public void whenAddNewUserThenUserMapSize() {
        UserStorage storage = new UserStorage();

        storage.addNewUser("User", 100000);

        assertThat(storage.sizeUsers(), is(1));
    }

    /**
     * testing method findUser().
     */
    @Test
    public void whenFindUserThenUser() {
        Map<Integer, User> map = new HashMap<>();

        User user1 = new User(1, "user1", 1);
        User user2 = new User(2, "user2", 2);
        map.put(1, user1);
        map.put(2, user2);

        UserStorage storage = new UserStorage(map);

        assertThat(storage.sizeUsers(), is(2));

        assertThat(storage.findUser(2), is(user2));
    }

    /**
     * testing removeUser().
     */
    @Test
    public void whenRemoveUserThenUserMapSize() {
        Map<Integer, User> map = new HashMap<>();

        User user1 = new User(1, "user1", 1);
        User user2 = new User(2, "user2", 2);
        map.put(1, user1);
        map.put(2, user2);

        UserStorage storage = new UserStorage(map);

        storage.removeUser(2);

        assertThat(storage.sizeUsers(), is(1));
    }

    /**
     * testing method updateUser().
     */
    @Test
    public void whenUpdateUserThenGetAmountOfUser() {
        Map<Integer, User> map = new HashMap<>();

        User user1 = new User(1, "user1", 1);
        User user2 = new User(2, "user2", 2);
        map.put(1, user1);
        map.put(2, user2);

        UserStorage storage = new UserStorage(map);

        storage.updateUser(2, "user3", 100);

        assertThat(storage.findUser(2).getAmount(), is(100L));
    }

    /**
     * testing method transactions().
     */
    @Test
    public void whenTransactionsThenUserAmount() {
        Map<Integer, User> map = new HashMap<>();

        User user1 = new User(1, "user1", 100);
        User user2 = new User(2, "user2", 2);
        map.put(1, user1);
        map.put(2, user2);

        UserStorage storage = new UserStorage(map);

        storage.transactions(1, 2, 99);

        assertThat(storage.findUser(1).getAmount(), is(1L));
        assertThat(storage.findUser(2).getAmount(), is(101L));
    }

}
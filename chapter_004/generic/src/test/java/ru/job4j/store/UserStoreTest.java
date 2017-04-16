package ru.job4j.store;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;


/**
 * tests methods class UserStore.
 * @author Dinis Saetgareev (dinis0086@mail.ru)
 * @version 1.0
 * @since 13.04.2017
 */
public class UserStoreTest {
    /**
     * testing method add().
     */
    @Test
    public void whenAddThenUserStore() {
        UserStore userStore = new UserStore();
        User user = new User(null);

        userStore.add(user);

        User user2 = new User(user.getId());

        assertThat(userStore.findAll().get(0), is(user2));
    }

    /**
     * testing method update().
     */
    @Test
    public void whenUpdateThenUserStore() {
        UserStore userStore = new UserStore();
        User user = new User(null);

        userStore.add(user);

        User user2 = new User(user.getId());
        User user3 = new User(user2.getId());

        assertThat(userStore.findAll().get(0), is(user3));
    }
    /**
     * testing method remove().
     */
    @Test
    public void whenRemoveThenUserStore() {
        UserStore userStore = new UserStore();
        User user = new User(null);

        userStore.add(user);

        assertThat(userStore.findAll().size(), is(1));

        User user1 = new User(user.getId());

        userStore.remove(user1);

        assertThat(userStore.findAll().size(), is(0));
    }
}

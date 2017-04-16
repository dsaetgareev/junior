package ru.job4j.store;

import ru.job4j.generic.SimpleArray;

import java.util.Iterator;
import java.util.Random;

/**
 *class UserStore implements Store<T>.
 * @author Dinis Saetgareev (dinis0086@mail.ru)
 * @version 1.0
 * @since 13.04.2017
 */
public class UserStore implements Store<User> {
    /**
     * database for user.
     */
    private SimpleArray<User> userStore = new SimpleArray<>(10);
    /**
     * rn - random value.
     */
    private Random rn = new Random();
    /**
     * adds new User.
     * @param user - new user
     */
    public void add(User user) {
        user.setId(String.valueOf(rn.nextInt(1000)));
        this.userStore.add(user);
    }
    /**
     * edit a user.
     * @param user - user of which is update
     */
    public void edit(User user) {
        for (int i = 0; i < this.userStore.size(); i++) {
            if (this.userStore.get(i) != null && this.userStore.get(i).getId().equals(user.getId())) {
                this.userStore.update(i, user);
            }
        }
    }

    /**
     * remove a user.
     * @param user - remove of which is remove
     */
    public void remove(User user) {
        for (int i = 0; i < this.userStore.size(); i++) {
            if (this.userStore.get(i) != null && this.userStore.get(i).getId().equals(user.getId())) {
                this.userStore.delete(user);
            }
        }
    }

    /**
     * return all element userStore.
     * @return all element
     */
    public SimpleArray<User> findAll() {
        SimpleArray<User> result = new SimpleArray<User>(this.userStore.size());
        Iterator<User> iterator = this.userStore.iteratorSimple();
        while (iterator.hasNext()) {
            result.add(iterator.next());
        }
        return result;
    }

}

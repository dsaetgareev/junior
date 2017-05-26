package ru.job4j.storage;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * Storage of Users.
 * @author Dinis Saetgareev (dinis0086@mail.ru)
 * @since 21.05.2017
 * @version 1.0
 */
public class UserStorage {
    /**
     * map of Users.
     */
    private Map<Integer, User> userMap = new HashMap<>();

    /**
     * constructor.
     */
    public UserStorage() {

    }

    /**
     * constructor.
     * @param map - new map.
     */
    public UserStorage(Map<Integer, User> map) {
        this.userMap = map;
    }

    /**
     * adds new User.
     * @param name - name of User
     * @param amount - amount of User
     */
    public synchronized void addNewUser(String name, long amount) {
        int id = new Random().nextInt();
        userMap.put(id, new User(id, name, amount));
    }

    /**
     * finds User.
     * @param id - id of User
     * @return user
     */
    public synchronized User findUser(int id) {
        return this.userMap.get(id);
    }

    /**
     * removes User.
     * @param id - id of User
     */
    public synchronized void removeUser(int id) {
        this.userMap.remove(id);
    }

    /**
     * updates User.
     * @param id - id of User
     * @param name - new name
     * @param amount - new amount
     */
    public synchronized void updateUser(int id, String name, long amount) {
        this.userMap.put(id, new User(id, name, amount));
    }

    /**
     * money transactions.
     * @param id1 - id of User1
     * @param id2 - id of User2
     * @param amount - amount of transfer
     * @return - boolean
     */
    public synchronized boolean transactions(int id1, int id2, long amount) {
        synchronized (this) {
            boolean result = false;
            User user1 = findUser(id1);
            User user2 = findUser(id2);
            if (user1.getAmount() >= amount) {
                user1.setAmount(user1.getAmount() - amount);
                user2.setAmount(user2.getAmount() + amount);
                result = true;
            } else {
                System.out.println("Insufficient funds on the account!");
            }
            return result;
        }
    }

    /**
     * returns size users.
     * @return this.userMap.size()
     */
    public synchronized int sizeUsers() {
        return this.userMap.size();
    }
}

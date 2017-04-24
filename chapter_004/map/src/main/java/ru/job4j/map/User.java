package ru.job4j.map;

import java.util.Calendar;

/**
 * class User.
 * @author Dinis Saetgareev (dinis0086@mail.ru)
 * @since 24.04.2017
 * @version 1.0
 */
public class User {
    /**
     * name of user.
     */
    private String name;
    /**
     * children of user.
     */
    private int children;
    /**
     * birthday of user.
     */
    private Calendar birthday;

    /**
     * constructor.
     * @param name - new name
     * @param children - new children
     * @param birthday - new birthday
     */
    public User(String name, int children, Calendar birthday) {
        this.name = name;
        this.children = children;
        this.birthday = birthday;
    }
}

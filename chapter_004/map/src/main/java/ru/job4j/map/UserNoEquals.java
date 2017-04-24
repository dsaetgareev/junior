package ru.job4j.map;


import java.util.Calendar;

/**
 * class UserNoEquals.
 * @author Dinis Saetgareev (dinis0086@mail.ru)
 * @since 24.04.2017
 * @version 1.0
 */
public class UserNoEquals {
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
    public UserNoEquals(String name, int children, Calendar birthday) {
        this.name = name;
        this.children = children;
        this.birthday = birthday;
    }

    /**
     * hashCode().
     * @return - hash
     */
    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + children;
        result = 31 * result + (birthday != null ? birthday.hashCode() : 0);
        return result;
    }
}

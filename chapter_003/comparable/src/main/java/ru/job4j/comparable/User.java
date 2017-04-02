package ru.job4j.comparable;

/**
 * class User implements Comparable<User>.
 * @author Dinis Saetgareev (dinis0086@mail.ru)
 * @since 02.04.2017
 * @version 1.0
 */
public class User implements Comparable<User> {
    /**
     * name of user.
     */
    private String name;
    /**
     * user's age.
     */
    private int age;

    /**
     * constructor User.
     * @param name - user's name
     * @param age - user's age
     */
    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    /**
     * getName().
     * @return this.name
     */
    public String getName() {
        return this.name;
    }

    /**
     * getAge().
     * @return this.age
     */
    public int getAge() {
        return this.age;
    }

    /**
     * compareTo(User user) - compare ages of users.
     * @param user - user
     * @return int
     */
    public int compareTo(User user) {
        return this.age > user.getAge() ? 1 : this.age == user.getAge() ? 0 : -1;
    }
}

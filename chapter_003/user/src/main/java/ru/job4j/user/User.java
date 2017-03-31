package ru.job4j.user;

/**
 * class User describe user.
 * and an array to a collections.
 * @author Dinis Saetgareev (dinis0086@mail.ru)
 * @version 1.0
 * @since 31.03.2017
 */
public class User {
    /**
     * id of User.
     */
    private int id;
    /**
     * name of User.
     */
    private String name;
    /**
     * city of User.
     */
    private String city;

    /**
     * constructor User(int id, String name, String city).
     * @param id - id of User
     * @param name - name of User
     * @param city - city of User
     */
    public User(int id, String name, String city) {
        this.id = id;
        this.name = name;
        this.city = city;
    }

    /**
     * getId().
     * @return this.id - int
     */
    public int getId() {
        return this.id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof User)) {
            return false;
        }

        User user = (User) o;

        if (getId() != user.getId()) {
            return false;
        }
        if (name != null ? !name.equals(user.name) : user.name != null) {
            return false;
        }
        return city != null ? city.equals(user.city) : user.city == null;
    }

    @Override
    public int hashCode() {
        int result = getId();
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (city != null ? city.hashCode() : 0);
        return result;
    }
}

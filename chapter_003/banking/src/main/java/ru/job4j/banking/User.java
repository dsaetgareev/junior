package ru.job4j.banking;

/**
 * class User creates user.
 * @author Dinis Saetgareev (dinis0086@mail.ru)
 * @since 02.04.2017
 * @version 1.0
 */
public class User {
    /**
     * user's name.
     */
    private String name;
    /**
     * user's passport.
     */
    private String passport;

    /**
     * constructor User(String name, String passport).
     * @param name - user's name
     * @param passport - user's passport
     */
    public User(String name, String passport) {
        this.name = name;
        this.passport = passport;
    }

    /**
     * getName().
     * @return name - this.name
     */
    public String getName() {
        return this.name;
    }

    /**
     * getPassport().
     * @return passport - this.passport
     */
    public String getPassport() {
        return this.passport;
    }

    /**
     * override equals().
     * @param o - another Object
     * @return boolean
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof User)) {
            return false;
        }

        User user = (User) o;

        if (getName() != null ? !getName().equals(user.getName()) : user.getName() != null) {
            return false;
        }
        return getPassport() != null ? getPassport().equals(user.getPassport()) : user.getPassport() == null;
    }

    /**
     * override hashCode().
     * @return result
     */
    @Override
    public int hashCode() {
        int result = getName() != null ? getName().hashCode() : 0;
        result = 31 * result + (getPassport() != null ? getPassport().hashCode() : 0);
        return result;
    }
}

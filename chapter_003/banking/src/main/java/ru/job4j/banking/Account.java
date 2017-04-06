package ru.job4j.banking;

/**
 * class Account describes a user's account.
 * @author Dinis Saetgareev (dinis0086@mail.ru)
 * @since 02.04.2017
 * @version 1.0
 */
public class Account {
    /**
     * account's value.
     */
    private double value;
    /**
     * account's requisites.
     */
    private String requisites;

    /**
     * constructor Account(long value, String requisites).
     * @param value - amount money
     * @param requisites - requisites of user's
     */
    public Account(double value, String requisites) {
        this.value = value;
        this.requisites = requisites;
    }

    /**
     * getValut().
     * @return this.value
     */
    public double getValue() {
        return this.value;
    }

    /**
     * setValue(double value).
     * @param value - this.value
     */
    public void setValue(double value) {
        this.value = value;
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
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Account account = (Account) o;

        if (Double.compare(account.value, value) != 0) {
            return false;
        }
        return requisites != null ? requisites.equals(account.requisites) : account.requisites == null;
    }
    /**
     * override hashCode().
     * @return result
     */
    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(value);
        result = (int) (temp ^ (temp >>> 32));
        result = 31 * result + (requisites != null ? requisites.hashCode() : 0);
        return result;
    }
}

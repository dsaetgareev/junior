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

}

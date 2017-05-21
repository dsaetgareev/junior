package ru.job4j.storage;

/**
 * describes User.
 * @author Dinis Saetgareev (dinis0086@mail.ru)
 * @since 21.05.2017
 * @version 1.0
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
     * amount money.
     */
    private long amount;

    /**
     * constructor.
     * @param id - new id
     * @param name - new name
     * @param amount - new amount
     */
    public User(int id, String name, long amount) {
        this.id = id;
        this.name = name;
        this.amount = amount;
    }

    /**
     * gets amount.
     * @return this.amount
     */
    public long getAmount() {
        return this.amount;
    }

    /**
     * sets amount.
     * @param amount - new amount
     */
    public void setAmount(long amount) {
        this.amount = amount;
    }
}

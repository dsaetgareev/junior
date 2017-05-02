package ru.job4j.book;

/**
 * class Order - describes order.
 * @author Dinis Saetgareev (dinis0086@mail.ru)
 * @since 02.04.2017
 * @version 1.0
 */
public class Order {
    /**
     * id of order.
     */
    private static int id = 0;
    /**
     * price of order.
     */
    private double price;
    /**
     * volume of order.
     */
    private int volume;
    /**
     * type of transaction of order.
     */
    private String typeTrans;

    /**
     * constructor.
     * @param price - new price
     * @param volume - new volume
     * @param typeTrans - new typeTrans
     */
    public Order(double price, int volume, String typeTrans) {
        this.id++;
        this.price = price;
        this.volume = volume;
        this.typeTrans = typeTrans;
    }

    /**
     * gets price.
     * @return this.price
     */
    public double getPrice() {
        return this.price;
    }

    /**
     * gets volume.
     * @return this.volume
     */
    public int getVolume() {
        return this.volume;
    }

    /**
     * sets volume.
     * @param volume - new volume
     */
    public void setVolume(int volume) {
        this.volume = volume;
    }

    /**
     * gets typeTrans.
     * @return this.typeTrans
     */
    public String getTypeTrans() {
        return this.typeTrans;
    }
}

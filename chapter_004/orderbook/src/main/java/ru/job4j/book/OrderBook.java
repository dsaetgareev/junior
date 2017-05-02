package ru.job4j.book;

import java.util.TreeMap;

/**
 * class OrderBook describes book of order.
 * @author Dinis Saetgareev (dinis0086@mail.ru)
 * @since 02.04.2017
 * @version 1.0
 */
public class OrderBook {
    /**
     * ask book.
     */
    private TreeMap<Double, Order> askBook;
    /**
     * bid book.
     */
    private TreeMap<Double, Order> bidBook;

    /**
     * constructor.
     */
    public OrderBook() {
        this.bidBook = new TreeMap<>();
        this.askBook = new TreeMap<>();
    }

    /**
     * gets askBook.
     * @return this.askBook
     */
    public TreeMap<Double, Order> getAskBook() {
        return this.askBook;
    }

    /**
     * gets bidBook.
     * @return this.bidBook
     */
    public TreeMap<Double, Order> getBidBook() {
        return this.bidBook;
    }


}

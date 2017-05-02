package ru.job4j.book;

import java.util.Random;

/**
 * class CreatorOrderBook creates order and orderBook.
 * @author Dinis Saetgareev (dinis0086@mail.ru)
 * @since 02.04.2017
 * @version 1.0
 */
public class CreatorOrderBook {
    /**
     * random.
     */
    private Random rn = new Random();

    /**
     * constructor.
     */
    public CreatorOrderBook() {

    }

    /**
     * creator of order, the new price varies by 20%.
     * @param oldPrice - old price
     * @return new order
     */
    public Order createOrder(double oldPrice) {
        String typeTrans;
        double newPrice = oldPrice * 0.8 + Math.random() * oldPrice * 0.4;
        int volume = rn.nextInt(100);
        int bayAndSell = rn.nextInt(5);
        if (bayAndSell % 2 == 0) {
            typeTrans = "bay";
        } else {
            typeTrans = "sell";
        }
        return new Order(newPrice, volume, typeTrans);
    }

    /**
     * creator for OrderBook.
     * @param oldPrice - old price
     * @param orderBook - new orderBook
     * @return new OrderBook
     */
    public OrderBook createOrderBook(double oldPrice, OrderBook orderBook) {
        double price = oldPrice;
        int count = 1 + rn.nextInt(10);
        for (int i = 0; i < count; i++) {
            Order order = createOrder(price);
            if (order.getTypeTrans().equals("bay")) {
                orderBook.getBidBook().put(order.getPrice(), order);
            } else {
                orderBook.getAskBook().put(order.getPrice(), order);
            }
            price = order.getPrice();
        }
        return orderBook;
    }
}

package ru.job4j.book;

import org.junit.Test;

/**
 * testing StockExchange.
 * @author Dinis Saetgareev (dinis0086@mail.ru)
 * @since 02.04.2017
 * @version 1.0
 */
public class StockExchangeTest {
    /**
     * testing methods fairPrice(), createOrderBook(), createOrder().
     */
    @Test
    public void whenOldPriceThenNewPrice() {
        CreatorOrderBook creator = new CreatorOrderBook();
        OrderBook orderBook = new OrderBook();
        StockExchange stockExchange = new StockExchange();
        double price = 100;
        for (int i = 9; i < 23; i++) {
            price = stockExchange.fairPrice(creator.createOrderBook(price, orderBook));
            System.out.println(String.format("[_%s:00_],  [%.2f]", i, price));
        }
    }
}
package ru.job4j.book;

/**
 * class StockExchange calculates fair price for market.
 * @author Dinis Saetgareev (dinis0086@mail.ru)
 * @since 02.04.2017
 * @version 1.0
 */
public class StockExchange {

    /**
     * calculate fair price.
     * @param orderBook orderBook
     * @return lastPrice
     */
    public double fairPrice(OrderBook orderBook) {
        double lastPrice = orderBook.getBidBook().lastKey();
        if (orderBook.getAskBook().size() == 0) {
            return orderBook.getBidBook().lastKey();
        }
        if (orderBook.getBidBook().size() == 0) {
            return orderBook.getAskBook().lastKey();
        }
        Order bid = orderBook.getBidBook().get(orderBook.getBidBook().lastKey());
        Order ask = orderBook.getAskBook().get(orderBook.getAskBook().firstKey());
        while (bid.getPrice() >= ask.getPrice()) {
            int differ = bid.getVolume() - ask.getVolume();
            if (differ > 0) {
                orderBook.getAskBook().remove(orderBook.getAskBook().firstKey());
                bid.setVolume(differ);
                lastPrice = bid.getPrice();
                if (orderBook.getAskBook().size() == 0) {
                    break;
                }
            }
            if (differ < 0) {
                orderBook.getBidBook().remove(orderBook.getBidBook().lastKey());
                differ = Math.abs(differ);
                ask.setVolume(differ);
                lastPrice = ask.getPrice();
                if (orderBook.getBidBook().size() == 0) {
                    break;
                }
            }
            if (differ == 0) {
                orderBook.getAskBook().remove(orderBook.getAskBook().firstKey());
                orderBook.getBidBook().remove(orderBook.getBidBook().lastKey());
                if (orderBook.getBidBook().size() == 0 || orderBook.getAskBook().size() == 0) {
                    break;
                }
            }
            bid = orderBook.getBidBook().get(orderBook.getBidBook().lastKey());
            ask = orderBook.getAskBook().get(orderBook.getAskBook().firstKey());
        }
        return lastPrice;
    }
}

package ru.job4j.wait;

/**
 * ProducerConsumer implements work of buffer.
 * @author Dinis Saetgareev (dinis0086@mail.ru)
 * @since 28.05.2017
 * @version 1.0
 */
public class ProducerConsumer {
    /**
     * method main.
     * @param args _ String[]
     * @throws InterruptedException - Exception
     */
    public static void main(String[] args) throws InterruptedException {
        Buffer buffer = new Buffer();

        Thread producer = new Thread(new Producer(buffer));
        Thread consumer = new Thread(new Consumer(buffer));

        producer.start();
        Thread.sleep(2000);
        consumer.start();
    }
}

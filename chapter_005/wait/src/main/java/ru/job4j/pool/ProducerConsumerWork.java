package ru.job4j.pool;


import java.text.ParseException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


/**
 * ProducerConsumerWork implements work of buffer.
 * @author Dinis Saetgareev (dinis0086@mail.ru)
 * @since 28.05.2017
 * @version 1.0
 */
public class ProducerConsumerWork {
    /**
     * method main.
     * @param args - String[]
     * @throws ParseException - exception
     * @throws InterruptedException - exception
     */
    public static void main(String[] args) throws ParseException, InterruptedException {

        BufferWork bufferWork = new BufferWork();

        ExecutorService producer = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors() + 1);

        ExecutorService consumer = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors() + 1);
        for (int j = 0; j < Runtime.getRuntime().availableProcessors() + 1; j++) {
            producer.submit(new ProducerWork(bufferWork));
            Thread.sleep(100);
            consumer.submit(new ConsumerWork(bufferWork));
        }

        producer.shutdown();
        consumer.shutdown();
        System.out.println("producer is shutdown? " + producer.isShutdown());
        System.out.println("consumer is shutdown? " + consumer.isShutdown());
    }


}

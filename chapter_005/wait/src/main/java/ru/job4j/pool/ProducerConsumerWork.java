package ru.job4j.pool;


import java.text.ParseException;


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
     */
    public static void main(String[] args) throws ParseException {

        BufferWork bufferWork = new BufferWork();

        new Thread(new ProducerWork(bufferWork)).start();


        for (int j = 0; j < Runtime.getRuntime().availableProcessors(); j++) {
            new Thread(new ConsumerWork(bufferWork)).start();
        }
    }


}

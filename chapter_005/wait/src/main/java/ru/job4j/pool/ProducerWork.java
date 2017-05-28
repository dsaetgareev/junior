package ru.job4j.pool;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Random;

/**
 * ProducerWork implements Runnable creates new work.
 * @author Dinis Saetgareev (dinis0086@mail.ru)
 * @since 28.05.2017
 * @version 1.0
 */
public class ProducerWork implements Runnable {
    /**
     * buffer.
     */
    private BufferWork bufferWork;

    /**
     * constructor.
     * @param bufferWork - new bufferWork
     */
    public ProducerWork(BufferWork bufferWork) {
        this.bufferWork = bufferWork;
    }

    /**
     * method run() - adds work.
     */
    @Override
    public void run() {
        while (true) {
            Calendar cal = new GregorianCalendar(2017, 1, 1);
            cal.add(Calendar.DAY_OF_YEAR, new Random().nextInt(365));
            if (cal.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY) {
                cal.add(Calendar.DAY_OF_YEAR, 2);
            }
            if (cal.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {
                cal.add(Calendar.DAY_OF_YEAR, 1);
            }
            Work work = new Work(cal);
            this.bufferWork.add(work);
        }
    }
}

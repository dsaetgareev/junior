package ru.job4j.nonblock;

/**
 * OptimisticException extends RuntimeException.
 * @author Dinis Saetgareev (dinis0086@mail.ru)
 * @version 1.0
 * @since 12.06.2017
 */
public class OptimisticException extends RuntimeException {
    /**
     * constructor.
     * @param messing - String messing
     */
    public OptimisticException(String messing) {
        super(messing);
    }
}

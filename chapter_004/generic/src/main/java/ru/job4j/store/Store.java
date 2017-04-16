package ru.job4j.store;

/**
 * interface Store.
 * @author Dinis Saetgareev (dinis0086@mail.ru)
 * @version 1.0
 * @since 13.04.2017
 * @param <T> extends Base
 */
public interface Store<T extends Base> {
    /**
     * adds new element.
     * @param t - new element
     */
    void add(T t);

    /**
     * edit a element.
     * @param t - element
     */
    void edit(T t);

    /**
     * remove a element.
     * @param t - element
     */
    void remove(T t);

}

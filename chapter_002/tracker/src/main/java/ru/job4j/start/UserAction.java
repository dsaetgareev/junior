package ru.job4j.start;

/**
 * interface UserAction.
 * @author Dinis Saetgareev (dinis0086@mail.ru)
 * @since 15.03.2017
 * @version 1.0
 */
public interface UserAction {
    /**
     * method key() return key for menu.
     * @return key - int
     */
    int key();

    /**
     * method void execute(Input input, Tracker tracker) executes class.
     * @param input - Input
     * @param tracker - Tracker
     */
    void execute(Input input, Tracker tracker);
    /**
     * method String info() return info.
     * @return info - String
     */
    String info();
}

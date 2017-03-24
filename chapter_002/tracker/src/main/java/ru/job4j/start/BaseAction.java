package ru.job4j.start;

/**
 * abstract class BaseAction implements UserAction.
 * @author Dinis Saetgareev (dinis0086@mail.ru)
 * @since 21.03.2017
 * @version 1.0
 */
public abstract class BaseAction implements UserAction {
    /**
     * String name - BaseAction name.
     */
    private String name;

    /**
     * Constructor BaseAction().
     * @param name - String
     */
    public BaseAction(String name) {
        this.name = name;
    }
    /**
     * method key() return key for menu.
     * @return key - int
     */
    public abstract int key();

    /**
     * method void execute(Input input, Tracker tracker) executes class.
     * @param input - Input
     * @param tracker - Tracker
     */
    public abstract void execute(Input input, Tracker tracker);
    /**
     * method String info() return info.
     * @return info - String
     */
    public String info() {
        return this.name;
    }
}

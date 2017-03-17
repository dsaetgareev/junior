package ru.job4j.start;

/**
 * class StartUI contains main method.
 * @author Dinis Saetgareev (dinis0086@mail.ru)
 * @since 15.03.2017
 * @version 1.0
 */
public class StartUI {
    /**
     * Input input.
     */
    private Input input;

    /**
     * Constructor StartUI(Input input).
     * @param input - Input
     */
    protected StartUI(Input input) {
        this.input = input;
    }
    /**
     * method init() displays a menu.
     */
    public void init() {
        Tracker tracker = new Tracker();
        TrackerMenu menu = new TrackerMenu(input, tracker);
        menu.fillAction();
        do {
            menu.show();
            int key = Integer.valueOf(input.ask("Select: "));
            menu.select(key);
        } while (!"y".equals(input.ask("Continue? any symbol. Exit? 'y' ")));
    }
    /**
     * method main.
     * @param args - String[]
     */
    public static void main(String[] args) {
        ConsoleInput input = new ConsoleInput();
        new StartUI(input).init();
    }
}

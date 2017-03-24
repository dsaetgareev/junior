package ru.job4j.start;

/**
 * class StartUI contains main method.
 *
 * @author Dinis Saetgareev (dinis0086@mail.ru)
 * @version 1.0
 * @since 15.03.2017
 */
public class StartUI {
    /**
     * Input input.
     */
    private Input input;
    /**
     * Tracker tracker.
     */
    private Tracker tracker;
    /**
     * Language lang.
     */
    private Language lang;

    /**
     * Constructor StartUI(Input input).
     *
     * @param input   - Input
     * @param tracker - Tracker
     */
    public StartUI(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    /**
     * method init() displays a menu.
     */
    public void init() {

        MenuLanguage lan = new MenuLanguage(this.input, this.tracker);
        lang = lan.selectLan(this.input.ask(lan.question(), lan.initRangeLan()));
        TrackerMenu menu = new TrackerMenu(this.input, this.tracker, this.lang);
        lang.fillAll();
        menu.descriptionTracker();
        menu.fillAction();
        do {
            menu.show();
            menu.select(this.input.ask(menu.questionSelect(), menu.initRange()));
        } while (!menu.questionKey().equals(input.ask(menu.questionBoolean())));
    }

    /**
     * method main.
     *
     * @param args - String[]
     */
    public static void main(String[] args) {
        ConsoleInput input = new ValidateInput();
        Tracker tracker = new Tracker();
        new StartUI(input, tracker).init();
    }
}

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
    public StartUI(Input input) {
        this.input = input;
    }
    /**
     * method init() displays a menu.
     */
    public void init() {
        Tracker tracker = new Tracker();
        TrackerMenu menu;
        String selectMenu = input.ask("English menu - enter 1.\nРусское меню - введите 2\n:___");
        if (selectMenu.equals("1")) {
            menu = new TrackerMenuEnglish(input, tracker);
            menu.descriptionTracker();
            menu.fillAction();
            do {
                menu.show();
                int key = Integer.valueOf(input.ask("Select:__ "));
                menu.select(key);
            } while (!"exit".equals(input.ask("Continue? any symbol. Exit? 'exit':__ ")));
        }
        if (selectMenu.equals("2")) {
            menu = new TrackerMenuRuss(input, tracker);
            menu.descriptionTracker();
            menu.fillAction();
            do {
                menu.show();
                int key = Integer.valueOf(input.ask("Выбор:__ "));
                menu.select(key);
            } while (!"выход".equals(input.ask("Продолжить? любая клавиша. Выйти? 'выход':__ ")));
        }
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

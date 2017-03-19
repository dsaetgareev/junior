package ru.job4j.start;

/**
 * class StartUiTest - testing StartUI class.
 * @author Dinis Saetgareev (dinis0086@mail.ru)
 * @since 15.03.2017
 * @version 1.0
 */
public class StartUiTest {
    /**
     * method main.
     * @param args - String[]
     */
    public static void main(String[] args) {
        Tracker tracker = new Tracker();
        Input input = new StubInput(new String[] {"1", "0", " test1", "checking test1", "15032017", "method add",
                "a", "0", "test2", "checking test2", "170317", "method add", "a", "1", " ", "2", tracker.findAll()[0].getId(),
                "test3", "test3", "170317", "test3", " ", "3", tracker.findAll()[0].getId(), " ", "6", " ", "7",
                tracker.getDeleteItems()[0].getId(), " ", "4", tracker.findAll()[1].getId(), " ", "test3", " ",
                "8", tracker.findAll()[1].getId(), "new ", " ", "1", "exit"});
        new StartUI(input).init();
    }
}


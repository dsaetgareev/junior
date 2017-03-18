package ru.job4j.start;

/**
 * class StartUITest - testing StartUI class.
 * @author Dinis Saetgareev (dinis0086@mail.ru)
 * @since 15.03.2017
 * @version 1.0
 */
public class StartUITest {
    /**
     * method main.
     * @param args - String[]
     */
    public static void main(String[] args) {
        Input input = new StubInput(new String[] {"0", " test1", "checing test1", "15032017", "method add", " ", "1", "y"});
        new StartUI(input).init();
    }
}


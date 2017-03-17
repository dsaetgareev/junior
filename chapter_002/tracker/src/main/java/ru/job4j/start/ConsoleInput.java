package ru.job4j.start;

import java.util.Scanner;

/**
 * class ConsoleInput.
 * @author Dinis Saetgareev (dinis0086@mail.ru)
 * @since 13.03.2017
 * @version 1.0
 */
public class ConsoleInput implements Input {
    /**
     * scanner.
     */
    private Scanner scanner = new Scanner(System.in);

    /**
     * method ask(String question) asks the console question and print a answer.
     * @param question - menu question
     * @return - user answer.
     */
    public String ask(String question) {
        System.out.print(question);
        return scanner.nextLine();
    }
}

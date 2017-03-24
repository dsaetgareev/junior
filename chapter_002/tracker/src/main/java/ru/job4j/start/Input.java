package ru.job4j.start;

/**
 * interface Input.
 * @author Dinis Saetgareev (dinis0086@mail.ru)
 * @since 13.03.2017
 * @version 1.0
 */
public interface Input {
    /**
     * method String ask(String question) choice of the user for the given question.
     * @param question - String
     * @return select user
     */
    String ask(String question);

    /**
     * method int ask(String question, int[] range) return int ask.
     * @param question - String, user question
     * @param range - int[]
     * @return ask - int
     */
    int ask(String question, int[] range);
}

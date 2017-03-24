package ru.job4j.start;

/**
 * class StubInput - stub for StartUI.
 *
 * @author Dinis Saetgareev (dinis0086@mail.ru)
 * @version 1.0
 * @since 15.03.2017
 */
public class StubInput implements Input {
    /**
     * String answers - array answers.
     */
    private String[] answers;
    /**
     * int position - array position.
     */
    private int position = 0;

    /**
     * Constructor StubInput(String[] answer.
     *
     * @param answers - String array
     */
    public StubInput(String[] answers) {
        this.answers = answers;
    }

    /**
     * method ask(String question) asks the console question and print a answer.
     *
     * @param question - menu question
     * @return - user answer.
     */
    public String ask(String question) {
        System.out.println(question);
        System.out.println(answers[position]);
        return answers[position++];
    }

    /**
     * method int ask(String question, int[] range) return int ask.
     *
     * @param question - String, user question
     * @param range    - int[]
     * @return ask - int
     */
    public int ask(String question, int[] range) {
        int value = Integer.valueOf(ask(question));
            for (int key : range) {
                if (value == key) {
                    return key;
                }
            }
        return -1;
    }
}

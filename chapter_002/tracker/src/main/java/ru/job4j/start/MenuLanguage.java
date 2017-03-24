package ru.job4j.start;

/**
 * abstract class BaseAction implements UserAction.
 * @author Dinis Saetgareev (dinis0086@mail.ru)
 * @since 21.03.2017
 * @version 1.0
 */
public class MenuLanguage {
    /**
     * Input input.
     */
    private Input input;
    /**
     * Tracker tracker.
     */
    private Tracker tracker;
    /**
     * Language[] languages - array Language.
     */
    private Language[] languages = new Language[3];

    /**
     * Constructor MenuLanguage(Input input, Tracker tracker).
     * @param input - Input
     * @param tracker - Tracker
     */
    public MenuLanguage(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    /**
     * String question() - question for MenuLanguage.
     * @return question - String
     */
    public String question() {
        return "English menu - enter 0.\nРусское меню - введите 1.\n Add new language 2.\n:___";
    }
    /**
     * void fillLanguage() - fills this.languages.
     */
    public void fillLanguage() {
        this.languages[0] = new EnglishLanguage();
        this.languages[1] = new RussLanguage();
        this.languages[2] = new AnotherLanguage();
    }

    /**
     * Language selectLan(int key) - selects Language.
     * @param key - int
     * @return - this.languages
     */
    public Language selectLan(int key) {
        fillLanguage();
        return this.languages[key];
    }

    /**
     * int[] initRangeLan() - create range.
     * @return range - array
     */
    public int[] initRangeLan() {
        int[] range = new int[this.languages.length];
        for (int i = 0; i < this.languages.length; i++) {
            range[i] = i;
        }
        return range;
    }
}

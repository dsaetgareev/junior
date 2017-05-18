package ru.job4j.threads;

import java.util.StringTokenizer;

/**
 * class Tokenizer counts words and spaces.
 * @author Dinis Saetgareev (dinis0086@mail.ru)
 * @since 17.05.2017
 * @version 1.0
 */
public class Tokenizer {
    /**
     * string.
     */
    private String string;

    /**
     * constructor.
     * @param string - new string
     */
    public Tokenizer(String string) {
        this.string = string;
    }

    /**
     * counts words.
     * @return count
     */
    public int countWord() {

        int countWord = 0;

        StringTokenizer st = new StringTokenizer(string);

        while (st.hasMoreTokens()) {
            st.nextToken();
            countWord++;
        }
        return countWord;
    }

    /**
     * counts spaces.
     * @return count
     */
    public int countSpaces() {
        int countSpc = 0;
        for (int i = 0; i < this.string.length(); i++) {
            char s = this.string.charAt(i);
            if (s == ' ') {
                countSpc++;
            }
        }
        return countSpc;
    }

}

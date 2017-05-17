package ru.job4j.threads;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * tests methods of class Tokenizer.
 * @author Dinis Saetgareev (dinis0086@mail.ru)
 * @since 17.05.2017
 * @version 1.0
 */
public class TokenizerTest {
    /**
     * testing method countWord().
     */
    @Test
    public void whenStringThenCountWords() {
        Tokenizer token = new Tokenizer("Hello! How are you?");

        assertThat(token.countWord(), is(4));
    }

    /**
     * testing method countSpaces().
     */
    @Test
    public void whenStringThenCountSpaces() {
        Tokenizer token = new Tokenizer("Hello! How are you?");

        assertThat(token.countSpaces(), is(3));
    }

}
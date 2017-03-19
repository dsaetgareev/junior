package ru.job4j.start;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * class StartUiTest - testing StartUI class.
 * @author Dinis Saetgareev (dinis0086@mail.ru)
 * @since 15.03.2017
 * @version 1.0
 */
public class StartUITest {
    /**
     * void whenAddItemThenResult().
     */
    @Test
    public void whenAddItemThenResult() {
        Tracker tracker = new Tracker();
        Input input = new StubInput(new String[] {"1", "0", "test1", "test2", "123", "test1", "exit"});
        new StartUI(input).init();
        Item item = new Item(tracker.findAll()[0].getId(), "test1", "test2", 123, "test1");
        assertThat(tracker.findAll()[0], is(item));
    }
}

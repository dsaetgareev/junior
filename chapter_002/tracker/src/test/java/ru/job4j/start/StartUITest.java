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
        Input input = new StubInput(new String[] {"1", "0", "test1", "test2", "123", "test1", " ", "1", "exit"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findAll().length, is(1));
        Item item = new Item(tracker.findAll()[0].getId(), "test1", "test2", 123, "test1");
        assertThat(tracker.findAll()[0], is(item));
    }

    /**
     * void whenEditItemThenResult() - testing method update.
     */
    @Test
    public void whenEditItemThenResult() {
        Tracker tracker = new Tracker();
        tracker.add(new Item(null, "item", "item", 11032017, "item"));
        Input input = new StubInput(new String[] {"1", "2", tracker.findAll()[0].getId(),
                "test3", "test3", "170317", "test3", "exit"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findAll().length, is(1));
        Item item = new Item(tracker.findAll()[0].getId(), "test3", "test3", 170317, "test3");
        assertThat(tracker.findAll()[0], is(item));
    }

    /**
     * void whenDeleteItemThenResult() - testing method delete.
     */
    @Test
    public void whenDeleteItemThenResult() {
        Tracker tracker = new Tracker();
        tracker.add(new Item(null, "item", "item", 11032017, "item"));
        tracker.add(new Item(null, "test3", "test3", 170317, "test3"));
        Input input = new StubInput(new String[] {"1", "3", tracker.findAll()[0].getId(), "exit"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findAll().length, is(2));
        Item item = new Item(tracker.findAll()[0].getId(), "test3", "test3", 170317, "test3");
        assertThat(tracker.findAll()[0], is(item));
    }

    /**
     * void whenRestoreItemThenResult() - testing method Restore.
     */
    @Test
    public void whenRestoreItemThenResult() {
        Tracker tracker = new Tracker();
        tracker.add(new Item(null, "item", "item", 11032017, "item"));
        tracker.add(new Item(null, "test3", "test3", 170317, "test3"));
        Input input = new StubInput(new String[] {"1", "3", tracker.findAll()[0].getId(), " ", "1", " ", "6", "exit"});
        new StartUI(input, tracker).init();
        Input input1 = new StubInput(new String[] {"1", "7", tracker.findAllDeleteItems()[0].getId(), " ", "1", "exit"});
        new StartUI(input1, tracker).init();
        Item item = new Item(tracker.findAll()[1].getId(), "item", "item", 11032017, "item");
        assertThat(tracker.findAll()[1], is(item));

    }

    /**
     * void whenAddNewCommentThenResult() - testing method AddComment.
     */
    @Test
    public void whenAddNewCommentThenResult() {
        Tracker tracker = new Tracker();
        tracker.add(new Item(null, "item", "item", 11032017, "item"));
        Input input3 = new StubInput(new String[] {"1", "8", tracker.findAll()[0].getId(), "new comment", " ", "1", "exit"});
        new StartUI(input3, tracker).init();
        assertThat(tracker.findAll()[0].getComments(), is("new comment"));
    }
}

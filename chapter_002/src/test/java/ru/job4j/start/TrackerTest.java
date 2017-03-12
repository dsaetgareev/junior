package ru.job4j.start;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 * Class TrackerTest testing methods from class Tracker.
 * @author Dinis Saetgareev (dinis0086@mail.ru)
 * @since 11.03.2017
 * @version 1.0
 */
public class TrackerTest {
    /**
     * method whenAddItemThenArrayItem.
     */
    @Test
    public void whenAddItemThenArrayItem() {
        Tracker tracker = new Tracker();
        Item item = new Item(null, "item1", "item1", 11032017, "item1");
        Item[] afterItem = new Item[10];
        afterItem[0] = item;
        tracker.add(item);
        assertThat(tracker.getItems(), is(afterItem));
    }

    /**
     * method whenReplacesItemThenArrayItem() checking update(Item item).
     */
    public void whenReplacesItemThenArrayItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("123", "item", "item", 11032017, "item");
        Item item1 = new Item("124", "Item1", "item1...", 11032017, "item1");
        Item item2 = new Item("123", "item2", "item2...", 11032017, "item2");
        Item[] items = new Item[10];
        items[0] = item;
        items[1] = item1;
        Item[] afterItems = new Item[10];
        afterItems[0] = item2;
        afterItems[1] = item1;
        tracker.setItems(items);
        tracker.update(item2);
        assertThat(tracker.getItems(), is(afterItems));
    }
}

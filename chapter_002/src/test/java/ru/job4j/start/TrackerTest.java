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
    @Test
    public void whenReplacesItemThenArrayItem() {
        Tracker tracker = new Tracker();
        Item item = new Item(null, "item", "item", 11032017, "item");
        Item item1 = new Item(null, "Item1", "item1...", 11032017, "item1");
        Item item2 = new Item(null, "item2", "item2...", 11032017, "item2");
        tracker.add(item);
        tracker.add(item1);
        Item[] afterItems = new Item[10];
        afterItems[0] = item2;
        afterItems[1] = item1;
        item2.setId(tracker.getItems()[0].getId());
        tracker.update(item2);
        assertThat(tracker.getItems(), is(afterItems));
    }
    /**
     * method whenDeleteItemThenArrayItem() checking delete(Item item).
     */
    @Test
    public void whenDeleteItemThenArrayItem() {
        Tracker tracker = new Tracker();
        Item item = new Item(null, "item", "item", 11032017, "item");
        Item item1 = new Item(null, "Item1", "item1...", 11032017, "item1");
        tracker.add(item);
        tracker.add(item1);
        Item[] afterItems = new Item[10];
        afterItems[0] = null;
        afterItems[1] = item1;
        tracker.delete(item);
        assertThat(tracker.getItems(), is(afterItems));
    }
    /**
     * method whenFindAllItemThenArrayItem() checking findAll().
     */
    @Test
    public void whenFindAllItemThenArrayItem() {
        Tracker tracker = new Tracker();
        Item item = new Item(null, "item", "item", 11032017, "item");
        Item item1 = new Item(null, "Item1", "item1...", 11032017, "item1");
        tracker.add(item);
        tracker.add(item1);
        Item[] afterItems = new Item[2];
        afterItems[0] = item;
        afterItems[1] = item1;
        assertThat(tracker.findAll(), is(afterItems));
    }

    /**
     * whenFindByIdItemThenArrayItem().
     */
    @Test
    public void whenFindByIdItemThenArrayItem() {
        Tracker tracker = new Tracker();
        Item item = new Item(null, "item", "item", 11032017, "item");
        Item item1 = new Item(null, "Item1", "item1...", 11032017, "item1");
        tracker.add(item);
        tracker.add(item1);
        assertThat(tracker.findById(tracker.getItems()[1].getId()), is(item1));
    }
    /**
     * whenFindByNameThenArrayItem().
     */
    @Test
    public void whenFindByNameThenArrayItem() {
        Tracker tracker = new Tracker();
        Item item = new Item(null, "item", "item", 11032017, "item");
        Item item1 = new Item(null, "Item1", "item1...", 11032017, "item1");
        tracker.add(item);
        tracker.add(item1);
        Item[] afterItem = {item1};
        assertThat(tracker.findByName(tracker.getItems()[1].getName()), is(afterItem));
    }
}

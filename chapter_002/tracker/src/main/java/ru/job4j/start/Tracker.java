package ru.job4j.start;

import java.util.Arrays;
import java.util.Random;

/**
 * Class Tracker - wrapper over class Item.
 * @author Dinis Saetgareev (dinis0086@mail.ru)
 * @since 11.03.2017
 * @version 1.0
 */
public class Tracker {
    /**
     * array Item[] items.
     */
    private Item[] items = new Item[10];
    /**
     * array Item[] deleteItems.
     */
    private Item[] deleteItems = new Item[10];
    /**
     * int position.
     */
    private int position = 0;
    /**
     * int deletePosition - counter for Item[] deleteItem.
     */
    private int deletePosition = 0;
    /**
     * rn - random value.
     */
    private Random rn = new Random();

    /**
     * Item add(Item item) add new item.
     * @param item - Item.
     * @return item - Item.
     */
    public Item add(Item item) {
        item.setId(String.valueOf(rn.nextInt(1000)));
        this.items[position++] = item;
        return item;
    }

    /**
     * method getItems().
     * @return items - Item[]
     */
    public Item[] getItems() {
        return this.items;
    }

    /**
     * method getDeleteItems().
     * @return items - Item[]
     */
    public Item[] getDeleteItems() {
        return this.deleteItems;
    }

    /**
     * method update(Item item) replaces item.
     * @param item - Item
     */
    public void update(Item item) {
        for (int i = 0; i != position; i++) {
            if (this.items[i] != null && item.getId().equals(this.items[i].getId())) {
                this.items[i] = item;
                break;
            }
        }
    }

    /**
     * method delete(Item item) remove item.
     * @param item - Item
     */
    public void delete(Item item) {
        for (int i = 0; i != position; i++) {
            if (this.items[i] != null && item.getId().equals(this.items[i].getId())) {
                Item tempItem = this.items[i];
                this.items[i] = null;
                this.deleteItems[deletePosition++] = tempItem;
                break;
            }
        }
    }

    /**
     * method Item[] findAll() return Item[].
     * @return this.items
     */
    public Item[] findAll() {
        Item[] result = new Item[position];
        int count = 0;
        for (int i = 0; i != position; i++) {
            if (this.items[i] != null) {
                result[count] = this.items[i];
                count++;
            }
        }
        return result;
    }

    /**
     * method Item[] findAllDeleteItems() return Item[].
     * @return this.deleteItems - Item[]
     */
    public Item[] findAllDeleteItems() {
        Item[] result = new Item[deletePosition];
        int count = 0;
        for (int i = 0; i != deletePosition; i++) {
            if (this.deleteItems[i] != null) {
                result[count] = this.deleteItems[i];
                count++;
            }
        }
        return result;
    }
    /**
     * method restoreById(String id) restore item.
     * @param id - String
     */
    public void restoreById(String id) {
        for (int i = 0; i != deletePosition; i++) {
            if (this.deleteItems[i] != null && id.equals(this.deleteItems[i].getId())) {
                Item tempItem = this.deleteItems[i];
                this.deleteItems[i] = null;
                this.items[position++] = tempItem;
                break;
            }
        }
    }

    /**
     * method findById(String id) return item that contains id.
     * @param id - String id
     * @return item.
     */
    public Item findById(String id) {
        Item result = null;
        for (Item item : items) {
            if (item != null && item.getId().equals(id)) {
                result = item;
            }
        }
        return result;
    }

    /**
     * method findByName(String key) return Item[] that contains key.
     * @param key - String
     * @return array.
     */
    public Item[] findByName(String key) {
        Item[] result = new Item[position];
        int count = 0;
        for (int i = 0; i != position; i++) {
            if (this.items[i] != null && (this.items[i].getName().contains(key) || this.items[i].getDesc().contains(key)
                    || this.items[i].getComments().contains(key))) {
                result[count] = this.items[i];
                count++;
            }
        }
        return Arrays.copyOf(result, count);
    }

    /**
     * method comment(String comments, String id) - finds item by id and add comment.
     * @param comments - String comment
     * @param id - String
     */
    public void comment(String comments, String id) {
        for (int i = 0; i != position; i++) {
            if (items[i] != null && id.equals(items[i].getId())) {
                items[i].setComments(comments);
            }
        }
    }
}
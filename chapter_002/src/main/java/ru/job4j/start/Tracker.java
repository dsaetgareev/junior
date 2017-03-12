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
     * int position.
     */
    private int position = 0;
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
        item.setId(String.valueOf(System.currentTimeMillis() + rn.nextInt()));
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
     * method setItems(Item[] items).
     * @param items - Item[].
     */
    public void setItems(Item[] items) {
        this.items = items;
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
            if (this.items[i] != null && this.items[i].getId().equals(item.getId())) {
                this.items[i] = null;
                position--;
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
}
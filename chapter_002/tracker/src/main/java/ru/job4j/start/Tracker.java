package ru.job4j.start;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

/**
 * Class Tracker - wrapper over class Item.
 * @author Dinis Saetgareev (dinis0086@mail.ru)
 * @since 11.03.2017
 * @version 1.0
 */
public class Tracker {
    /**
     * array List<Item> items.
     */
    private List<Item> items = new ArrayList<>();
    /**
     * array List<Item> deleteItems.
     */
    private List<Item> deleteItems = new ArrayList<>();
    /**
     * int position.
     */
    private int position = 0;
    /**
     * int deletePosition - counter for List<Item> deleteItems.
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
        this.items.add(item);
        position++;
        return item;
    }

    /**
     * method getItems().
     * @return items - Item[]
     */
    public List<Item> getItems() {
        return this.items;
    }

    /**
     * method getDeleteItems().
     * @return items - List<Item>
     */
    public List<Item> getDeleteItems() {
        return this.deleteItems;
    }

    /**
     * method update(Item item) replaces item.
     * @param item - Item
     */
    public void update(Item item) {
        for (int i = 0; i != position; i++) {
            if (this.items.get(i) != null && item.getId().equals(this.items.get(i).getId())) {
                this.items.set(i, item);
                break;
            }
        }
    }

    /**
     * method delete(Item item) remove item.
     * @param item - Item
     */
    public void delete(Item item) {
        Iterator<Item> iterator = this.items.iterator();
        for (int i = 0; i != position && iterator.hasNext(); i++) {
            iterator.next();
            if (this.items.get(i) != null && item.getId().equals(this.items.get(i).getId())) {
                Item tempItem = this.items.get(i);
                iterator.remove();
                this.deleteItems.add(tempItem);
                position--;
                deletePosition++;
                break;
            }
        }
    }

    /**
     * method List<Item> findAll() return Item[].
     * @return this.items
     */
    public List<Item> findAll() {
        ArrayList<Item> result = new ArrayList<>();
        for (int i = 0; i != position; i++) {
            if (this.items.get(i) != null) {
                result.add(this.items.get(i));
            }
        }
        result.trimToSize();
        return result;
    }

    /**
     * method List<Item> findAllDeleteItems() return Item[].
     * @return this.deleteItems - Item[]
     */
    public List<Item> findAllDeleteItems() {
        ArrayList<Item> result = new ArrayList<>();
        for (int i = 0; i != deletePosition; i++) {
            if (this.deleteItems.get(i) != null) {
                result.add(this.deleteItems.get(i));
            }
        }
        result.trimToSize();
        return result;
    }
    /**
     * method restoreById(String id) restore item.
     * @param id - String
     */
    public void restoreById(String id) {
        Iterator<Item> iterator = deleteItems.iterator();
        for (int i = 0; i != deletePosition && iterator.hasNext(); i++) {
            iterator.next();
            if (this.deleteItems.get(i) != null && id.equals(this.deleteItems.get(i).getId())) {
                Item tempItem = this.deleteItems.get(i);
                iterator.remove();
                this.items.add(tempItem);
                position++;
                deletePosition--;
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
     * method findByName(String key) return List<Item> that contains key.
     * @param key - String
     * @return array.
     */
    public List<Item> findByName(String key) {
        ArrayList<Item> result = new ArrayList<>();
        for (int i = 0; i != position; i++) {
            if (this.items.get(i) != null && (this.items.get(i).getName().contains(key) || this.items.get(i).getDesc().contains(key)
                    || this.items.get(i).getComments().contains(key))) {
                result.add(this.items.get(i));
            }
        }
        result.trimToSize();
        return result;
    }

    /**
     * method comment(String comments, String id) - finds item by id and add comment.
     * @param comments - String comment
     * @param id - String
     */
    public void comment(String comments, String id) {
        for (int i = 0; i != position; i++) {
            if (this.items.get(i) != null && id.equals(this.items.get(i).getId())) {
                this.items.get(i).setComments(comments);
            }
        }
    }
}
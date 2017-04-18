package ru.job4j.store;

import ru.job4j.generic.SimpleArray;

import java.util.Iterator;
import java.util.Random;

/**
 * class ImplementsStore<T extends Base>.
 * @author Dinis Saetgareev (dinis0086@mail.ru)
 * @version 1.0
 * @since 18.04.2017
 * @param <T> - extends Base.
 */
public class ImplementsStore<T extends Base> implements Store<T> {

    /**
     * database for T.
     */
    private SimpleArray<T> database = new SimpleArray<>(10);
    /**
     * rn - random value.
     */
    private Random rn = new Random();

    /**
     * constructor.
     */
    public ImplementsStore() {

    }

    /**
     * adds new t.
     * @param t - new t
     */
    public void add(T t) {
        t.setId(String.valueOf(rn.nextInt(1000)));
        this.database.add(t);
    }

    /**
     * edit a t.
     * @param t - t of which is update
     */
    public void edit(T t) {
        for (int i = 0; i < this.database.size(); i++) {
            if (this.database.get(i) != null && this.database.get(i).getId().equals(t.getId())) {
                this.database.update(i, t);
            }
        }
    }

    /**
     * remove a t.
     * @param t - remove of which is remove
     */
    public void remove(T t) {
        for (int i = 0; i < this.database.size(); i++) {
            if (this.database.get(i) != null && this.database.get(i).getId().equals(t.getId())) {
                this.database.delete(t);
            }
        }
    }
    /**
     * return all element database.
     * @return all element
     */
    public SimpleArray<T> findAll() {
        SimpleArray<T> result = new SimpleArray<>(this.database.size());
        Iterator<T> iterator = this.database.iteratorSimple();
        while (iterator.hasNext()) {
            result.add(iterator.next());
        }
        return result;
    }
}

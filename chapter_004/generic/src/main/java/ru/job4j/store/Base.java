package ru.job4j.store;

/**
 * abstract class Base.
 * @author Dinis Saetgareev (dinis0086@mail.ru)
 * @version 1.0
 * @since 13.04.2017
 */
public abstract class Base {
    /**
     * id.
     */
    private String id;

    /**
     * constructor.
     * @param id - new id
     */
    public Base(String id) {
        this.id = id;
    }
    /**
     * get id.
     * @return id
     */
    String getId() {
        return id;
    }

    /**
     * set id.
     * @param id - new id
     */
    void setId(String id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Base base = (Base) o;

        return id != null ? id.equals(base.id) : base.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}

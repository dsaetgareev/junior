package ru.job4j.store;

/**
 * class Role extends Base.
 * @author Dinis Saetgareev (dinis0086@mail.ru)
 * @version 1.0
 * @since 13.04.2017
 */
public class Role extends Base {
    /**
     * constructor.
     * @param id - new id
     */
    public Role(String id) {
        super(id);
    }

    /**
     * get id.
     * @return id
     */
    @Override
    public String getId() {
        return super.getId();
    }

    /**
     * set id.
     * @param id - new id
     */
    @Override
    public void setId(String id) {
        super.setId(id);
    }
}

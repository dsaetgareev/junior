package ru.job4j.start;

/**
 * Class Item.
 * @author Dinis Saetgareev (dinis0086@mail.ru)
 * @since 11.03.2017
 * @version 1.0
 */
public class Item {
    /**
     * String id - item.
     */
    private String id;
    /**
     * String name - name item.
     */
    private String name;
    /**
     * String desc - description item.
     */
    private String desc;
    /**
     * long create.
     */
    private long create;
    /**
     * String comments - comments item.
     */
    private String comments;

    /**
     * Constructor Item.
     * @param id - String
     * @param name - String
     * @param desc - String
     * @param create - long
     * @param comments - String
     */
    public Item(String id, String name, String desc, long create, String comments) {
        this.id = id;
        this.name = name;
        this.desc = desc;
        this.create = create;
        this.comments = comments;
    }

    /**
     * method getId().
     * @return id - this.id
     */
    public String getId() {
        return this.id;
    }

    /**
     * method setId(String id).
     * @param id - String
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * method getName().
     * @return name - name item
     */
    public String getName() {
        return this.name;
    }

    /**
     * method setName(String name).
     * @param name - String
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * method getDesc().
     * @return desc - desc item
     */
    public String getDesc() {
        return this.desc;
    }

    /**
     * method setDesc(String desc).
     * @param desc - String
     */
    public void setDesc(String desc) {
        this.desc = desc;
    }

    /**
     * method getCreate().
     * @return create - long
     */
    public long getCreate() {
        return this.create;
    }

    /**
     * method setCreate(long create).
     * @param create - long
     */
    public void setCreate(long create) {
        this.create = create;
    }

    /**
     * method getComments.
     * @return comments - String
     */
    public String getComments() {
        return this.comments;
    }

    /**
     * method setComments(String comments).
     * @param comments - String
     */
    public void setComments(String comments) {
        this.comments = comments;
    }

    /**
     * Override hashCode().
     * @return result - int
     */
    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (desc != null ? desc.hashCode() : 0);
        result = 31 * result + (int) (create ^ (create >>> 32));
        result = 31 * result + (comments != null ? comments.hashCode() : 0);
        return result;
    }

    /**
     * boolean equals(Object obj).
     * @param item - Item
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Item other = (Item) obj;
        if (id != other.id) {
            return false;
        }
        if (name != other.name) {
            return false;
        }
        if (desc != other.desc) {
            return false;
        }
        if (create != other.create) {
            return false;
        }
        if (comments != other.comments) {
            return false;
        }
        return true;
    }
}

package ru.job4j.start;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Create by dinis of 04.09.17.
 */
public class Comment {
    /**
     * logger.
     */
    private static final Logger Log = LoggerFactory.getLogger(Comment.class);
    /**
     * int id.
     */
    private int id;
    /**
     * item_id.
     */
    private int item_id;
    /**
     * comment.
     */
    private String comments;

    /**
     * constructor.
     * @param id - id
     * @param item_id - item_id
     * @param comments - comment
     */
    public Comment(int id, int item_id, String comments) {
        this.id = id;
        this.item_id = item_id;
        this.comments = comments;
    }

    /**
     * gets id.
     * @return id - int
     */
    public int getId() {
        return id;
    }

    /**
     * gets item_id
     * @return item_id - int
     */
    public int getItem_id() {
        return item_id;
    }

    /**
     * comment.
     * @return comment - String.
     */
    public String getComments() {
        return comments;
    }
}

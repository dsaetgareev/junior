package ru.job4j.start;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * Create by dinis of 17.08.17.
 */
public class Tracker {
    /**
     * logger for database.
     */
    private static final Logger Log = LoggerFactory.getLogger(Tracker.class);
    /**
     * properties for database.
     */
    private Properties prs = new Properties();
    /**
     * connection.
     */
    private Connection conn = null;
    /**
     * properties file name.
     */
    private final String properties = "db.properties";

    /**
     * loads properties.
     */
    public void loadsProperties() {
        try (InputStream in = getClass().getClassLoader().getResourceAsStream(properties)) {
            this.prs.load(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * connection to database.
     */
    public void connectionToDb() {
        try {
            this.conn = DriverManager.getConnection(this.prs.getProperty("url"), this.prs.getProperty("user"),
                    this.prs.getProperty("password"));
        } catch (SQLException e) {
            Log.error(e.getMessage(), e);
        }
        this.checkDbTables();
    }

    /**
     * check for tables.
     */
    public void checkDbTables() {
        try (Statement st = conn.createStatement()) {
            st.execute("CREATE TABLE IF NOT EXISTS items (item_id SERIAL PRIMARY KEY, name VARCHAR(100)," +
                    "description TEXT, create_date TIMESTAMP)");
            st.execute("CREATE TABLE IF NOT EXISTS comments (comment_id SERIAL PRIMARY KEY, comment TEXT," +
                    "item_id INTEGER REFERENCES items(item_id))");
            st.execute("CREATE TABLE IF NOT EXISTS delitem (item_id INTEGER, name VARCHAR(100)," +
                "description TEXT, create_date TIMESTAMP)");
        } catch (SQLException e) {
            Log.error(e.getMessage(), e);
        }
    }

    /**
     * disconnect.
     */
    public void disconnect() {
        try {
            this.conn.close();
        } catch (SQLException e) {
            Log.error(e.getMessage(), e);
        } finally {

                if (this.conn != null) {
                    try {
                        this.conn.close();
                    } catch (SQLException e) {
                        Log.error(e.getMessage(), e);
                    }
                }
        }
    }

    /**
     * adds new item.
     * @param item - new item
     */
    public void add(Item item) {
        try {
            PreparedStatement ps = this.conn.prepareStatement("INSERT INTO items(name, description," +
                    "create_date) VALUES (?, ?, ?)");
            ps.setString(1, item.getName());
            ps.setString(2, item.getDesc());
            ps.setTimestamp(3, new Timestamp(item.getCreate()));
            ps.executeUpdate();
            ps = this.conn.prepareStatement("SELECT MAX(item_id) FROM tracker.public.items");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("max");
                item.setId(id);
            }
        } catch (SQLException e) {
            Log.error(e.getMessage(), e);
        }
    }

    /**
     * edits item.
     * @param item - item
     */
    public void update(Item item) {
        try (PreparedStatement ps = this.conn.prepareStatement("UPDATE items SET name = ?," +
                "description = ?, create_date = ? WHERE item_id = ?")) {

            ps.setString(1, item.getName());
            ps.setString(2, item.getDesc());
            ps.setTimestamp(3, new Timestamp(item.getCreate()));
            ps.setInt(4, item.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            Log.error(e.getMessage(), e);
        }
    }

    /**
     * deletes item.
     * @param id - int
     */
    public void delete(int id) {
        Item item = this.findById(id);
        try ( PreparedStatement ps = this.conn.prepareStatement("INSERT INTO delitems(item_id, name," +
                "description, create_date) VALUES (?, ?, ?, ?)")) {
            ps.setInt(1, item.getId());
            ps.setString(2, item.getName());
            ps.setString(3, item.getDesc());
            ps.setTimestamp(4, new Timestamp(item.getCreate()));
            ps.executeUpdate();
        } catch (SQLException e) {
            Log.error(e.getMessage(), e);
        }
        try (PreparedStatement ps = this.conn.prepareStatement("DELETE FROM items WHERE item_id = ?")) {
            ps.setInt(1, item.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            Log.error(e.getMessage(), e);
        }

    }

    /**
     * finds item by id.
     * @param id - id for item
     * @return - item
     */
    public Item findById(int id) {
        Item result = null;
        try (PreparedStatement ps = this.conn.prepareStatement("SELECT * FROM items WHERE item_id = ?")) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    result = new Item(rs.getString("name"), rs.getString("description"),
                    rs.getTimestamp("create_date").getTime());
                }
                result.setId(id);
            } catch (SQLException e) {
                Log.error(e.getMessage(), e);
            }
        } catch (SQLException e) {
            Log.error(e.getMessage(), e);
        }
        return result;
    }

    /**
     * finds all items.
     * @return - List items
     */
    public List<Item> findAll() {
        List<Item> result = new ArrayList<>();

        try (PreparedStatement ps = this.conn.prepareStatement("SELECT * FROM items")) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Item item = new Item(rs.getString("name"),
                        rs.getString("description"), rs.getTimestamp("create_date").getTime());
                item.setId(rs.getInt("item_id"));
                result.add(item);
            }
        } catch (SQLException e) {
            Log.error(e.getMessage(), e);
        }
        return result;
    }

    /**
     * finds all deleted items.
     * @return - List items
     */
    public List<Item> findAllDeleteItems() {
        List<Item> result = new ArrayList<>();
        try (PreparedStatement ps = this.conn.prepareStatement("SELECT * FROM delitems")) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Item item = new Item(rs.getString("name"),
                        rs.getString("description"), rs.getTimestamp("create_date").getTime());
                item.setId(rs.getInt("item_id"));
                result.add(item);
            }

        } catch (SQLException e) {
            Log.error(e.getMessage(), e);
        }
        return result;
    }

    /**
     * restores by id.
     * @param id - item's id
     */
    public void restoreById(int id) {
        Item item = null;
        try (PreparedStatement ps = this.conn.prepareStatement("SELECT * FROM delitems WHERE item_id = ?")) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                item = new Item(rs.getString("name"), rs.getString("description"),
                        rs.getTimestamp("create_date").getTime());
            }
            PreparedStatement st = this.conn.prepareStatement("INSERT INTO items(name, description,create_date)" +
                    "VALUES (?, ?, ?)");
            st.setString(1, item.getName());
            st.setString(2, item.getDesc());
            st.setTimestamp(3, new Timestamp(item.getCreate()));
            st.executeUpdate();
            st = this.conn.prepareStatement("DELETE FROM delitems WHERE item_id = ?");
            st.setInt(1, id);
            st.executeUpdate();
        } catch (SQLException e) {
            Log.error(e.getMessage(), e);
        }
    }

    /**
     * finds by key.
     * @param key - key
     * @return - List items
     */
    public List<Item> findByName(String key) {
        List<Item> result = new ArrayList<>();
        try (PreparedStatement ps = this.conn.prepareStatement("SELECT * FROM items WHERE name LIKE '%" + key + "%'" +
                "OR description LIKE '%" + key + "%'")) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Item item = new Item(rs.getString("name"),
                        rs.getString("description"), rs.getTimestamp("create_date").getTime());
                item.setId(rs.getInt("item_id"));
                result.add(item);
            }

        } catch (SQLException e) {
            Log.error(e.getMessage(), e);
        }
        return result;
    }

    /**
     * adds new comment.
     * @param id - id item
     * @param comment - new comment
     */
    public void addComment(int id, String comment) {
        try (PreparedStatement ps = this.conn.prepareStatement("INSERT INTO comments(comment, item_id) VALUES (?, ?)")) {
            ps.setString(1, comment);
            ps.setInt(2, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            Log.error(e.getMessage(), e);
        }
    }

    /**
     * gets comments.
     * @param id - item's id
     * @return result - List comments
     */
    public List<Comment> getComment(int id) {
        List<Comment> result = new ArrayList<>();
        try (PreparedStatement ps = this.conn.prepareStatement("SELECT * FROM comments WHERE item_id = ?")) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Comment comment = new Comment(rs.getInt("comment_id"), rs.getInt("item_id"),
                        rs.getString("comment"));
                result.add(comment);
            }
        } catch (SQLException e) {
            Log.error(e.getMessage(), e);
        }
        return result;
    }
}

package ru.job4j.jsoup;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

/**
 * Create by dinis of 19.09.17.
 */
public class DBManager {
    /**
     * logger.
     */
    private static final Logger Log = LoggerFactory.getLogger(DBManager.class);
    /**
     * connection.
     */
    private Connection conn = null;
    /**
     * properties for data base.
     */
    private Properties prop = new Properties();
    /**
     *properties file name.
     */
    private final String properties = "db.properties";

    /**
     * load properties.
     */
    public void loadProp() {
        try (InputStream in = getClass().getClassLoader().getResourceAsStream(this.properties)) {
            this.prop.load(in);
        } catch (IOException e) {
            Log.error(e.getMessage(), e);
        }
    }

    /**
     * connection to data base.
     */
    public void connectionDB() {
        try {
            this.conn = DriverManager.getConnection(this.prop.getProperty("url"), this.prop.getProperty("user"),
                    this.prop.getProperty("password"));
        } catch (SQLException e) {
            Log.error(e.getMessage(), e);
        }
    }

    /**
     * disconnect database.
     */
    public void disconnectDB() {
        try {
            this.conn.close();
        } catch (SQLException e) {
            Log.error(e.getMessage(), e);
        } finally {
            try {
                if (this.conn != null) {
                    this.conn.close();
                }
            } catch (SQLException e) {
                Log.error(e.getMessage(), e);
            }
        }
    }

    /**
     * adds new offer.
     * @param offer_id - id for offer
     * @param link - link for offer
     * @param description - description for offer
     * @param lastUpdate - last update
     */
    public void add(int offer_id, String link, String description, Timestamp lastUpdate) {
        try (PreparedStatement ps = this.conn.prepareStatement("INSERT INTO offers(offer_id, link, description, last_update)" +
                "VALUES (?, ?, ?, ?)")) {
            ps.setInt(1, offer_id);
            ps.setString(2, link);
            ps.setString(3, description);
            ps.setTimestamp(4, lastUpdate);
            ps.executeUpdate();
        } catch (SQLException e) {
            Log.error(e.getMessage(), e);
        }
    }

    /**
     * show offers.
     */
    public void show() {
        try (PreparedStatement ps = this.conn.prepareStatement("SELECT * FROM offers")) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Log.info(String.format("id: %s, link: %s, desc: %s, lastUpdate: %s",
                        rs.getInt("offer_id"), rs.getString("link"),
                        rs.getString("description"), rs.getTimestamp("last_update")));
            }
        } catch (SQLException e) {
            Log.error(e.getMessage(), e);
        }
    }
}

package ru.job4j.storage;



import java.sql.*;


/**
 * Create by dinis of 13.08.17.
 */
public class SqlStorage {

    //private static final Logger Log = LoggerFactory.getLogger(SqlStorage.class);

    public static void main(String[] args) {

        String url = "jdbc:postgresql://localhost:5432/job4j";
        String username = "postgres";
        String password = "NZdr4fo";

        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, username, password);
//            PreparedStatement st = conn.prepareStatement("INSERT INTO users(login, password, create_date)" +
//                    "VALUES(?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
//            st.setString(1, "new user2");
//            st.setString(2, "password2");
//            st.setTimestamp(3, new Timestamp(System.currentTimeMillis()));
//            st.executeUpdate();
//
//            ResultSet genKeys = st.getGeneratedKeys();
//            while (genKeys.next()) {
//                System.out.println(genKeys.getInt(1));
//            }
            PreparedStatement st = conn.prepareStatement("SELECT * FROM users");
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                System.out.println(String.format("%s [%s] %s",
                        rs.getString("login"),rs.getString("password"), rs.getTimestamp("create_date")));
            }
            rs.close();
            st.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

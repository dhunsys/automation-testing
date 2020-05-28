package db;

import org.apache.log4j.Logger;

import java.sql.*;
import java.util.List;
import java.util.Map;

public class SqliteHelper {

    public List<Map<String, Object>> getTestData(String table) {
        Connection conn = null;
        ResultSet rs = null;
        PreparedStatement st = null;
        QueryResultConverter queryResultConverter = null;
        try {
            conn = getSqliteConnect();
            st = conn.prepareStatement("Select * from " + table);
            rs = st.executeQuery();
            queryResultConverter = new QueryResultConverter(rs);

        } catch (SQLException e) {

        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(SqliteHelper.class.getName()).log(null, ex);
                }
            }
            if (st != null) {
                try {
                    st.close();
                } catch (SQLException ex) {
                    Logger.getLogger(SqliteHelper.class.getName()).log(null, ex);
                }
            }

            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(SqliteHelper.class.getName()).log(null, ex);
                }
            }

        }
        return queryResultConverter.getResultSet();

    }

    private static Connection getSqliteConnect() {
        Connection conn = null;
        try {
            // db parameters
            String url = "jdbc:sqlite:" + System.getProperty("user.dir") + "/db/sqlitedb.sqlite3";
            // create a connection to the database
            if (conn == null) {
                conn = DriverManager.getConnection(url);
            }

        } catch (SQLException e) {

        }
        return conn;
    }
}

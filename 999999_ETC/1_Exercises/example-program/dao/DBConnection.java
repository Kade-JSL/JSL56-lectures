package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBConnection {

    // 싱글톤 패턴으로 만들자
    private static DBConnection instance = new DBConnection();
    private DBConnection() {}
    public static DBConnection getInstance() { return instance; }


    public Connection getConnection() {
        Connection conn = null;

        String url = "jdbc:oracle:thin:@localhost:1521:xe"; // 외우자.
        String id = "bankdba";
        String pw = "bank1234";

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver"); // 이건 좀 외울 만 하다.
            conn = DriverManager.getConnection(url, id, pw);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return conn;
    }

    public static void close(Connection conn, PreparedStatement pstmt) {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (pstmt != null) {
            try {
                pstmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void close(Connection conn, PreparedStatement pstmt, ResultSet rs) {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (pstmt != null) {
            try {
                pstmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}

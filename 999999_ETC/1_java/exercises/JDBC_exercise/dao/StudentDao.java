package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import dto.Student;

public class StudentDao {
    private static StudentDao studentDao = new StudentDao();
    private StudentDao() {}
    public static StudentDao getDao() { return studentDao; }

    public void insert(Student stu) {
        Connection conn = null;
        PreparedStatement pstmt = null;

        String query =
            "INSERT INTO JDBCEXERCISE (" +
                "NUM, NAME, ADDRESS, TEL, KOR, ENG, MAT, TOT, AVG, RESULT" +
            ") VALUES (" +
                "?, ?, ?, ?, ?, ?, ?, ?, ?, ?" +
            ")";
        
        conn = DBConnection.getInstance().getConnection();

        try {
            pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, stu.getNum());
            pstmt.setString(2, stu.getName());
            pstmt.setString(3, stu.getAddress());
            pstmt.setString(4, stu.getTel());
            pstmt.setInt(5, stu.getKor());
            pstmt.setInt(6, stu.getEng());
            pstmt.setInt(7, stu.getMat());
            pstmt.setInt(8, stu.getTot());
            pstmt.setDouble(9, stu.getAvg());
            pstmt.setString(10, stu.getResult());

            int result = pstmt.executeUpdate();
            if (result > 0) System.out.println("등록이 성공적으로 완료되었습니다.");
            else System.out.println("데이터베이스 오류.");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnection.close(conn, pstmt);
        }
    }

    public static int getMaxNum() {
        int max = 0;
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        conn = DBConnection.getInstance().getConnection();

        String query = "SELECT MAX(NUM) AS MNUM FROM JDBCEXERCISE";

        try {
            pstmt = conn.prepareStatement(query);
            rs = pstmt.executeQuery();
            if (rs.next()) max = rs.getInt("MNUM");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnection.close(conn, pstmt, rs);
        }

        return max;
    }
}

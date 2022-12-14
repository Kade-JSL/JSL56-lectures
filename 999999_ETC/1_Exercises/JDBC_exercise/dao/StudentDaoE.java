package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dto.StudentDto;

public class StudentDaoE {
    private static StudentDaoE studentDao = new StudentDaoE();
    private StudentDaoE() {}
    public static StudentDaoE getDao() { return studentDao; }

    public void insert(StudentDto stu) {
        Connection conn = null;
        PreparedStatement pstmt = null;

        String query =
            "INSERT INTO JDBCEXERCISE (" +
                "NUM, NAME, ADDRESS, TEL, KOR, ENG, MAT, TOT, AVG, RESULT" +
            ") VALUES (" +
                "?, ?, ?, ?, ?, ?, ?, ?, ?, ?" +
            ")";
        
        conn = DBConnectionE.getInstance().getConnection();

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
            DBConnectionE.close(conn, pstmt);
        }
    }

    public static int getMaxNum() {
        int max = 0;
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        conn = DBConnectionE.getInstance().getConnection();

        String query = "SELECT MAX(NUM) AS MNUM FROM JDBCEXERCISE";

        try {
            pstmt = conn.prepareStatement(query);
            rs = pstmt.executeQuery();
            if (rs.next()) max = rs.getInt("MNUM");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnectionE.close(conn, pstmt, rs);
        }

        return max;
    }
}

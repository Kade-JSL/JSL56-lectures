package dao;

import dto.Student;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import DBManager.DBConnection;

public class StudentJdbcDao { // DB와 연동해서 입력(C), 검색(R), 수정(U), 삭제(D)를 함

    /* 싱글톤 객체 */
    private static StudentJdbcDao studentJdbcDao = new StudentJdbcDao();

    private StudentJdbcDao() {};

    public static StudentJdbcDao getDao() {
        return studentJdbcDao;
    }

    Scanner sc = new Scanner(System.in); // 시스템 입력 스트림을 통해 데이터를 입력받기 위한 스캐너

    /* 맨 끝 학번을 돌려주는 메서드 */
    public int numAdd() {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        conn = DBConnection.getInstance().getConnection();

        String query = "SELECT MAX(NUM) AS BNO FROM STUDENT";

        int max = 0;
        try {
            pstmt = conn.prepareStatement(query);
            rs = pstmt.executeQuery(); // SELECT 문을 실행 후 ResultSet 객체에 담음
            if (rs.next())
                max = rs.getInt("BNO"); // 검색한 결과가 없으면 레코드 포인트를 이동
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnection.close(conn, pstmt, rs);
        }

        return max;
    }

    /* 입력화면 */
    public void insert(Student stu) {
        Connection conn = null;
        PreparedStatement pstmt = null;

        conn = DBConnection.getInstance().getConnection();

        String query =
                "INSERT INTO STUDENT (NUM, NAME, ADDRESS, TEL, KOR, ENG, MAT, TOT, AVG, RESULT) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try {
            pstmt = conn.prepareStatement(query);

            pstmt.setInt(1, stu.getNum()); // 첫 번째 ?에 int값을 입력하시오
            pstmt.setString(2, stu.getName());
            pstmt.setString(3, stu.getAddress());
            pstmt.setString(4, stu.getTel());
            pstmt.setInt(5, stu.getKor());
            pstmt.setInt(6, stu.getEng());
            pstmt.setInt(7, stu.getMat());
            pstmt.setInt(8, stu.getTot());
            pstmt.setDouble(9, stu.getAvg());
            pstmt.setString(10, stu.getResult());

            int status = pstmt.executeUpdate();
            if (status > 0)
                System.out.println("데이터 입력 완료");
            else
                System.out.println("데이터 입력 실패");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnection.close(conn, pstmt);
        }
    }

    /* 전체 학생 리스트 출력 */
    public List<Student> selectAll() {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        String query = "SELECT * FROM STUDENT ORDER BY NUM";

        conn = DBConnection.getInstance().getConnection();

        List<Student> stuList = new ArrayList<Student>(); // List 타입으로 받으면 Vector도 된다

        try {
            pstmt = conn.prepareStatement(query);
            rs = pstmt.executeQuery(); // PreparedStatement 쿼리 실행, Result 결과 저장
            while (rs.next()) {
                Student stu = new Student();
                stu.setNum(rs.getInt("NUM"));
                stu.setName(rs.getString("NAME"));
                stu.setAddress(rs.getString("ADDRESS"));
                stu.setTel(rs.getString("TEL"));
                stu.setKor(rs.getInt("KOR"));
                stu.setEng(rs.getInt("ENG"));
                stu.setMat(rs.getInt("MAT"));
                stu.setTot(rs.getInt("TOT"));
                stu.setAvg(rs.getDouble("AVG"));
                stu.setResult(rs.getString("RESULT"));
                stuList.add(stu);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnection.close(conn, pstmt, rs);
        }
        return stuList;
    }

}

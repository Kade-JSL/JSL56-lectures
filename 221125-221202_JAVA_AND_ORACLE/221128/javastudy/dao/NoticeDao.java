package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import DBManager.DBConnection;
import dto.NoticeDto;

public class NoticeDao {
    
    private static NoticeDao noticeDao = new NoticeDao();
    private NoticeDao() {}
    public static NoticeDao getNoticeDao() { return noticeDao; }

    Scanner sc = new Scanner(System.in);

    public void newContent(NoticeDto nd) {
        Connection conn = DBConnection.getInstance().getConnection();
        PreparedStatement pstmt = null;

        String query =
            "INSERT INTO NOTICE (" +
                "BNO, TITLE, CONTENT, NAME" +
            ") VALUES (" +
                "?, ?, ?, ?" +
            ")";

        try {
            pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, nd.getBno());
            pstmt.setString(2, nd.getTitle());
            pstmt.setString(3, nd.getContent());
            pstmt.setString(4, nd.getName());

            int update = pstmt.executeUpdate();
            if (update > 0) System.out.println("게시물 작성이 완료되었습니다.");
            else System.out.println("데이터베이스 오류. 다시 시도해 주세요.");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnection.close(conn, pstmt);
        }
    }

    public int getContentNum() {
        int cno = 0;

        Connection conn = DBConnection.getInstance().getConnection();
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        String query = "SELECT MAX(BNO) AS CNO FROM NOTICE";
        
        try {
            pstmt = conn.prepareStatement(query);
            rs = pstmt.executeQuery();
            if (rs.next()) cno = rs.getInt("CNO");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnection.close(conn, pstmt, rs);
        }

        return cno;
    }
}

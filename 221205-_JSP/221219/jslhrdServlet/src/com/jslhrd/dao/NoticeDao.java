package com.jslhrd.dao;

import java.sql.*;
import java.util.*;
import com.jslhrd.dto.NoticeDto;
import com.jslhrd.dbmanager.DBManager;

public class NoticeDao {

	private static NoticeDao instance = new NoticeDao();
	private NoticeDao() {}
	public static NoticeDao getInstance() { return instance; }
	
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	DBManager dbm = DBManager.getInstance();
	List<NoticeDto> noticeList = null;
	NoticeDto dto = null;
	String query = null;
	
	public void noticeInsert(NoticeDto dto) {
		conn = dbm.getConnection();
		
		query = "INSERT INTO NOTICE (" +
					"BNO, TITLE, CONTENT, WRITER, REGDATE, VIEWCOUNT" +
				") VALUES (" +
					"NOTICE_SEQ.NEXTVAL, ?, ?, ?, SYSDATE, 0" + 
				")";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, dto.getTitle());
			pstmt.setString(2, dto.getContent());
			pstmt.setString(3, dto.getWriter());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbm.close(conn, pstmt);
		}
	}
	
	public List<NoticeDto> noticeSelectAll() {
		conn = dbm.getConnection();
		
		query = "SELECT BNO, TITLE, WRITER, REGDATE, VIEWCOUNT FROM NOTICE ORDER BY BNO DESC";
		
		try {
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();
			
			if (rs != null) { noticeList = new ArrayList<NoticeDto>(); }
			while (rs.next()) {
				dto = new NoticeDto();
				
				dto.setBno(rs.getInt("BNO"));
				dto.setTitle(rs.getString("TITLE"));
				dto.setWriter(rs.getString("WRITER"));
				String rdate = rs.getString("REGDATE");
				rdate = rdate.substring(0,10);
				dto.setRegdate(rdate);
				dto.setViewcount(rs.getInt("VIEWCOUNT"));
				
				noticeList.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return noticeList;
	}
	
	public NoticeDto selectBno(int bno) {
		conn = dbm.getConnection();
		
		query = "SELECT TITLE, WRITER, REGDATE, VIEWCOUNT, CONTENT, BNO FROM NOTICE WHERE BNO = " + bno;
		
		try {
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();
			
			if (rs != null) { dto = new NoticeDto(); }
			
			if (rs.next()) {
				dto.setTitle(rs.getString("TITLE"));
				dto.setWriter(rs.getString("WRITER"));
				String rdate = rs.getString("REGDATE");
				rdate = rdate.substring(0,10);
				dto.setRegdate(rdate);
				dto.setViewcount(rs.getInt("VIEWCOUNT"));
				dto.setContent(rs.getString("CONTENT").replace("\r\n", "<br>"));
				dto.setBno(rs.getInt("BNO"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbm.close(conn, pstmt, rs);
		}
		
		return dto;
	}
	
	public void viewCount(int bno) {
		conn = dbm.getConnection();
		
		query = "UPDATE NOTICE SET VIEWCOUNT = VIEWCOUNT + 1 WHERE BNO = " + bno;
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbm.close(conn, pstmt);
		}
	}
	
	public NoticeDto prevBno(int bno) {
		conn = dbm.getConnection();
		
		query = "SELECT BNO, TITLE FROM NOTICE WHERE BNO = (SELECT MAX(BNO) FROM NOTICE WHERE BNO < " + bno + ")";
		
		try {
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				dto = new NoticeDto();
				dto.setBno(rs.getInt("BNO"));
				dto.setTitle(rs.getString("TITLE"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbm.close(conn, pstmt, rs);
		}
		
		return dto;
	}
	
	public NoticeDto nextBno(int bno) {
		conn = dbm.getConnection();
		
		query = "SELECT BNO, TITLE FROM NOTICE WHERE BNO = (SELECT MIN(BNO) FROM NOTICE WHERE BNO > " + bno + ")";
		
		try {
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				dto = new NoticeDto();
				dto.setBno(rs.getInt("BNO"));
				dto.setTitle(rs.getString("TITLE"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbm.close(conn, pstmt, rs);
		}
		
		return dto;
	}
	
	public void noticeUpdate(NoticeDto n) {
		conn = dbm.getConnection();
		
		query = "UPDATE NOTICE SET TITLE = ?, CONTENT = ? WHERE BNO = " + n.getBno();
		
		try {
			pstmt = conn.prepareStatement(query);
			
			pstmt.setString(1, n.getTitle());
			pstmt.setString(2, n.getContent());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbm.close(conn, pstmt);
		}
	}
	
	public void deleteBno(int bno) {
		conn = dbm.getConnection();
		
		query = "DELETE FROM NOTICE WHERE BNO = " + bno;
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbm.close(conn, pstmt);
		}
	}
}

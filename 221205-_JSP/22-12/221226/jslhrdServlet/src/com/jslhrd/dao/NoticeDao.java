package com.jslhrd.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.jslhrd.dbmanager.DBManager;
import com.jslhrd.dto.NoticeDto;
import com.jslhrd.utility.Criteria;

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
		
		query = "SELECT /*+ INDEX_DESC (NOTICE NOTICE_PK) */ BNO, TITLE, WRITER, REGDATE, VIEWCOUNT FROM NOTICE";
		
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
		} finally {
			dbm.close(conn, pstmt, rs);
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
	
	public List<NoticeDto> getListWithPaging(Criteria cri) {
		conn = dbm.getConnection();
		
		query = "SELECT * FROM ( " + 
				"SELECT /*+ INDEX_DESC (NOTICE NOTICE_PK) */ " +
					"ROWNUM RN, BNO, TITLE, CONTENT, WRITER, REGDATE, VIEWCOUNT " + 
				"FROM NOTICE WHERE ROWNUM <= ? * ?" + 
			") WHERE RN > (? - 1) * ?";
				
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, cri.getPageNum());
			pstmt.setInt(2, cri.getAmount());
			pstmt.setInt(3, cri.getPageNum());
			pstmt.setInt(4, cri.getAmount());
			rs = pstmt.executeQuery();
			
			if (rs != null) { noticeList = new ArrayList<NoticeDto>(); }
			while (rs.next()) {
				dto = new NoticeDto();
				
				dto.setBno(rs.getInt("BNO"));
				dto.setTitle(rs.getString("TITLE"));
				dto.setContent(rs.getString("CONTENT"));
				dto.setWriter(rs.getString("WRITER"));
				String rdate = rs.getString("REGDATE");
				rdate = rdate.substring(0,10);
				dto.setRegdate(rdate);
				dto.setViewcount(rs.getInt("VIEWCOUNT"));
				
				noticeList.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbm.close(conn, pstmt, rs);
		}
		
		return noticeList;
	}
	
	public int noticeSize(Criteria cri) {
		Connection con = dbm.getConnection();
		PreparedStatement stmt = null;
		ResultSet r = null;
		int count = 0;
		
		String subq = "NOTICE";
		if (!cri.getCondition().equals("")) {
			subq = "(SELECT * FROM ( " + 
					"SELECT ROWNUM RN, BNO, TITLE, CONTENT, WRITER, REGDATE, VIEWCOUNT " + 
					"FROM NOTICE WHERE " + cri.getCondition().replace(" AND ", "") + "))";
		}
		String sql = "SELECT COUNT(*) AS CNT FROM " + subq;
		
		// System.out.println(sql);
		
		try {
			stmt = con.prepareStatement(sql);
			r = stmt.executeQuery();
			
			if (r.next()) {
				count = r.getInt("CNT");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbm.close(con, stmt, r);
		}
		
		return count;
	}
	
//	public List<HashMap<String, Object>> selectNoticeWithPagingMap(Criteria cri) {
//		conn = dbm.getConnection();
//		
//		query = "SELECT * FROM ( " + 
//				"SELECT /*+ INDEX_DESC (NOTICE NOTICE_PK) */ " +
//					"ROWNUM RN, BNO, TITLE, CONTENT, WRITER, REGDATE, VIEWCOUNT " + 
//				"FROM NOTICE WHERE ROWNUM <= ? * ?" + 
//			") WHERE RN > (? - 1) * ?";
//				
//		try {
//			pstmt = conn.prepareStatement(query);
//			pstmt.setInt(1, cri.getPageNum());
//			pstmt.setInt(2, cri.getAmount());
//			pstmt.setInt(3, cri.getPageNum());
//			pstmt.setInt(4, cri.getAmount());
//			rs = pstmt.executeQuery();
//			
//			if (rs != null) { mapList = new ArrayList<HashMap<String, Object>>(); }
//			while (rs.next()) {
//				map = new HashMap<String, Object>();
//				
//				map.put("bno", rs.getInt("BNO"));
//				map.put("title", rs.getString("TITLE"));
//				map.put("content", rs.getString("CONTENT"));
//				map.put("writer", rs.getString("WRITER"));
//				String rdate = rs.getString("REGDATE");
//				rdate = rdate.substring(0,10);
//				map.put("regdate", rdate);
//				map.put("viewcount", rs.getInt("VIEWCOUNT"));
//				
//				mapList.add(map);
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			dbm.close(conn, pstmt, rs);
//		}
//		
//		return mapList;
//	}
	
	public List<HashMap<String, Object>> searchNoticePageMap(Criteria cri) {
		conn = dbm.getConnection();
		
		query = "SELECT * FROM ( " + 
				"SELECT /*+ INDEX_DESC (NOTICE NOTICE_PK) */ " +
					"ROWNUM RN, BNO, TITLE, CONTENT, WRITER, REGDATE, VIEWCOUNT " + 
				"FROM NOTICE WHERE " + cri.getCondition() + "ROWNUM <= ? * ?" + 
			") WHERE RN > (? - 1) * ?";
		
		List<HashMap<String, Object>> mapList = null;
		HashMap<String, Object> map = null;
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, cri.getPageNum());
			pstmt.setInt(2, cri.getAmount());
			pstmt.setInt(3, cri.getPageNum());
			pstmt.setInt(4, cri.getAmount());
			rs = pstmt.executeQuery();
			
			if (rs != null) { mapList = new ArrayList<HashMap<String, Object>>(); }
			while (rs.next()) {
				map = new HashMap<String, Object>();
				
				map.put("bno", rs.getInt("BNO"));
				map.put("title", rs.getString("TITLE"));
				map.put("content", rs.getString("CONTENT"));
				map.put("writer", rs.getString("WRITER"));
				String rdate = rs.getString("REGDATE");
				rdate = rdate.substring(0,10);
				map.put("regdate", rdate);
				map.put("viewcount", rs.getInt("VIEWCOUNT"));
				
				mapList.add(map);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbm.close(conn, pstmt, rs);
		}
		
		return mapList;
	}
}

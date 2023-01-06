package com.jslhrd.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.jslhrd.dbmanager.DBManager;
import com.jslhrd.dto.PortfolioDto;
import com.jslhrd.utility.Criteria;

public class PortfolioDao {
	
	private static PortfolioDao instance = new PortfolioDao();
	private PortfolioDao() {}
	public static PortfolioDao getInstance() { return instance; }
	
	DBManager dbm = DBManager.getInstance();
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	public void insertPort(PortfolioDto dto) {
		conn = dbm.getConnection();
		
		String sql = "INSERT INTO PORTFOLIO "
				+ "(BNO, TITLE, CONTENT, IMGURL) "
				+ "VALUES "
				+ "(PORT_SEQ.NEXTVAL, ?, ?, ?)";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getTitle());
			pstmt.setString(2, dto.getContent());
			pstmt.setString(3, dto.getImgurl());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbm.close(conn, pstmt);
		}
	}
	
	public Map<String, Object> readPortContent(int bno) {
		conn = dbm.getConnection();
		
		String sql = "SELECT * FROM PORTFOLIO WHERE BNO = ?";
		viewCount(conn, bno);
		
		Map<String, Object> map = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bno);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				map = new HashMap<String, Object>();
				map.put("bno", rs.getInt("BNO"));
				map.put("title", rs.getString("TITLE"));
				map.put("writer", rs.getString("WRITER"));
				map.put("regdate", rs.getString("REGDATE"));
				map.put("viewcount", rs.getInt("VIEWCOUNT"));
				map.put("content", rs.getString("CONTENT"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return map;
	}
	
	public List<PortfolioDto> readPortList(Criteria cri) {
		conn = dbm.getConnection();
		
		String sql = "SELECT * FROM (" + 
				"SELECT /*+ INDEX_DESC (PORTFOLIO PORT_PK) */ " +
				"ROWNUM RN, BNO, TITLE, CONTENT, IMGURL, REGDATE, VIEWCOUNT " + 
				"FROM PORTFOLIO WHERE ROWNUM <= ? ORDER BY BNO DESC" + 
				") WHERE RN > ?";
		
		List<PortfolioDto> list = null;
		PortfolioDto dto = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, cri.getPageNum() * cri.getAmount());
			pstmt.setInt(2, (cri.getPageNum() - 1) * cri.getAmount());
			rs = pstmt.executeQuery();
			
			if (rs != null) { list = new ArrayList<PortfolioDto>(); }
			while (rs.next()) {
				dto = new PortfolioDto();
				dto.setBno(rs.getInt("BNO"));
				dto.setTitle(rs.getString("TITLE"));
				dto.setContent(rs.getString("CONTENT").replaceAll("<(/)?([a-zA-Z]*)(\\s[a-zA-Z]*=[^>]*)?(\\s)*(/)?>", ""));
				dto.setImgurl(rs.getString("IMGURL"));
				dto.setRegdate(rs.getString("REGDATE"));
				dto.setViewcount(rs.getInt("VIEWCOUNT"));
				
				list.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbm.close(conn, pstmt, rs);
		}
		
		return list;
	}
	
	public void updatePort(Map<String, Object> map) {
		conn = dbm.getConnection();
		
		String ddtnl = "";
		String imgurl = (String) map.get("imgurl");
		boolean isUrlExists = imgurl.equals("");
		if(!isUrlExists) { ddtnl = ", IMGURL = '" + imgurl + "' ";}
		
		String sql = "UPDATE PORTFOLIO SET "
				+ "TITLE = ?, CONTENT = ? " + ddtnl
				+ "WHERE BNO = ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, (String) map.get("title"));
			pstmt.setString(2, (String) map.get("content"));
			pstmt.setInt(3, (int) map.get("bno"));
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbm.close(conn, pstmt);
		}
	}
	
	public void deletePort(int bno) {
		
	}
	
	/* utility methods */
	public int portCount() {
		conn = dbm.getConnection();
		
		String sql = "SELECT COUNT(BNO) AS CNT FROM PORTFOLIO";
		
		int cnt = 0;
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if (rs.next()) { cnt = rs.getInt("CNT"); }
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbm.close(conn, pstmt, rs);
		}
		
		return cnt;
	}
	
	public void viewCount(Connection conn, int bno) {
		
		String sql = "UPDATE PORTFOLIO SET VIEWCOUNT = VIEWCOUNT + 1 WHERE BNO = " + bno;
		
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.executeUpdate();
			pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}

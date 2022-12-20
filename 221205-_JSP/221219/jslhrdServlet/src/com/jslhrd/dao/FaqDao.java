package com.jslhrd.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.jslhrd.dbmanager.DBManager;
import com.jslhrd.dto.FaqDto;

public class FaqDao {
	
	private static FaqDao instance = new FaqDao();
	private FaqDao() {}
	public static FaqDao getInstance() { return instance; }
	
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	DBManager dbm = DBManager.getInstance();
	
	FaqDto dto = null;
	List<FaqDto> dtoList = null;
	String sql = null;
	
	public List<FaqDto> selectAllFaq() {
		conn = dbm.getConnection();
		
		sql = "SELECT " + 
				"A.BNO, " +
				"A.TITLE, " + 
				"B.CONTENT " + 
			"FROM " + 
				"FAQ1 A " + 
				"LEFT JOIN FAQ2 B " + 
				"ON A.BNO = B.QNO " + 
			"ORDER BY " + 
				"A.BNO DESC";
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			if (rs != null) { dtoList = new ArrayList<FaqDto>(); }
			while (rs.next()) {
				dto = new FaqDto();
				dto.setBno(rs.getInt("BNO"));
				dto.setTitle(rs.getString("TITLE"));
				dto.setContent(rs.getString("CONTENT"));
				dtoList.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbm.close(conn, pstmt, rs);
		}
		
		return dtoList;
	}
	
	public void insertFaq(FaqDto f) {
		conn = dbm.getConnection();
		
		String sql1 = "INSERT INTO FAQ1 VALUES (FAQ1_SEQ.NEXTVAL, ?)";
		String sql2 = "SELECT BNO FROM FAQ1 WHERE TITLE = ?";
		String sql3 = "INSERT INTO FAQ2 VALUES (FAQ2_SEQ.NEXTVAL, ?, ?)";
		
		try {
			PreparedStatement pstmt1 = conn.prepareStatement(sql1);
			pstmt1.setString(1, f.getTitle());
			pstmt1.executeUpdate();
			pstmt1.close();
			
			PreparedStatement pstmt2 = conn.prepareStatement(sql2);
			pstmt2.setString(1, f.getTitle());
			rs = pstmt2.executeQuery();
			int bno = 0;
			if (rs.next()) { bno = rs.getInt("BNO"); }
			pstmt2.close();
			rs.close();
			
			PreparedStatement pstmt3 = conn.prepareStatement(sql3);
			pstmt3.setInt(1, bno);
			pstmt3.setString(2, f.getContent());
			pstmt3.executeUpdate();
			pstmt3.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}

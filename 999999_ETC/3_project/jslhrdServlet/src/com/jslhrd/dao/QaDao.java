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
import com.jslhrd.utility.Criteria;

public class QaDao {
	
	private static QaDao instance = new QaDao();
	private QaDao() {}
	public static QaDao getInstance() { return instance; }
	
	private DBManager dbm = DBManager.getInstance();
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	public void createQa(HashMap<String, Object> query) {
		conn = dbm.getConnection();
		
		String sql = "INSERT INTO QA ("
				+ "BNO, TITLE, CONTENT, WRITER"
				+ ") VALUES ("
				+ "?, ?, ?, ?)";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, (int) query.get("bno"));
			pstmt.setString(2, (String) query.get("title"));
			pstmt.setString(3, (String) query.get("content"));
			pstmt.setString(4, (String) query.get("writer"));
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbm.close(conn, pstmt);
		}
	}
	
	public List<HashMap<String, Object>> readQaList(Criteria cri) {
		List<HashMap<String, Object>> list = null;
		Map<String, Object> map = null;
		conn = dbm.getConnection();
		
		String sql = "SELECT * FROM QA";
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			if (rs != null) { list = new ArrayList<HashMap<String, Object>>(); }
			while (rs.next()) {
				map = new HashMap<String, Object>();
				map.put("bno", rs.getInt("BNO"));
				map.put("title", rs.getString("TITLE"));
				map.put("status", rs.getString("STATUS"));
				map.put("regdate", rs.getString("REGDATE"));
				map.put("writer", rs.getString("WRITER"));
				map.put("viewcount", rs.getInt("VIEWCOUNT"));
				list.add((HashMap<String, Object>) map);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return list;
	}
}

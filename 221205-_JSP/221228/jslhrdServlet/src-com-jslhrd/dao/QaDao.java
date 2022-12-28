package com.jslhrd.dto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

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
	
	public void createQa(HashMap<String, Object> q) {
		conn = dbm.getConnection();
		
		String sql = "INSERT INTO QA ("
				+ "BNO, TITLE, CONTENT, WRITER"
				+ ") VALUES ("
				+ "?, ?, ?, ?)";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, (int) q.get("bno"));
			pstmt.setString(2, (String) q.get("title"));
			pstmt.setString(3, (String) q.get("content"));
			pstmt.setString(4, (String) q.get("writer"));
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbm.close(conn, pstmt);
		}
	}
	
	public List<HashMap<String, Object>> readQa(Criteria cri) {
		List<HashMap<String, Object>> list = null;
		
		return list;
	}
}

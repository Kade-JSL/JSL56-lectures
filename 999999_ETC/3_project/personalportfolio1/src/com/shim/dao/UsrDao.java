package com.shim.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class UsrDao {

	private static UsrDao instance = new UsrDao();
	private UsrDao() {}
	public static UsrDao getInstance() { return instance; }
	
	DBConn dbc = DBConn.getInstance();
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	public void createUser(Map<String, Object> map) {
		conn = dbc.getConnection();
		
		String sql = "INSERT INTO P1_USERS (UNO, EMAIL, UNAME, PW, PROFILEIMG) "
				+ "VALUES (UNO_SEQ.NEXTVAL, ?, ?, ?, ?)";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, (String) map.get("email"));
			pstmt.setString(2, (String) map.get("uname"));
			pstmt.setString(3, (String) map.get("pw"));
			pstmt.setString(4, (String) map.get("profileimg"));
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbc.close(conn, pstmt);
		}
	}

	public Map<String, Object> login(String id, String pw) {
		Map<String, Object> user = null;
		conn = dbc.getConnection();
		
		String sql = "SELECT PW, UNAME FROM P1_USERS WHERE EMAIL = ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				String tablepw = rs.getString("PW");
				user = new HashMap<String, Object>();
				if (tablepw.equals(pw)) {
					user.put("uname", rs.getString("UNAME"));
				} else {
					user.put("uname", null);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbc.close(conn, pstmt, rs);
		}
		
		return user;
	}
}

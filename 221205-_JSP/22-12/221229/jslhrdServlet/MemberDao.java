package com.jslhrd.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.jslhrd.dbmanager.DBManager;

public class MemberDao {
	
	private static MemberDao instance = new MemberDao();
	private MemberDao() {}
	public static MemberDao getInstance() { return instance; }
	
	DBManager dbm = DBManager.getInstance();
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	public int selectNickname(String nickname) {
		int result = 0;
		conn = dbm.getConnection();
		
		String sql = "SELECT * FROM MEMBER WHERE NICKNAME = ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, nickname);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				result = 1;
			} else {
				result = -1;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbm.close(conn, pstmt, rs);
		}
		
		return result;
	}
	
	public int selectId(String id) {
		int result = 0;
		conn = dbm.getConnection();
		
		String sql = "SELECT * FROM MEMBER WHERE ID = ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				result = 1;
			} else {
				result = -1;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbm.close(conn, pstmt, rs);
		}
		
		return result;
	}
}

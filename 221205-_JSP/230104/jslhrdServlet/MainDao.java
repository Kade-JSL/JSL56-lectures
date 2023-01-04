package com.jslhrd.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import com.jslhrd.dbmanager.DBManager;

public class MainDao {

	private static MainDao instance = new MainDao();

	private MainDao() {
	}

	public static MainDao getInstance() {
		return instance;
	}

	DBManager dbm = DBManager.getInstance();
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	public ArrayList<HashMap<String, Object>> readMainPort() {
		conn = dbm.getConnection();

		String sql = "SELECT * FROM ("
				+ "SELECT /*+ INDEX_DESC (PORTFOLIO PORT_PK) */ * FROM PORTFOLIO ORDER BY BNO DESC"
				+ ") WHERE ROWNUM <= 3";

		ArrayList<HashMap<String, Object>> list = null;
		HashMap<String, Object> map = null;

		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			if (rs != null) {
				list = new ArrayList<HashMap<String, Object>>();
			}
			while (rs.next()) {
				map = new HashMap<String, Object>();

				map.put("bno", rs.getInt("BNO"));
				map.put("title", rs.getString("TITLE"));
				String content = rs.getString("CONTENT").replaceAll("<(/)?([a-zA-Z]*)(\\s[a-zA-Z]*=[^>]*)?(\\s)*(/)?>", "");
				if (content.length() > 30) { content = content.substring(0, 30); }
				map.put("content", content);
				map.put("imgurl", rs.getString("IMGURL"));
				map.put("regdate", rs.getString("REGDATE"));

				list.add(map);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbm.close(conn, pstmt, rs);
		}

		return list;
	}

	public ArrayList<HashMap<String, Object>> readMainNotice() {
		conn = dbm.getConnection();

		String sql = "SELECT * FROM (" + "SELECT /*+ INDEX_DESC (NOTICE NOTICE_PK) */ * FROM NOTICE ORDER BY BNO DESC"
				+ ") WHERE ROWNUM <= 5";

		ArrayList<HashMap<String, Object>> list = null;
		HashMap<String, Object> map = null;

		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			if (rs != null) {
				list = new ArrayList<HashMap<String, Object>>();
			}
			while (rs.next()) {
				map = new HashMap<String, Object>();

				map.put("bno", rs.getInt("BNO"));
				map.put("title", rs.getString("TITLE"));
				String content = rs.getString("CONTENT").replaceAll("<(/)?([a-zA-Z]*)(\\s[a-zA-Z]*=[^>]*)?(\\s)*(/)?>", "");
				if (content.length() > 20) { content = content.substring(0, 20); }
				map.put("content", content);
				map.put("regdate", rs.getString("REGDATE"));

				list.add(map);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbm.close(conn, pstmt, rs);
		}

		return list;
	}

}

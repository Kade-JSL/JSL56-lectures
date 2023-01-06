package com.shim.dao;

import java.sql.Connection;
import java.util.Map;

public class MainDao {
	private static MainDao instance = new MainDao();
	private MainDao() {}
	public static MainDao getInstance() { return instance; }
	
	Connection conn = null;
	
	public Map<String, Object> connTest(Map<String, Object> map) {
		conn = DBConn.getInstance().getConnection();
		
		if (conn != null) {
			map.put("msg", "Connection successful");
		} else {
			map.put("msg", "Connection failed");
		}
		
		return map;
	}
}

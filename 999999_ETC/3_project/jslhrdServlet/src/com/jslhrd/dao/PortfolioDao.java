package com.jslhrd.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.jslhrd.dbmanager.DBManager;
import com.jslhrd.dto.PortfolioDto;

public class PortfolioDao {
	
	private static PortfolioDao instance = new PortfolioDao();
	private PortfolioDao() {}
	public static PortfolioDao getInstance() { return instance; }
	
	DBManager dbm = DBManager.getInstance();
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	PortfolioDto dto = null;
	String sql = null;
	
	public void insertPort(PortfolioDto p) {
		conn = dbm.getConnection();
		
		sql = "INSERT INTO PORTFOLIO "
				+ "(BNO, TITLE, CONTENT, IMGURL) "
				+ "VALUES "
				+ "(PORT_SEQ.NEXTVAL, ?, ?, ?)";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, p.getTitle());
			pstmt.setString(2, p.getContent());
			pstmt.setString(3, p.getImgurl());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbm.close(conn, pstmt);
		}
	}

}

package model;

import java.sql.*;
import java.util.*;

public class Dao {
	private static Dao dao = new Dao();
	private Dao() {}
	public static Dao getInstance() { return dao; }
	
	List<Dto> dtoList = null;
	Dto dto = null;
	DBConn dbc = DBConn.getInstance();
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	public List<Dto> selectAllCust() {
		conn = dbc.getConnection();
		
		String query = "SELECT * FROM TBL_CUST_201004 ORDER BY P_NO";
		
		try {
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();
			
			if (rs != null) { dtoList = new ArrayList<Dto>(); }
			while (rs.next()) {
				dto = new Dto();
				dto.setP_no(rs.getString("P_NO"));
				dto.setP_name(rs.getString("P_NAME"));
				dto.setP_birth(rs.getString("P_BIRTH"));
				dto.setP_gender(rs.getString("P_GENDER"));
				dto.setP_tel1(rs.getString("P_TEL1"));
				dto.setP_tel2(rs.getString("P_TEL2"));
				dto.setP_tel3(rs.getString("P_TEL3"));
				dto.setP_city(rs.getString("P_CITY"));
				dtoList.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbc.close(conn, pstmt, rs);
		}
		
		return dtoList;
	}
	
	public void insertOrder(Dto dto) {
		conn = dbc.getConnection();
		
		String query = "INSERT INTO TBL_ORDER_201004 (P_SENO, P_NO, I_CODE, P_DATE) VALUES (" +
				"?, ?, ?, TO_DATE(?, 'YYYYMMDD'))";
		
		try {
			pstmt = conn.prepareStatement(query);
			
			pstmt.setInt(1, dto.getP_seno());
			pstmt.setString(2, dto.getP_no());
			pstmt.setString(3, dto.getI_code());
			pstmt.setString(4, dto.getP_date());
			
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbc.close(conn, pstmt);
		}
	}
	
	public List<Dto> selectAllOrder() {
		conn = dbc.getConnection();
		
		String query = "SELECT A.P_SENO, A.P_NO, B.P_NAME, A.I_CODE, C.I_NAME, TO_CHAR(A.P_DATE, 'YYYY-MM-DD') AS PDATE " + 
				"FROM TBL_ORDER_201004 A " + 
				"INNER JOIN TBL_CUST_201004 B ON A.P_NO = B.P_NO " + 
				"INNER JOIN TBL_INJECTION_201004 C ON A.I_CODE = C.I_CODE " + 
				"ORDER BY A.P_NO, A.I_CODE";
		
		try {
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();
			
			if (rs != null) { dtoList = new ArrayList<Dto>(); }
			while (rs.next()) {
				dto = new Dto();
				dto.setP_seno(Integer.parseInt(rs.getString("P_SENO")));
				dto.setP_no(rs.getString("P_NO"));
				dto.setP_name(rs.getString("P_NAME"));
				dto.setI_code(rs.getString("I_CODE"));
				dto.setI_name(rs.getString("I_NAME"));
				dto.setP_date(rs.getString("PDATE"));
				dtoList.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbc.close(conn, pstmt, rs);
		}
		
		return dtoList;
	}
	
	public List<Dto> selectAllInjection() {
		conn = dbc.getConnection();
		
		String query =
				"SELECT " + 
					"A.I_CODE, " + 
					"C.I_NAME, " + 
					"COUNT(A.I_CODE) AS CNT " + 
				"FROM " +
					"TBL_ORDER_201004 A " + 
					"INNER JOIN TBL_INJECTION_201004 C " +
					"ON A.I_CODE = C.I_CODE " + 
				"GROUP BY " + 
					"A.I_CODE, " + 
					"C.I_NAME " + 
				"ORDER BY " + 
					"A.I_CODE";
		
		try {
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();
			
			if (rs != null) { dtoList = new ArrayList<Dto>(); }
			while (rs.next()) {
				dto = new Dto();
				dto.setI_code(rs.getString("I_CODE"));
				dto.setI_name(rs.getString("I_NAME"));
				dto.setCnt(rs.getString("CNT"));
				dtoList.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbc.close(conn, pstmt, rs);
		}
		
		return dtoList;
	}
}

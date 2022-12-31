package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Dao {
	private static Dao dao = new Dao();
	private Dao() {}
	public static Dao getInstance() { return dao; }
	
	DBManager dbm = DBManager.getInstance();
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	Vo vo = null;
	List<Vo> stuList = null;
	
	public void insertStudent(Vo vo) {
		conn = dbm.getConnection();
		
		String query = "INSERT INTO TBL_STUDENT (" +
		"SYEAR, SCLASS, SNO, SNAME, BIRTH, GENDER, TEL1, TEL2, TEL3" +
		") VALUES ( " +
		"?, ?, ?, ?, ?, ?, ?, ?, ?" +
		")";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, vo.getSyear());
			pstmt.setString(2, vo.getSclass());
			pstmt.setString(3, vo.getSno());
			pstmt.setString(4, vo.getSname());
			pstmt.setString(5, vo.getBirth());
			pstmt.setString(6, vo.getGender());
			pstmt.setString(7, vo.getTel1());
			pstmt.setString(8, vo.getTel2());
			pstmt.setString(9, vo.getTel3());
			
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
	}
	
	public void insertScore(Vo vo) {
		conn = dbm.getConnection();
		
		String query = "INSERT INTO TBL_SCORE (" +
		"SYEAR, SCLASS, SNO, KOR, ENG, MAT" +
		") VALUES ( " +
		"?, ?, ?, ?, ?, ?" +
		")";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, vo.getSyear());
			pstmt.setString(2, vo.getSclass());
			pstmt.setString(3, vo.getSno());
			pstmt.setInt(4, vo.getKor());
			pstmt.setInt(5, vo.getEng());
			pstmt.setInt(6, vo.getMat());
			
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
	}
	
	public List<Vo> selectAllStudent() {
		conn = dbm.getConnection();
		
		String query = "SELECT " + 
				"A.SYEAR, " + 
				"A.SCLASS, " + 
				"A.SNO, " + 
				"A.SNAME, " + 
				"A.GENDER, " + 
				"B.KOR, " + 
				"B.ENG, " + 
				"B.MAT, " +
				"B.KOR + B.ENG + B.MAT AS TOT, " +
			    "ROUND((B.KOR + B.ENG + B.MAT)/3, 1) AS AVG " +
				"FROM " + 
				"TBL_STUDENT A " + 
				"INNER JOIN TBL_SCORE B " + 
				"ON A.SYEAR = B.SYEAR AND A.SCLASS = B.SCLASS AND A.SNO = B.SNO";	
		
		try {
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();
			stuList = new ArrayList<Vo>();
			
			while (rs.next()) {
				vo = new Vo();
				vo.setSyear(rs.getString("SYEAR"));
				vo.setSclass(rs.getString("SCLASS"));
				vo.setSno(rs.getString("SNO"));
				vo.setSname(rs.getString("SNAME"));
				vo.setGender(rs.getString("GENDER"));
				vo.setKor(rs.getInt("KOR"));
				vo.setEng(rs.getInt("ENG"));
				vo.setMat(rs.getInt("MAT"));
				vo.setTot(rs.getInt("TOT"));
				vo.setAvg(rs.getDouble("AVG"));
				stuList.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
		
		return stuList;
	}
}

package model;

import java.sql.*;
import java.util.*;

public class Dao {
	private static Dao dao = new Dao();
	private Dao() {}
	public static Dao getDao() { return dao; }
	
	List<Dto> dtoList = null;
	Dto dto = null; 
	DBConn dbc = DBConn.getInstance();
	String query = null;
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	public void insertArtist(Dto dto) {
		conn = dbc.getConnection();
		
		query = "INSERT INTO TBL_ARTIST_201905 ( " +
		"ARTIST_ID, ARTIST_NAME, ARTIST_BIRTH, ARTIST_GENDER, TALENT, AGENCY " +
		") VALUES ( " + 
		"?, ?, ?, ?, ?, ?)";
		
		try {
			pstmt = conn.prepareStatement(query);
			
			pstmt.setString(1, dto.getArtist_id());
			pstmt.setString(2, dto.getArtist_name());
			pstmt.setString(3, dto.getArtist_birth());
			pstmt.setString(4, dto.getArtist_gender());
			pstmt.setString(5, dto.getTalent());
			pstmt.setString(6, dto.getAgency());
			
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbc.close(conn, pstmt);
		}
	}
	
	public List<Dto> selectAllArtist() {
		conn = dbc.getConnection();
		
		query = "SELECT * FROM TBL_ARTIST_201905 ORDER BY ARTIST_ID";
		
		try {
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();
			
			dtoList = new ArrayList<Dto>();
			while(rs.next()) {
				dto = new Dto();
				dto.setArtist_id(rs.getString("ARTIST_ID"));
				dto.setArtist_name(rs.getString("ARTIST_NAME"));
				dto.setArtist_birth(rs.getString("ARTIST_BIRTH"));
				dto.setArtist_gender(rs.getString("ARTIST_GENDER"));
				dto.setTalent(rs.getString("TALENT"));
				dto.setAgency(rs.getString("AGENCY"));
				dtoList.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbc.close(conn, pstmt, rs);
		}
		
		return dtoList;
	}
	
	public List<Dto> selectAllMentor() {
		conn = dbc.getConnection();
		
		query = "SELECT " +
			    "A.SERIAL_NO, " +
			    "A.ARTIST_ID, " +
			    "B.ARTIST_NAME, " +
			    "B.ARTIST_BIRTH, " +
			    "A.POINT, " +
			    "C.MENTO_NAME " +
			"FROM " +
			    "TBL_POINT_201905 A " +
			    "INNER JOIN TBL_ARTIST_201905 B " +
			    "ON A.ARTIST_ID = B.ARTIST_ID " +
			    "INNER JOIN TBL_MEMTO_201905 C " +
			    "ON A.MENTO_ID = C.MENTO_ID " +
			"GROUP BY " +
			    "A.SERIAL_NO, " +
			    "A.ARTIST_ID, " +
			    "B.ARTIST_NAME, " +
			    "B.ARTIST_BIRTH, " +
			    "A.POINT, " +
			    "C.MENTO_NAME " +
			"ORDER BY " +
			    "A.SERIAL_NO";
		
		try {
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();
			
			dtoList = new ArrayList<Dto>();
			while(rs.next()) {
				dto = new Dto();
				dto.setSerial_no(Integer.parseInt(rs.getString("SERIAL_NO")));
				dto.setArtist_id(rs.getString("ARTIST_ID"));
				dto.setArtist_name(rs.getString("ARTIST_NAME"));
				dto.setArtist_birth(rs.getString("ARTIST_BIRTH"));
				dto.setPoint(Integer.parseInt(rs.getString("POINT")));
				dto.setMento_name(rs.getString("MENTO_NAME"));
				dtoList.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbc.close(conn, pstmt, rs);
		}
		
		return dtoList;
	}
	
	public List<Dto> selectAllRank() {
		conn = dbc.getConnection();
		
		query = "SELECT B.ARTIST_ID, B.ARTIST_NAME, B.ARTIST_GENDER, " +
			    "SUM(A.POINT) AS TOT, SUM(A.POINT) / COUNT(C.MENTO_ID) AS AVG " +
			    "FROM TBL_POINT_201905 A " +
			        "INNER JOIN TBL_ARTIST_201905 B ON A.ARTIST_ID = B.ARTIST_ID " +
			        "INNER JOIN TBL_MEMTO_201905 C ON A.MENTO_ID = C.MENTO_ID " +
			    "GROUP BY B.ARTIST_ID, B.ARTIST_NAME, B.ARTIST_GENDER ORDER BY AVG DESC";
		
		try {
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();
			
			dtoList = new ArrayList<Dto>();
			int rank = 1;
			while(rs.next()) {
				dto = new Dto();
				dto.setArtist_id(rs.getString("ARTIST_ID"));
				dto.setArtist_name(rs.getString("ARTIST_NAME"));
				dto.setArtist_gender(rs.getString("ARTIST_GENDER"));
				dto.setTot(Integer.parseInt(rs.getString("TOT")));
				dto.setAvg(rs.getDouble("AVG"));
				dto.setRank(rank);
				rank++;
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

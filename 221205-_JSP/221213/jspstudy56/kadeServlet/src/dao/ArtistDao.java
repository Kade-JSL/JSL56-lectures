package dao;

import java.sql.*;
import java.util.*;
import dto.*;
import DBManager.DBManager;

public class ArtistDao {
	private static ArtistDao instance = new ArtistDao();
	private ArtistDao() {}
	public static ArtistDao getInstance() { return instance; }
	
	Connection conn = null;
	DBManager dbm = DBManager.getInstance();
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	ArtistDto dto = null;
	List<ArtistDto> artistDtoList = null;
	String query = null;
	
	public void insertArtist(ArtistDto dto) {
		conn = dbm.getConnection();
		
		query = "INSERT INTO TBL_ARTIST_201905 (" +
					"ARTIST_ID, ARTIST_NAME, ARTIST_GENDER, ARTIST_BIRTH, TALENT, AGENCY" +
				") VALUES (" +
					"?, ?, ?, ?, ?, ?)";
		
		try {
			pstmt = conn.prepareStatement(query);
			
			pstmt.setString(1, dto.getArtist_id());
			pstmt.setString(2, dto.getArtist_name());
			pstmt.setString(3, dto.getArtist_gender());
			pstmt.setString(4, dto.getArtist_birth());
			pstmt.setString(5, dto.getTalent());
			pstmt.setString(6, dto.getAgency());
			
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbm.close(conn, pstmt);
		}
	}
	
	public List<ArtistDto> selectArtist() {
		conn = dbm.getConnection();
		
		query = "SELECT * FROM TBL_ARTIST_201905 ORDER BY ARTIST_ID";
		
		try {
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();
			
			if (rs != null) { artistDtoList = new ArrayList<ArtistDto>(); }
			while (rs.next()) {
				dto = new ArtistDto();
				dto.setArtist_id(rs.getString("ARTIST_ID"));
				dto.setArtist_name(rs.getString("ARTIST_NAME"));
				dto.setArtist_gender(rs.getString("ARTIST_GENDER"));
				String birth = rs.getString("ARTIST_BIRTH");
				String yy = birth.substring(0, 4),
						mm = birth.substring(4, 6),
						dd = birth.substring(6);
				dto.setArtist_birth(yy + "년" + mm + "월" + dd + "일");
				dto.setTalent(rs.getString("TALENT"));
				dto.setAgency(rs.getString("AGENCY"));
				
				artistDtoList.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbm.close(conn, pstmt, rs);
		}
		
		return artistDtoList;
	}
	
	public List<ArtistDto> selectMentor() {
		conn = dbm.getConnection();
		
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
			
			if (rs != null) { artistDtoList = new ArrayList<ArtistDto>(); }
			while (rs.next()) {
				dto = new ArtistDto();
				dto.setSerial_no(rs.getInt("SERIAL_NO"));
				dto.setArtist_id(rs.getString("ARTIST_ID"));
				dto.setArtist_name(rs.getString("ARTIST_NAME"));
				String birth = rs.getString("ARTIST_BIRTH");
				String yy = birth.substring(0, 4),
						mm = birth.substring(4, 6),
						dd = birth.substring(6);
				dto.setArtist_birth(yy + "년" + mm + "월" + dd + "일");
				dto.setPoint(rs.getInt("POINT"));
				dto.setMento_name(rs.getString("MENTO_NAME"));
				
				artistDtoList.add(dto);
			}
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return artistDtoList;
	}
	
	public List<ArtistDto> selectRank() {
		conn = dbm.getConnection();
		
		query = "SELECT " + 
					"B.ARTIST_ID, " + 
					"B.ARTIST_NAME, " + 
					"B.ARTIST_GENDER, " + 
					"SUM(A.POINT) AS TOT, " + 
					"SUM(A.POINT) / COUNT(C.MENTO_ID) AS AVG " + 
				"FROM " + 
					"TBL_POINT_201905 A " + 
					"INNER JOIN TBL_ARTIST_201905 B " + 
					"ON A.ARTIST_ID = B.ARTIST_ID " + 
					"INNER JOIN TBL_MEMTO_201905 C " + 
					"ON A.MENTO_ID = C.MENTO_ID " + 
				"GROUP BY " + 
					"B.ARTIST_ID, " + 
					"B.ARTIST_NAME, " + 
					"B.ARTIST_GENDER " + 
				"ORDER BY " + 
					"AVG DESC";
		
		try {
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();
			
			artistDtoList = new ArrayList<ArtistDto>();
			int rank = 1;
			while(rs.next()) {
				dto = new ArtistDto();
				dto.setArtist_id(rs.getString("ARTIST_ID"));
				dto.setArtist_name(rs.getString("ARTIST_NAME"));
				dto.setArtist_gender(rs.getString("ARTIST_GENDER"));
				dto.setTot(Integer.parseInt(rs.getString("TOT")));
				dto.setAvg(rs.getDouble("AVG"));
				dto.setRank(rank);
				rank++;
				artistDtoList.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return artistDtoList;
	}
}

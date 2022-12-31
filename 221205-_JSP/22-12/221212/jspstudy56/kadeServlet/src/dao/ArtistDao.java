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
	List<ArtistDto> dtoList = null;
	
	public void insertArtist(ArtistDto dto) {
		conn = dbm.getConnection();
		
		String query =
				"INSERT INTO TBL_ARTIST_201905 (" +
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
}

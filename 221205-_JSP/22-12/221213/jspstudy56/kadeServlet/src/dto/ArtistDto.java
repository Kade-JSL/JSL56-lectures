package dto;

public class ArtistDto {
	
	private String
		artist_id,
		artist_name,
		artist_gender,
		artist_birth,
		talent,
		agency;
	
	private String mento_id, mento_name;
	
	private int serial_no, point;
	
	private int tot, rank;
	
	private double avg;
	
	public String getArtist_id() {
		return artist_id;
	}

	public void setArtist_id(String artist_id) {
		this.artist_id = artist_id;
	}

	public String getArtist_name() {
		return artist_name;
	}

	public void setArtist_name(String artist_name) {
		this.artist_name = artist_name;
	}

	public String getArtist_gender() {
		return artist_gender;
	}

	public void setArtist_gender(String artist_gender) {
		this.artist_gender = artist_gender;
	}

	public String getArtist_birth() {
		return artist_birth;
	}

	public void setArtist_birth(String artist_birth) {
		this.artist_birth = artist_birth;
	}

	public String getTalent() {
		return talent;
	}

	public void setTalent(String talent) {
		this.talent = talent;
	}

	public String getAgency() {
		return agency;
	}

	public void setAgency(String agency) {
		this.agency = agency;
	}

	public String getMento_id() {
		return mento_id;
	}

	public void setMento_id(String mento_id) {
		this.mento_id = mento_id;
	}

	public String getMento_name() {
		return mento_name;
	}

	public void setMento_name(String mento_name) {
		this.mento_name = mento_name;
	}

	public int getSerial_no() {
		return serial_no;
	}

	public void setSerial_no(int serial_no) {
		this.serial_no = serial_no;
	}

	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	}

	public int getTot() {
		return tot;
	}

	public void setTot(int tot) {
		this.tot = tot;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	public double getAvg() {
		return avg;
	}

	public void setAvg(double avg) {
		this.avg = avg;
	}

}

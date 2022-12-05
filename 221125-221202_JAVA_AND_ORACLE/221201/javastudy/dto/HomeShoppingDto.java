package dto;

public class HomeShoppingDto {
    private int custNo;
    private String custName, phone, gender, joinDate, grade, city;

    public int getCustNo() { return custNo; }
    public void setCustNo(int custNo) { this.custNo = custNo; }
    public String getCustName() { return custName; }
    public void setCustName(String custName) { this.custName = custName; }
    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }
    public String getGender() { return gender; }
    public void setGender(String gender) { this.gender = gender; }
    public String getJoinDate() { return joinDate; }
    public void setJoinDate(String joinDate) { this.joinDate = joinDate; }
    public String getGrade() { return grade; }
    public void setGrade(String grade) { this.grade = grade; }
    public String getCity() { return city; }
    public void setCity(String city) { this.city = city; }
}

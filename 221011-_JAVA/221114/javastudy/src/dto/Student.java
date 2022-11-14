package dto;

public class Student {

    private int num;
    private String name, address, tel;

    public Student() {}

    public Student(int num, String name, String address, String tel) {
        this.num = num;
        this.name = name;
        this.address = address;
        this.tel = tel;
    }

    // getters and setters
    public int getNum() {
        return num;
    }
    public void setNum(int num) {
        this.num = num;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }
}

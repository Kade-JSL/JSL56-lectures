package dto;

public class Student {

    private int num, kor, eng, mat, tot, rank = 1;
    private double avg;
    private String name, address, tel;

    public static enum Subjects { KOR, ENG, MAT }

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

    public int getKor() {
        return kor;
    }

    public void setKor(int kor) {
        this.kor = kor;
    }

    public int getEng() {
        return eng;
    }

    public void setEng(int eng) {
        this.eng = eng;
    }

    public int getMat() {
        return mat;
    }

    public void setMat(int mat) {
        this.mat = mat;
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

    public int getSub(Subjects j) {
        switch (j) {
            case KOR: return kor;
            case ENG: return eng;
            case MAT: return mat;
            default: return 0;
        }
    }

    public void setSub(Subjects j, int s) {
        switch (j) {
            case KOR: this.kor = s; break;
            case ENG: this.eng = s; break;
            case MAT: this.mat = s;
        }
    }

    @Override
    public String toString() {
        return num + " " + name + " " + address + " " + tel + " " + kor + " " + eng + " " + mat + " " + tot + " " + avg;
    }
}

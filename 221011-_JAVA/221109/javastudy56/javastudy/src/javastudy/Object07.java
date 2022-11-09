package javastudy;



public class Object07 {
    // 클래스는 뭐?: 설계도 혹은 틀, 또는 현장 용어로 왁구
    // 클래스로부터 객체를 만드는 과정을 인스턴스화라고 한다.
    // 객체는 굳이 클래스형이 아니어도 되지만 클래스를 통해서 만든 객체는 반드시 인스턴스라 한다.
    // 구성요소: 속성(attribute)과 기능(methods)을 가짐
    // 속성: 멤버변수; 기능: 생성자, 메서드 
    int bno, kor, eng, mat, tot;
    double avg;
    String name, grade;
    
    public Object07() { // 매개변수가 없는 생성자

    }
    public Object07(int bno, String name, int kor, int eng, int mat) { // 매개변수가 있는 생성자
        this.bno = bno; // this는 이 클래스의 멤버 변수를 가리킴
        this.name = name;
        this.kor = kor;
        this.eng = eng;
        this.mat = mat;
    }
    public int getScore() {
        tot = kor + eng + mat;
        return tot;
    }

    public double getAve() {
        avg = tot / 3.;
        return avg;
    }
}

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
    
    public Object07() {
        bno = 1;
        name = "홍길동";
        kor = 0; eng = 0; mat = 0;
    }
    public Object07(String name) {
        bno = 1;
        this.name = name;
        kor = 0; eng = 0; mat = 0;
    }
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
}

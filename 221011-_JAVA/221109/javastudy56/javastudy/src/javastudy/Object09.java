package javastudy;

public class Object09 {

    String id;
    String pw;

    public Object09() { // 생성자는 반드시 클래스의 이름과 같아야 한다

    }
    public Object09(String id, String pw) {
        this.id = id;
        this.pw = pw;
    }

    public void printResult() {
        if (id.equals("abce") && pw.equals("1234")) { // 문자열을 비교할 땐 ==가 아니라 equals() 메서드를 사용할 것
            System.out.println("로그인되었습니다.");
        } else {
            System.out.println("아이디 또는 패스워드를 확인하세요.");
        }
    }
}

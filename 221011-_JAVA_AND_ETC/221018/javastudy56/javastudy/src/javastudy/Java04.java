package javastudy;

public class Java04 { // 설계도

    // 1. 선언
    public static void main(String args[]) { 

        /*
        - public: 접근 제한자, 아무나 접근할 수 있는 메소드라는 뜻
        - static: 객체 생성 없이 사용 가능한 메서드
        - void: main() 메서드를 실행한 후 리턴해줄 값이 없음
        - main(): 반드시 1개는 존재해야 하는 메서드
        - String args[]: 문자열을 저장하는 배열을 의미하는 매개변수
        */ 

        // 2. 처리
        int bno = 11; // 11이란 값을 bno란 기억장소에 저장해 두어라
        String name = "홍길동";
        /* 뱀발: String만 대문자인 이유는,
        사실 String 변수 역시 String이라는 자바 내부
        라이브러리에 정의되어 있는 클래스의 객체이기 때문입니다.
        앞으로 객체 지향을 열심히 하다 보면 알게 되지만,
        실상은 자료형과 클래스의 차이는 그다지 크지 않습니다.
        클래스 정의 파트 밖에서는 거의 똑같이 쓰게 될 겁니다. */
        int kor = 100;
        int eng = 100;
        int mat = 100;
        int tot = kor + eng + mat; // 세 기억장소에 저장된 값을 가지고 와서 더할 것
        // 이와 같은 연산을 산술연산이라 한다.
        // +: 더하기, -: 빼기, *: 곱하기, /: 나누기, %: 나눈 후의 나머지
        // 이 중에 %의 존재를 알아 두면 쓸모가 아주 많으니 기억해 두도록 합시다.
        double avg = tot / 3.; // 실수가 되려면 실수와 같이 연산해야 한다.
        String score = "A+";

        int bno22 = 22; // 변수를 선언한 다음에 처음으로 값을 대입하는 것을 '초기화'라고 한다.
        String name22 = "이순신";
        int kor22 = 90;
        int eng22 = 90;
        int mat22 = 90;
        int tot22 = kor22 + eng22 + mat22;
        double avg22 = tot22 / 3.;
        String score22 = "A";
        
        int bno33 = 33; // 정수 타입엔 정수가 들어간다. 실수를 넣으면 타입 오류(TypeError)가 뜬다.
        String name33 = "강감찬"; // 문자'열'타입에는 문자'열'만 들어간다. 단일 문자는 들어갈 수 없다.
        int kor33 = 80;
        int eng33 = 80;
        int mat33 = 80;
        int tot33 = kor33 + eng33 + mat33;
        double avg33 = tot33 / 3.;
        String score33 = "B";
        // 새로운 사람을 추가하려면 아예 새로운 기억장소들을 다 정의해 줘야 한다.
        // 뭔가 틀은 같은 거 같은데 쉬운 방법이 없을까나...?

        // 3. 출력
        System.out.println("\t\t성적표");
        System.out.println("번호\t이름\t국어\t영어\t수학\t총점\t평균\t학점");
        // 한 줄에 출력하고 싶으면 println이 아니라 print!
        System.out.println(bno + "\t" + name + "\t" + kor + "\t" + eng + "\t" + mat + "\t" + tot + "\t" + avg + "\t" + score);
        // print 메소드 안에 변수를 넣으면 변수에 저장된 값을 출력하라는 의미.
        /* print 메소드 안에서 변수는
        콘솔 화면에서의 출력을 위해 문자열이 됩니다.
        그리고 문자열끼리의 덧셈은 순서대로 쭉 나열해 놓는 것과 같습니다.
        즉 "가나"+"다라"="가나다라"가 된다는 뜻입니다.
        그러므로 위와 같이 bno+"\t"를 하게 되면
        bno의 값을 문자열화한 "11"과 제어문자인 "\t"를 더하여
        "11\t"가 되므로 출력은 11 다음에
        탭을 삽입한 형태가 되는 것입니다. */
        System.out.println(bno22 + "\t" + name22 + "\t" + kor22 + "\t" + eng22 + "\t" + mat22 + "\t" + tot22 + "\t" + avg22 + "\t" + score22); // 총점이랑 평균은 자동으로 계산이 되어 나옴을 알 수 있다.
        System.out.println(bno33 + "\t" + name33 + "\t" + kor33 + "\t" + eng33 + "\t" + mat33 + "\t" + tot33 + "\t" + avg33 + "\t" + score33);
    } // 열린 중괄호는 반드시 닫혀야 한다. 그렇지 않으면 문법 오류(Syntax Error)가 난다.

}

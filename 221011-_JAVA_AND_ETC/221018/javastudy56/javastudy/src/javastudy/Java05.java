package javastudy;

import java.util.Scanner; // [패키지 이름].[클래스 이름]

public class Java05 {
    
	public static void main(String[] args) {
		// Scanner: 콘솔로부터 데이터를 입력받는 기능을 제공하는 클래스
        // next(): 문자열, nextInt(): 정수, nextDouble(): 배정밀도 실수
        // Scanner 클래스를 쓰려면 Scanner 객체를 만들어야 한다. 그 명령어가 new다.
        Scanner sc = new Scanner(System.in);
        // new [클래스 이름]([입력값]) 이렇게 하면 클래스 내의 기본 생성자 함수를 불러내게 된다.
        System.out.print("整数xの値は?: ");
        int x = sc.nextInt();
        System.out.print("整数yの値は?: ");
        int y = sc.nextInt();
        int sum = x + y;
        System.out.println("x + y = " + sum + "です。");
	}

}

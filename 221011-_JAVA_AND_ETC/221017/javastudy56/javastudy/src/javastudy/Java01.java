package javastudy;

public class Java01 {

	public static void main(String[] args) {
		// 포워드슬래시 두 개로 한 줄을 주석처리하게 된다.
		/* 참고로 여러 줄 주석처리는 이렇게 한다. */
		/* 콘솔로 출력하고 싶다면 System.out.print(), 내지는 System.out.println()
		Java로 출력한 결과는 콘솔 메시지로 나온다. */
		System.out.print("안녕하세요"); // print 메서드는 콘솔 창에 괄호 안의 무언가를 출력하는 것.
		System.out.print("*"); // System.out은 그 print가 이루어지는 개체.
		System.out.print("**");
		System.out.print("***"); // 문장이 끝나면 반드시 세미콜론(;)을 찍어 두자.
		/* IDE는 수시로 컴파일을 하면서 문법적으로 틀린 부분이 있으면 빨간 줄을 쳐 준다.
		이 빨간 줄이 컴파일 에러라는 녀석이다. */
		/* 근데 System.out.print()는 너무나도 많이 사용된지라 자동완성도 지원한다.
		sysout을 치고 Ctrl+Space를 치면 System.out.println()이 자동 완성된다. */
		// 참고로 VSCode에서의 자동완성은 HTML의 emmet처럼 Tab이었다...
		// Eclipse의 코드 실행 단축키는 Ctrl+F11임을 발견했다.
		System.out.println("*");
		System.out.println("**");
		System.out.println("***"); // println은 출력을 하고 나서 줄 변경(line break)을 하게 된다.
	}

}

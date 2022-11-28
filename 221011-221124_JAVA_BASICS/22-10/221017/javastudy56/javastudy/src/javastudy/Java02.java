// 클래스를 만들 때 main 메서드는 체크해 두도록 하자. 자동으로 메인 메서드를 코딩해서 넣어 준다.
// 체크를 안 했다? 그냥 그럼 코딩해서 넣으면 된다.
package javastudy;

public class Java02 {

    public static void main(String args[]){
        // 그럼 이제 제어문자를 좀 알아보자.
        // 역슬래시 \는 백스페이스 아래쪽의 화폐기호 자판이다.
        // \t: Tab, \n: 줄 변경
        // 저장: Ctrl+'s', 이전 단계: Ctrl+'z', 다음 단계: Ctrl+'y'
        System.out.println("\t\t성적표");
		System.out.println("-------------------------------------------------------");
		System.out.println("번호\t이름\t국어\t영어\t수학\t총점\t평균");
		System.out.println("-------------------------------------------------------");
        System.out.println("11\t홍길동\t100\t100\t100\t300\t100.00");
        // 일반적인 코딩 테스트는 출력 결과물을 보여준 다음 이대로 출력되는 코드를 짜라고 하는 문제가 대부분이다.
    }

}

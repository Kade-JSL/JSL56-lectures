package javastudy;

public class Java30 {
    public static void main(String[] args){
        // 변수의 메모리에는 기본 타입과 참조 타입이 있다.
        // 기본 타입: 8개의 그... 거시기
        // 참조 타입: 주소를 통해서 객체를 참조함(e.g. String, 배열, 객체)
        // 배열: 같은 성격을 가진 자료를 기억시킬 수 있는 다수의 변수

        // 배열의 선언과 생성
        // 정수값을 저장하는 배열
        // int[] score; // 배열 선언
        // score = new int[10]; // 배열 객체 생성: 참조 타입은 객체를 생성해야지만 초기화할 수 있다.
        // int[] score = new int[10]; // 으로 한 문장으로 줄일 수도 있을 것이다.

        /*
        for (int i = 0; i < score.length; i++) { // 배열의 크기
            score[i] = 10 * (i + 1);
            System.out.print(score[i] + " ");
        }
        */

        /*
        int[] arr1 = new int[3];
        double[] arr2 = new double[3];
        String[] arr3 = new String[3];
        */

        /*
        arr1[0] = 10;
        arr1[1] = 20;
        arr1[2] = 30;
        arr1[3] = 40;
        */

        // void main(String[] args): 이건 매개변수라고 한다.
        // 컴파일 오류는 이클립스에서 실시간으로 컴파일을 하여 빨간 줄을 쳐 주는 거고,
        // (제 환경에선 VSCode지만 Code의 자바 확장도 이클립스 기반이기 때문에 그냥 같다고 보면 됩니다.)
        // 런타임 오류는 실행 중에 생기는 오류입니다.
        // 컴파일로는 파악할 수 없고 실행 중에 오류가 생기면 명령줄에 Exception을 띄운다. 

        /*
        arr2[0] = 0.1;
        arr2[1] = 10; // double 배열에 int가 들어가면 자동으로 double로 형변환(10.0)이 된다.
        // double은 64비트 실수 타입이고 int는 32비트 정수 타입이라 잘 맞아들어가는 것.
        arr2[2] = 0.3;
        for (int i = 0; i < arr2.length; i++) {
            System.out.println(arr2[i]);
        }
        */

        // 배열 선언과 동시에 초기화

        /*
        int[] intArr = {10, 20, 30, 40, 50}; // 중괄호 안에 넣는다
        // 이러면 배열 크기는 자동으로 5가 되고, 입력한 내용이 곧바로 배열에 저장됨
        for (int i = 0; i < intArr.length; i++) {
            System.out.println(intArr[i]);
        }
        */

        // 연습 문제:
        // 80, 90, 100이라는 정수 배열의 선언과 초기화를 하여 합계와 평균을 출력하시오.

        int[] scores = {80, 90, 100};
        int scoresSum = 0;
        for (int i = 0; i < scores.length; i++) {
            scoresSum += scores[i];
        }
        double scoresAvg = (double)scoresSum / (double)scores.length;
        System.out.println("합계: " + scoresSum + " 평균: " + scoresAvg);
    }    
}

package javastudy;

import java.util.Scanner;

// 무언가 캡슐화를 하려고 노력한 흔적

abstract class exampleConstants {
    int first, second;
    int sumMethodInitializingNumber = 0;
    int[] object03ScoreArray = new int[] {83, 90, 87};
}

interface exampleMethodsAdd {
    public int[] getParams();
    public int add (int[] s); // 매개변수 타입은 호출한 변수타입과 일치해야 한다
}

class Ob03 extends exampleConstants implements exampleMethodsAdd {
    int t = sumMethodInitializingNumber;
    public int[] getParams() {
        return object03ScoreArray;
    }
    public int add (int[] s) {
        for (int i : s) {
            t += i;
        }
        return t;
    }
    public void inputAndPrintBiggerInt() {
        Scanner sc = new Scanner(System.in);
        System.out.print("첫 번째 정수를 입력하세요: ");
        first = sc.nextInt();
        System.out.print("두 번째 정수를 입력하세요: ");
        second = sc.nextInt();
        if (first > second) {
            System.out.println(first + "은(는) " + second + "보다 큽니다.");
        } else {
            System.out.println(second + "은(는) " + first + "보다 큽니다.");
        }
        sc.close();
    }
}
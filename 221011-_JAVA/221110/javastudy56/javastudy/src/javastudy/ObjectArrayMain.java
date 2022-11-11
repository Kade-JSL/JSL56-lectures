package javastudy;

import java.util.Scanner;

public class ObjectArrayMain {

    static void rankObjectArrayByAvg(ObjectArray[] o) {
        for (int i = 0; i < o.length; i++) {
            for (int j = 0; j < o.length; j++) {
                if(o[i].avg < o[j].avg) o[i].rank++;
            }
        }
    }

    public static void main(String[] args) {
        ObjectArray[] arr = new ObjectArray[4];
        Scanner s = new Scanner(System.in);
        
        while (true) {
            // 프로그램 메뉴 구현
            System.out.println("\n정수를 입력하여 메뉴 선택:\n");
            System.out.println("[1] 레코드 입력하기");
            System.out.println("[2] 전체 출력하기");
            System.out.println("[other] 프로그램 종료");
            System.out.println("-----------------------------------");

            int a = s.nextInt();
            if (a != 1 && a != 2) { 
                break;
            } else if (a == 1) {
                for (int i = 0; i < arr.length; i++) {
                    arr[i] = new ObjectArray();
                    System.out.print((i + 1) + "번 학생의 번호: ");
                    arr[i].num = s.nextInt();
                    System.out.print((i + 1) + "번 학생의 이름: ");
                    arr[i].name = s.next();

                    // 점수 범위에 따라 재입력 프롬프트 출력
                    // foreach문
                    for (Subject sub : Subject.values()) {
                        while (true) {
                            arr[i].printScoresMsg(i, sub);
                            arr[i].setScores(s.nextInt(), sub);
                            if (arr[i].isScoresInRange()) {
                                break;
                            }
                        }
                    }

                    arr[i].setGradeByAvg();
                }
                rankObjectArrayByAvg(arr);
            } else if (a == 2) {
                arr[0].printTitleMsg();
                for (int i = 0; i < arr.length; i++) {
                    arr[i].printRecordMsg();
                }
            }
        }
        s.close();
    }
}

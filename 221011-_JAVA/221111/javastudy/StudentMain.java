package javastudy;

import java.util.Scanner;

public class StudentMain {
    public static void main(String[] args) {

        /* 객체 선언부 */
        Scanner scanner = new Scanner(System.in);

        System.out.print("오늘 시험 본 명수?: ");
        int studentNums = scanner.nextInt();
        Student[] arrStudents = new Student[studentNums];

        /* 메뉴가 반복되는 걸 무한반복으로 구현 */
        while (true) {

            /* 메뉴, 입력 */
            System.out.println("\nMenu\n[1] 입력\n[2] 출력\n[0, etc.] 종료");
            System.out.print("작업하고자 하는 번호를 입력하세요: ");

            int menuInput = scanner.nextInt(); // 메뉴 번호 입력

            if (menuInput != 1 && menuInput != 2) {
                break; // Scanner로 입력받은 값이 1이나 2가 아니면 무한반복 스코프 벗어남

            } else if (menuInput == 1) { // 입력받은 값이 1이면 입력부로 들어감

                /* 객체배열 입력부 */

                System.out.println("학생 " + studentNums + "명의 성적 입력을 시작합니다.");

                for (int in = 0; in < arrStudents.length; in++) { // 배열 길이만큼 객체를 만들어서 넣음
                    arrStudents[in] = new Student(); // 배열 요소 객체 생성
                    arrStudents[in].printSetterMsg(in, "번호");
                    arrStudents[in].num = scanner.nextInt();
                    arrStudents[in].printSetterMsg(in, "이름");
                    arrStudents[in].name = scanner.next();

                    /* 성적 입력부 */
                    for (Student.IntVarIndex var : Student.IntVarIndex.values()) { // 국어, 영어, 수학 성적 입력
                        while(true) { // 범위에 맞는 성적을 입력할 때까지 무한반복
                            arrStudents[in].printSetScoresMsg(in, var); // 입력을 받을 때 프롬프트 출력
                            arrStudents[in].setScores(scanner.nextInt(), var); // 실제로 입력을 받음
                            
                            if (!arrStudents[in].isScoreOutOfRange()) {
                                break; // 성적이 범위 안에 있으면 다음 과목 성적 입력으로 넘어감
                            }
                        }
                    }

                    /* 다른 변수도 정리 */
                    arrStudents[in].setGradeByAvg();
                }
                /* 객체들의 입력이 끝나면 순위를 정리 */
                sortRankByAvg(arrStudents);

            } else if (menuInput == 2) { // 입력값이 2면 출력부로 들어감
                
                /* 객체배열 출력부 */
                Student.printResultHeader();
                for (int i = 0; i < arrStudents.length; i++) {
                    arrStudents[i].printResultBody();
                }

            }
        }

        /* 무한반복문 밖, 종료를 입력한 뒤 */
        scanner.close(); // 그냥 노란 줄이 보기 싫었음
        System.out.println("프로그램을 종료합니다. 수고하셨습니다.");
    }

    static void sortRankByAvg(Student[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if(arr[i].avg < arr[j].avg) arr[i].rank++;
            }
        }
    }
}

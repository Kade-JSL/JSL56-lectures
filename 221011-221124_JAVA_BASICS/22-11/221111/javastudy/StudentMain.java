package javastudy;

import java.util.Scanner;

public class StudentMain {
    public static void main(String[] args) {

        /* 객체 선언부 */
        Scanner scanner = new Scanner(System.in);

        System.out.print("오늘 시험 본 명수?: ");
        int studentNums = scanner.nextInt();

        Student[] stuArr = new Student[studentNums];

        /* 메뉴가 반복되는 걸 무한반복으로 구현 */
        while (true) {

            /* 메뉴, 입력 */
            System.out.println("\nMenu\n[1] 입력\n[2] 출력\n[3] 내림차순 출력\n[4] 오름차순 출력\n[0, etc.] 종료");
            System.out.print("작업하고자 하는 번호를 입력하세요: ");

            int menuInput = scanner.nextInt(); // 메뉴 번호 입력

            // Scanner로 입력받은 값이 1이나 2가 아니면 무한반복 스코프 벗어남
            // (이후 수정) 3이나 4가 아니어도 스코프를 벗어나도록
            if (menuInput != 1 && menuInput != 2 && menuInput != 3 && menuInput != 4) {
                break;
            } else if (menuInput == 1) { // 입력받은 값이 1이면 입력부로 들어감

                /* 객체배열 입력부 */

                System.out.println("학생 " + studentNums + "명의 성적 입력을 시작합니다.");

                for (int index = 0; index < stuArr.length; index++) { // 배열 길이만큼 객체를 만들어서 넣음
                    stuArr[index] = new Student(); // 배열 요소 객체 생성
                    stuArr[index].printSetterMsg(index, "번호");
                    stuArr[index].num = scanner.nextInt();
                    stuArr[index].printSetterMsg(index, "이름");
                    stuArr[index].name = scanner.next();

                    /* 성적 입력부 */
                    for (Student.IntVarIndex var : Student.IntVarIndex.values()) { // 국어, 영어, 수학 성적
                                                                                   // 입력
                        while (true) { // 범위에 맞는 성적을 입력할 때까지 무한반복
                            stuArr[index].printSetScoresMsg(index, var); // 입력을 받을 때 프롬프트 출력
                            stuArr[index].setScores(scanner.nextInt(), var); // 실제로 입력을 받음

                            if (!stuArr[index].isScoreOutOfRange()) {
                                break; // 성적이 범위 안에 있으면 다음 과목 성적 입력으로 넘어감
                            }
                        }
                    }

                    /* 다른 변수도 정리 */
                    stuArr[index].setGradeByAvg();
                }
                /* 객체들의 입력이 끝나면 순위를 정리 */
                StudentArraySort.calcRankByAvg(stuArr);

            } else if (menuInput == 2) { // 입력값이 2면 출력부로 들어감

                /* 객체배열 출력부 */
                Student.printResultHeader();
                for (int i = 0; i < stuArr.length; i++) {
                    stuArr[i].printResultBody();
                }

            } else if (menuInput == 3) {

                /* 내림차순 출력부 */
                StudentArraySort.sortElementsByRank(stuArr);
                Student.printResultHeader();
                for (int i = stuArr.length - 1; i >= 0; i--) { // 인덱스를 거슬러 오른다
                    stuArr[i].printResultBody();
                }

            } else if (menuInput == 4) {

                /* 오름차순 출력부 */
                StudentArraySort.sortElementsByRank(stuArr);
                Student.printResultHeader();
                for (int i = 0; i < stuArr.length; i++) {
                    stuArr[i].printResultBody();
                }

            }
        }

        /* 무한반복문 밖, 종료를 입력한 뒤 */
        scanner.close(); // 그냥 노란 줄이 보기 싫었음
        System.out.println("프로그램을 종료합니다. 수고하셨습니다.");
    }


}

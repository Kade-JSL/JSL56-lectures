package javastudy;

import java.util.ArrayList;
import java.util.Scanner;

public class CustomMain {
    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        ArrayList<Custom> cArr = new ArrayList<Custom>();

        // 1번 회원가입, 2번 회원목록, 3번 전체출력, 4번 번호 내림차순 출력, 번호를 선택하세요
        while(true) {
            System.out.print("[1]회원가입\n[2]회원목록\n[3]번호 오름차순 출력\n[0 or etc.] 종료\n번호를 선택해 주세요 >> ");

            int menu = s.nextInt();
            if (
                menu != 1 &&
                menu != 2 &&
                menu != 3 
            ) {
                break;
            } else if (menu == 1) {

                while (true) {
                    String id = null,
                    name = null,
                    pw = null;
    
                    for (Custom.InputFields ifi : Custom.InputFields.values()) {
    
                        CustomProcess.printInputPrompt(ifi);
                        switch (ifi) {
                            case ID:
                                id = s.next(); break;
                            case NAME:
                                name = s.next(); break;
                            case PW:
                                pw = s.next(); break;
                        }
                    }
                    cArr.add(new Custom(id, name, pw));

                    System.out.println("현재 회원 명수: " + Custom.num + "명");
                    System.out.print("다음 회원도 입력하려면 1을 눌러주세요: ");
                    int stopInput = s.nextInt();
                    if (stopInput != 1) break;
                }
                

            } else if (menu == 2) {
                
                CustomProcess.printList(cArr);
                
            } else if (menu == 3) {

                // TODO 한 번 정렬을 하면 배열이 끝까지 정렬되어 버리는 문제 해결하기
                ArrayList<Custom> temp = new ArrayList<Custom>();
                temp = cArr;
                CustomProcess.ascCustomArrayList(temp);
                CustomProcess.printList(temp);

            }
        }

        System.out.println("프로그램을 종료합니다.");
        s.close();
    }   
}

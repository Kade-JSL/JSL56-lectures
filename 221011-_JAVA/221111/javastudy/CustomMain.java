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
                String id = null, name = null, pw = null;
                for (Custom.InputFields ifi : Custom.InputFields.values()) {
                    CustomProcess.printInputPrompt(ifi);
                    switch (ifi) {
                        case ID: id = s.next(); break;
                        case NAME: name = s.next(); break;
                        case PW: pw = s.next(); break;
                    }
                }
                cArr.add(new Custom(id, name, pw));
            } else if (menu == 2) {
                for (int i = 0; i < cArr.size(); i++) {
                    
                }
            }
        }

        s.close();
    }   
}

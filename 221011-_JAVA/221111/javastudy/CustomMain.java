package javastudy;

import java.util.ArrayList;
import java.util.Scanner;

public class CustomMain {
    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        ArrayList<Custom> cArr = new ArrayList<Custom>();

        // 1번 회원가입, 2번 회원목록, 3번 전체출력, 4번 번호 내림차순 출력, 번호를 선택하세요
        while(true) {
            System.out.print("[1]회원 생성\n[2]회원 로그인\n[3]관리자 로그인\n[0 or etc.] 종료\n번호를 선택해 주세요 >> ");

            int menu = s.nextInt();
            if (
                menu != 1 &&
                menu != 2 &&
                menu != 3 
            ) {
                break;
            } else if (menu == 1) {

                /* 회원 생성 */
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
                    System.out.print("입력을 계속하려면 1을 눌러주세요: ");
                    int stopInput = s.nextInt();
                    if (stopInput != 1) break;
                }
                

            } else if (menu == 3) {

                /* 관리자 메뉴 */
                System.out.println("관리자 계정으로 로그인합니다.");
                System.out.print("관리자 ID: ");
                String loginID = s.next();
                System.out.print("관리자 PW: ");
                String loginPW = s.next();
                while (CustomProcess.isAdminLogin(loginID, loginPW)) {
                    if (cArr.size() == 0) {
                        System.out.println("먼저 회원 생성을 해서 회원 목록을 생성해 주세요.");
                        break;
                    }
                    System.out.print("관리자 메뉴\n[1]회원 목록\n[2]번호 오름차순 회원 목록\n[3]회원 제거\n[4]관리자 정보 변경\n[0 or etc.]관리자 메뉴 나가기\n번호를 선택해 주세요>> ");

                    int adminMenu = s.nextInt();
                    if (
                        adminMenu != 1 &&
                        adminMenu != 2 &&
                        adminMenu != 3 &&
                        adminMenu != 4
                    ) {

                        break;

                    } else if (adminMenu == 1) {

                        CustomProcess.printList(cArr);

                    } else if (adminMenu == 2) {

                        ArrayList<Custom> temp = CustomProcess.ascCustomArrayList(cArr);
                        CustomProcess.printList(temp);

                    } else if (adminMenu == 3) {

                        while(true) {

                            CustomProcess.printList(cArr);
                            System.out.print("\n제거할 회원의 회원번호를 입력해 주세요 >> ");
                            int removeIndex = s.nextInt();
                            CustomProcess.removeMember(cArr, removeIndex);
                            System.out.println(removeIndex + " 번 회원이 제거되었습니다.");
                            System.out.print("계속 제거하려면 1을 눌러주세요: ");
                            int stopRemove = s.nextInt();
                            if (stopRemove != 1) { break; }
                        }
                    } else if (adminMenu == 4) {

                        System.out.print("관리자 PW 확인: ");
                        String confirmPW = s.next();
                        if (CustomProcess.isAdminLogin(loginID, confirmPW)) {
                            System.out.print("변경할 ID 입력\n(똑같이 입력하면 변경하지 않음): ");
                            String editID = s.next();
                            if (!editID.equals(Custom.getAdminID())) {
                                Custom.setAdminId(editID, loginID, confirmPW);
                                loginID = editID;
                            }
                            System.out.print("변경할 PW 입력\n(똑같이 입력하면 변경하지 않음): ");
                            String editPW = s.next();
                            if (!editID.equals(Custom.getAdminPW())) {
                                Custom.setAdminPw(editPW, editID, confirmPW);
                                loginPW = editPW;
                            }
                        }
                        System.out.println("성공적으로 관리자 정보를 변경했습니다.");
                    }
                }
                
                
            }
        }

        System.out.println("프로그램을 종료합니다.");
        s.close();
    }   
}

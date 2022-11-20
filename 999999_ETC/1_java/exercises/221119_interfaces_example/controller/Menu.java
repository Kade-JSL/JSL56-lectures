package controller;

import java.util.Scanner;

import dao.*;
import dto.*;

public class Menu {
    public static void main(String[] args) {
        GeneralActions g = GeneralActions.getInstance();
        Scanner s = new Scanner(System.in);
        while (true) {
            System.out.print(
                    "개발자들의 새로운 발전된 금융, 개발새발은행입니다.\n메뉴를 선택해 주세요.\n[1] 로그인\n[2] 신규 계좌 생성\n[3] 관리자 메뉴\n[other] 프로그램 종료\n---------------------------------------------------\n>> ");
            int login = s.nextInt();
            if (login == 1) {
                if (AccountList.getLength() == 0) {
                    System.out.println("아직 이 은행엔 계좌랄 게 없어요...\n");
                    continue;
                }
                System.out.print("계좌번호를 입력해 주세요 >> ");
                int num = s.nextInt();
                BankAccount a = g.numToAccount(num);
                if (a == null) {
                    System.out.println("없는 계좌번호입니다. 메뉴로 돌아갑니다.\n");
                    continue;
                } else {
                    g.passwordMatch(a);
                }
                while (true) {
                    System.out.print(
                            "계좌 메뉴\n[1] 입금\n[2] 출금\n[3] 이체\n[4] 이 계좌 제거\n[other] 로그아웃\n---------------------------------------------------\n>> ");
                    int menu = s.nextInt();
                    if (menu == 1) {
                        g.deposit(a);
                    } else if (menu == 2) {
                        g.withdraw(a);
                    } else if (menu == 3) {
                        g.transfer(a);
                    } else if (menu == 4) {
                        g.deleteAccount(a);
                    } else {
                        break;
                    }
                }
                System.out.println("로그아웃되었습니다.\n");
                continue;
            } else if (login == 2) {
                g.createAccount();
                continue;
            } else if (login == 3) {
                while (true) {
                    if (AccountList.getLength() == 0) {
                        System.out.println("아직 이 은행엔 계좌랄 게 없어요...\n");
                        break;
                    }
                    System.out.print(
                            "관리자 메뉴\n[1] 계좌 목록 출력(가입 순서순 정렬)\n[2] 계좌 목록 출력(계좌번호순 출력)\n[3] (테스트용임시)비밀번호 목록 출력\n[other] 이전 메뉴로 돌아가기\n---------------------------------------------------\n>> ");
                    int adminMenu = s.nextInt();
                    if (adminMenu == 1) {
                        System.out.println(
                                "계좌 목록\n타입\t계좌번호\t\t예금주\t잔액\n---------------------------------------------------");
                        for (int i = 0; i < AccountList.getLength(); i++) {
                            g.readAccount(AccountList.getList()[i]);
                        }
                        System.out.println();
                    } else if (adminMenu == 2) {
                        AccountList.sortItAndPrintIt();
                    } else if (adminMenu == 3) {
                        for (int i = 0; i < AccountList.getLength(); i++) {
                            System.out.println("(테스트용임시)비번: " + AccountList.getList()[i].getPassword());
                        }
                    } else {
                        break;
                    }
                }
            } else {
                break;
            }
        }
        System.out.println("프로그램을 종료합니다. 이용해 주셔서 감사합니다.");
        s.close();
    }
}

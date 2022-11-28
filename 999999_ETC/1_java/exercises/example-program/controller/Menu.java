package controller;

import java.util.Scanner;
import dao.*;
import dto.*;

public class Menu {
    public static void main(String[] args) {
        GeneralActions genAct = GeneralActions.getInstance();
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.print(
                    "개발자들의 새로운 발전된 금융, 개발새발은행입니다.\n메뉴를 선택해 주세요.\n[1] 로그인\n[2] 신규 계좌 생성\n[3] 관리자 메뉴\n[other] 프로그램 종료\n---------------------------------------------------\n>> ");
            int login = sc.nextInt();
            // if (login == 1) {
            //     System.out.print("계좌번호를 입력해 주세요 >> ");
            //     int num = sc.nextInt();
            //     BankAccount a = genAct.numToAccount(num);
            //     if (a == null) {
            //         System.out.println("없는 계좌번호입니다. 메뉴로 돌아갑니다.\n");
            //         continue;
            //     } else {
            //         genAct.passwordMatch(a);
            //     }
            //     while (true) {
            //         System.out.print(
            //                 "계좌 메뉴\n[1] 입금\n[2] 출금\n[3] 이체\n[4] 이 계좌 제거\n[other] 로그아웃\n---------------------------------------------------\n>> ");
            //         int menu = sc.nextInt();
            //         if (menu == 1) {
            //             genAct.deposit(a);
            //         } else if (menu == 2) {
            //             genAct.withdraw(a);
            //         } else if (menu == 3) {
            //             genAct.transfer(a);
            //         } else if (menu == 4) {
            //             genAct.deleteAccount(a);
            //         } else break;      
            //     }
            //     System.out.println("로그아웃되었습니다.\n");
            //     continue;
            // } else
            if (login == 2) {
                BankAccount a = new LiteAccount();
                System.out.printf("[임시 메뉴] 계좌 생성\n계좌번호: %d\n비밀번호: %d\n예금주명 입력\n>> ", a.getAccountNum(), a.getPassword());
                a.setOwnerName(sc.next());
                System.out.print("초기 입금액 입력 >> ");
                a.setBalance(sc.nextInt());
                genAct.createAccount(a);
            }
            // else if (login == 3) {
            //     while (true) {
            //         System.out.print(
            //                 "관리자 메뉴\n[1] 계좌 목록 출력(가입 순서순 정렬)\n[2] 계좌 목록 출력(계좌번호순 출력)\n[3] (테스트용임시)비밀번호 목록 출력\n[other] 이전 메뉴로 돌아가기\n---------------------------------------------------\n>> ");
            //         int adminMenu = sc.nextInt();
            //         if (adminMenu == 1) {
            //             System.out.println(
            //                     "계좌 목록\n타입\t계좌번호\t\t예금주\t잔액\n---------------------------------------------------");
            //             for (int i = 0; i < genAct.getList().size(); i++) {
            //                 genAct.readAccount(genAct.getList().get(i));
            //             }
            //             System.out.println();
            //         } else if (adminMenu == 2) {
            //             GeneralActions.sortItAndPrintIt();
            //         } else if (adminMenu == 3) {
            //             for (BankAccount a : genAct.getList()) {
            //                 System.out.println(a.getAccountNum() + " 계좌 비번: " + a.getPassword());
            //             }
            //         } else {
            //             break;
            //         }
            //     }
            // }
            else {
                break;
            }
        }
        System.out.println("프로그램을 종료합니다. 이용해 주셔서 감사합니다.");
        sc.close();
    }
}

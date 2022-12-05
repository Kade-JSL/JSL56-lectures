package controller;

import java.util.Scanner;
import dao.NoticeDao;
import dto.NoticeDto;

public class NoticeMain {
    public static void main(String[] args) {
        
        NoticeDao ndao = NoticeDao.getNoticeDao();
        Scanner sc = new Scanner(System.in);

        boolean run = true;
        while (run) {
            System.out.print("[1] 글쓰기 / [0] 종료\n>> ");
            int menu = sc.nextInt();
            switch (menu) {
                case 1:
                    NoticeDto nd = new NoticeDto();
                    nd.setBno(ndao.getContentNum() + 1);
                    System.out.print("제목\n>> ");
                    nd.setTitle(sc.next());
                    System.out.print("작성자\n>> ");
                    nd.setName(sc.next());
                    System.out.print("내용\n>> ");
                    nd.setContent(sc.next());
                    ndao.newContent(nd);
                    break;
                case 0: System.out.println("프로그램을 종료합니다."); run = false; break;
                default: continue;
            }
        }

        sc.close();
    }
}

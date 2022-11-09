package javastudy;

import java.util.Scanner;

class Notice {
    int bno, viewcount, favcount;
    String title, content, name, regdate;
    Scanner s = new Scanner(System.in);

    public Notice() {
        // 생성자는 리턴 타입을 지정할 수 없다.
        // 리턴 타입이 없다고 해서 void를 리턴 타입으로 지정해서는 안 된다.
        // 객체가 생성될 때 객체 내부 속성들을 초기화하기 위한 메서드
        // 클래스가 생성자가 하나도 선언되지 않은 경우 컴파일러에 의해 자동으로 기본생성자가 삽입됨
        // 개발자가 생성자를 하나라도 만들면 기본 생성자는 자동으로 삽입되지 않음 
    }
    public Notice(int bno, String title, String content, String name, String regdate) {
        setBno(bno);
        setTitle(title);
        setContent(content);
        setName(name);
        setRegdate(regdate);
        setViewcount(0);
        setFavcount(0);
    }

    public void noticeInput() {
        System.out.print("게시물 번호: ");
        setBno(s.nextInt());
        System.out.print("게시물 제목: ");
        setTitle(s.next());
        System.out.print("게시물 작성자: ");
        setName(s.next());
        System.out.print("게시물 작성 시간: ");
        setRegdate(s.next());
        System.out.print("게시물 내용을 입력하세요: ");
        setContent(s.next());
    }

    public void titlePrint() {
        System.out.println("공지사항");
        System.out.println("번호\t제목\t글쓴이\t날짜\t조회수\t추천수");
    }
    public void viewPrint() {
        System.out.println(getBno() + "\t" + getTitle() + "\t" + getName() + "\t" + getRegdate() + "\t" + getViewcount() + "\t" + getFavcount());
    }

    /* getter와 setter들 */
    public void setBno(int bno) {
        this.bno = bno;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public void setContent(String content) {
        this.content = content;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setRegdate(String regdate) {
        this.regdate = regdate;
    }
    public void setViewcount(int viewcount) {
        this.viewcount = viewcount;
    }
    public void setFavcount(int favcount) {
        this.favcount = favcount;
    }
    public int getBno() {
        return bno;
    }
    public String getContent() {
        return content;
    }
    public int getFavcount() {
        return favcount;
    }
    public String getName() {
        return name;
    }
    public String getRegdate() {
        return regdate;
    }
    public String getTitle() {
        return title;
    }
    public int getViewcount() {
        return viewcount;
    }
}

public class NoticeWrite {
    public static void main(String[] args) {
        Notice n = new Notice();

        n.noticeInput();
        System.out.println();

        n.titlePrint();
        n.viewPrint();
    }
}

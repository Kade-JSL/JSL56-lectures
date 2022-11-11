package javastudy;

public class CustomProcess {
    static void printInputPrompt(Custom.InputFields f) {
        String msg = null;
        switch (f) {
            case ID: msg = "아이디"; break;
            case NAME: msg = "이름"; break;
            case PW: msg = "비밀번호"; break;
        }
        System.out.print(msg + " 입력: ");
    }
    static void printListHeader() {
        System.out.println("\t회원 목록");
        System.out.println();
    }
}

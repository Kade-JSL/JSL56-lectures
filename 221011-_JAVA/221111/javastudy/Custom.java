package javastudy;

abstract class CustomAdmin {
    private static String adminID = "admin";
    private static String adminPW = "1234";

    static void setAdminId(String id, String authId, String authPw) {
        if (authId.equals(adminID) && authPw.equals(adminPW)) {
            adminID = id;
        } else {
            System.out.println("관리자 아이디 또는 비밀번호가 틀렸습니다.");
        }
    }
    static void setAdminPw(String pw, String authId, String authPw) {
        if (authId.equals(adminID) && authPw.equals(adminPW)) {
            adminPW = pw;
        } else {
            System.out.println("관리자 아이디 또는 비밀번호가 틀렸습니다.");
        }
    }
    static String getAdminID() { return adminID; }
    static String getAdminPW() { return adminPW; }
}

public class Custom extends CustomAdmin{
    
    int instNum;
    String name, id, pw;

    static int num;

    static enum OutputFields {
        NUM,
        ID,
        NAME
    }
    static enum InputFields {
        ID,
        NAME,
        PW
    }

    public Custom() {
        num++;

        this.instNum = (int)(10000 * Math.random());
    }
    public Custom(String id, String name, String pw) {
        num++;
        
        this.instNum = (int)(10000 * Math.random());
        this.id = id;
        this.name = name;
        this.pw = pw;
    }
}

package javastudy;

public class Custom {
    static int num;
    static enum OutputFields { NUM, ID, NAME }
    static enum InputFields { ID, NAME, PW }
    int instNum;
    String name, id, pw;

    public Custom() {
        num++;
        this.instNum = num;
    }
    public Custom(String id, String name, String pw) {
        num++;
        this.instNum = num;
        this.id = id;
        this.name = name;
        this.pw = pw;
    }
}

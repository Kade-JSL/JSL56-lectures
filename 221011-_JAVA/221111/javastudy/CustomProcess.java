package javastudy;

import java.util.ArrayList;

class CustomProcess {

    static boolean isMemberLogin(Custom member, String id, String pw) {

        return false;
    }

    /* 관리자 계정 */
    static boolean isAdminLogin(String id, String pw) {

        if (id.equals(Custom.getAdminID()) && pw.equals(Custom.getAdminPW())) {
            return true;
        } else {
            System.out.println("관리자 ID 혹은 PW가 틀렸습니다.");
            return false;
        }
    }

    static void removeMember(ArrayList<Custom> o, int n) {

        for (int i = 0; i < o.size(); i++) {
            if (o.get(i).instNum == n) {
                o.remove(i);
                break;
            }
        }
    }

    /* 출력 메서드 */
    static void printInputPrompt(Custom.InputFields f) {

        String msg = null;
        switch (f) {
            case ID:
                msg = "아이디";
                break;
            case NAME:
                msg = "이름";
                break;
            case PW:
                msg = "비밀번호";
                break;
        }
        System.out.print(msg + " 입력: ");
    }

    static void printListHeader() {
        System.out.println("\n\t회원 목록");
        System.out.println("번호\t아이디\t이름");
    }

    static void printList(ArrayList<Custom> o) {

        if (o.size() != 0) {
            printListHeader();

            for (int i = 0; i < o.size(); i++) {
                for (Custom.OutputFields f : Custom.OutputFields.values()) {
                    switch (f) {
                        case NUM:
                            System.out.print(o.get(i).instNum + "\t");
                            break;
                        case ID:
                            System.out.print(o.get(i).id + "\t");
                            break;
                        case NAME:
                            System.out.print(o.get(i).name);
                            break;
                    }
                }
                System.out.println();
            }
        } else {
            System.out.println("출력할 회원이 없습니다.");
        }
    }

    static ArrayList<Custom> ascCustomArrayList(ArrayList<Custom> p) {

        ArrayList<Custom> r = new ArrayList<Custom>();
        for (int i = 0; i < p.size(); i++) {
            r.add(p.get(i));
        }
        for (int i = 0; i < r.size(); i++) {
            for (int j = i; j < r.size(); j++) {
                if (r.get(i).instNum > r.get(j).instNum) {
                    Custom temp = r.get(i);
                    r.set(i, r.get(j));
                    r.set(j, temp);
                }
            }
        }
        return r;
    }
}

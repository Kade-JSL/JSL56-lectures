package javastudy;

import java.util.ArrayList;

class CustomProcess {

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
        System.out.println("\n\t회원 목록");
        System.out.println("번호\t아이디\t이름");
    }

    static void printList(ArrayList<Custom> o) {
        if (o.size() != 0) {
            printListHeader();
            for (int i = 0; i < o.size(); i++) {
                System.out.println(o.get(i).instNum + "\t" + o.get(i).id + "\t" + o.get(i).name);
            }
        } else {
            System.out.println("출력할 회원이 없습니다.");
        }
    }

    static void ascCustomArrayList(ArrayList<Custom> r) {
        for (int i = 0; i < r.size(); i++) {
            for (int j = i; j < r.size(); j++) {
                if (r.get(i).instNum > r.get(j).instNum) {
                    Custom temp = r.get(i);
                    r.set(i, r.get(j));
                    r.set(j, temp);
                }
            }
        }
    }
}

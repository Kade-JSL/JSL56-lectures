package controller;

import java.util.Scanner;
import dto.InheritDtoChild;

public class InheritMain {
    
    public static void main(String[] args) {

        InheritDtoChild idc = new InheritDtoChild();

        Scanner s = new Scanner(System.in);
        System.out.print("a 입력: ");
        idc.setA(s.nextInt()); // 상속받은 메서드
        System.out.print("b 입력: ");
        idc.setB(s.nextInt()); // 상속받은 메서드

        idc.add(); // 상속받은 메서드 
        idc.sub(); // 상속받은 메서드

        idc.mul(); // 새로 쓴 메서드
        idc.div(); // 새로 쓴 메서드

        s.close();
    }

}

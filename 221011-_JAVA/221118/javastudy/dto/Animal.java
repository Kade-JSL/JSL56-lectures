package dto;

public class Animal { // 상위 클래스
    
    public Animal next;
    public Animal() { next = null; }

    public void nakigoe() {
        System.out.println("/* animal sound */");
    }
}

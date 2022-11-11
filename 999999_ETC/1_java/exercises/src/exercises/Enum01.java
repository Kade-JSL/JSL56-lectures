package exercises;

enum Level {
    LOW,
    MEDIUM,
    HIGH
}

public class Enum01 {
    enum Meow {
        LowMeow,
        MedMeow,
        HiMeow
    }
    public static void main(String[] args) {
        Level myVar = Level.MEDIUM;
        Meow myCat = Meow.HiMeow;
        System.out.println(myVar + " " + myCat);

        // switch문에서의 활용
        switch(myVar) {
            case LOW:
                System.out.println("meow...");
                break;
            case MEDIUM:
                System.out.println("Meow.");
                break;
            case HIGH:
                System.out.println("Meow meow!");
        }

        // values() 메서드를 이용한 for문에서의 활용
        for (Level m : Level.values()) {
            System.out.println(m);
        }
    }    
}

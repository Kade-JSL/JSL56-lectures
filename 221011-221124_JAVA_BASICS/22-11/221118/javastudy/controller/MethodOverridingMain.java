package controller;

import dto.*;
// import dto.Person; import dto.Professor; import dto.HighSchoolStudent;

public class MethodOverridingMain {

    public static void main(String[] args) {

        // Person personKade = new Person("케이드", 29);
        // Professor profKade = new Professor("케이드", 39, "물리학");
        // HighSchoolStudent studentKade = new HighSchoolStudent("케이드", 19, "이과", 3);

        // personKade.printInfo(); // 오버라이드된 메서드 호출
        // profKade.printInfo();
        // studentKade.printInfo();

        /* 오버라이드로써의 다형성 구현 */
        AnimalDog dog = new AnimalDog();

        AnimalOverride.nakigoe(dog);
        AnimalOverride.nakigoe(new AnimalCat());
        AnimalOverride.nakigoe(new AnimalPig());
    }

}

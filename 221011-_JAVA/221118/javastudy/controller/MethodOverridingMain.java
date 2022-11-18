package controller;

//import dto.*;
import dto.Person; import dto.Professor; import dto.HighSchoolStudent;

public class MethodOverridingMain {

    public static void main(String[] args) {

        Person personKade = new Person("케이드", 29);
        Professor profKade = new Professor("케이드", 39, "물리학");
        HighSchoolStudent studentKade = new HighSchoolStudent("케이드", 19, "이과", 3);

        personKade.printInfo();
        profKade.printInfo();
        studentKade.printInfo();

    }

}

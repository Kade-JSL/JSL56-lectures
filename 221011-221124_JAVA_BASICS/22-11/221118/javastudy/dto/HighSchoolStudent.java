package dto;

public class HighSchoolStudent extends Person {
    
    private String majorClass;
    private int grade;

    public HighSchoolStudent(String name, int age, String majorClass, int grade) {
        super(name, age);
        this.majorClass = majorClass;
        this.grade = grade;
    }

    @Override
    public void printInfo() {
        System.out.println("<학생>");
        System.out.printf("이름: %s\n", name);
        System.out.printf("나이: %d\n", age);
        System.out.printf("학과: %s\n", majorClass);
        System.out.printf("학년: %d학년\n", grade);
    }
}

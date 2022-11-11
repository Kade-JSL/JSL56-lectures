package javastudy;

abstract class StudentVars { // 멤버 변수들의 목록
    int num, kor, eng, mat, tot, rank;
    String name, grade;
    double avg;
    enum IntVarIndex { kor, eng, mat } // 멤버 변수를 편하게 입력받기 위해 enum 정의
    abstract boolean isScoreOutOfRange();
}

class Student extends StudentVars {
    public void printSetterMsg(int arrIndex, String msg) { // 앞의 값들을 입력할 떄 프롬프트에 출력되는 메시지
        System.out.print((arrIndex + 1) + "번 학생의 " + msg + " 입력: ");
    }
    public void printSetScoresMsg(int arrIndex, IntVarIndex v) { // 성적을 입력할 때 프롬프트에 출력되는 메시지
        String memberString = null;
        switch (v) {
            case kor: memberString = "국어"; break;
            case eng: memberString = "영어"; break;
            case mat: memberString = "수학"; break;
        }
        System.out.print((arrIndex + 1) + "번 학생의 " + memberString + " 입력: ");
    }
    public void setScores(int setVal, IntVarIndex v) { // 성적을 실제로 입력하는 메서드
        switch (v) {
            case kor: this.kor = setVal; break;
            case eng: this.eng = setVal; break;
            case mat: this.mat = setVal; break;
        }
        if (isScoreOutOfRange()) {
            System.out.println("점수가 범위를 벗어났습니다. 다시 입력해 주세요.");
        }
    }

    public boolean isScoreOutOfRange() { // 성적 변수들이 범위 밖에 있는지 없는지 판단하는 합수
        if (kor > 100 || kor < 0 || eng > 100 || eng < 0 || mat > 100 || mat < 0) {
            return true;
        } else {
            return false;
        }
    }
    public void setGradeByAvg() {
        tot = kor + eng + mat;
        avg = (double)tot / 3.;
        if (avg >= 90) {
            grade = "A";
        } else if (avg >= 80) {
            grade = "B";
        } else if (avg >= 70) {
            grade = "C";
        } else if (avg >= 60) {
            grade = "D";
        } else {
            grade = "F";
        }
        rank = 1;
    }

    public static void printResultHeader() { // 결과 출력 헤더
        System.out.println("\t\t성적표");
        System.out.println("번호\t이름\t국어\t영어\t수학\t총점\t평균\t학점\t등수");
    }
    public void printResultBody() { // 레코드 결과 출력
        System.out.println(num + "\t" + name + "\t" + kor + "\t" + eng + "\t" + mat + "\t" + tot + "\t" + avg + "\t" + grade  + "\t" + rank);
    }
}
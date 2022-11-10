package javastudy;

enum Subject { kor, eng, mat }

public class ObjectArray {
    int num;
    String name;
    int kor, eng, mat;
    int tot;
    double avg;
    String grade;
    int rank;
    String errorMsgString = "점수가 범위를 벗어났습니다. 다시 입력해 주세요.";

    public ObjectArray() {}
    public ObjectArray(int num, String name, int kor, int eng, int mat) {
        this.num = num;
        this.name = name;
        this.kor = kor; this.eng = eng; this.mat = mat;
        setGradeByAvg();
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

    public void setScores(int s, Subject sub) {
        switch (sub) {
            case kor: this.kor = s; break;
            case eng: this.eng = s; break;
            case mat: this.mat = s; break;
        }
        if (s > 100 || s < 0) {
            System.out.println(errorMsgString);
        }
    }

    public boolean isScoresInRange() {
        if (kor > 100 || eng > 100 || mat > 100 || kor < 0 || eng < 0 || mat < 0) {
            return false;
        } else {
            return true;
        }
    }

    public void printScoresMsg(int objectArrayIndex, Subject sub) {
        String scoresMsg = null;
        switch (sub) {
            case kor: scoresMsg = "국어"; break;
            case eng: scoresMsg = "영어"; break;
            case mat: scoresMsg = "수학";
        }
        System.out.print((objectArrayIndex + 1) + "번 학생의 " + scoresMsg + " 점수: ");
    }
    public void printTitleMsg() {
        System.out.println("\t\t성적표");
        System.out.println("번호\t이름\t국어\t영어\t수학\t총점\t평균\t학점\t성적");
    }
    public void printRecordMsg() {
        System.out.println(num + "\t" + name + "\t" + kor + "\t" + eng + "\t" + mat + "\t" + tot + "\t" + avg + "\t" + grade + "\t" + rank);
    }
}

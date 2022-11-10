package javastudy;

import java.util.Scanner;

class ObjectArray {
    int num;
    String name;
    int kor, eng, mat;
    int tot;
    double avg;
    String grade;
    int rank;

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

    public void printTitleMsg() {
        System.out.println("\t\t성적표");
        System.out.println("번호\t이름\t국어\t영어\t수학\t총점\t평균\t학점\t성적");
    }
    public void printRecordMsg() {
        System.out.println(num + "\t" + name + "\t" + kor + "\t" + eng + "\t" + mat + "\t" + tot + "\t" + avg + "\t" + grade + "\t" + rank);
    }
}

public class ObjectArrayMain {
    static void rankObjectArrayByAvg(ObjectArray[] o) {
        for (int i = 0; i < o.length; i++) {
            for (int j = 0; j < o.length; j++) {
                if(o[i].avg < o[j].avg) o[i].rank++;
            }
        }
    }
    public static void main(String[] args) {
        ObjectArray[] arr = new ObjectArray[4];
        String[] msg = new String[] {
            "번호", "이름", "국어", "영어", "수학"
        };
        
        int c = 0;
        Scanner s = new Scanner(System.in); 
        while(c < arr.length) {
            System.out.print((c + 1) + "번 학생의 " + msg[0] + ": ");
            int num = s.nextInt();
            System.out.print((c + 1) + "번 학생의 " + msg[1] + ": ");
            String name = s.next();
            System.out.print((c + 1) + "번 학생의 " + msg[2] + ": ");
            int kor = s.nextInt();
            System.out.print((c + 1) + "번 학생의 " + msg[3] + ": ");
            int eng = s.nextInt();
            System.out.print((c + 1) + "번 학생의 " + msg[4] + ": ");
            int mat = s.nextInt();

            arr[c] = new ObjectArray(num, name, kor, eng, mat);
            c++;
        }

        rankObjectArrayByAvg(arr);

        arr[0].printTitleMsg();
        for (int i = 0; i < arr.length; i++) {
            arr[i].printRecordMsg();
        }

        s.close();
    }
}

# 변수에 대하여:[about_variables.md](/221011-221202_JAVA_BASICS/22-10/221020/about_variables.md)

- [Java11.java](/221011-221202_JAVA_BASICS/22-10/221020/javastudy56/javastudy/src/javastudy/Java11.java): 변수 덮어쓰기, `++`, `--`
- [Java12.java](/221011-221202_JAVA_BASICS/22-10/221020/javastudy56/javastudy/src/javastudy/Java12.java): 축약된 연산과 대입 `*=`
- [Java13.java](/221011-221202_JAVA_BASICS/22-10/221020/javastudy56/javastudy/src/javastudy/Java13.java): `if`, `else`문
- [Java14.java](/221011-221202_JAVA_BASICS/22-10/221020/javastudy56/javastudy/src/javastudy/Java14.java)
    - `if`, `else`문 실습
    - `String msg = "";`: 코드를 간단하게 쓰는 법을 다시금 리마인드
- [Java15.java](/221011-221202_JAVA_BASICS/22-10/221020/javastudy56/javastudy/src/javastudy/Java15.java): `else if`문

---

# 제어문

- 프로그램의 순차적인 실행 순서를 변경시키는 것
- 조건문
    - `if`
        - `else if`
    - `switch`
- 반복문
    - `for`
    - `while`
    - `do-while`
    - 간단 `for`문
- 분기문
    - `break`
    - `continue`
- 제어문들의 사용은 예제 코드에서 해 보자.

# 연습 문제

```Java
// 학번 bno, 이름 name, 점수 score를 입력받아
// 점수가 90점 이상이면 A+ 학점,
// 점수가 85점 이상 90점 미만이면 A 학점,
// 점수가 80점 이상 85점 미만이면 B+ 학점,
// 점수가 75점 이상 80점 미만이면 B 학점,
// 점수가 70점 이상 75점 미만이면 C+ 학점,
// 점수가 65점 이상 70점 미만이면 C 학점,
// 65점 미만의 점수는 재시험을 출력하기
// 입력예:
// 학번: 1111 \n 이름: 홍길동 \n 점수: 76
// 출력예:
// 학점: C학점
```

### 답안
```Java
package javastudy;

import java.util.Scanner;

public class Java16 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("학번: ");
        int bno = sc.nextInt();
        System.out.print("이름: ");
        String name = sc.next();
        System.out.print("점수: ");
        int score = sc.nextInt();

        String grade = "";
        if (score >= 90) {
            grade = "A+";
        } else if (score >= 85) {
            grade = "A";
        } else if (score >= 80) {
            grade = "B+";
        } else if (score >= 75) {
            grade = "B";
        } else if (score >= 70) {
            grade = "C+";
        } else if (score >= 65) {
            grade = "C";
        } else {
            grade = "재시험";
        }

        System.out.println("\t성적표");
        System.out.println("-----------------------------");
        System.out.println("번호\t이름\t점수\t학점");
        System.out.println(bno + "\t" + name + "\t" + score + "\t" + grade);
    }

}
```

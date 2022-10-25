# 이날 배웠던 것

- 링크를 클릭하면 각 주제별 실습 코드로 이동합니다.
- [`else if`문 복습](/221011-_JAVA_AND_ETC/221021/javastudy56/javastudy/src/javastudy/Java17.java)
- [`switch`, `case`문](/221011-_JAVA_AND_ETC/221021/javastudy56/javastudy/src/javastudy/Java18.java)
- [`switch`, `case`문 연습 문제(계산기 만들기)](/221011-_JAVA_AND_ETC/221021/javastudy56/javastudy/src/javastudy/Java19.java)
- [`java.text.DecimalFormat` 클래스](/221011-_JAVA_AND_ETC/221021/javastudy56/javastudy/src/javastudy/Java20.java)
- [`switch`, `case`문 연습 문제(가위바위보)](/221011-_JAVA_AND_ETC/221021/javastudy56/javastudy/src/javastudy/Java21.java)
- [`for`문](/221011-_JAVA_AND_ETC/221021/javastudy56/javastudy/src/javastudy/Java22.java)

---

# Switch - Case 조건문

- 조건식의 값에 따라 여러 개의 경우들 중에서 하나를 선택하여 처리하도록 하는 조건문.
- 예제:
    ```java
    switch (식) {
        case 값1:
            break;
        case 값2:.
            break;
        default:
    }
    ```
    - 식에는 문자 하나, 또는 정수만 넣을 수 있다. 실수는 넣을 수 없다.
    - `break`: 조건문 괄호 밖을 벗어나는 구문
        - `break`문이 없으면 다음 case문을 계속 실행한다
    - `printf`: print format의 약자 정도로 생각하면 된다. *C언어에서 넘어온 듯합니다.*
        - `%d`: decimal. 십진수로 출력하라.
        - `%c`: `char` 형식 출력
        - `%s`: `String` 형식 출력
- 다중 `if`(`else if`)문을 사용하게 되면 조건이 많아질 때 범위를 특정하기 쉽지 않다.

# DecimalFormat 클래스

- `java.text` 패키지 내에 존재
- 주어진 패턴 문자열의 형태로 데이터를 형식화하여 출력
- `format()` 메서드를 이용하여 데이터를 형식화함
    ```java
    import java.text.DecimalFormat;
    ...
    DecimalFormat fmt = new DecimalFormat(패턴 문자열);
    ```
- 이 때 **패턴 문자열**은 `#`과 `0`을 사용해서 처리한다.
    - *엑셀의 셀 서식에서 본 적이 있는 사람도 있을 겁니다.*
    - `"#,###.000"`: 세 자리마다 쉼표, 소수점 아래는 세 자리까지
- `fmt.format(포매팅하고 싶은 변수)`: 형식화된 변수를 `String`으로 변환하여 출력할 수 있게 해 줌
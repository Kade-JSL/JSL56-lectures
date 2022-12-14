# 이날 배웠던 것

- [Java04.java](/221011-221202_JAVA_BASICS/22-10/221018/javastudy56/javastudy/src/javastudy/Java04.java)
    - `main()` 메서드의 의미를 배웠습니다.
    - 코딩을 할 때에 하면 좋을 생각 순서(선언-처리-출력)에 대해서 배웠습니다.
    - 제어 문자와 `+` 연산자를 조합한 출력에 대해서 배웠습니다.
- [Java05.java](/221011-221202_JAVA_BASICS/22-10/221018/javastudy56/javastudy/src/javastudy/Java05.java)
    - `java.util` 패키지의 `Scanner` 클래스 객체를 만드는 방법을 배웠습니다.
    - 콘솔 화면에서 값을 입력받아 변수에 저장하는 방법을 배웠습니다.
- [Java06.java](/221011-221202_JAVA_BASICS/22-10/221018/javastudy56/javastudy/src/javastudy/Java06.java): 이 때까지 배운 내용을 연습문제로써 코딩해 보았습니다.
- [Java07.java](/221011-221202_JAVA_BASICS/22-10/221018/javastudy56/javastudy/src/javastudy/Java07.java): 역시나 연습문제.

---

## 자바를 쓰는 이유?

- 많이 쓰는 3개의 언어가 대체로 자바랑 C랑 파이썬인데
    - 셋 다 연산자가 있다.
    - 셋 다 객체지향적이다.
- 그리고 자바를 한 번 배워놓으면 당연히 다른 언어를 배우기가 더 수월해진다.

## 클래스란?

- 클래스 이름 첫 글자는 대문자!
    - 이건 관례(convention)이다.
    - 그렇게 안 쓴다고 오류 내진 않는다.
    - 컨벤션을 잘 지키면 읽기 좋은 코드를 만들 수 있고, 읽기 좋은 코드는 협업의 생산성을 증대시킨다.
- 클래스로 만드는 객체(인스턴스)의 설계도.
    - 어떤 빌딩을 여러 개 짓고 싶다면 그 빌딩의 설계도는 하나만 있어도 몇 개고 지을 수 있을 것이다.
    - 또 붕어빵을 여러 개 굽고 싶을 때도 붕어빵 틀 하나만 있으면 같은 모양의 붕어빵은 몇 개고 나올 것이다.
- **public static void main(String args[])**
    - public: 누구나 접근 가능한 메서드라는 **접근 제한자**
        - *영어사전 뜻: 대중의, 공공의*
    - static: 객체를 생성하지 않고 사용 가능한 메서드라는 뜻
        - *영어사전 뜻: 정적인, 정지한*
    - void: 메서드를 실행한 후 리턴을 해 줄 값이 없음
        - *영어사전 뜻: 빈 공간, 공허감*
        - 예컨대:
        ```java
        class A {
            void kbs(){}
        }
        class B {
            void main{
                A.kbs();
                // 이렇게 실행하면 kbs()에서 돌아오는 값이 없이 그냥 실행만 된다는 것
            }            
        }
        ```
    - String args[]: 문자열을 저장하는 배열

## 변수로 다시 돌아가 보자

- 변수: 처리하고자 하는 하나의 데이터를 저장하는 기억장소
    - *変数とは：処理しようとする一つのデータを置く記憶装置の中の場所*
    - *변수는 음독 그대로 変数(へんすう)라고 쓰고, 값은 あたい라고 읽는 値라는 한자를 사용합니다.*
- [202217.md](/221011-221202_JAVA_BASICS/22-10/221017/221017.md)에서 변수와 그 자료형들의 정의를 돌아보는 시간을 가지자

    | 변수형 | 변수 | = | 변수 or 수식 or 리터럴 | ; |
    |---|---|---|---|---|
    | `int` | `bno` | `=` | `11` | `;` |
    | `double` | `avg` | `=` | `100.00` | `;` |

    - 이러면 `bno`란 이름이 붙은 메모리에 4바이트 정수인 `int`형 공간이 생기고, 그 공간에 `11`이란 값이 들어간다 그 말이다.
        - 세미콜론(;) 빼먹지 말고.
    - `double avg = 100.00;`도 마찬가지로 8바이트 실수(*부동소수점*) 메모리 공간에 값이 대입된다.

- 이제 이 변수를 선언해서 값을 대입해본 다음에 그걸 출력해 보자.
    - *이후의 필기는 소스 코드 파일의 주석에 내용을 자세히 적어 놓았습니다.*
- 코드는 위에서 아래로 처리되므로 선언, 처리, 출력 순서로 코드를 작성해야 한다.

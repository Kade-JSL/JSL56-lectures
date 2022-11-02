### [221024 ←](/221011-_JAVA/22-10/221024/) | [→ 221026](/221011-_JAVA/22-10/221026/)

# 이날 배웠던 것

- 링크를 클릭하면 해당 주제에 대해서 공부했던 소스 코드로 이동합니다.
    - [`do`...`while`문 연습(업다운 게임)](/221011-_JAVA/22-10/221025/javastudy56/javastudy/src/javastudy/Java25.java)
    - [중첩 `for`문](/221011-_JAVA/22-10/221025/javastudy56/javastudy/src/javastudy/Java26.java)
    - [`continue`문](/221011-_JAVA/22-10/221025/javastudy56/javastudy/src/javastudy/Java27.java)
    - [`contunue`, `break`문 연습(프로그램 메뉴)](/221011-_JAVA/22-10/221025/javastudy56/javastudy/src/javastudy/Java28.java)
    - [`for`, `while`, `do`...`while`문 종합 실습](/221011-_JAVA/22-10/221025/javastudy56/javastudy/src/javastudy/Java29.java)

---

# 중첩 `for`문에서 좀 어려운 점

- 항상 중괄호(`{}`) 안에서 일어나는 일을 먼저 생각한다.
- 또 원하는 출력값이 있을 때 일단 머릿속으로 각각의 변수가 어떻게 되어야 하는지 상상해 본다.
- 예제 해석:
    ```
    *
    **
    ***
    ****
    *****
    ```
    1. `j` 반복문 안의 `print()`가 실행된다.
    2. 반복이 끝나고 나면 `j` 반복문의 중괄호 내용은 끝난다.
    3. `i` 반복문의 내용인 `println()`이 실행된다.
    4. 다시 `i` 반복문의 머리로 돌아가 `i++`을 실행한다.
    5. 반복문 안에 있는건 `j` 반복문 뿐이므로, `i`의 값은 고정되어 있고 그에 따라서 `j` 반복문이 실행된다.
    6. 처음으로 돌아간다.
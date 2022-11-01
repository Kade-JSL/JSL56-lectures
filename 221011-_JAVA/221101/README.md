# 이날 배웠던 것

- [메소드에 대한 약간 다른 접근?](/221011-_JAVA/221101/javastudy56/javastudy/src/javastudy/Object03.java)
- [이런저런 메소드 만들어보기](/221011-_JAVA/221101/javastudy56/javastudy/src/javastudy/Object04.java)

---

## 선언문은 눈을 크게 뜨고 보자.

- 아니 정말로. 몇 번을 강조해도 지나치지 않다구요.

    ```java
    public[접근 제한자] static[...뭐더라?] int[리턴 자료형] foo[메서드 이름](int[매개변수 자료형] var[매개변수 이름]){
        int barBar = bar(var);[함수 내용]
        return barBar[리턴할 값];
        }
    ```
    
    - 중괄호를 열었으면 꼭 닫고!
    - 메서드 이름 오른쪽엔 꼭 소괄호 열고 닫고!
    - 받는 자료형 다시 확인하고! 리턴하는 자료형 다시 확인하고!
    - 매개변수 순서! 매개변수 갯수!
    - 내부 변수 선언! 내부 코드 처리!
    - 이러한 정의는 반드시 반드시 반드시 머릿속에 꼭꼭 넣어두세요.
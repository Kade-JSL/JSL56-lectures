### [221107 ←](/221011-221124_JAVA_BASICS/22-11/221107) | [→ 221109](/221011-221124_JAVA_BASICS/22-11/221109/)

# 이날 배웠던 것

- [Object06.java: `try` ~ `catch`문, 그리고 `throws`문](/221011-221124_JAVA_BASICS/22-11/221108/javastudy56/javastudy/src/javastudy/Object06.java)
- [Object07.java: 클래스 입문](/221011-221124_JAVA_BASICS/22-11/221108/javastudy56/javastudy/src/javastudy/Object07.java)

## [(일본어) 클래스, 객체, 인스턴스의 구분에 대한 좋은 글](https://freesworder.net/class-instance-object/)

---

## 우리에게 클래스가 필요한 이유

- 예컨대 어떤 학생 한 명에 대해서 설명해야 한다고 생각해 보자.
    - 그럼 그냥 그 학생의 특징들을 변수로다가 쭉쭉 써서 서술할 수도 있다.

    ```java
    int bno = 11;
    String name = "홍길동";
    int kor = 100;
    int eng = 100;
    int mat = 100;
    int tot = kor + eng + mat;
    double avg = (double)tot / 3.;
    ```

- 그리고 이제 갑자기 학생이 300명이 됐다고 해 보자.
    - 저 변수들의 정의를 300번이나 써야 한다니 조금 정신이 아찔하다.
1. **배열로는 되나?**
    - 변수가 자료형이 이리저리 섞여 있어서 힘들어 보인다.
        - 배열은 같은 형의 변수만 만들 수 있는데 말이다.
    - 그나마 번호 배열, 이름 배열 같은 걸 만들면 가능은 해 보인다.
        - 근데 배열 길이는 고정되어 있다.
        - 그리고 그 길이를 수정할 수도 없다.
        - 300명이 아니라 301명이면 어떡하지?
2. **메서드로는 되나?**
    
    ```java
    static void student(int bno, String name, int kor, int eng, int mat) {
        ...
    }
    ```

    - 어차피 데이터는 또 저장해야 한다.
    - 그리고 배열을 선언해야 한다는 건 변하지 않는다.
- **어디 좀 하나의 대상이 가진 특성들을, 그러니까 데이터베이스 용어로 하자면 레코드들에 있는 특성들을 전부 하나에 모아다가 불러와서 출력할 수는 없을까?**
    - That's where the concept of class comes in.

## 클래스의 구성

- 멤버 변수
    - *attribute, field, variables 등 여러 표현을 씁니다.*
    - *차이는 미묘하지만 실무자들도 잘 모르는 것 같습니다. 그냥 어감에 따라 쓰는듯?*
- 생성자
- 멤버 메서드

```java
class Student {
    int bno, kor, eng, mat, tot;
    double avg;
    String name, grade;
    
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    ...
}
```

- 즉 이러한 자료나 기능 덩어리의 설계도라는 것이다.
- 지난 주에 배웠지? 자동차 설계도라고 예를 들 수도 있을 것이다.
    - 클래스는 설계도.
    - 이 설계도를 가지고 자동차를 만들면 객체 생성.
    - 자동차를 만드는 과정을 **인스턴스화**라 한다.

## *객체는 굳이 클래스 형이 아니어도 됩니다.*

- *그냥 main() 메서드 안에서 변수만 선언해도 객체입니다.*
- *하지만 **클래스라는 설계도를 통해서 만들어낸 객체**를 **인스턴스**라 하는 것입니다.*
- *그리고 자바는 누가 객체지향의 극한 아니랄까봐 변수가 별도의 형태로 존재하는 게 아니라 다른 객체들과 똑같이 취급됩니다.*

## 생성자

- 객체를 생성할 때 멤버들을 초기화하는 역할
- 메서드의 일종으로써 선언되지만 인수를 받기만 하며, 리턴타입은 `void`가 아니라 없는 거다.
- 그리고 생성자의 이름은 반드시 그 클래스의 이름과 같아야 한다.
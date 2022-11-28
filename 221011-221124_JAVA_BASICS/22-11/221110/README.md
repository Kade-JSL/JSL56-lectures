### [221109 ←](/221011-221124_JAVA_BASICS/22-11/221109) | [→ 221111](/221011-221124_JAVA_BASICS/22-11/221111/)

# 이날 배웠던 것

- [OverloadingMain.java: 클래스 생성자 오버로딩](/221011-221124_JAVA_BASICS/22-11/221110/javastudy56/javastudy/src/javastudy/OverloadingMain.java)
- [ObjectArrayMain.java: 클래스 배열](/221011-221124_JAVA_BASICS/22-11/221110/javastudy56/javastudy/src/javastudy/ObjectArrayMain.java)
    - [ObjectArray.java: 뇌절에 또 뇌절](/221011-221124_JAVA_BASICS/22-11/221110/javastudy56/javastudy/src/javastudy/ObjectArray.java)

---

## 오버로딩

- 한 클래스 안에서 같은 이름의 메서드를 여러 개 정의하는 것을 말함
    - 당연히 이름은 같아야 한다.
    - 메서드라고 볼 수도 있는 생성자에서도 당연히 오버로딩이 가능.
- 그러니까 `Main` 클래스가 있다고 치자.

    ```java
    class Main {
        public Main() {}
        public Main(int a, int b, ...) {
            ...
        }
        public Main(String s, ...) {
            ...
        }
    }
    ```

- 이런 식으로 객체를 생성할 때 넣은 매개변수에 따라서 다른 생성자를 정의할 수 있다는 것.
- 하지만 그렇다고 똑같은 이름에 똑같은 **순서**로 인수를 받는 메서드는 당연히 컴퓨터 입장에서도 헷갈리니까, 오버로딩으로 취급되지 않고 컴파일 에러가 뜬다.
    - 그치만 인수 순서가 다르면 그건 또 다른 메서드가 된다.

## `this` 생성자

- 클래스 멤버로써의 `this`와 같이, 자기 자신 클래스에 있는 다른 생성자를 호출할 때에 사용
- 아무 인자도 받지 않을 때라던가, 뭐 레거시 코드를 지원한다던가, 코드의 중복을 제거하기 위해서라던가 하기 위해서 쓴다.
- `this` 생성자를 호출할 땐 반드시 첫 줄에만 써야 한다. 객체를 생성할 때 멤버변수 지정이 가장 먼저 이루어지는데, 다른 게 먼저 이루어지면 순서가 모순되어 버리기 때문이다.

## 객체 배열

- 배열은 배열인데 객체의 배열이다.
- 선언하는 방식은 다음과 같다. 하는 김에 배열 구성요소 객체들도 정의해 보자.

    ```java
    class Cats {
        ...
    }

    public class Main {
        public static void main(String[] args) {
            Cats[] = new Cats[10];

            Cats[0] = new Cats("Snowy", 2);
            Cats[1] = new Cats("Brownie", 3);
            ...
        }
    }
    ```

- 클래스로 만드니까 반복도 줄어들고, 요소가 더 알기 쉽게 머릿속에 들어갔고, 레코드를 추가하는 것도 매우 간편해졌다.
    - 인간의 사고방식에도 잘 맞고, 컴퓨터의 사고방식에도 잘 맞는 느낌이다.
    - 객체지향을 안 할 이유가 없는 것이다.
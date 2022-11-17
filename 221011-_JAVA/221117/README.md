### [221116 ←](/221011-_JAVA/221116) | _→ 221118_<!--(/221011-_JAVA/221118/)-->

# 이날 배웠던 것

- 

---

## 다형성; Polymorphism; ポリモーフィズム

- 상위 클래스의 참조형 변수로써 하위 클래스의 객체를 다룰 수 있음
- 상속 관계에 있는 상위 클래스와 하위 클래스가 있을 경우, 상위 클래스 타입의 객체를 만들 때 하위 클래스의 생성자를 써서도 만들 수 있다.

```java
class TV {
    boolean power;
    int channel;

    void powerOn() {}
    void channelUp() {}
    void channelDown() {}
}
class SmartTV extends TV {
    String text;

    void caption() {}
}

...

public class Main {
    public static void main(String[] args) {
        TV t = new SmartTV(); // 일단 이걸로 다형성 시작

        // t.text = "text"; // 컴파일 오류: TV 타입의 참조형으로는 SmartTV의 멤버를 다룰 수 없음
    }
}
```

## 매개변수 다형성

- 참조형 매개변수는 메서드 호출 시 자신과 같은 타입은 물론 하위 클래스 타입의 인스턴스를 넘겨줄 수 있다.

## 업캐스팅과 다운캐스팅

- 업캐스팅: 하위 클래스 객체를 상위 클래스 타입으로 변환
- 다운캐스팅: 상위 클래스 객체를 하위 클래스 타입으로 변환

```java
int a = 1;
double b;
b = a;
// == "b = (double)a;"

TV t1;
SmartTV s1 = new SmartTV();
t1 = s1;
// == "t1 = (TV)s1;" 

TV t2 = new TV();
SmartTV s2;
s2 = (SmartTV)t2;
// 반드시 형을 써 줘야 한다
```
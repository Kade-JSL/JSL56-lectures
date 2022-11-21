### [221118 ←](/221011-_JAVA/221118) | _→ 221122_<!--(/221011-_JAVA/221122/)-->

# 이날 배웠던 것

---

## 패키지와 관련된 클래스

- 패키지: 서로 관련된 클래스들을 하나의 폴더로 묶어 놓은 것
- 우리가 만드는 패키지가 있고, JDK에서 제공하는 표준 패키지가 있다.
- 패키지들의 상하위 구분은 `java.util`같이 마침표로 구분한다.
- `java.lang`
    - `String`, `Math`, 입출력 등 자바 프로그래밍에 필요한 기본적인 클래스와 인터페이스들
- `java.util`
    - 대표적인 유틸리티 패키지. 우리는 주로 `Scanner` 클래스를 사용했다.
    - 날짜, 시간, 벡터, 해시맵 등과 같은 다양한 유틸리티 클래스와 인터페이스
- `java.io`
    - 키보드, 모니터, 프린터, 디스크 등에 입출력을 할 수 있는 클래스와 인터페이스
- `java.awt`, `javax.swing`
    - GUI 프로그래밍을 위한 패키지
- 기타 API 관련 문서는 여기서 찾아볼 수 있다: [https://docs.oracle.com/javase/jp/8/docs/api/index.html](https://docs.oracle.com/javase/jp/8/docs/api/index.html) 참고로 일본어다.

## Object 클래스

- 全てのクラスのスーパークラス。全てのクラスに強制的に継承される。
- `getClass()`: 그 객체 타입의 클래스를 반환
    - `getName()`: 그 클래스의 패키지.이름을 반환
- `hashCode()`: 그 객체의 해시코드 값
- `toString()`: 그 객체를 문자열로 만들어줌
    - sysout을 이용해 obj만 출력히면: 모든 print 메서드는 모든 인수를 문자열로 만들기 때문에 사실상 `toString()` 메서드를 사용하는 것이나 다름없다.

## Wrapper 클래스

- 실제로 존재하는 이름은 아니지만, 편의를 위해 이런 클래스들을 wrapper라고 한다.

    ||||||||||
    | --- | --- | --- | --- | --- | --- | --- | --- | --- |
    | 기본 타입 | `byte` | `short` | `int` | `long` | `char` | `float` | `double` | `boolean` |
    | 클래스 | `Byte` | `Short` | **`Integer`** | `Long` | **`Character`** | `Float` | `Double` | `Boolean` |

- Boxing(박싱): 기본타입 변수를 wrapper 객체로 변환
- Unboxing(언박싱): wrapper 객체를 기본타입 변수로 변환
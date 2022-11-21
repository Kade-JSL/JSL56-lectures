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

## `Object` 클래스

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

## `String` 객체

- String은 대입으로 바로 집어넣은 **내용이** (대소문자를 구분해서도) **똑같다면 똑같은 메모리 주소를 가리키게 된다.**
- **`concat(String str)`** 메서드로 두 문자열을 합칠 수 있다
- **`trim()`** 메서드로 앞뒤 공백을 제거할 수 있음
- **`charAt(int index)`**로 `index`+1번째 문자열 값을 `char`로 돌려줌
- **`replace(CharSequence target, CharSequence replacement)`**: `target` 문자열을 `replacement` 문자열로 바꿔줌
- **`split(String regex)`**: regex에 넣은 측정 문자열을 기준으로 문자열을 문자열 배열로 나눠 돌려줌
- **`substring(int beginIndex)`**: `beginIndex`+1번째 문자열부터 끝까지 추출
    - `int beginIndex, int endIndex`: `beginIndex` ~ `endIndex` 번째 문자열까지 추출
- **`toUppercase()`**: 말 그대로 전부 대문자로 출력. 당연히 `toLowerCase()`도 있다.

## `StringBuffer` 클래스

- 가변 크기의 문자열을 저장하는 클래스
    - 문자열 길이에 따라 객체의 크기는 가변적으로 변함
- `String` 클래스와는 달리 내용을 바꿀 수 있다
- **`append(...)`**: 아무거나 문자열 끝에 덧붙임
- **`insert(int offset, ...)`**: 아무거나 `offset`번째 문자열부터 삽입
- **`replace(int start, int end, ...)`**: `start`부터 `end`까지 있는 문자열을 아무거나로 대체
- **`length()`**: 객체 문자열의 길이
- **`setLength(int newLength)`**: 정해진 길이까지 문자열을 자름
- **`delete(int start, int end)`**: `start`번째부터(0부터 시작하는 그 번째) `end`번째까지의 문자열을 삭제. `end`는 딱히 `length()`를 넘더라도 상관 없다.

## `java.util.StringTokenizer`

- 하나의 문자열을 여러 문자열로 분리
- **`StringTokenizer(String str, String delim)`**
    - `String.split()` 메서드와 같이 `str` 문자열을 `delim` 문자열을 기준으로 분리가 된다.
- `hasMoreTokens()` 메서드라던가 `nextToken()` 메서드 같은 게 있긴 한데, 그냥 이런 게 있구나 하고 넘어가도록 한다.

## `Math` 클래스

- 모든 메서드가 `static`. 클래스 이름으로 바로 호출해서 사용한다.
- **`random()`**: 0에서 1까지의 무작위 `double`값
- **`PI`**: `double`, 3.1415926535...
- **`ceil()`**: 올림
- **`round()`**: 반올림
- **`floor()`**: 내림
- **`sqrt()`**: 제곱근
- **`exp()`**: 자연상수의 제곱
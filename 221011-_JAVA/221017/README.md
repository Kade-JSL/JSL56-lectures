***코딩하면서 강의한 내용은 소스 파일의 주석에 있습니다.***

# 이날 배웠던 것

- [Java01.java](/221011-_JAVA/221017/javastudy56/javastudy/src/javastudy/Java01.java)
- [Java02.java](/221011-_JAVA/221017/javastudy56/javastudy/src/javastudy/Java02.java)
- [Java03.java](/221011-_JAVA/221017/javastudy56/javastudy/src/javastudy/Java03.java)
    - 프로젝트 파일 구조에 맞게 저장(링크를 클릭하세요)되어 있습니다.
    - 이대로 Java 프로젝트가 되는 것은 아니므로, 소스 코드만 봐 주세요. 
- Eclipse IDE 구축과 함께 기본적인 자바 코드를 만드는 법을 배웠습니다.
- `System.out.print()` 메서드와 유사 메서드인 `System.out.println()`를 배웠습니다.
- 제어문자 `\t`와 `\n`을 배웠습니다.

---

## 숙제

- `Java03.java` 만들기
- 콘솔창에 이렇게 띄우기
```cmd
            급여명세서
--------------------------------------
사원번호 이름 직급 급여 상여금 총액
--------------------------------------
1101 홍길동 대리 3000000 300000 3300000
```
- 코드:
```java
package javastudy;

public class Java03 {

	public static void main(String[] args) {
		System.out.println("\t\t급여명세서");
		System.out.println("----------------------------------------------");
		System.out.println("사원번호\t이름\t직급\t급여\t상여금\t총액");
		System.out.println("----------------------------------------------");
		System.out.println("1101\t홍길동\t대리\t3000000\t300000\t3300000");
	}

}
```

## JAVA 개발 환경 구축해 보기

- JDK 1.8 update 202
- Eclipse IDE for Enterprise JAVA Developers 2020-06을 사용한다

## Eclipse는...

- Workspace(작업 공간)를 지정해서 거기에 한 덩어리의 소스코드들을 저장해 둔다.
- 그리고 이 소스코드를 컴파일하고 실행하는 것도 JDK를 대신 실행해서 할 수 있게 된다.
- IDE라 하면 Integrated Development Environment, 즉 통합 개발 환경을 말한다.

## 기본형(Primitive Type): 자바의 정석 3e의, 28페이지

## 데이터란?

- 처리하고 싶은 자료를 말한다.
- 데이터의 종류
    - 기본형
        - boolean(논리형)
            - `true`, 아니면 `false`
            - *뱀발: bool-ean이라는 것은 번역하면 'bool(불)-적인'으로 번역할 수 있는데, 이 bool(불)은 19세기 영국의 수학자 [조지 불](https://ko.wikipedia.org/wiki/%EC%A1%B0%EC%A7%80_%EB%B6%88)의 이름에서 따 왔습니다. 불은 불 대수(boolean algebra)라고 불리는 논리 연산들의 집합을 고안해 내었습니다. 이 불 대수에서 boolean이라는 용어가 유래하였습니다.*
        - 정수형: 소수점이 없는 숫자
            - `byte`: 1바이트
            - `short`: 2바이트
            - `int`: 4바이트
            - `long`: 8바이트
        - 실수형: 소수점이 있는 숫자
            - `float`: 4바이트
            - `double`: 8바이트
        - 문자형: `char`, 'a'처럼 작은따옴표로 감싼다.
    - 참조형
        - 배열(array)
        - 문자열(`string`)

### 변수란?

- HTML을 배울 때를 기억해 보자. `<input type="text" name="id"/>` 이런 식으로 저장했었지? 이 때 `name`을 임시적인 저장소라고 했는데, 이제부터 우리는 이걸 **변수**라고 하겠다 그 말이다.
- 컴퓨터는 CPU로 대표되는 연산장치와, RAM으로 대표되는 기억장치가 있다. 변수는 기억장치에 저장이 된다.
- 변수는 **값을 저장하는 기억장소**를 뜻한다.
- `kor`이라는 기억장소에 원래는 123이라는 숫자가 저장되어 있다고 생각해 보자. 이제 여기에 100을 저장하고 싶다고 해 보자.
    - 이 때 등장하는 것이 **대입문**이다.
    - `V = e;`라고 하면 e라는 값을 V라는 기억장소에 저장하라는 의미.
    - 즉 `kor = 100;`이라고 써 놓으면 `kor`이라는 기억장소에 100이 새로 저장된다는 것이다.
        - *뱀발: 4바이트(32비트) 정수의 한계는 $2^{31}-1$로써 2,147,483,647(21억 4748만)입니다. 어딘가의 게임에서 소지금의 한계선으로 본 적이 있을 수도 있겠네요. 8바이트(64비트) 정수의 한계는 $2^{63}-1$으로써 9,223,372,036,854,775,807(92경 2337조)가 됩니다.*
    - 대입문의 왼쪽에는 대입되는 변수가, 오른쪽에는 대입을 할 또 다른 변수, 또는 수식, 또는 리터럴(그대로의 값)이 들어갈 수 있다.
- 다음과 같은 기억장소 구조를 생각해 보자.

    | | 번호 | 이름 | 국어 | 영어 | 수학 | 총점 | 평균 | 등수 |
    |---|---|---|---|---|---|---|---|---|
    | 자료형 | `int` | `string` | `int` | `int` | `int` | `int` | `double` | `int` |
    | 변수명 | `bno` | `name` | `kor` | `eng` | `mat` | `tot` | `ave` | `rank` |

    - 그러면 이것들은 Java에서는 다음과 같이 정의할 수 있다.
    ```java
    int bno = 0;
    string name = null;
    int kor = 0;
    int eng = 0;
    int mat = 0;
    int tot = 0;
    double ave = 0.0; // 일반적으로 실수 자료형에선 double을 쓴다.
    int rank = 0;
    ```
    - Java에서는 이처럼 변수를 선언할 때 그 변수의 자료형을 반드시 선언해 줘야 한다.
        - *뱀발: 이와 같은 언어를 강타입(strong typing; 強い型付け) 언어라고 합니다. Python이나 JavaScript처럼 변수를 자료형과 같이 선언하지 않는 경우도 있는데, 이 경우엔 약타입(weak(또는 loose) typing; 弱い型付け) 언어라고 합니다.*
    - 자, 다시 변수 선언 예제.
    ```java
    double month = 123.456;
    string name = "홍길동"; // string 자료형은 큰따옴표 안에 넣는다.
    int won = 45600;
    ```
    - 이렇게 `=`을 쓰는 문장이 뭐라고? 대입문!
    - 조각지식: `double`이 `long`보다는 살짝 더 메모리를 많이 차지한다.

## 즐거운 실습 시간

- Eclipse IDE를 켜 본다. UI가 너무 구리다.
- Show View인지 담원 쇼메이커인지 할튼 배웠다.
- Dynamic Web Project: 웹을 처리하는 프로그램을 만들 때 배운댄다.
- Eclipse의 `New...`메뉴에는 왜 단순한 `Java Project` 만들기 메뉴가 숨겨져 있을까?
    - Enterprise 버전을 설치했기 때문. 웹하고 Java를 같이 개발하고 싶어서일 것이다.
- `Open Perspective` 단추를 클릭해서 `Java`로 작업 공간 레이아웃을 전환해 준다.
    - 왼쪽의 커피콩이 있는 단추는 웹 개발에 쓰이는 작업 공간 전환 단추이다.

### 프로젝트 만들기

- `javastudy` 프로젝트를 만들려고 한다.
    - 오류메시지를 주의깊게 보자. 이건 미래에도 도움이 된다.
    - `Use default location`을 눌러서 `~/javastudy56/javastudy` 폴더를 만들어 본다.
    - 그러면 `javastudy` 폴더 밑에는 `JRE System Library` 폴더와 `src` 폴더가 만들어진다.
        - `src` 폴더 안에다 원시 파일(소스)을 코딩해서 넣는 것이다.
- `src` 폴더의 맥락 메뉴에서 `New > Class...`를 누른다.
    - **클래스 이름의 첫 글자는 반드시 대문자로 하도록 하자!**
- 편집기 화면에서 글자 크기를 조절하려면 `Ctrl`+`+` 또는 `-`를 이용해서 할 수 있다.

### 헬로 월드 비스무리한 걸 해보기

```java
package javastudy;

public class Java01 {

	public static void main(String[] args) {
		System.out.print("안녕하세요");
	}

}
```
- 메서드란?
    - 엑셀의 함수 같은 것.
        - 사실 다른 프로그래밍에서도 함수라고 하기도 한다.
        - 하지만 다른 언어에서도 가끔 메서드라고도 부른다.
        - `{}`로 둘러싸여 있다.
    - 참고로 클래스들을 모아 놓은 단위들을 패키지라고 한다.
- 실행은 그냥 툴바의 초록색 재생 버튼을 누르기만 하면 번거로운 과정 없이 그냥 실행된다.
- 그 어떤 사건도 없던 것으로 해 주는 절대시간마법 `Ctrl`+`z`의 힘을 맛보도록 하자.
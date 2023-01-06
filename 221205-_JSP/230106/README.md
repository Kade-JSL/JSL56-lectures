### [230104 ←](/221205-_JSP/230104/) | [→ 230109](/221205-_JSP/230109/)

# 이날 배웠던 것

---

## 입출력 스트림

- 데이터는 스트림을 통해서 입출력된다.
- 스트림은 단방향이다.
- 키보드에서 → 프로그램을 거쳐 → 모니터로
- 프로그램이 출발지(출력)냐 도착지(입력)냐에 따라서 스트림의 종류가 결정

## 바이트 기반 클래스

- 그림, 음악 파일, 기타 파일, 영상 파일
- 이진(binary) 데이터
- 최상위 클래스: `InputStream`, `OutputStream`
    - `XXXInputStream`, `XXXOutputStream`이 하위 클래스
    - `FileInputStream`, `FileOutputStream`이 그 예

## 문자 기반 클래스

- 문자 데이터를 읽고 쓸 때 사용
- 최상위 클래스: `Reader`, `Writer`
    - `XXXReader`, `XXXWriter`가 하위 클래스
    - `FileReader`, `FileWriter`

## 주요 메서드

| 인수 | `write()` | `read()` |
|---|---|---|
| `int b` | 1바이트씩 출력 | 1바이트씩 읽고 바이트를 리턴 |
| `byte[] b` | 주어진 배열 `b`의 모든 바이트를 출력 | 읽은 바이트를 인수로 주어진 배열에 저장하고 읽은 바이트 수를 리턴 |
| `byte[] b, int off, len` | 배열 `b[off]`부터 `len`개까지의 바이트를 출력 | `len`개까지의 바이트를 읽고 인수로 주어진 배열 `b[off]`부터 `len`개까지의 배열에 저장 |

- `close()`: 입출력 스트림을 닫는다

## 출력 스트림 실습

```java
OutputStream out = new FileOutputStream(".../221205-_JSP/230106");
// 출력할 파일을 생성자에 넣어 출력 스트림 객체를 생성

byte[] array = new byte[] { 'H', 'e', 'l', 'l', 'o', ',', ' ', 'W', 'o', 'r', 'l', 'd', '!' };
// write할 바이트 배열을 만듦
		
out.write(array);
// 출력 스트림에 배열을 write
out.flush();
// 버퍼에 남아 있는 모든 바이트를 변깃물 내리듯이(flush) 파일에 쏴아아 쏟겨내림
```

- 이러면 이제 저 경로에 있는 hello.txt가 출력된다 그 말이다.
    - _참고로 지금 이 폴더에 있는 hello.txt는 진짜로 저 코드를 실행한 결과로 생성된 파일입니다. `...`으로 되어 있는 경로는 프라이버시 보호를 위해 생략을... 어차피 프로젝트 폴더 가면 バレバレ입니다만._

```
Hello, World!
```

## 입력 스트림 실습

```java
InputStream in = new FileInputStream(".../221205-_JSP/230106/hello.txt");
		
byte[] buffer = new byte[1024];

while (true) {
    int readByte = in.read(buffer);
    if (readByte == -1) {
        System.out.println("다 읽어왔습니다.");
        break;
    }
    for (int i = 0; i < readByte; i++) {
        System.out.print(buffer[i] + " ");
    }
}
```

- 이러면 출력은 다음과 같다.

```
72 101 108 108 111 44 32 87 111 114 108 100 33
다 읽어왔습니다.
```

- 숫자인 이유는, 각 문자들의 아스키 코드를 읽어왔기 때문이다. `Character.toChars()` 메서드로 치환하면 다시 원래처럼 `Hello, World!`가 출력된다.

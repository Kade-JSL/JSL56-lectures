# 이날 배웠던 것

- Java를 시작했습니다. 이에 따라서 리포지토리 구조를 이것저것 바꿨습니다.
- `Hello World!`를 하는 데 성공했습니다. 정말 가슴이 웅장해진다...
- 수업 중엔 Eclipse IDE를 깔았고 이것저것 개발환경을 설정한 거 같긴 한데 리포지토리에는 올리지 않겠습니다.
    - 용량이 큰 게 마음에 안 듭니다. 커밋에도 시간이 걸릴 테고요.
    - UI도 너무 구립니다.
        - 수업 따라가는 건 Eclipse로 하겠습니다만, 되도록이면 VSCode 확장인 **OpenJDK**를 써서 빌드할 것 같습니다.
- 경로를 특정하거나 링크를 걸거나 할 때 여러 환경에서 오류를 일으키지 않도록 리포지토리 내부 폴더 이름들을 다시금 바꾸었습니다.
    - 이제는 더 이상 안 바꿨으면 좋겠습니다.

---

## 숙제
- JDK와 JRE의 차이는 무엇인가?
    - JDKとは？
    - JREとは？
    - 二つの違いは？
- JVM이란?
    - JVMとは？

---

## JRE(Java Runtime Environment)란?

JRE는 자바 실행 환경(Java Runtime Environment)의 약자로 자바로 만들어진 프로그램을 실행시키는데 필요한 라이브러리들과 각종 API, 그리고 자바 가상 머신 (JVM)이 포함되어 있습니다. JRE는 자바로 "개발(쓰기)은 안되고 실행(읽기)만 된다"라고 생각해주시면 될 것 같습니다.

> JREとはJava実行環境(Java Runtime Environment)の略であり、Javaで作成したプログラムの実行に必要なライブラリーと各種のAPI、そしてJava仮想マシンが含まれている。即ち、JREは「Javaの実行(読み)はできるが、開発(書き)はできない」と言える。

---

## JDK(Java Development Kit)란?

JDK는 자바 개발키트(Java Development Kit)의 약자로 이름 그대로 개발자들이 자바로 개발하는 데 사용됩니다. JDK안에는 개발 시 필요한 라이브러리들과 javac, javadoc 등의 개발 도구들을 포함되어 있고 개발을 하려면 당연히 실행도 시켜줘야 하기 때문에 JRE (Java Runtime Environment)도 함께 포함되어 있습니다.

> JDKはJava開発キット(Java Development Kit)の略で、文字通り開発者がJavaのソフトウェアの開発に使う道具である。JDKの中には開発の際に必要なライブラリー、javacやjavadocなどの開発道具と、当然開発には実行も必要なのでJRE(Java Runtime Environment)も含まれている。


#### 정리하자면 Java로 프로그램을 직접 개발하려면 JDK가 필요하고 Java로 만들어진 프로그램을 실행시키려면 JRE가 필요합니다.
> **つまり、JREはJavaのプログラムを実行だけ出来る環境である。JDKはそのJREにJavaのプログラムの開発機能まで加えた開発道具なのだ。**

![그림 1](https://blog.kakaocdn.net/dn/dYZ5zo/btruAiSxZGI/u1gxIOHNtkVV9KtNVl3knk/img.png)

(출처: [https://coding-factory.tistory.com/826](https://coding-factory.tistory.com/826))

## JVM(Java Virtual Machine)이란?

자바 가상 머신 JVM(Java Virtual Machine)은 자바 프로그램 실행환경을 만들어 주는 소프트웨어입니다. 자바 코드를 컴파일하여 .class 바이트 코드로 만들면 이 코드가 자바 가상 머신 환경에서 실행됩니다. JVM은 자바 실행 환경 JRE(Java Runtime Environment)에 포함되어 있습니다. 현재 사용하는 컴퓨터의 운영체제에 맞는 자바 실행환경 (JRE)가 설치되어 있다면 자바 가상 머신이 설치되어 있다는 뜻입니다.

> Java仮想マシン(Java Virtual Machine; JVM)とはJavaプログラムの実行環境を築くソフトウェアである。Javaのコードを.classバイトコードでコンパイルした後、そのコードはJava仮想マシン環境で実行される。JVMはJRE(Java Runtime Environment; Java実行環境)に含まれている。現在使いのコンピューターのOSと合うJREがインストールされていればJava仮想マシンも一緒にインストールされている。

---

## Java가 실행되려면

- `jar`, `java`, `javac` 등의 실행 파일이 `.exe`로 저장되어 있다.
- Java로 쓴 원시(source) 파일의 확장자는 당연히 `.java`이다.
- 이 소스 파일을 실행 파일로 만들려면 **컴파일**이라는 것이 필요하며, 컴파일이란 소스를 컴퓨터가 이해 가능한 기계어로 번역하는 과정을 말한다.
    - `javac`로 컴파일을 하게 된다.
- 컴파일이 완료된 코드의 확장자는 `.class`이며, 이를 바이트 코드(byte code)라고 한다.
- 바이트 코드를 실행하면 결과값이 출력된다.
    - 이 실행 부분을 `java` 명령어가 담당한다.

---

## Hello World!

```Java
class Hello {
	public static void main(String[] args) {
		System.out.println("Hello World!");
	}
}
```

1. `hello.java` 파일을 생성한다.
2. `javac hello.java`로 `.class` 파일(바이트 코드)을 만든다.
3. `java Hello.class`로 바이트 코드를 실행시킨다.
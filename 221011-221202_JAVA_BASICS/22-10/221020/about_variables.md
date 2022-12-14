# 아니 근데, 변수가 대체 뭐야?

### 약간은 더 근본적인 질문을 해 보자.

- **프로그래밍은 왜 하는 걸까?**
    - 컴퓨터가 이 녀석의 기능을 이용해서 유용한 무언가를 하기를 바라니까.
        - 하지만 컴퓨터는 0이랑 1 말고는 아무 것도 알아듣지 못한다.
        - 0이랑 1만 가지고도 컴퓨터한테 일을 시킬 수는 있다.
            - *위대한 컴퓨터공학자인 존 폰 노이만은 실제로 0이랑 1만 가지고 일을 시켰습니다.*
    - 하지만 우리는 컴퓨터로 훨씬 더 많은 일을 훨씬 더 효율적으로 할 수 있다.
    - 그게 컴퓨터와 인간의 중간 다리 역할을 하는 **프로그래밍 언어**인 것이다.
- 그치만 언어를 쓸 때 쓰더라도, 일단은 컴퓨터로 무슨 문제를 해결하고 싶은가부터 생각을 해 봐야 한다.

### 문제: 컴퓨터한테 통장 잔고를 출력시키게 하기

- 이제 다시 현실로 돌아와서, **비어 있는 은행 통장에 100원을 입금한 뒤, 10원을 출금하고, 50원을 입금하고, 다시 100원을 입금하는 과정에서 각 과정의 통장 잔고를 전부 출력하시오**라는 문제를 해결하고 싶다고 하자.
- 일단 인간 입장에서 생각하면 0 + 100 - 10 + 50 + 100이라는 순서가 먼저 생각이 날 것이다.
- 매번 잔고를 출력하라니까, 예상되는 출력은 대충 이런 형태가 될 것이다:
    ```
    통장 잔고: 0원
    100원을 입금함
    통장 잔고: 100원
    10원을 출금함
    통장 잔고: 90원
    50원을 입금함
    통장 잔고: 140원
    100원을 입금함
    통장 잔고: 240원
    ```
- 근데 아까도 말했지만 **컴퓨터는 0이랑 1 말고는 못 알아듣는다.**

### CPU, RAM, print()

- 우리는 그래서 일단은 컴퓨터를 연산장치랑 기억장치와 출력장치로 나누어 놓고, 프로그래밍 언어를 이용해서 이 연산장치가 할 일과 기억장치가 할 일, 그리고 출력장치가 할 일을 설명하기로 약속했다.
    - 연산장치는 우리가 알고 있는 CPU다.
        - *현대 컴퓨터의 발전으로 CPU 반도체 안에도 기억장치가 있으나, 구조 자체는 똑같습니다.*
    - 기억장치는 우리가 알고 있는 RAM이다.
    - 그리고 출력장치는 콘솔창 텍스트이다.
        - *다른 출력도 당연히 엄청 많지만, 지금은 그렇습니다.*

### 해결 방법

- 일단 **출력**을 해야 하니 출력장치가 할 일은 명확하다. 그냥 저 텍스트대로 출력을 하면 되는 일이다.
- 가장 간단한 해결 방법: 텍스트를 저대로 써서 `System.out.print()`에다 출력시키면 될 일이다.
- 사실 이렇게만 해도 아무 문제가 없다.
    - 정말 말 그대로 입금액을 인간의 머리에 넣은 다음 그 금액들을 계산해서 결과를 낸 다음, 출력하는 몫만 컴퓨터한테 넘기는 형태이기 때문이다.
- 근데 입금액도 컴퓨터가 받고 계산도 컴퓨터가 하고 츨력도 컴퓨터가 하면 굉장히 편할 것 같다.
- 실제 그렇다. 다 컴퓨터가 하게 되면 입금이 몇 번이 되든, 얼마가 되든, 정말 빠르게 다 해 줄 것이다.

### 해결 방법: 컴퓨터의 방식으로

- 여기에 **변수**, **연산자**, 그리고 맨 처음에 배운 **출력 함수**가 등장하게 되는 것이다.
- 그렇다면 잔고 출력 문제의 얼개는 Java로 표현하면 이런 식이 될 것이다:
    ```Java
    public class AccountBalance {
        public static void main(String[] args) {
            int bal = 0; // 통장 생성
            System.out.println("통장 잔고: " + bal + "원"); // 잔고 출력
            int depwit = 100; // 첫 입금액은 100원이다
            System.out.println(depwit + "원을 입금함"); // 입금액 출력
            bal = bal + depwit; // 입금한 만큼 잔고에 반영
            System.out.println("통장 잔고: " + bal + "원"); // 아까와 똑같은 식
            depwit = -10; // 10원을 출금(마이너스), 아까와 똑같은 식!
            System.out.println(depwit*(-1) + "원을 출금함"); // 아까와...이하생략
            bal = bal + depwit;
            System.out.println("통장 잔고: " + bal + "원");
            depwit = 50;
            System.out.println(depwit + "원을 입금함");
            bal = bal + depwit;
            System.out.println("통장 잔고: " + bal + "원");
            depwit = 100;
            System.out.println(depwit + "원을 입금함");
            bal = bal + depwit;
            System.out.println("통장 잔고: " + bal + "원");
        }
    }
    ```

    - 이 코드를 출력하면?
        ```
        통장 잔고: 0원
        100원을 입금함  
        통장 잔고: 100원
        10원을 출금함
        통장 잔고: 90원
        50원을 입금함
        통장 잔고: 140원
        100원을 입금함
        통장 잔고: 240원
        ```
        - 의도했던 출력과 똑같아졌고, 변수를 변화시키는 것만으로 쉽게 계산을 수정할 수 있었다.

- 이렇게 **변수**를 만들어서 **기억 장치**에 각각 잔고와 입출금액에 해당하는 `bal`과 `depwit`이라는 이름이 붙은 공간에 저장해 두었다.
- 그리고 `+`와 `=` 연산자를 이용해 이 변수들의 계산을 수행했다는 것이다.
- 즉 문제를 해결하는 과정에서 컴퓨터의 구조와 우리의 생각 순서를 맞추기 위해 고안된 것이 변수와 연산자라는 것이다.

# 덮어쓰기

- 위의 예제 코드를 짜는 과정에서 만일 `bal`이랑 `depwit`이라는 변수 두 개만 안 쓰고, 모든 과정에서 변수를 새로 정의해서 써 봤다고 치자.
    - 뭐 못 할 건 없을 것이다. `int bal1`을 만들어서 첫 번째 잔고에, `int depwit3`을 만들어서 세 번째 입출금에 사용해도 무방하다.
    - 하지만 그렇게 하지 않았던 이유는:
        - 컴퓨터의 기억 장치는 몇 번이고 다시 덮어쓸 수 있도록 만들어져 있기 때문이다.
            - 그게 자신에 대한 연산이라도 말이다.
- 사실 우리는 대입 연산자의 정의에서 이미 그러한 **덮어쓰기**의 편린을 보았다.
    - `V = e;`를 다시 돌아보자.
    - 만약에 `V = e;`가 씌어진 다음 줄에 `V = e1;`을 썼다고 한다면,
    - 컴퓨터가 첫 줄을 보고 `V`에 해당하는 기억 장치에 `e`를 저장하고 있다가 다음 줄에 있는 코드를 본 다음에 `e1`을 V의 자리에 새로운 값으로 **덮어써서**(기억 장치는 몇 번이고 다시 덮어쓸 수 있으니까!) 저장할 것이다.

### int v

- `int v = 0;`를 정의했다고 해 보자.
- 다음 줄에 `v = v + 2;`를 썼다고 해서 뭐 양변에서 v를 빼거나 하는 일은 없다는 것이다.
    - 등호가 아니라, 대입 연산자이기 때문이다.
    - 즉 이 경우에는 기억장치의 `v` 위치에 가서 위치(*메모리에서 변수의 위치 역시 0과 1로 이루어져 있습니다.*) 그 자체가 아닌 위치에 저장되어 있는 값에 2를 더한 만큼의 값을 다시 `v` 자리에 저장한다는 말이 된다.
    - 이렇게 계속 변수를 덮어써가며 코드를 작성하면 계산이 이루어질 때마다 새로운 변수를 정의해 줄 필요가 없다.
        - 그리고 다른 사람이 코드를 이해하는 것도 더 수월할 것이다.
        - 그 사람도 덮어쓰기의 개념을 이해했다면 말이다.
- **문제를 해결하는 알고리즘을 설계함에 있어서 변수의 개념을 제대로 이해하는 것은 프로그래밍 언어의 기본 얼개를 이해하는 것이고, 기본 얼개를 이해한다는 것은 우리가 이 언어를 가지고 현실의 문제를 해결할 수 있게 된다는 것이다.** 

# 대입과 연산을 축약해서 표시하기

- `a++` : a = a + 1
- `a--` : a = a - 1
- `a += m` : a = a + m
    - `a -= m` : a = a - m
    - `a *= m` : a = a * m
    - `a /= m` : a = a / m

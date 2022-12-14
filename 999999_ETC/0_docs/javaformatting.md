# 자바 코딩 맞춤법

- 2020년대 코딩의 키워드는 **협업**입니다.
    - 지나치게 단축하거나 제대로 된 맞춤법(컨벤션)을 지키지 않은 코드는 가독성이 떨어지고,
    - 가독성이 떨어지는 코드는 코드를 보는 동료 프로그래머의 일 능률을 저하시킵니다.
    - 협업 애플리케이션의 발전과 재택근무 트렌드 등으로 협업의 가치는 점점 더 증가하고 있습니다.
    - 이 때문에 맞춤법을 지켜서 코딩하는 것 역시 매우 중요하다고 할 수 있습니다.
- `<`, `>`와 같은 부등호, 그리고 등호(`=`)의 앞뒤는 띄어 씁니다.
- `,`, `;` 뒤에는 띄어 씁니다.
- `()`이나 `[]`, `{}`과 같은 괄호가 같은 줄에 있을 때에는 붙여 씁니다.
    - `int a = 1;`
    - `int[] aa = {1, 2, 3};`
    - `for (int i = 0; i < 5; i++)`
- 중괄호는 선언문과 같은 줄에서 열리고, 독립된 줄에서 닫힙니다.

    ```java
    for (int i = 0; i < blaa; i++) {
        blabla bla = new blabla(blaaa.a);
    }
    ```

    ```java
    if (bobla == false) {
        bla = blaa;
    } else {
        bla = blaaa;
    }
    ```

- 중괄호 안쪽의 코드는 중괄호 바깥쪽 코드보다 한 탭 들여씁니다.

    ```java
    public class Blabla {
        public static void main(String[] args) {
            System.out.print("blabla?");
        }
    }
    ```

- 메서드 이름의 첫 글자는 반드시 소문자여야 합니다.
    - 이름이 단어 두 개 이상으로 이루어져 있다면, 두 개째의 단어부터는 단어의 첫 글자를 반드시 대문자로 써야 합니다.
    - 이는 변수에도 마찬가지로 적용됩니다.

        ```java
        public class FooFoo {
            public static int[] barBar() {
                int[] varVar = new int[9999];
                ...
            }
        }
        ```

    - 반면에 위와 같이 클래스의 이름은 첫 글자가 대문자, 두 번째 단어도 대문자죠.
    - 이 규칙을 지키지 않았다고 해서 컴파일이 안 되는 건 아니지만, 규칙을 잘 지켜서 착한 프로그래머가 되도록 해요.

<!--
---

## Getting Started

Welcome to the VS Code Java world. Here is a guideline to help you get started to write Java code in Visual Studio Code.

## Folder Structure

The workspace contains two folders by default, where:

- `src`: the folder to maintain sources
- `lib`: the folder to maintain dependencies

Meanwhile, the compiled output files will be generated in the `bin` folder by default.

> If you want to customize the folder structure, open `.vscode/settings.json` and update the related settings there.

## Dependency Management

The `JAVA PROJECTS` view allows you to manage your dependencies. More details can be found [here](https://github.com/microsoft/vscode-java-dependency#manage-dependencies).
-->

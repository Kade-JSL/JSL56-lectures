# 자바 코드 맞춤법

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

- 클래스나 변수 이름에도 맞춤법이 있지만, 일단은 여기까지만.

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

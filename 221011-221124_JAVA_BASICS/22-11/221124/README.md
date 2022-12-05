### [221123 ←](/221011-221124_JAVA_BASICS/22-11/221123) | [→ 221125](/221125-_JAVA_AND_BEYOND/221125)

# 이날 배웠던 것

- [/controller/](/221011-221124_JAVA_BASICS/22-11/221124/javastudy/controller/)
    - [**MapMain.java**: `HashMap` 입문](/221011-221124_JAVA_BASICS/22-11/221124/javastudy/controller/MapMain.java)
    - [**MapMainTwo.java**: `HashMap` 객체 메서드 사용](/221011-221124_JAVA_BASICS/22-11/221124/javastudy/controller/MapMainTwo.java)
    - [**ScoreMain.java**: 연습문제 코드 실행용 클래스](/221011-221124_JAVA_BASICS/22-11/221124/javastudy/controller/ScoreMain.java)
- [/dao/](/221011-221124_JAVA_BASICS/22-11/221124/javastudy/dao/)
    - [**ScoreDaoImpl.java**: 점수 입력 프로그램의 `HashMap` 버전](/221011-221124_JAVA_BASICS/22-11/221124/javastudy/dao/ScoreDaoImpl.java)
    - [**ScoreDao.java**: 점수 입력 프로그램 인터페이스](/221011-221124_JAVA_BASICS/22-11/221124/javastudy/dao/ScoreDao.java)
- [/dto/](/221011-221124_JAVA_BASICS/22-11/221124/javastudy/dto/)
    - [**Student.java**: `enum`이 모든 가독성을 망쳤지만... ~~닷떼 오니쨩... enum은 좋은 문명인걸...~~](/221011-221124_JAVA_BASICS/22-11/221124/javastudy/dto/Student.java)

---

## `Map` 인터페이스

- 순서 없음, 데이터 중복은...
    - 키(key; キー)는 중복되면 안 되나 값(value; 値)은 중복이 가능
- 구현: `HashMap<K, V>`
    - 키와 값의 쌍으로 구성되는 요소를 다룸
    - 값을 얻기 위해선 반드시 키를 이용해야 함
- _파이썬과 C# 등지에서는 dictionary라고 불립니다. 사전에 있는 단어와 뜻풀이의 쌍과 닮아 있다는 뜻입니다._
- `get()` 메서드에서 해당 HashMap에 없는 키를 인수로 넣게 되면 `null`을 출력하게 된다.
- `ArrayList`의 배열 요소와 마찬가지로 참조형 객체기만 하면 그 어떤 형태로든 키와 값에 들어갈 수 있다.
- `keySet()`: 키에 해당하는 요소를 담아 두는 배열
- `entrySet()`: 키-값 쌍을 하나의 요소로 배열에 담아둠
- `containsKey()`: 입력한 키에 해당하는 값이 존재하는지 `boolean`으로 넘겨줌

## `Iterator`

- 컬렉션에 저장되어 있는 요소들을 읽어오는 메서드가 담긴 클래스
- `HashMap`의 경우 `entrySet()` 메서드로 `Set` 타입으로 업캐스팅한 다음에 사용할 수 있게 된다.
    - _아마도 Iterator 다음에 wrapper가 빠진 느낌인데, 정확히는 모르겠으니 넘어가겠습니다._
- `next()` 메서드 역시 현재 `entrySet()` 메서드를 거친 `HashMap`의 요소이므로 상위 클래스 타입인 `Map.Entry`로 요소를 저장하는 모양이다.
- 이제 그러면 `getKey()` 메서드와 `getValue()` 메서드를 사용할 수 있게 된다.

## 연습문제(위의 Score가 붙어 있는 일련의 파일들) 요구 사항

- HashMap이랑 ArrayList, 인터페이스를 사용하는 점수 입력 및 출력 프로그램
    - 실행
    - 메뉴 선택
    - 계산
    - 삭제
    - 검색
    - 수정
    - 이상의 기능이 필요함
- _어째서 처음에 `<String, Student>`로 만들어 두시고는 굳이 굳이 학생 이름을 키로 안 받겠다는 건 정말 무슨 심보인 건지 짧은 제 프로그래밍 경력으로써는 모르겠습니다..._

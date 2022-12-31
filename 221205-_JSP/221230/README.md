### [221228 ←](/221205-_JSP/221228/) | [→ 221230](/221205-_JSP/221230/)

# 이날 배웠던 것

- [**SendEmail.java**: 죽이고 싶은 스펠링과의 10선](/221205-_JSP/221230/jslhrdServlet/SendEmail.java)
- [**member.jsp**: 죽이고 싶은 제이쿼리와의 10선](/221205-_JSP/221230/jslhrdServlet/member.jsp)

---

## JSON

- JSON 모르면 곤란합니다. 많이 곤란할 거라고 생각해요. Java에서 그걸 처리하는 방식인 Map도 비슷하게 중요할 거구요.
- '제이슨'이라 읽는다. 영어권도 이렇게 읽는지는 몰?루
- **데이터**의 한 형식. 배열>객체>이름>값
- 이름: 값
    - 이름은 String 형식으로 지정된다. 값에 해당하는 리터럴에는 숫자, 문자, 불리언이 있다.
    - 이름과 값 사이엔 콜론 `:`이 있다.
    - 값들끼리는 콤마 `,`로 구별한다.
    - 문자 리터럴은 반드시 큰따옴표 `""`로 감싸야 한다.
    
        ```json
        {
            "number": 0,
            "text": "문자열 값",
            "boolean": true
        }
        ```
- 객체
    - 앞에서 코드 예제로 보여준 중괄호로 둘러싸인 값들의 모임을 객체라고 합니다.

        ```json
        {
            "name": "케이드",
            "family": "오타쿠",
            "age": 28,
            "weight": null
        }
        ```
- 배열
    - 객체들의 모임을 대괄호로 감싼 것. `[]` 안에 들어가 있습니다.

        ```json
        {
            "human": [
                { "name": "케이드", "nation": "South Korea" },
                { "name": "Brian", "nation": "United States" },
                { "name": "千早", "nation": "Japan" }
            ]
        }
        ```
- 그리고 좀 더 복잡하게 가자면...
    - 배열이나 객체 역시 또 다른 배열이나 객체의 성분이 될 수 있습니다.

        ```json
        {
            {
                "name": "케이드",
                "race": "human",
                "organs" : [
                    {
                        "name": "brain",
                        "function": "think"
                    },
                    {
                        "name": "stomach",
                        "function": "digest"
                    },
                    {
                        "name": "colon",
                        "function": "poop"
                    }
                ],
                {
                    "name": "흑염룡",
                    "why": "크큭... 또 하나의 인격... 크크큭...",
                    "could you just stop?": "흑염룡은 그 누구의 속박도 받지 않는다..."
                }
            },
            {
                "name": "치하야",
                "race": "goddess",
                "organs" : [
                    {
                        "Idols": "don't",
                        "have": "organs,"
                    },
                    {
                        "they": "are",
                        "filled": "with"
                    },
                    {
                        "hopes": "and",
                        "dreams.": "Now",
                        "you": "know."
                    }
                ]
            }
        }
        ```

## `JSON.stringify()`, `JSON.parse()`, `toJSON()`

- JSON 형태 객체 → 문자열: `JSON.stringify()`
- 문자열(JSON 같이 되어 있는 거) → JSON: `JSON.parse()`
- 객체 → JSON: `객체.toJSON()`

## 패스워드 암호화

- 안함
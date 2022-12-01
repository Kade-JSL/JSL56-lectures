### [221130 ←](/221125-_JAVA_INTERMEDIATE/221130/) | [→ 221202](/221125-_JAVA_INTERMEDIATE/221202/)

# 이날 배웠던 것

- 

---

## 테이블끼리 `JOIN`을 해 보자

- Join: 결합한다는 뜻.
    - 그러니까 테이블끼리 서로 결합하여 새로 뭔가 만드는 거.
    - *Joining tables to make something new about tables... I think?*
- Kinds of join
    - Inner join: Doesn's contain `NULL`
    - Outer join: Contains 'NULL'
- Methods of join
    - ANSI join: For version 9 or higher
        - Since we're using version 11g, we use ANSI join method.
    - Oracle: For version lower
- In our certification tests, question 4 and 5 amounts for join.

## Oracle join method

- Find the column in common between two tables
- `SELECT`, `FROM`, `WHERE`
    - `FROM`: Tables to join
        - `AS`: Tables' aliases
    - `SELECT`: Columns to output, use `.` to specify the table that the column is contained
    - `WHERE`: Specify values of column that two tables have in common

## ANSI method

- `SELECT`, `FROM`, `INNER JOIN`, `ON`
    - Whereas Oracle one using just one `FROM` word,
    - ANSI designates the **main table** as `FROM`,
    - and the **join table** as `INNER JOIN`.

## `OUTER JOIN`

- There are `LEFT` and `RIGHT` outer joins, but `LEFT` is mostly used
- Outputs the record that has `NULL` in two tables' common columns
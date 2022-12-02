COMMIT;

UPDATE DEPARTMENT
SET
    DNAME='EDUCATION',
    LOC='SEOUL'
WHERE
    DNO = 50;

/* Oracle method, inner join(output no null) */
SELECT
    B.ENO, -- '.' specifies column's location
    B.ENAME,
    B.DNO, -- which table's DNO?
    A.DNAME
FROM
    DEPARTMENT A, -- Tables' alias
    EMPLOYEE   B
WHERE -- columns in common
    A.DNO = B.DNO;

/* ANSI method */
SELECT
    A.ENO,
    A.ENAME,
    A.DNO,
    B.DNAME -- Columns to select
FROM
    EMPLOYEE   A -- Perform an inner join between main table A,
    INNER JOIN DEPARTMENT B -- ...join table B,
    ON A.DNO = B.DNO; -- ...and join column

/* Add an employee */
INSERT INTO EMPLOYEE (
    ENO,
    ENAME,
    JOB,
    MANAGER,
    HIREDATE,
    SALARY,
    COMMISSION,
    DNO
) VALUES (
    9999,
    NULL,
    'STUDENT',
    7902,
    TO_DATE('1-12-2022', 'dd-mm-yyyy'),
    7500,
    NULL,
    30
);

/* Put some nulls */
UPDATE EMPLOYEE
SET
    ENAME = 'KADE',
    DNO = NULL
WHERE
    ENO = 9999;

UPDATE EMPLOYEE
SET
    ENAME = NULL,
    DNO = 30
WHERE
    ENO = 9999;

/* Left outer join(mostly used) */
SELECT
    A.ENO,
    A.ENAME,
    A.DNO,
    B.DNAME
FROM
    EMPLOYEE   A -- Main table
    LEFT OUTER JOIN DEPARTMENT B
    ON A.DNO = B.DNO; -- Outputs 'KADE' even if DNO field is null
-- is able to put WHERE word

/* LOJ, in Oracle way */
SELECT
    A.ENO,
    A.ENAME,
    A.DNO,
    B.DNAME
FROM
    EMPLOYEE   A,
    DEPARTMENT B
WHERE
    A.DNO = B.DNO(+); -- put (+) on RHS

INSERT INTO "KADE01"."TBL_MEMBER" (
    CUSTNO,
    CUSTNAME,
    PHONE,
    GENDER,
    JOINDATE,
    GRADE,
    CITY
) VALUES (
    100001,
    '김행복',
    '010-1111-2222',
    'M',
    '20151202',
    'A',
    '01'
);

INSERT INTO "KADE01"."TBL_MEMBER" (
    CUSTNO,
    CUSTNAME,
    PHONE,
    GENDER,
    JOINDATE,
    GRADE,
    CITY
) VALUES (
    100002,
    '이축복',
    '010-1111-3333',
    'M',
    '20151206',
    'B',
    '01'
);

INSERT INTO "KADE01"."TBL_MEMBER" (
    CUSTNO,
    CUSTNAME,
    PHONE,
    GENDER,
    JOINDATE,
    GRADE,
    CITY
) VALUES (
    '100003',
    '장믿음',
    '010-1111-4444',
    'F',
    '20151001',
    'B',
    '02'
);

INSERT INTO "KADE01"."TBL_MEMBER" (
    CUSTNO,
    CUSTNAME,
    PHONE,
    GENDER,
    JOINDATE,
    GRADE,
    CITY
) VALUES (
    100004,
    '최사랑',
    '010-1111-5555',
    'F',
    '20151113',
    'A',
    '02'
);

INSERT INTO "KADE01"."TBL_MEMBER" (
    CUSTNO,
    CUSTNAME,
    PHONE,
    GENDER,
    JOINDATE,
    GRADE,
    CITY
) VALUES (
    100005,
    '진평화',
    '010-1111-6666',
    'F',
    '20151225',
    'B',
    '11'
);

INSERT INTO "KADE01"."TBL_MEMBER" (
    CUSTNO,
    CUSTNAME,
    PHONE,
    GENDER,
    JOINDATE,
    GRADE,
    CITY
) VALUES (
    100006,
    '차공단',
    '010-1111-7777',
    'M',
    '20151211',
    'C',
    '11'
);

delete from TBL_MEMBER WHERE custno = 100007;

commit;

SELECT
    *
FROM
    TBL_MEMBER;
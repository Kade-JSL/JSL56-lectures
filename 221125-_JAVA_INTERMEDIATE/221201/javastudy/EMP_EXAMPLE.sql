DROP TABLE EMPLOYEE;

DROP TABLE DEPARTMENT;

DROP TABLE SALGRADE;

CREATE TABLE DEPARTMENT (
	DNO NUMBER(2) CONSTRAINT PK_DEPT PRIMARY KEY,
	DNAME VARCHAR2(14),
	LOC VARCHAR2(13)
);

CREATE TABLE EMPLOYEE (
	ENO NUMBER(4) CONSTRAINT PK_EMP PRIMARY KEY,
	ENAME VARCHAR2(10),
	JOB VARCHAR2(9),
	MANAGER NUMBER(4),
	HIREDATE DATE,
	SALARY NUMBER(7, 2),
	COMMISSION NUMBER(7, 2),
	DNO NUMBER(2) CONSTRAINT FK_DNO REFERENCES DEPARTMENT
);

CREATE TABLE SALGRADE (
	GRADE NUMBER,
	LOSAL NUMBER,
	HISAL NUMBER
);

INSERT INTO DEPARTMENT VALUES (
	10,
	'ACCOUNTING',
	'NEW YORK'
);

INSERT INTO DEPARTMENT VALUES (
	20,
	'RESEARCH',
	'DALLAS'
);

INSERT INTO DEPARTMENT VALUES (
	30,
	'SALES',
	'CHICAGO'
);

INSERT INTO DEPARTMENT VALUES (
	40,
	'OPERATIONS',
	'BOSTON'
);

INSERT INTO EMPLOYEE VALUES (
	7369,
	'SMITH',
	'CLERK',
	7902,
	TO_DATE('17-12-1980', 'dd-mm-yyyy'),
	800,
	NULL,
	20
);

INSERT INTO EMPLOYEE VALUES (
	7499,
	'ALLEN',
	'SALESMAN',
	7698,
	TO_DATE('20-2-1981', 'dd-mm-yyyy'),
	1600,
	300,
	30
);

INSERT INTO EMPLOYEE VALUES (
	7521,
	'WARD',
	'SALESMAN',
	7698,
	TO_DATE('22-2-1981', 'dd-mm-yyyy'),
	1250,
	500,
	30
);

INSERT INTO EMPLOYEE VALUES (
	7566,
	'JONES',
	'MANAGER',
	7839,
	TO_DATE('2-4-1981', 'dd-mm-yyyy'),
	2975,
	NULL,
	20
);

INSERT INTO EMPLOYEE VALUES (
	7654,
	'MARTIN',
	'SALESMAN',
	7698,
	TO_DATE('28-9-1981', 'dd-mm-yyyy'),
	1250,
	1400,
	30
);

INSERT INTO EMPLOYEE VALUES (
	7698,
	'BLAKE',
	'MANAGER',
	7839,
	TO_DATE('1-5-1981', 'dd-mm-yyyy'),
	2850,
	NULL,
	30
);

INSERT INTO EMPLOYEE VALUES (
	7782,
	'CLARK',
	'MANAGER',
	7839,
	TO_DATE('9-6-1981', 'dd-mm-yyyy'),
	2450,
	NULL,
	10
);

INSERT INTO EMPLOYEE VALUES (
	7788,
	'SCOTT',
	'ANALYST',
	7566,
	TO_DATE('13-07-1987', 'dd-mm-yyyy'),
	3000,
	NULL,
	20
);

INSERT INTO EMPLOYEE VALUES (
	7839,
	'KING',
	'PRESIDENT',
	NULL,
	TO_DATE('17-11-1981', 'dd-mm-yyyy'),
	5000,
	NULL,
	10
);

INSERT INTO EMPLOYEE VALUES (
	7844,
	'TURNER',
	'SALESMAN',
	7698,
	TO_DATE('8-9-1981', 'dd-mm-yyyy'),
	1500,
	0,
	30
);

INSERT INTO EMPLOYEE VALUES (
	7876,
	'ADAMS',
	'CLERK',
	7788,
	TO_DATE('13-07-1987', 'dd-mm-yyyy'),
	1100,
	NULL,
	20
);

INSERT INTO EMPLOYEE VALUES (
	7900,
	'JAMES',
	'CLERK',
	7698,
	TO_DATE('3-12-1981', 'dd-mm-yyyy'),
	950,
	NULL,
	30
);

INSERT INTO EMPLOYEE VALUES (
	7902,
	'FORD',
	'ANALYST',
	7566,
	TO_DATE('3-12-1981', 'dd-mm-yyyy'),
	3000,
	NULL,
	20
);

INSERT INTO EMPLOYEE VALUES (
	7934,
	'MILLER',
	'CLERK',
	7782,
	TO_DATE('23-1-1982', 'dd-mm-yyyy'),
	1300,
	NULL,
	10
);

INSERT INTO SALGRADE VALUES (
	1,
	700,
	1200
);

INSERT INTO SALGRADE VALUES (
	2,
	1201,
	1400
);

INSERT INTO SALGRADE VALUES (
	3,
	1401,
	2000
);

INSERT INTO SALGRADE VALUES (
	4,
	2001,
	3000
);

INSERT INTO SALGRADE VALUES (
	5,
	3001,
	9999
);

COMMIT;
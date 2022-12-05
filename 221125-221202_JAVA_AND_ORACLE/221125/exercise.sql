create table student (
    num number(4) not null primary key,
    name varchar2(12) not null,
    address varchar2(100) not null,
    tel varchar2(20) not null,
    kor number(3) not null,
    eng number(3) not null,
    mat number(3) not null,
    tot number(3),
    avg number(5,2)
);

-- dml
/* 명령어 한 줄씩 실행은 Ctrl+Enter, 전부 실행은 F5 */

insert into student (num, name, address, tel, kor, eng, mat) values
(1111, '케이드', '대전광역시', '010', 100, 100, 100);
/* 7개의 COLUMN애 들어가는 7개의 데이터 */
insert into student (num, name, address, tel, kor, eng, mat) values
(2222, '페시아', '대전광역시', '010', 90, 90, 90);
insert into student (num, name, address, tel, kor, eng, mat) values
(3333, '고양이', '대전광역시', '010', 80, 100, 70);
insert into student (num, name, address, tel, kor, eng, mat) values
(4444, '멍멍이', '대전광역시', '010', 100, 70, 70);
insert into student (num, name, address, tel, kor, eng, mat) values
(5555, '곰돌이', '대전광역시', '010', 90, 50, 50);

select * from student; -- 테이블의 모든 내용 검색
select num, name, address from student; -- 테이블의 특정 컬럼 검색
select * from student where name like '페%'; -- %는 '그 글자 뒤 몇 글자든'이라는 의미
select * from student where name like '케%'; -- name이 '케'로 시작하는 모든 레코드
select * from student where name like '고%';
select * from student where name like '멍%';
select * from student;
select kor, eng, mat from student; -- 이하 STUDENT 테이블 검색:
select * from student where kor >= 90; -- 국어점수 90점 이상
select * from student where eng < 90; -- 영어점수 90점 미만
select * from student where kor >= 90 or eng >= 90 or mat >= 90; -- 적어도 과목 하나는 90점 이상
select * from student where kor >= 90 and eng >= 90 and mat >= 90; -- 전 과목 90점 이상
select * from student where address like '대전광역시%'; -- 주소 필드 맨 앞에 대전광역시가 있는 레코드
select * from student where address like '대전광역시%' and name like '케%';
-- 주소 맨 앞에 대전광역시가 있고 이름이 케로 시작하는 레코드

select * from student;
select * from student where num = 3333;

/* 3333번 학번인 고양이 학생의 국어 점수를 50점으로 수정하고 싶다. */
update student set kor = 50 where num = 3333;
select * from student where num = 3333;

/* 4444번 멍멍이 학생의 수학 점수를 100점으로 수정 */
update student set mat = 100 where num = 4444; 
select * from student where num = 4444; 
select * from student;

/* 이름이 고양이인 학생의 주소를 대구광역시로 변경 */
update student set address = '대구광역시' where name = '고양이';
select * from student where name = '고양이';

/* 계산식으로 총점 구하기 */
select * from student;
update student set tot = kor + eng + mat;
select * from student;

/* 계산식으로 평균 구하기 */
update student set avg = tot / 3;
select * from student;

/* 학번 내림차순으로 출력 */
select * from student order by num desc;

select * from student where name like '페%';

/* 평균이 90점 이하인 레코드 검색 */
select * from student where avg < 90;

/* 케이드 학생은 무슨 잘못을 했길래 점수가 10점으로 떡락한 걸까요? */
update student set kor = 10, eng = 10, mat = 10 where num = 1111;
select * from student;
update student set tot = kor + eng + mat;
update student set avg = tot / 3;
select * from student;

/* 이름 오름차순(ASC는 치지 않아도 된다) */
select * from student order by name asc;

/* 평균 오름차순 */
select * from student order by avg desc;

/* 5555번 학생 삭제 */
delete student where num = 5555;
select * from student;

delete student where avg <= 80;
select * from student;
rollback;

/* RESULT 컬럼 만들기, 거기에 조건문에 따라 텍스트 넣기 */
alter table student add (memo varchar2(50)); -- 컬럼 추가
alter table student modify (memo varchar2(100)); -- 컬럼 자료형 수정
alter table student rename column memo to result; -- 컬럼 이름 변경
alter table student drop column result; --  컬럼 삭제
alter table student add (result varchar2(50)); -- 컬럼 다시 추가
select * from student;
update student set result = '합격' where avg >= 80; -- 컬럼에 내용 입력
select * from student;
update student set result = -- 조건에 따른 내용 입력
case
when avg >= 80 then '합격'
when avg < 80 then '불합격'
end;
select * from student;

select * from student where result = '불합격';


create table notice (
    bno number(3) not null primary key,
    title varchar2(500) not null,
    content varchar2(4000) not null,
    name varchar2(10) not null,
    viewcount number(3) default 0
);

desc notice; -- 제 환경(VS Code)에선 안 되더랩니다. 이게 뭐 DB 연결의 주체에 따라 다르다는데, 걍 SQL Developer 프로그램에선 되더군요.

insert into notice (
    bno, title, content, name
) values (
    1, '개발자 모집', '여기 자바 3명이요', '관리자'
);

select * from notice; -- NOTICE 테이블의 모든 컬럼 검색
select title, content from notice; -- 제목, 내용 컬럼만 검색

insert into notice
values (
    2, '자바 배우기', '객체지향 언어', '관리자', 0
);  -- 데이터를 순서대로 입력할 땐 컬럼 이름 안 입력해도 된다(디폴트까지 입력해 주자)
insert into notice (
    bno, title, content, name
) values (
    3, '제목임', '제곧내', '관리자'
);
insert into notice (
    bno, title, content, name
) values (
    4, '방구석에선 코딩허접이던 내가 마법학원에 갔더니 기대의 신입생?!', '방구석에서 코딩하다가 어디서 날아온 예외에 맞아서 죽었다. 하지만 죽었더니 웬 인도네시아 여성처럼 생긴 여신이 나타나서 나를 이세계로 부활시킨다고 하는 것이다. 가는 건 이세계인데 왜 나는 체크무늬 옷차림 그대로일까? 아니나다를까 전생해서 간 곳도 마법학원이라 쓰고 그냥 코딩학원이라 읽는 그런 인력양성소 같은 데였다.', '소설가'
);
insert into notice (
    bno, title, content, name
) values (
    5, '「別に」なんて言わないで、「またね」って言って', '私のものにならなくていい、傍にいるだけでいい', '千早'
);

select * from notice;

select * from notice where name = '소설가';
select * from notice where title like '%な%';
commit;
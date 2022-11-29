SELECT
    *
FROM
    STUDENT;

select * from student order by num;

SELECT
    MAX(NUM) AS BNO
FROM
    STUDENT;

DELETE notice
WHERE
    BNO = 6;

COMMIT;

delete from student;

delete from student where num = 3;

rollback;

insert into student (num, name, address, tel, kor, eng, mat, tot, avg, result)
values (1, '케이드', '대전광역시', '010', 100, 100, 100, 300, 100, '합격');

select * from notice;
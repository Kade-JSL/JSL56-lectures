SELECT
    *
FROM
    STUDENT;

SELECT
    MAX(NUM) AS BNO
FROM
    STUDENT;

DELETE notice
WHERE
    BNO = 6;

COMMIT;

select * from notice;
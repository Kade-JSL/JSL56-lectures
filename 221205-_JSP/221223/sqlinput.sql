﻿CREATE TABLE PORTFOLIO (
    BNO NUMBER NOT NULL,
    TITLE VARCHAR2(200) NOT NULL,
    CONTENT VARCHAR2(4000) NOT NULL,
    IMGURL VARCHAR2(200) NOT NULL,
    REGDATE DATE DEFAULT SYSDATE,
    WRITER VARCHAR2(20) DEFAULT '관리자',
    VIEWCOUNT NUMBER DEFAULT 0,
    CONSTRAINT PORT_PK PRIMARY KEY (BNO)
);

CREATE SEQUENCE PORT_SEQ;

SELECT * FROM PORTFOLIO;

COMMIT;
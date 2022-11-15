package dao;

import java.sql.Connection;

public class DBConn {
    private static Connection conn; // 데이터베이스 타입의 객체

    private DBConn() {} // new 예약어로 기본 생성자에 접근할 수 없도록 접근 제한
}

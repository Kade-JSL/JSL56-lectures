package controller;

import java.sql.Connection;
import java.sql.SQLException;
import dao.DBConn;

public class SingletonMain {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        // DBConn d = new DBConn(); // 컴파일 오류: singleton 패턴이 적용되어 생성자가 private이다.

        Connection c = DBConn.getInstance().getConnection(); // 열거형. chain 방식이라 부르기도 함.
        // 객체 생성 없음. 포인터로만 가리킴.
        // 포인터로 가서 가리키는 객체의 메서드를 실행하여 리턴값을 받음
        // getConnection()에서 던져진 예외를 받음: 또 던진다
        if (c != null) {
            System.out.println("오라클 DB에 접속되어 DB에 대한 CRUD 작업 처리가 가능해졌다!");
        }

        DBConn.getInstance().close();
        // 데이터베이스 처리를 하고 완료하면 close를 호출한다.
    }
}

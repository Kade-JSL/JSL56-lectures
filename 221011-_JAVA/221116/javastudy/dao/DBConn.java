package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConn {

    private static DBConn instance = new DBConn();
    // 데이터베이스 타입의 객체

    private DBConn() {}
    // new 예약어로 기본 생성자에 접근할 수 없도록 접근 제한

    private static Connection conn;
    // 멤버 변수니까 이것도 private이라 해 준다

    public static DBConn getInstance() {
        return instance;
    }
    // 결과: 이 DBConn 클래스는 자기 자신 안에서만 인스턴스가 하나 생성되어 있고,
    // 생성자가 private이므로 new 예약어를 통해 새로 인스턴스를 생성하는 것도 불가능하며,
    // getInstance()메소드를 호출하는 것으로만 이 클래스의 유일한 객체를 사용할 수 있다.
    // 이 방법론들의 조합을 singleton 패턴이라고 한다.

    public Connection getConnection() throws ClassNotFoundException, SQLException {
        /* 드라이버 로딩 */
        String driver = "oracle.jdbc.driver.OracleDriver",
                url = "jdbc:oracle:thin:@localhost:1521:xe", user = "kade01", pw = "1234";

        /* DBW 접속 */
        Class.forName(driver);
        // 클래스가 없는 예외가 발생함: 메서드 보고 던져 달라 하자

        conn = DriverManager.getConnection(url, user, pw);
        // SQL 예외가 발생: 역시 메서드 보고 던져 달라 하자

        return conn;
    }

    public void close() throws SQLException {
        if (conn != null) conn.close();
    }
}

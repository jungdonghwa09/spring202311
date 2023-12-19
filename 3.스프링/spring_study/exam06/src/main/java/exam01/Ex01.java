package exam01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Ex01 {
    public static void main(String[] args) throws ClassNotFoundException {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        String url = "jdbc:oracle:thin:@localhost:1521:orcl";
        String username = "SPRING6";
        String password = "_aA123456";
        Connection conn = null;
        //try뒤에()안에 해제할 자원을 쓰지 않으면 finally로 무조건적인 자원 해제가 필요
        try {
            conn = DriverManager.getConnection(url, username, password);
            System.out.println(conn);

        } catch (SQLException e) {
            e.printStackTrace();

        } finally {
            //예외가 발생하든 아니든 무조건 실행-자원 해제하는 부분
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e2) {
                }
            }


        }
    }
}

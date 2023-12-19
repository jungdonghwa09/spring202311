package exam01;

import java.sql.*;

public class Ex04 {
    public static void main(String[] args) throws ClassNotFoundException{
        Class.forName("oracle.jdbc.driver.OracleDriver");
        String url = "jdbc:oracle:thin:@localhost:1521:orcl";
        String username = "SPRING6";
        String password = "_aA123456";

        String sql="INSERT INTO MEMBER(USER_NO, USER_ID, USER_PW, USER_NM, EMAIL)"+
                "VALUES(SEQ_MEMBER.nextval, ?,?,?,?)";
        //setString뒤에 ""도 나중엔 변수로 적음, 일단 ""안의 내용은 서버로 넘어온 값을 db에 저장하기 위해
        //넘어온 값을 그대로 입력

        try(Connection conn = DriverManager.getConnection(url, username, password);
            PreparedStatement pstmt = conn.prepareStatement(sql, new String[]
                    {"USER_NO"})){
                pstmt.setString(1,"USER04");
            pstmt.setString(2,"123456");
            pstmt.setString(3,"사용자04");
            pstmt.setString(4,"user02@test.org");

            int result = pstmt.executeUpdate();
            ResultSet rs = pstmt.getGeneratedKeys();
            if(rs.next()){
                long userNo = rs.getLong(1);
                System.out.printf("USER_NO : %d%n", userNo);
            }

        }catch(SQLException e){
            e.printStackTrace();
        }
    }
}

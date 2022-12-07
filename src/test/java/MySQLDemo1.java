import java.sql.*;

public class MySQLDemo1 {
    public static void main(String[] args) {
        String dbUrl="jdbc:mysql://3.239.253.255:3306/syntaxhrm_mysql";
        String userName="syntax_hrm";
        String password="syntaxhrm123";

        try {
            Connection connection= DriverManager.getConnection(dbUrl,userName,password);
            Statement statement=connection.createStatement();
            String query="select * from person2";
            ResultSet resultSet=statement.executeQuery(query);
            while (resultSet.next()){
               String id =resultSet.getString("id");
               String firstname=resultSet.getString("FirstName");
               String lastname= resultSet.getString("LastName");
               String gender =resultSet.getString("Gender");
               String age= resultSet.getString("age");
                System.out.println(id+"     "+firstname+"     "+lastname+"   "+gender+"  "+age);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

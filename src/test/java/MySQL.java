import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class MySQL {
    public static void main(String[] args) {
        String dbUrl="jdbc:mysql://3.239.253.255:3306/syntaxhrm_mysql";
        String userName="syntax_hrm";
        String password="syntaxhrm123";
        List<Map<String,String>>tableDate=null;

        try {
            Connection connection= DriverManager.getConnection(dbUrl,userName,password);
            Statement statement=connection.createStatement();
            String query="select * from person2";
            ResultSet resultSet=statement.executeQuery(query);
            ResultSetMetaData resultSetMetaData=resultSet.getMetaData();
            tableDate=new ArrayList<>();
            while (resultSet.next()){
                LinkedHashMap<String,String>rwoData=new LinkedHashMap<>();
                for (int i =1; i <resultSetMetaData.getColumnCount() ; i++) {
                    rwoData.put(resultSetMetaData.getColumnName(i),resultSet.getString(i));

                }
                tableDate.add(rwoData);

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        System.out.print(tableDate);
    }
}

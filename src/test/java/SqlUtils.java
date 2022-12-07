import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class SqlUtils {

    public static List<Map<String,String>> Fetch_DbData(String query) {
        String dbUrl="jdbc:mysql://3.239.253.255:3306/syntaxhrm_mysql";
        String userName="syntax_hrm";
        String password="syntaxhrm123";
        Connection connection=null;
        Statement statement=null;
        ResultSet resultSet=null;

        try {
            connection= DriverManager.getConnection(dbUrl,userName,password);
            statement=connection.createStatement();
            resultSet=statement.executeQuery(query);
            ResultSetMetaData resultSetMetaData=resultSet.getMetaData();
            List<Map<String,String>>tableData=new ArrayList<>();
            while (resultSet.next()){
                LinkedHashMap<String,String>rowDta=new LinkedHashMap<>();
                for (int i = 1; i <resultSetMetaData.getColumnCount() ; i++) {
                    rowDta.put(resultSetMetaData.getColumnName(i),resultSet.getString(i));

                }
                tableData.add(rowDta);
            }
            return tableData;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            try {
                connection.close();
                statement.close();
                resultSet.close();
            }catch (SQLException e){
                throw new RuntimeException (e);
            }

        }
    }
}

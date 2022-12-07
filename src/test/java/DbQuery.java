public class DbQuery {
    public static void main(String[] args) {
        String query="select * from person where age>(select avg(age) from person)";
        System.out.println(SqlUtils.Fetch_DbData(query));

    }
}

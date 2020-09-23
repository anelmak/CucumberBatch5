package Utilities;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class JDBSTest2 {

    public static void main(String[] args) throws SQLException {

        JDBSUtils.establishConnection();
        List<Map<String, Object>> data = JDBSUtils.runQuery(
                "select first_name, last_name, salary from employees where salary >10000");

        System.out.println(data.get(0).get("FIRST_NAME"));
        System.out.println(data.get(5).get("SALARY"));

        for (int i=0; i<data.size(); i++){
            System.out.println(data.get(i).get("SALARY"));
        }
    }
}

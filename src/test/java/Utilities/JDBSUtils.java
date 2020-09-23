package Utilities;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JDBSUtils {

        /* STATIC METHODS
    .establishConnection();
    .runQuery(String query); -> returns list of maps
    .countRows(String query);
    .closeDatabase();
     */

    private static Connection connection;
    private static Statement statement;
    private static ResultSet resultSet;

    /**
     * This method will establish connection with Oracle SQL database
     */
    public static void establishConnection() {
        try {

            connection = DriverManager.getConnection(
                    CommonUtils.getProperty("DBURL"),
                    CommonUtils.getProperty("DBUsername"),
                    CommonUtils.getProperty("DBPassword")
            );
            statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static List<Map<String, Object>> runQuery(String query) throws SQLException {
        List<Map<String, Object>> data = new ArrayList<>();

            resultSet = statement.executeQuery(query);


        ResultSetMetaData rMetaData = resultSet.getMetaData();

        // looping through rows of that table
        while (resultSet.next()) {
            Map<java.lang.String, Object> map = new HashMap<>();
            // It is looping through each column of current row and stores to map
            for (int i = 1; i <= rMetaData.getColumnCount(); i++) {
                map.put(rMetaData.getColumnName(i), resultSet.getObject(rMetaData.getColumnName(i)));
            }
            data.add(map);
        }
        return data;
    }

    public static int countRows(String query) throws SQLException {
        resultSet = statement.executeQuery(java.lang.String.valueOf(query));
        resultSet.last();
        return resultSet.getRow();
    }

    /**
     * This method will close connection to database
     *
     * @throws SQLException
     */

    public static void closeDataBase() throws SQLException {
        if (connection != null) {
            connection.close();
        }
        if (statement != null) {
            statement.close();
        }
        if (resultSet != null) {
            resultSet.close();
        }
    }

    public static ResultSet getResultSet() {
        return resultSet;
    }
}






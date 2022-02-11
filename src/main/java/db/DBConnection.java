package db;

import java.sql.*;

public class DBConnection {

    private Connection connection;

    public DBConnection(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    //SELECT
    public ResultSet getDataBySQL(String sql) throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        return resultSet;
    }

    //DELET; EDIT; INSERT
    public void commandSQL(String sql) throws SQLException {
        Statement statement = connection.createStatement();
        statement.execute(sql);
    }


    //Comandos conexión
    public void connect() throws SQLException {
        connection = DriverManager.getConnection("jdbc:mysql://200.3.193.22/P09728_1_11", "P09728_1_11", "ZCSaQGZU");
    }

    public void disconnect() throws SQLException {
        connection.close();
    }
}

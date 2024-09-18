package ProductManagementSystem;

import java.sql.*;

public class Database {

    private String url = "jdbc:mysql://127.0.0.1:3306/?user=root/ProductWarehouse/Employees";
    private String username = "root";
    private String password = "Nikheel04";
    private Statement statement;

    public Database(){
        try{
            Connection myConnection = DriverManager.getConnection(url,username,password);
            statement = myConnection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        } catch (SQLException e1){
            e1.printStackTrace();
        }
    }

    public Statement getStatement(){
        return statement;
    }

}

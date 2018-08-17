package model.dao;

import config.Configuration;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.ResourceBundle;

public class DataConnection {

    private static Connection con = null;

    private DataConnection() {
    }
    
    public static Connection getConnection()throws Exception{
        if(con==null){
            ResourceBundle rb;
            rb = ResourceBundle.getBundle("config.Configuration");
            Class.forName(rb.getString("DRIVER_NAME"));
            con = DriverManager.getConnection(rb.getString("CONNECTION_URL"),
                    rb.getString("DB_USER"),rb.getString("DB_PASS"));
        }
        return con;
    }
    public static void closeConnection() throws Exception{
        if(con!=null){
            con.close();
        }
        con = null;
    }
    public static PreparedStatement getStatement(String query)throws Exception{
        return getConnection().prepareStatement(query);
    }
}

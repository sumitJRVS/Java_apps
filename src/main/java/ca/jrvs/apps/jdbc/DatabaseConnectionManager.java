package ca.jrvs.apps.jdbc;

import java.net.ConnectException;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DatabaseConnectionManager {
    private final String uurrll;
    private final Properties properties;

    //constructor begins...now...
    public DatabaseConnectionManager(String host, String dbname, String username, String password){

        this.uurrll ="jdbc:postgresql://"+host+"/"+dbname;
        this.properties = new Properties();
        this.properties.setProperty("user", username) ;
        this.properties.setProperty("password", password);
    }
    public Connection  getConnect()  throws SQLException{
        return DriverManager.getConnection(this.uurrll, properties );


    }

}

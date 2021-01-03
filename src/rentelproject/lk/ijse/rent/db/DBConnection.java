/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rentelproject.lk.ijse.rent.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Nipun
 */
public class DBConnection {
    private static DBConnection dBConnection;
    private Connection connection;
    
    private DBConnection() throws ClassNotFoundException, SQLException{
        Class.forName("com.mysql.jdbc.Driver");
        connection=DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/rentalproject",
                "root",
                "ijse"
        );
    }
     public static DBConnection getInstance() throws ClassNotFoundException, SQLException{
        return (null==dBConnection)?(dBConnection= new DBConnection()):(dBConnection);
    }
    
    public Connection getConnection(){
        return connection;
    }
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mpr;
import java.sql.*;

/**
 *
 * @author DELL
 */
public class DBConnection {
    Connection conn = null;
    static final String DB_URL = "jdbc:mysql:/localhost:3306/mydb";
    static final String USER ="root";
    static final String PASS ="";
    public static Connection connectDB(){
        try{
            Class.forName("con.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
            return conn;
        }catch(Exception e){
            System.out.println("There is an error"+e);
            return null;
        }
    }
}

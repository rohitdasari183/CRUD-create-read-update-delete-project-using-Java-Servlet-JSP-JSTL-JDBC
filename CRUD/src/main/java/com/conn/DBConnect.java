package com.conn;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author hp
 */
import java.sql.*;
public class DBConnect 
{
    private static Connection conn;
    public static Connection getConn()
    {
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/crud","root","");
            
                    
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return conn;
    }
    
}

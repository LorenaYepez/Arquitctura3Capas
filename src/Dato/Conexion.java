/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dato;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Johny
 */
public class Conexion {
    Connection con;
    Statement statement;
    
    public Connection getConnection(){
        String url= "jdbc:mysql://localhost:3306/cine";
        String user = "root";
        String pass = "";
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(url, user, pass);
        }catch(Exception e){
        }
        return con;
    }   
    /*EJECUTA UNA CONSULTA DE INSERCIONE EN LA BASE DE DATOS INSERT INTO VALUES */
    public int insertar(String sqlinsert){
        try {
           return statement.executeUpdate(sqlinsert); 
        }
        catch (Exception e){
           JOptionPane.showMessageDialog(null, e.getMessage(),"Insertar", JOptionPane.ERROR_MESSAGE); 
        }
        return 0;
    }
}


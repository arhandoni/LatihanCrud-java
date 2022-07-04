/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author DONI
 */
public class KoneksiDB {
    public KoneksiDB() { }
    
    public Connection openConnection() {
        Connection connection = null;
        
        // Define Connection
        String jdbcURL = "jdbc:mysql://localhost/db_latihan";
        String username = "root";
        String password = "password";
        
        try {
            // open connection
            connection = DriverManager.getConnection(jdbcURL, username, password);
            
            // check apakah koneksi berhasil
            if (connection !=null) {
                System.out.println("Connected to database");
                return connection;
            } else {
                System.out.println("Gagal koneksi ke database");
                return null;
            }
        } catch (SQLException ex){
            ex.printStackTrace();
        }
        return null;
    }
}


    


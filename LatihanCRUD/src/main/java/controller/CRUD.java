/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;




/**
 *
 * @author DONI
 */
public class CRUD {
    KoneksiDB koneksiDB;
    
    private Connection connection;
    private PreparedStatement preparedStatement;
    
    public CRUD (){
        koneksiDB = new KoneksiDB();
        }
    public HashMap getDataDosenByNidn(int nidn) {
        HashMap data = new HashMap();
        String sql = "SELECT * FROM dosen where nidn = ?";
        
        try {
            // open connection
            connection = koneksiDB.openConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, nidn);
            
            ResultSet result = preparedStatement.executeQuery();
            ResultMetaData resultSetMetaData = result.getMetaData();
            
            // uuntuk mengambil jumlah kolom
            int umlahKolom = resultSetMetaData.getColumnCount();
            
            while (result.next()) {
                for(int i = 1; i<= jumlahKolom; i++) {
                    data.put(resultSetMetaData.getColumnName(i), resuult.getString(i));
                }
            }
            
            // check apakah data ada atau tidak
            if (data.isEmpty()) {
                throw new Error ("Data tidak ditemukan!");
            }
            
            // close connection
            connection.close();
            preparedStatement.close();
            
            // end of get data
        } catch (Exception e) {
            System.out.println("Error getDataDosenByNidn(): " + e);
            e.printStackTrace();
        }
        
        return data;
    }
    
    public void deleteDataDosenById(int id) {
        String sql = "DELETE FROM dosen WHERE id = ?";
        
        try {
            // open connection
            connection = koneksiDB.openConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            
            // execute query
            int rows = preparedStatement.executeUpdate();
            
            // check berhasil delete data atau tidak
            if (rows > 0) {
                System.out.println("Data berhasil dihapus!");
            } else {
                throw new Error ("Data gagal dihapus");
            }
            
            // close connection
            connection.close();
            preparedStatement.close();
            
            // end of get data
        } catch (Exception e) {
            System.out.println("Error deleteDataDosenById() : " + e );
            e.printStackTrace();
        }
    }
}

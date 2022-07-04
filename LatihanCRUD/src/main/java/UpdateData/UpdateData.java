/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UpdateData;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
/**
 *
 * @author fauzan
 */
public class UpdateData {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        // pengenalan koneksi
        String jdbcURL = "jdbc:mysql://localhost/latihan";
        String username ="root";
        String password ="password";
        
        try{
            Connection connection =DriverManager.getConnection(jdbcURL, username, password);
            if (connection !=null){
                System.out.println("connected to Database");
                
                //update data
                String sql = "Update dosen SET alamat = 'jalan jalan' WHERE nidn = 12345";
                Statement statement = connection.createStatement();
                int rows = statement.executeUpdate(sql);
                
                //cek berhasil
                if (rows >0) {
                    System.out.println("data berhasil diubah");
                }else{
                   System.out.println("data gagal diubah") ;
                }
            
                connection.close();
            } 
    }catch (SQLException ex){
            ex.printStackTrace();
        }
    
}
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InsertDataDosen;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
/**
 *
 * @author fauzan
 */
public class InsertDataDosen {

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
            //get data
            String sql = "SELECT * FROM dosen";
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(sql);
            
            //loop
            while (result.next()){
               int nidn = result.getint ("nidn");
               String namaDosen = result.getString ("nama");
               String alamat = result.getString ("alamat");
               String JenisKelamin = result.getString ("jenis_kelamin");
               
               System.out.println("===================");
               System.out.println("nidn/t/t:  " + nidn);
               System.out.println("nama/t/t:  " + namaDosen);
               System.out.println("alamat/t/t:  " + alamat);
                System.out.println("jenis_kelamin/t/t:  " + JenisKelamin);
                System.out.println("===================");
            }
            
    }
    
}catch (SQLException ex){
     ex.printStackTrace();
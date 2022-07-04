/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import controller.CRUD;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

/**
 *
 * @author DONI
 */
public class Main {
    
    public static void main(String[] args){
        try {
            // menalakan controller
            Main obj = new Main();
            obj.controller(args);
        }catch (Exception e){
            e.printStackTrace();
        }            
    }
    
    // instace variables 
    public void controller (String[] args) throws Exception {
        // memanggil class CRUD
        CRUD crud = new CRUD();
        
        // memanggil clas BufferedReader untuk menginput data
        BufferedReader obekInput = new BufferedReader (new InputStreamReader(System.in));
        
        // instance variables here
        public void controller (String[] args) throws Exception {
            // memanggil class CRUD
            CRUD crud = new CRUD();
            
            // memanggil class BufferedReader untuk menginput data
            BufferedReader obekInput = new BufferedReader (new InputStreamReader(System.in));
            
            try {
                // mencetak tulisan input nidn
                System.out.print("input nidn");
                // fungsi inputan
                int nidn = Integer.parseInt(objekInput.readLine());
                
                // mengambil data dosen berdasarkan nidn
                HashMap dataDosen = crud.getDataDosenByNidn(nidn);
                
                int idDataDosen = Integer.parseInt(dataDosen.get("id".toString());
                
                // menghapus data dosen berdasarkan id
                crud.deleteDataDosenById(idDataDosen);
            }catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}

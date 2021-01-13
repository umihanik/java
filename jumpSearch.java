/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tugaspencarian;

import pencarian.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

/**
 *
 * @author admin
 */
public class JumpSearch {
        
    public static int jumpSearch(int[] arr, int x) 
    { 
        int n = arr.length; 
  
        // Finding block size to be jumped 
        int step = (int)Math.floor(Math.sqrt(n)); 
  
        // Finding the block where element is 
        // present (if it is present) 
        int prev = 0; 
        while (arr[Math.min(step, n)-1] < x) 
        { 
            prev = step; 
            step += (int)Math.floor(Math.sqrt(n)); 
            if (prev >= n) 
                return -1; 
        } 
  
        // Doing a linear search for x in block 
        // beginning with prev. 
        while (arr[prev] < x) 
        { 
            prev++; 
  
            // If we reached next block or end of 
            // array, element is not present. 
            if (prev == Math.min(step, n)) 
                return -1; 
        } 
  
        // If element is found 
        if (arr[prev] == x) 
            return prev; 
  
        return -1; 
    }
    public static void main(String args []) throws IOException{
    long start;
        long end;
 
        start = System.currentTimeMillis();//menghitung waktu proses dalam detik
        
        //    Objek BufferedReader
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader dataIn = new BufferedReader(isr);
         
        //    Input jumlah Data
        System.out.print("Masukkan jumlah Data : ");    
        int jlh_data = Integer.parseInt(dataIn.readLine());
         
        //    Array Data sebagai penampung nilai Data
        int[] data = new int[jlh_data];
         
        //    Pilih Metode Pengisian Data
        System.out.println("\nPENGISIAN DATA");
        System.out.println("1. Di input oleh user");
        System.out.print("2. Di input oleh program --> Pilihan [1 / 2]: ");
        int isi = Integer.parseInt(dataIn.readLine());
        switch(isi)
        {
            case 1    :    //    Pengisian Data dilakukan oleh si User
                for(int a = 0; a < jlh_data; a++)
                        {
                            System.out.print("Data ke-"+(a+1)+" : ");        
                            data[a] = Integer.parseInt(dataIn.readLine());
                        }
                            break;
                             
            case 2    :    //    Pengisian Data dilakukan oleh program secara random
                
                        for(int a = 0; a < jlh_data; a++)
                            data[a] = new Random().nextInt(201);    //    Data di isi secara random dengan nilai tertinggi 200
                         
                        //    Tampilkan Data yang di isi oleh program
                        
                        System.out.println("\nTampilkan Data");
                        for(int a = 0; a < jlh_data; a++)
                            System.out.println("Data ke-"+(a+1)+" : "+data[a]);
                        
                            break;
                             
            default    :    System.out.println("Pilihan tidak tersedia");    //    Jika pilihan menu tidak sesuai
        }
         
        //    Input Data yang dicari
        System.out.print("\nInput Data yang dicari : ");    
        int key = Integer.parseInt(dataIn.readLine());
        
//    Proses Jump Searching
        
       // Find the index of 'x' using Jump Search 
        int index = jumpSearch(data, key); 
  
        // Print the index where 'x' is located 
        System.out.println("\nNumber " + key + 
                            " is at index " + index);


        
        end = System.currentTimeMillis();
        System.out.println("\nWaktu yang diperlukan selama proses adalah " + ((end - start) / 1000.0) + " detik");
 
    }
}

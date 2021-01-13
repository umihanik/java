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
public class BinarySearch {
    void merge(int arr[], int l, int m, int r)
    {
        // Find sizes of two subarrays to be merged
        int n1 = m - l + 1;
        int n2 = r - m;
 
        /* Create temp arrays */
        int L[] = new int[n1];
        int R[] = new int[n2];
 
        /*Copy data to temp arrays*/
        for (int i = 0; i < n1; ++i)
            L[i] = arr[l + i];
        for (int j = 0; j < n2; ++j)
            R[j] = arr[m + 1 + j];
 
        /* Merge the temp arrays */
 
        // Initial indexes of first and second subarrays
        int i = 0, j = 0;
 
        // Initial index of merged subarry array
        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            }
            else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }
 
        /* Copy remaining elements of L[] if any */
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }
 
        /* Copy remaining elements of R[] if any */
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }
 
    // Main function that sorts arr[l..r] using
    // merge()
    void sort(int arr[], int l, int r)
    {
        if (l < r) {
            // Find the middle point
            int m = (l + r) / 2;
 
            // Sort first and second halves
            sort(arr, l, m);
            sort(arr, m + 1, r);
 
            // Merge the sorted halves
            merge(arr, l, m, r);
        }
    }
 
    /* A utility function to print array of size n */
    static void printArray(int arr[])
    {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }
    
    public static int pencarianBinary(int[] list, int key) {
        int bawah = 0; int atas = list.length - 1;
        while (atas >= bawah) {
        int tengah = (bawah + atas) / 2;
        if (key < list[tengah])
        atas = tengah - 1;
        else
        if (key == list[tengah])
        return tengah;
        else
        bawah = tengah + 1;
        }
        return -1; // tidak ditemukan
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
   
 
        BinarySearch ob = new BinarySearch();
        ob.sort(data, 0, data.length - 1);
 
        System.out.println("\nSorted array");
        printArray(data);
//                        System.out.println();
//                        for(int a = 0; a < jlh_data; a++)
//                        {
//                            System.out.print("Data ke-"+(a+1)+" : ");        
//                            data[a] = Integer.parseInt(dataIn.readLine());
//                        }
                            break;
                             
            case 2    :    //    Pengisian Data dilakukan oleh program secara random
                
                        for(int a = 0; a < jlh_data; a++)
                            data[a] = new Random().nextInt(201);    //    Data di isi secara random dengan nilai tertinggi 200
                         
                        //    Tampilkan Data yang di isi oleh program
                        
                        System.out.println("\nTampilkan Data");
                        for(int a = 0; a < jlh_data; a++)
                            System.out.println("Data ke-"+(a+1)+" : "+data[a]);
                        
                         BinarySearch ob2 = new BinarySearch();
        ob2.sort(data, 0, data.length - 1);
 
        System.out.print("\nSorted array \n");
        printArray(data);
                            break;
                             
            default    :    System.out.println("Pilihan tidak tersedia");    //    Jika pilihan menu tidak sesuai
        }
         
        //    Input Data yang dicari
        System.out.print("\nInput Data yang dicari : ");    
        int key = Integer.parseInt(dataIn.readLine());
        
//    Proses binary Searching
        
       int i = BinarylSearching.pencarianBinary(data, key);

System.out.println("Key " + key + " index " + i);


        
        end = System.currentTimeMillis();
        System.out.println("\nWaktu yang diperlukan selama proses adalah " + ((end - start) / 1000.0) + " detik");
 
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Soal1.ManajamenDataKaryawan;
import java.util.*;
/**
 *
 * @author Desi
 */
public class Perusahaan {
    private static List<Karyawan> dataKaryawan = new ArrayList<>();
    
    //Tambah karyawan baru
    public static boolean tambahKaryawan (Karyawan karyawan){
        //ID tidak boleh kosong
        if (karyawan.getId() == null || karyawan.getId().trim().isEmpty()) {
        System.out.println("ID karyawan harus diisi");
        return false;
        }
        //ID tidak boleh duplikat
        for (Karyawan existing : dataKaryawan) {
            if (existing.getId().equals(karyawan.getId())) {
                System.out.println("ID sudah digunakan");
                return false;
            }
        }
        //ID tidak boleh negatif
        if(karyawan.getGaji() < 0) {
            System.out.println("Gaji tidak boleh negatif");
            return false;
        }
        //Simpan ke list
        dataKaryawan.add(karyawan);
        return true;
    }
    

    //Update data jika id ditemukan
    public static boolean updateKaryawan(Karyawan karyawan) {
        for (int i = 0; i < dataKaryawan.size(); i++) {
            Karyawan current = dataKaryawan.get(i);
            if (current.getId().equalsIgnoreCase(karyawan.getId())) {
                dataKaryawan.set(i, karyawan);
                return true;
            }
        }
        System.out.println("Produk tidak ditemukan: " + karyawan.getId());
        return false;
    }
    
    //Delete data karyawan jika ID ditemukan
    public static boolean hapusKaryawan (String id) {
        boolean removed = dataKaryawan.removeIf(karyawan -> karyawan.getId().equalsIgnoreCase(id));
        if (removed) {
            System.out.println("Data karyawan "+id+" berhasil dihapus");
        } else {
            System.out.println("Produk tidak ditemukan");
        }
        return removed;
    }
    
    //Ambil seluruh data karyawan
    public static List<Karyawan> SemuaKaryawan() {
        return dataKaryawan;
    }
    
    
}

        
        
        
   


    
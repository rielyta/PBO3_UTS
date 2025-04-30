/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Soal2.ParkirChan;

import java.util.ArrayList;

/**
 *
 * @author Desi
 */
public class ParkingService {
    private final ArrayList<Kendaraan> daftarKendaraan = new ArrayList<>();
    
    public Kendaraan jenisKendaraan(String jenis) {
        return new Kendaraan(jenis);
    }
    
    public void DurasiManual(Kendaraan kendaraan, int jam) {
        kendaraan.setLamaParkir(jam);
        daftarKendaraan.add(kendaraan);
    }
    
    public void DurasiDenganWaktu(Kendaraan kendaraan, int masuk, int keluar){
        kendaraan.setLamaParkir(keluar-masuk);
        daftarKendaraan.add(kendaraan);
    }
    
    public ArrayList<Kendaraan> getDaftarKendaraan() {
        return daftarKendaraan;
    }
    
    public double hitungTotalBiaya() {
        double total = 0;
        for (Kendaraan k  : daftarKendaraan) {
            total += k.hitungBiaya();
        }
        return total;
    }
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Soal2.ParkirChan;

/**
 *
 * @author Desi
 */
public class Kendaraan {
    private String jenis;
    private int lamaParkir;
    private double biayaPerJam;
    
    public Kendaraan(String jenis) {
        this.jenis = jenis.toLowerCase();
        switch(this.jenis) {
            case "motor" -> biayaPerJam = 2000;
            case "mobil" -> biayaPerJam = 5000;
            case "truk"  -> biayaPerJam = 10000;
            default -> throw new IllegalArgumentException("Jenis kendaraan tidak valid");
            
        }
    }

    /**
     * @return the jenis
     */
    public String getJenis() {
        return jenis;
    }

    /**
     * @param jenis the jenis to set
     */
    public void setJenis(String jenis) {
        this.jenis = jenis;
    }

    /**
     * @return the Waktu
     */
    public int getLamaParkir() {
        return lamaParkir;
    }

    /**
     * @param Waktu the Waktu to set
     */
    public void setLamaParkir(int lamaParkir) {
        this.lamaParkir = lamaParkir;
    }

    /**
     * @return the Biaya
     */
    public double getBiayaPerJam() {
        return biayaPerJam;
    }

    /**
     * @param Biaya the Biaya to set
     */
    public void setBiayaPerJam(double biayaPerJam) {
        this.biayaPerJam = biayaPerJam;
    }
    
    public double hitungBiaya() {
        double total = lamaParkir * biayaPerJam;
        if (lamaParkir > 5) {
            total *= 0.9;
        }
        return total;
    }
    
    
}

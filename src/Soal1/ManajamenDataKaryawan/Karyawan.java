/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Soal1.ManajamenDataKaryawan;

/**
 *
 * @author Desi
 */
public class Karyawan {
    private String id;
    private String nama;
    private String posisi;
    private double gaji;   

    //Constructor
    public Karyawan(String id, String nama, String posisi, double gaji){
        this.id = id;
        this.nama = nama;
        this.posisi = posisi;
        this.gaji = gaji;
    }
    
    public Karyawan (String nama, String posisi, double gaji) {
        this.nama = nama;
        this.posisi = posisi;
        this.gaji = gaji;
    }
    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return the nama
     */
    public String getNama() {
        return nama;
    }

    /**
     * @param nama the nama to set
     */
    public void setNama(String nama) {
        this.nama = nama;
    }

    /**
     * @return the posisi
     */
    public String getPosisi() {
        return posisi;
    }

    /**
     * @param posisi the posisi to set
     */
    public void setPosisi(String posisi) {
        this.posisi = posisi;
    }

    /**
     * @return the gaji
     */
    public double getGaji() {
        return gaji;
    }

    /**
     * @param gaji the gaji to set
     */
    public void setGaji(double gaji) {
        this.gaji = gaji;
        
    }
    
    @Override
    public String toString() {
    return "ID: " + id + ", Nama: " + nama + ", Posisi: " + posisi + ", Gaji: " + gaji;
    }
    
}

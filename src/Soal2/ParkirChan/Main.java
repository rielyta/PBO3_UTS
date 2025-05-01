package Soal2.ParkirChan;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    //menyimpan daftar kendaraan
    private final ArrayList<Kendaraan> daftarKendaraan = new ArrayList<>();
    //manual
    public void durasiManual(Kendaraan kendaraan, int jam) {
        kendaraan.setLamaParkir(jam);
        daftarKendaraan.add(kendaraan);
    }
    //dengan waktu/time (jam keluar - jam masuk)
    public void durasiDenganWaktu(Kendaraan kendaraan, int masuk, int keluar) {
        kendaraan.setLamaParkir(keluar - masuk);
        daftarKendaraan.add(kendaraan);
    }
    //Getter mengambil daftar kendaraan
    public ArrayList<Kendaraan> getDaftarKendaraan() {
        return daftarKendaraan;
    }
    //mrnghitung total biaya
    public double hitungTotalBiaya() {
        double total = 0;
        for (Kendaraan k : daftarKendaraan) {
            total += k.hitungBiaya();
        }
        return total;
    }
    //Fungsi utama
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Main app = new Main();

        System.out.println("======= Welcome to ParkingChan =======");
        
        while (true) {
            //input jenis
            System.out.print("\nEnter vehicle type (Motor/Mobil/Truk) : ");
            String jenis = input.nextLine();
            //input metode
            System.out.print("Enter Duration (Manual/Time): ");
            String metode = input.nextLine();

            Kendaraan kendaraan;
            //validasi jenis
            try {
                kendaraan = new Kendaraan(jenis);
            } catch (IllegalArgumentException e) {
                System.out.println("Jenis kendaraan tidak valid.");
                continue;
            }
            //menentukan metode input durasi parkir
            try {
                if (metode.equalsIgnoreCase("Manual")) {
                    System.out.print("Enter Duration (in hour): ");
                    int jam = Integer.parseInt(input.nextLine());
                    if (jam <= 0) {
                        System.out.println("Durasi tidak valid.");
                        continue;
                    }
                    app.durasiManual(kendaraan, jam);
                } else if (metode.equalsIgnoreCase("Time")) {
                    System.out.print("Enter entry time  : ");
                    int masuk = Integer.parseInt(input.nextLine());
                    System.out.print("Enter exit time   : ");
                    int keluar = Integer.parseInt(input.nextLine());

                    if (keluar <= masuk) {
                        System.out.println("Exit time must be greater than entry time.");
                        continue;
                    }
                    app.durasiDenganWaktu(kendaraan, masuk, keluar);
                } else {
                    System.out.println("Metode durasi tidak valid.");
                    continue;
                }
            } catch (NumberFormatException e) {
                System.out.println("Input waktu tidak valid.");
                continue;
            }
            //ringkasan
            System.out.println("\n---- PARKING SUMMARY ----");
            System.out.println("Vehicle Type     : " + kendaraan.getJenis());
            System.out.println("Parking Time     : " + kendaraan.getLamaParkir() + " hour(s)");
            System.out.println("Total Fee        : Rp" + kendaraan.hitungBiaya());
            //menanyakan ingin menambah kendaraan lagi yang akan diproses
            System.out.print("\nAdd another vehicle? (y/n): ");
            if (!input.nextLine().equalsIgnoreCase("y")) break;
        }
        //output akhir
        System.out.println("\n======= FINAL REPORT =======");
        System.out.println("Total Vehicle Final        : " + app.getDaftarKendaraan().size());
        System.out.println("Total Parking Fees Final   : Rp" + app.hitungTotalBiaya());
        System.out.println("Thank You.....");
    }
}

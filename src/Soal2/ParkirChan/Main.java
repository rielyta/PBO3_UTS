package Soal2.ParkirChan;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private final ArrayList<Kendaraan> daftarKendaraan = new ArrayList<>();

    public void durasiManual(Kendaraan kendaraan, int jam) {
        kendaraan.setLamaParkir(jam);
        daftarKendaraan.add(kendaraan);
    }

    public void durasiDenganWaktu(Kendaraan kendaraan, int masuk, int keluar) {
        kendaraan.setLamaParkir(keluar - masuk);
        daftarKendaraan.add(kendaraan);
    }

    public ArrayList<Kendaraan> getDaftarKendaraan() {
        return daftarKendaraan;
    }

    public double hitungTotalBiaya() {
        double total = 0;
        for (Kendaraan k : daftarKendaraan) {
            total += k.hitungBiaya();
        }
        return total;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Main app = new Main();

        System.out.println("======= Welcome to ParkingChan =======");

        while (true) {
            System.out.print("\nEnter vehicle type (Motor/Mobil/Truk) : ");
            String jenis = input.nextLine();

            System.out.print("Enter Duration (Manual/Time): ");
            String metode = input.nextLine();

            Kendaraan kendaraan;

            try {
                kendaraan = new Kendaraan(jenis);
            } catch (IllegalArgumentException e) {
                System.out.println("Jenis kendaraan tidak valid.");
                continue;
            }

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

            System.out.println("\n---- PARKING SUMMARY ----");
            System.out.println("Vehicle Type     : " + kendaraan.getJenis());
            System.out.println("Parking Time     : " + kendaraan.getLamaParkir() + " hour(s)");
            System.out.println("Total Fee        : Rp" + kendaraan.hitungBiaya());

            System.out.print("\nAdd another vehicle? (y/n): ");
            if (!input.nextLine().equalsIgnoreCase("y")) break;
        }

        System.out.println("\n======= FINAL REPORT =======");
        System.out.println("Total Vehicle Final        : " + app.getDaftarKendaraan().size());
        System.out.println("Total Parking Fees Final   : Rp" + app.hitungTotalBiaya());
        System.out.println("Thank You.....");
    }
}

package Soal3.LotreGosok;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        LotreBoard board = new LotreBoard();

        System.out.println("======= Welcome to E-Lottery Gosok =======");

        while (true) {
            board.displayBoard();
            System.out.print("\nMasukkan tebakan anda (baris dan kolom) : ");
            int row = input.nextInt();
            int col = input.nextInt();

            if (row < 0 || row >= board.getRows() || col < 0 || col >= board.getCols()) {
                System.out.println("Koordinat di luar jangkauan!");
                continue;
            }

            if (board.Revealed(row, col)) {
                System.out.println("Kotak telah dibuka sebelumnya!");
                continue;
            }

            boolean safe = board.guess(row, col);
            if (!safe) {
                System.out.println("BOOM! Anda menemukan bom! Permainan berakhir.");
                board.displayBoard();
                break;
            } else {
                System.out.println("Kotak Aman");
                if (board.GameOver()) {
                    System.out.println("Selamat anda menang!");
                    board.displayBoard();
                    break;
                }
            }
        }
    }
}

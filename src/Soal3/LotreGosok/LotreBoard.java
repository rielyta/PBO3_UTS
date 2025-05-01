package Soal3.LotreGosok;

import java.util.Random;

public class LotreBoard {
    private final int rows = 4;
    private final int cols = 5;
    private final int[][] data;
    private final boolean[][] revealed;

    public LotreBoard() {
        data = new int[rows][cols];
        revealed = new boolean[rows][cols];
        generateBoard();
    }

    public void generateBoard() {
        Random rand = new Random();
        int bombsPlaced = 0;

        while (bombsPlaced < 2) {
            int r = rand.nextInt(rows);
            int c = rand.nextInt(cols);
            if (data[r][c] == 0) {
                data[r][c] = 1; 
                bombsPlaced++;
            }
        }
    }
    // menampilkan papan
    public void displayBoard() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (revealed[i][j]) {
                    if (data[i][j] == 1) {
                        System.out.print("X ");
                    } else {
                        System.out.print("O ");
                    }
                } else {
                    System.out.print("* ");
                }
            }
            System.out.println();
        }
    }
    //tebakan
    public boolean guess(int row, int col) {
        revealed[row][col] = true;
        return data[row][col] != 1;
    }
    //cek kotak udah pernah dibuka
    public boolean Revealed(int row, int col) {
        return revealed[row][col];
    }
    //cek permainan berakhir
    public boolean GameOver() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (data[i][j] == 0 && !revealed[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    public int getRows() {
        return rows;
    }

    public int getCols() {
        return cols;
    }
}

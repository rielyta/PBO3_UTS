/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Soal3.LotreGosok;

import java.util.Random;

/**
 *
 * @author Desi
 */
public class LotreBoard {
    private int rows = 4;
    private int cols = 5;
    private int[][] data;
    private boolean[][] revealed;
    
    public LotreBoard() {
        data = new int[rows][cols];
        revealed = new boolean[rows][cols];
        generateBoard();
    }
    
    private void generateBoard() {
        Random rand = new Random();
        int bombsPlaced = 0;
        
        while (bombsPlaced < 2) {
            int r = rand.nextInt(rows);
            int c = rand.nextInt(cols);
            if (data[r][c] == 0){
                data[r][c] = 1;
                bombsPlaced++;
            }
        }
    }
    
    public boolean isBomb(int row, int col) {
        return data [row][col] == 1;
    }
    
    public void reveal(int row, int col) {
        revealed[row][col] = true;
    }
    
    public boolean isRevealed(int row, int col) {
        return revealed[row][col];
    }
    
    public boolean isWin() {
        for (int i=0; i<data.length; i++) {
            for (int j=0; j<data[0].length; j++) {
                if (data[i][j] == 0 && !revealed[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
    
}

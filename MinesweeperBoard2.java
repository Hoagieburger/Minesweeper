/**
 * Write a description of class Minesweeper here.
 * 
 * @author Joshua Hergenroeder
 * @version 30 October 2017
 */
import java.lang.Math;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
public class MinesweeperBoard2{
    Cell[][] board;
    int rows, columns;
    public MinesweeperBoard2(int row, int column){
        //Put the constructor here.
        rows = row;
        columns = column;
        board = new Cell[rows][columns];
        //These pieces are for the GUI.
        JFrame frame = new JFrame();
        frame.add(addCells());   
        frame.pack();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
    public MinesweeperBoard2(){
        this(10,10); // Basic board size
    }
    public void addBombs(int bombs) throws Exception{
        if (bombs >= rows*columns && bombs < 1){
            System.out.println("Please quit the program and restart. Next time enter a valid integer.");
            throw new RuntimeException();
        }else{
            for (int i = 0; i < bombs; i++){
                boolean placed = false;
                while (!placed){
                    int r = (int)(Math.random() * rows);
                    int c = (int)(Math.random() * columns);
                    if (board[r][c].getValue() == 0){
                        board[r][c].changeValue(-1);
                        placed = true;
                    }
                }
            }
        }
    }
    public void addNums(){
        for (int i = 0; i < rows; i++){
            for (int j = 0; j < columns; j++){
                int adjacentBombs = 0;
                if (board[i][j].getValue() >= 0){ // Checks if current cell is a bomb
                    if (j - 1 >= 0){ // Cell to the left
                        if (board[i][j - 1].getValue() == -1){
                            adjacentBombs++;
                        }
                    }
                    if (j + 1 < columns){ // Cell to the right
                        if (board[i][j + 1].getValue() == -1){
                            adjacentBombs++;
                        }
                    }    
                    if (i - 1 >= 0 && j - 1 >= 0){ // Cell to the upper left
                        if (board[i - 1][j - 1].getValue() == -1){
                            adjacentBombs++;
                        }
                    }
                    if (i - 1 >= 0){ // Cell above
                        if (board[i - 1][j].getValue() == -1){
                            adjacentBombs++;
                        }
                    }
                    if (i - 1 >= 0 && j + 1 < columns){ // Cell to the upper right
                        if (board[i - 1][j + 1].getValue() == -1){
                            adjacentBombs++;
                        }
                    }
                    if (j - 1 >= 0 && i + 1 < rows){ // Cell to the lower left
                        if (board[i + 1][j - 1].getValue() == -1){
                            adjacentBombs++;
                        }
                    }
                    if (i + 1 < rows){ // Cell underneath
                        if (board[i + 1][j].getValue() == -1){
                            adjacentBombs++;
                        }
                    }
                    if (i + 1 < rows && j + 1 < columns){ // Cell to the lower right
                        if (board[i + 1][j + 1].getValue() == -1){
                            adjacentBombs++;
                        }
                    }
                    board[i][j].changeValue(adjacentBombs);
                }
            }
        }
    }
    /**This method is used for testing and will be deleted if using the GUI.    
     *  It is still required for all students.
     */
    public void printBoard(){
        for (int i = 0; i < rows; i++){
            for (int j = 0; j < columns; j++){
                int val = board[i][j].getValue();
                if (val < 0){
                    System.out.print("X ");
                }else{
                    System.out.print(val + " ");
                }
            }
            System.out.println();
        }
    }
    public JPanel addCells(){
        JPanel panel = new JPanel(new GridLayout(rows,columns));
        for(int i = 0; i< rows; i++){
            for (int j = 0; j < columns; j++){
                board[i][j] = new Cell();
                panel.add(board[i][j].getButton());
            }
        }
        return panel;
    }
    /*
     * public void unveilSurrounding(){
     *  
     *  }
     */
}
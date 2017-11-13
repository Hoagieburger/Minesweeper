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
    Cell[] board;
    int rows, columns;
    public MinesweeperBoard2(int row, int column){
        //Put the constructor here.
        rows = row;
        columns = column;
        board = new Cell[rows * columns];
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
        int[] bombIndex;
        if (bombs >= rows*columns && bombs < 1){
            throw new RuntimeException();
        }else{
            bombIndex = new int[bombs];
            int index;
            // Confusing way of making sure no duplicate indices
            for (int i = 0; i < bombs; i++){
                boolean r = true;
                index = (int)(Math.random() * rows * columns);
                while (r){
                    boolean usedIndex = false;
                    for (int j = 0; j < bombIndex.length; j++){
                        if (bombIndex[j] == index){
                            usedIndex = true;
                        }
                    }
                    if (usedIndex){
                        index = (int)(Math.random() * rows * columns);
                    }else{
                        r = false;
                    }
                }
                bombIndex[i] = index;
                board[index].changeValue(-1);
            }
        }
    }
    public void addNums(){
        int[] leftColumnIndex;
        int[] rightColumnIndex;
        for (int i = 0; i < board.length; i++){
            int adjacentBombs = 0;
            if (board[i].getValue() != -1){
                if (i == 0){ // Assigning top-left corner
                    if (board[1].getValue() == -1){
                        adjacentBombs++;
                    }
                    if (board[columns].getValue() == -1){
                        adjacentBombs++;
                    }
                    if (board[columns + 1].getValue() == -1){
                        adjacentBombs++;
                    }
                }else if (i == columns - 1){ // Assigning top-right corner
                    if (board[i - 1].getValue() == -1){
                        adjacentBombs++;
                    }
                    if (board[2 * columns - 1].getValue() == -1){
                        adjacentBombs++;
                    }
                    if (board[2 * columns - 2].getValue() == -1){
                        adjacentBombs++;
                    }
                }else if (i == rows * columns - 1){ // Assigning bottom-right corner
                    if (board[i - 1].getValue() == -1){
                        adjacentBombs++;
                    }
                    if (board[columns * (rows - 2)].getValue() == -1){
                        adjacentBombs++;
                    }
                    if (board[columns * (rows - 2) + 1].getValue() == -1){
                        adjacentBombs++;
                    }
                }else if (i == columns * (rows - 1)){ // Assigning bottom-left corner
                    if (board[i - 1].getValue() == -1){
                        adjacentBombs++;
                    }
                    if (board[columns * (rows - 1) -1].getValue() == - 1){
                        adjacentBombs++;
                    }
                    if (board[columns * (rows - 1) -1].getValue() == - 2){
                        adjacentBombs++;
                    }
                }else if (i > 0 && i < columns){ // Assigning rest of top row
                    if (board[i - 1].getValue() == -1){
                        adjacentBombs++;
                    }
                    if (board[i + 1].getValue() == -1){
                        adjacentBombs++;
                    }
                    if (board[i - 1 + columns].getValue() == -1){
                        adjacentBombs++;
                    }
                    if (board[i + columns].getValue() == -1){
                        adjacentBombs++;
                    }
                    if (board[i + 1 + columns].getValue() == -1){
                        adjacentBombs++;
                    }
                }else if (i < board.length - 1 && i > (rows - 1) * columns){ // Assigning rest of bottom row
                    if (board[i - 1].getValue() == -1){
                        adjacentBombs++;
                    }
                    if (board[i + 1].getValue() == -1){
                        adjacentBombs++;
                    }
                    if (board[i - 1 - columns].getValue() == -1){
                        adjacentBombs++;
                    }
                    if (board[i - columns].getValue() == -1){
                        adjacentBombs++;
                    }
                    if (board[i + 1 - columns].getValue() == -1){
                        adjacentBombs++;
                    }
                }else if (i % columns == 0){ // Assigning rest of left column
                    if (board[i + columns].getValue() == -1){
                        adjacentBombs++;
                    }
                    if (board[i + 1 + columns].getValue() == -1){
                        adjacentBombs++;
                    }
                    if (board[i + 1].getValue() == -1){
                        adjacentBombs++;
                    }
                    if (board[i - columns].getValue() == -1){
                        adjacentBombs++;
                    }
                    if (board[i + 1 - columns].getValue() == -1){
                        adjacentBombs++;
                    }
                }else if (i % (columns - 1) == 0){ // Assigning rest of right column
                    if (board[i - 1].getValue() == -1){
                        adjacentBombs++;
                    }
                    if (board[i - 1 - columns].getValue() == -1){
                        adjacentBombs++;
                    }
                    if (board[i - columns].getValue() == -1){
                        adjacentBombs++;
                    }
                    if (board[i - 1 + columns].getValue() == -1){
                        adjacentBombs++;
                    }
                    if (board[i + columns].getValue() == -1){
                        adjacentBombs++;
                    }
                }else{
                    if (board[i - 1].getValue() == -1){
                        adjacentBombs++;
                    }
                    if (board[i + 1].getValue() == -1){
                        adjacentBombs++;
                    }
                    if (board[i - 1 - columns].getValue() == -1){
                        adjacentBombs++;
                    }
                    if (board[i - columns].getValue() == -1){
                        adjacentBombs++;
                    }
                    if (board[i + 1 - columns].getValue() == -1){
                        adjacentBombs++;
                    }
                    if (board[i - 1 + columns].getValue() == -1){
                        adjacentBombs++;
                    }
                    if (board[i + columns].getValue() == -1){
                        adjacentBombs++;
                    }
                    if (board[i + 1 + columns].getValue() == -1){
                        adjacentBombs++;
                    }
                }
                board[i].changeValue(adjacentBombs);
            }
        }
    }
    /**This method is used for testing and will be deleted if using the GUI.
     *  It is still required for all students.
     */
    public void printBoard(){
        for (int i = 0; i < rows; i++){
            for (int j = 0; j < columns; j++){
                int value2 = board[i*columns+j].getValue();
                if (value2 < 0){
                    System.out.print("X ");
                }else{
                    System.out.print(value2 + " ");
                }
            }
            System.out.println();
        }
    }
    public JPanel addCells(){
        JPanel panel = new JPanel(new GridLayout(rows,columns));
        for(int i = 0; i< rows*columns; i++){
                board[i]= new Cell();
                panel.add(board[i].getButton());
        }
        return panel;
    }
}
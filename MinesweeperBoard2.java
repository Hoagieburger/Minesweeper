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
            for (int i = 0; i <= bombs; i++){
                boolean usedIndex = false,r = true;
                index = (int)(Math.random() * rows * columns + 1);
                while (r){
                    for (int j = 0; j < bombIndex.length; j++){
                        if (bombIndex[j] == index){
                            usedIndex = true;
                        }
                    }
                    if (usedIndex){
                        index = (int)(Math.random() * rows * columns + 1);
                    }else{
                        r = false;
                    }
                }
                board[index].changeValue(-1);
            }
        }
    }
    public void addNums(){
        
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
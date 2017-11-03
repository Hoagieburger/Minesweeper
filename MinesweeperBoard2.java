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
        this(10,10);
    }
    public void addBombs(int bombs) throws Exception{
        int[] bombIndex;
        if (bombs >= rows*columns){
            throw new RuntimeException();
        }else{
            bombIndex = new int[bombs];
            int index;
            for (int i = 0; i < bombs; i++){
                index = (int)(Math.random() * rows * columns + 1);
                if (!bombIndex.indexOf(index)){
                    bombIndex[i] = index;
                }else{
                    while (bombIndex.indexOf(index)){
                        index = (int)(Math.random() * rows * columns + 1);
                    }
                    bombIndex[i] = index;
                }
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
                System.out.print(board[i*columns+j].getValue() + " ");
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
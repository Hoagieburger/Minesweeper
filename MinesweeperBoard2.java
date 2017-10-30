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
    int rows;
    int columns;
    public MinesweeperBoard2(){
        //Put the constructor here.
        
        //These pieces are for the GUI.
        JFrame frame = new JFrame();
        frame.add(addCells());   
        frame.pack();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
    public void addBombs(int bombs) throws Exception{
        
    }
    public void addNums(){
        
    }
    /**This method is used for testing and will be deleted if using the GUI.
     *  It is still required for all students.
     */
    public void printBoard(){
        
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
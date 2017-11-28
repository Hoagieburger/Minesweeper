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
public class BoardPotentialChanges{
    PotentialCellChanges[] board;
    int rows, columns;
    public BoardPotentialChanges(int row, int column){
        //Put the constructor here.
        rows = row;
        columns = column;
        board = new PotentialCellChanges[rows * columns];
        //These pieces are for the GUI.
        JFrame frame = new JFrame();
        frame.add(addPotentialCellChangess());   
        frame.pack();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
    public BoardPotentialChanges(){
        this(10,10); // Basic board size
    }
    public void addBombs(int bombs) throws Exception{
        if (bombs >= rows*columns && bombs < 1){
            throw new RuntimeException();
        }else{
            for (int i = 0; i < bombs; i++){
                boolean placed = false;
                while (!placed){
                    int index = (int)(Math.random() * rows * columns);
                    if (board[index].getValue() == 0){
                        board[index].changeValue(-1);
                        placed = true;
                    }
                }
            }
        }
    }
    public void addNums(){
        for (int i = 0; i < board.length; i++){
            int adjacentBombs = 0;
            if (board[i].getValue() >= 0){
                if (i - 1 > 0){
                    if (board[i - 1].getValue() == -1 && i % columns != 0){
                        adjacentBombs++;
                    }
                }
                if (i + 1 < rows * columns){    
                    if (board[i + 1].getValue() == -1 && (i + 1) % columns != 0){
                        adjacentBombs++;
                    }
                }    
                if (i - 1 - columns > 0){
                    if (board[i - 1 - columns].getValue() == -1 && i % columns != 0){
                        adjacentBombs++;
                    }
                }
                if (i - columns > 0){
                    if (board[i - columns].getValue() == -1){
                        adjacentBombs++;
                    }
                }
                if (i + 1 - columns > 0){
                    if (board[i + 1 - columns].getValue() == -1 && (i + 1) % columns != 0){
                        adjacentBombs++;
                    }
                }
                if (i - 1 + columns < rows * columns){
                    if (board[i - 1 + columns].getValue() == -1 && i % columns != 0){
                        adjacentBombs++;
                    }
                }
                if (i + columns < rows * columns){
                    if (board[i + columns].getValue() == -1){
                        adjacentBombs++;
                    }
                }
                if (i + 1 + columns < rows * columns){
                    if (board[i + 1 + columns].getValue() == -1 && (i + 1) % columns != 0){
                        adjacentBombs++;
                    }
                }
                board[i].changeValue(adjacentBombs);
            }
        }
    }
    public void checkAdjacent(int pos){
        int i = pos;
        if (board[i].getValue() == 0){
                if (i - 1 > 0){
                    if (board[i - 1].getValue() == 0 && i % columns != 0){
                        board[i - 1].checkPotentialCellChanges();
                    }
                }
                if (i + 1 < rows * columns){    
                    if (board[i + 1].getValue() == 0 && (i + 1) % columns != 0){
                        board[i + 1].checkPotentialCellChanges();
                    }
                }    
                if (i - 1 - columns > 0){
                    if (board[i - 1 - columns].getValue() == 0 && i % columns != 0){
                        board[i - 1 - columns].checkPotentialCellChanges();
                    }
                }
                if (i - columns > 0){
                    if (board[i - columns].getValue() == 0){
                        board[i - columns].checkPotentialCellChanges();
                    }
                }
                if (i + 1 - columns > 0){
                    if (board[i + 1 - columns].getValue() == 0 && (i + 1) % columns != 0){
                        board[i + 1 - columns].checkPotentialCellChanges();
                    }
                }
                if (i - 1 + columns < rows * columns){
                    if (board[i - 1 + columns].getValue() == 0 && i % columns != 0){
                        board[i - 1 + columns].checkPotentialCellChanges();
                    }
                }
                if (i + columns < rows * columns){
                    if (board[i + columns].getValue() == 0){
                        board[i + columns].checkPotentialCellChanges();
                    }
                }
                if (i + 1 + columns < rows * columns){
                    if (board[i + 1 + columns].getValue() == 0 && (i + 1) % columns != 0){
                        board[i + 1 + columns].checkPotentialCellChanges();
                    }
                }
            }
    }
    /**This method is used for testing and will be deleted if using the GUI.
     *  It is still required for all students.
     */
    public void printBoard(){
        for (int i = 0; i < rows; i++){
            int j = 0;
            while (j < columns){
                int val = board[i*columns+j].getValue();
                if (val < 0){
                    System.out.print("X ");
                }else{
                    System.out.print(val + " ");
                }
                j++;
            }
            System.out.println();
        }
    }
    public JPanel addPotentialCellChangess(){
        JPanel panel = new JPanel(new GridLayout(rows,columns));
        for(int i = 0; i< rows*columns; i++){
            board[i]= new PotentialCellChanges(i);
            panel.add(board[i].getButton());
        }
        return panel;
    }
}
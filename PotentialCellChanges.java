/**
 * Write a description of class PotentialCellChanges here.
 * 
 * @author Joshua Hergenroeder
 * @version 30 October 2017
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class PotentialCellChanges implements ActionListener{
    //Variables you need to work with
    private int value, position;  
    //Variables you don't need to worry about or care about.
    private JButton button;
    /**
     * This constructor is complete and does not need modification
     */
    public PotentialCellChanges(int pos){
        position = pos;
        button = new JButton();
        button.addActionListener(this);
        button.setPreferredSize(new Dimension(20,20));
        button.setMargin(new Insets(0,0,0,0));
        value = 0;
    }
    /** This Method tells me if the PotentialCellChanges is a bomb.
     * 
     * @return True if it is a bomb, otherwse false.
     */
    boolean isBomb(){
        if (value == -1){
            return true;
        }else{
            return false;
        }
    }
    //Additional Methods may be required. Please make them yourself.
    
    //The following methods are used for the User Inferface. These methods are fully functional and do not need to be modified.
    public void checkPotentialCellChanges(){
        button.setEnabled(false);
        displayValue();
    }
    public void displayValue(){
        if(this.isBomb()){
            button.setText("\u2600");
            button.setBackground(Color.RED);
        }else if(value!=0){
            button.setText(String.valueOf(value));
        }
    }
    public JButton getButton() {
        return button;
    }
    public int getValue(){
        return value;
    }
    public int getPosition(){
        return position;
    }
    public void changeValue(int newValue){
        value = newValue;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        checkPotentialCellChanges();
        BoardPotentialChanges.checkAdjacent(position);
    }
}
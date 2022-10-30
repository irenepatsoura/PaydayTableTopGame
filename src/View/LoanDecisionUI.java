package View;

import Model.Player;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Enumeration;

public class LoanDecisionUI {
    private JDialog window;
    private JButton yes, no;
    private boolean wantsLoan = false;
    private BoardUI borad;
    private boolean pressedYes = false;
    private boolean pressedNo =false;


    public LoanDecisionUI(BoardUI board) {
        this.borad = board;
    }

    public boolean isPressedYes() {
        return pressedYes;
    }

    public void setPressedYes(boolean pressedYes) {
        this.pressedYes = pressedYes;
    }

    public boolean isPressedNo() {
        return pressedNo;
    }

    public void setPressedNo(boolean pressedNo) {
        this.pressedNo = pressedNo;
    }

    public void setWindow(JDialog window) {
        this.window = window;
    }

    public JDialog getWindow() {
        return window;
    }

    public BoardUI getBorad() {
        return borad;
    }

    public void setBorad(BoardUI borad) {
        this.borad = borad;
    }

    public boolean isWantsLoan() {
        return wantsLoan;
    }

    public void setWantsLoan(boolean wantsLoan) {
        this.wantsLoan = wantsLoan;
    }

    public JButton getNo() {
        return no;
    }

    public void setNo(JButton no) {
        this.no = no;
    }

    public JButton getYes() {
        return yes;
    }

    public void setYes(JButton yes) {
        this.yes = yes;
    }

    public void takeLoan() {

        String info = getBorad().getInfoBox().getText();
        String[] text = info.split("\n");

       JFrame f = new JFrame();
       window = new JDialog(f,"Loan", true);
       window.setLayout(new FlowLayout());
       JLabel label = new JLabel("Do you want to take loan?");
       label.setBounds(50,30,100,30);
       window.add(label);
       setYes(new JButton("Yes"));
       getYes().setBounds(40,70,50,20);
       window.add(getYes());
       getYes().addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               getWindow().setVisible(false);
               setWantsLoan(true);

               text[3] = "-->"+text[2]+": Press button Get Loan to take loan";

               getBorad().getInfoBox().setText(" ");

               for(int i=0; i< text.length; i++) {
                   getBorad().getInfoBox().setText(getBorad().getInfoBox().getText()+text[i] + "\n");
               }

               setPressedYes(true);
               getWindow().dispose();

           }
       });
       setNo(new JButton("No"));
       getNo().setBounds(100,70,50,20);
       window.add(getNo());
       getNo().addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               getWindow().setVisible(false);
               setWantsLoan(false);

               setPressedNo(true);
               getWindow().dispose();
           }
       });


       window.setLocationRelativeTo(null);
       window.setSize(200,100);
       window.setVisible(true);

    }
}

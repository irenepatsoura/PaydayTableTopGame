package View;

import Controller.Controller;
import Model.Player;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WinnerDialog {
    private Image image;
    private static JDialog LoanWindow;
    private JTextField LoanField;
    private JButton OKButton;
    private Player player;
    private BoardUI board;
    public static boolean tookloan = false;

    /**
     * <b>Constructor</b>Constructs a new instance of a Loan component
     */
    public WinnerDialog() {
    }

    public BoardUI getBoard() {
        return board;
    }

    public void setBoard(BoardUI board) {
        this.board = board;
    }

    /**
     * <b>Transformer(mutative)</b>Initializes our componentsr<br>
     * <p><b>Postcondition:</b>The new components have been initialized</p>
     */
    public void initComponents() {

        JFrame f = new JFrame();
        LoanWindow = new JDialog(f,"Winner", true);
        LoanWindow.setLayout(new FlowLayout());
//        LoanField = new JTextField(10);
        OKButton = new JButton("OK");
        OKButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                f.dispose();
            }
        });
        JPanel innerPannel = new JPanel();
//        innerPannel.add(LoanField);
        if((Controller.obj.getP1().getMoney()-Controller.obj.getP1().getBill()-Controller.obj.getP1().getLoan())>
                Controller.obj.getP2().getMoney()-Controller.obj.getP2().getBill()-Controller.obj.getP2().getLoan()){
            LoanWindow.add(new JLabel("Νικητή είναι ο παίχτης 1!!!!"));
        }else{
            LoanWindow.add(new JLabel("Νικητή είναι ο παίχτης 2!!!!"));
        }


        LoanWindow.setLocationRelativeTo(null);
//        LoanWindow.add(loanpos);
        LoanWindow.add(innerPannel);
        LoanWindow.add(OKButton);
        LoanWindow.setSize(400,200);
        LoanWindow.setVisible(true);

    }
    /**
     * <b>Transformer(mutative)</b>Initializes our buttons<br>
     * <p><b>Postcondition:</b>Our buttons have been initialized</p>
     */
    private void init_buttons() {

    }
    /**
     * A class that manages the take loan button
     */
    private class TakeLoanListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

        }
    }


}

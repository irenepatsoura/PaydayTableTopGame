package View;

import Controller.Controller;
import Model.Player;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 * Contains needed signatures to make a new instance of a Lottery Window
 */
public class LotteryUI {
    private Image image;
    private static JDialog LotteryWindow;
    private JTextField P1Field;
    private JButton OKButton;
//    private Player player1;
    private int num;
    private BoardUI board;
    public static boolean tookloan = false;

    /**
     * <b>Constructor</b>Constructs a new instance of a Loan component
     */
    public LotteryUI( BoardUI board) {
//        this.player = player;
        this.board = board;

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
    public int initComponents() {

        JFrame f = new JFrame();
        LotteryWindow = new JDialog(f,"Λαχείο", true);
        LotteryWindow.setLayout(new FlowLayout());
        JLabel label = new JLabel("Διαλεξε τον τυχερο σου αριθμο απο 1 μεχρι 6");
        P1Field = new JTextField(10);
        OKButton = new JButton("OK");
        OKButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if(Integer.parseInt(P1Field.getText()) > 0 && Integer.parseInt(P1Field.getText()) < 7) {
                    num = Integer.parseInt(P1Field.getText());
                    f.dispose();
                }
                else {
                    P1Field.setText("Wrong Input");
                }
            }
        });
        JPanel innerPannel = new JPanel();
        innerPannel.add(P1Field);
        ImageIcon loan = new ImageIcon("./images/lottery.png");
        image = loan.getImage();
        Image newimg = image.getScaledInstance(100,100, Image.SCALE_SMOOTH);
        loan = new ImageIcon(newimg);
        JLabel loanpos = new JLabel(loan);
        loanpos.setSize(200,100);
        LotteryWindow.setLocationRelativeTo(null);
        LotteryWindow.add(label);
        LotteryWindow.add(loanpos);
        LotteryWindow.add(innerPannel);
        LotteryWindow.add(OKButton);
        LotteryWindow.setSize(400,200);
        LotteryWindow.setVisible(true);

        return num;

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


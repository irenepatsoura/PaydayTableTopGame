package View;

import Controller.Controller;
import Model.Player;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 * Contains needed signatures to make a new instance of a Loan Window
 */
public class LoanUI {
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
    public LoanUI(Player player, BoardUI board) {
        this.player = player;
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
    public void initComponents() {

        JFrame f = new JFrame();
        LoanWindow = new JDialog(f,"Δάνειο", true);
        LoanWindow.setLayout(new FlowLayout());
        LoanField = new JTextField(10);
        OKButton = new JButton("OK");
        OKButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if(Integer.parseInt(LoanField.getText())%1000 == 0) {
                    player.setLoan(player.getLoan()+Integer.parseInt(LoanField.getText()));
                    player.setMoney(player.getMoney()+Integer.parseInt(LoanField.getText()));
                    tookloan = true;
                    f.dispose();

                    if(Controller.getTurn()==1) {
                       getBoard().getMoney1().setText("Money: "+String.valueOf(player.getMoney())+" Euros");
                       getBoard().getLoan1().setText("Loan: "+String.valueOf(player.getLoan())+" Euros");
                       getBoard().getWindow().repaint();
                    }
                    else if(Controller.getTurn()==2) {
                        getBoard().getMoney2().setText("Money: "+String.valueOf(player.getMoney())+" Euros");
                        getBoard().getLoan2().setText("Loan: "+String.valueOf(player.getLoan())+" Euros");
                        getBoard().getWindow().repaint();
                    }
                    else {
                        System.out.println("Wrong number of turn");
                    }

                }
                else {
                    LoanField.setText("Wrong Input");
                }
            }
        });
        JPanel innerPannel = new JPanel();
        innerPannel.add(LoanField);
        LoanWindow.add(new JLabel("Το δάνειο πρέπει να είναι πολλαπλάσιο των 1000 Ευρώ"));
        ImageIcon loan = new ImageIcon("./images/loan.png");
        image = loan.getImage();
        Image newimg = image.getScaledInstance(100,100, Image.SCALE_SMOOTH);
        loan = new ImageIcon(newimg);
        JLabel loanpos = new JLabel(loan);
        loanpos.setSize(200,100);
        LoanWindow.setLocationRelativeTo(null);
        LoanWindow.add(loanpos);
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

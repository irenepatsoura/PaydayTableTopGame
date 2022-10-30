package View;

import Controller.Controller;
import Model.DealCard;
import Model.DealDeck;
import Model.Player;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 * Contains needed signatures to make a new instance of a DealCards Component
 */
public class DealCardsUI extends JFrame {
    private Image image;
    private JButton BuyButton;
    private JButton IgnoreButton;
    private static JDialog dealCardWindow;
    private JOptionPane WindowInfo;
    private Player player;
    private DealCard dealcard;
    /**
     * <b>Constructor</b>Constructs a new instance of a Deal Cards UI component
     */
    public DealCardsUI(Player player, DealCard dealcard) {
        this.player = player;
        this.dealcard = dealcard;
    }
    /**
     * <b>Transformer(mutative)</b>Initializes our componentsr<br>
     * <p><b>Postcondition:</b>The new components have been initialized</p>
     */
    public void initComponents(String[] info) {
        JFrame f = new JFrame();
        dealCardWindow = new JDialog(f,"Συμφωνία", true);
        dealCardWindow.setLayout(new FlowLayout());
        BuyButton = new JButton(info[6]);
        BuyButton.addActionListener(new BuyListener());

        IgnoreButton = new JButton(info[7]);
        IgnoreButton.addActionListener(new IgnoreListener());

        dealCardWindow.add(new JLabel(info[2]));
        dealCardWindow.add(new JLabel(info[3]));
        dealCardWindow.add(new JLabel(info[4]));
        ImageIcon car = new ImageIcon("./resources/images/"+info[5]);
        image = car.getImage();
        Image newimg = image.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        car = new ImageIcon(newimg);
        JLabel carpos = new JLabel(car);
        carpos.setSize(100,100);
        carpos.setLocation(0,0);
        dealCardWindow.add(carpos);
        dealCardWindow.add(BuyButton);
        dealCardWindow.add(IgnoreButton);
        dealCardWindow.setSize(600,200);

        dealCardWindow.setLocationRelativeTo(null);
        dealCardWindow.setVisible(true);

    }
    /**
     * <b>Transformer(mutative)</b>Initializes our buttons<br>
     * <p><b>Postcondition:</b>Our buttons have been initialized</p>
     */
    private void init_buttons() {

    }
    /**
     * A class that manages the buy button
     */
    private class BuyListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            DealCardsUI.dealCardWindow.setVisible(false);
            int timi = dealcard.getBuyingCost();
            while(player.getMoney()<timi){
                LoanUI.tookloan = false;
                LoanUI l = new LoanUI(player,Controller.obj);
                l.initComponents();
                while(!LoanUI.tookloan){
                    System.out.print("");
                }
            }
            player.setMoney(player.getMoney()-timi);
            if(Controller.getTurn() ==1)  {
                Controller.obj.getMoney1().setText("Money: "+player.getMoney()+" Euros");
            }
            else {
                Controller.obj.getMoney2().setText("Money: "+player.getMoney()+" Euros");
            }
            Controller.obj.getWindow().repaint();
            player.addDeal(dealcard);
            Controller.obj.finished_deal = true;

        }
    }
    /**
     * A class that manages the ignore button
     */
    private class IgnoreListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            DealCardsUI.dealCardWindow.setVisible(false);
            DealDeck.addToDiscardPile(dealcard);
            Controller.obj.finished_deal = true;
        }
    }
}

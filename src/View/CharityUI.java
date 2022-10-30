package View;

import Controller.Controller;
import Model.Jackpot;
import Model.MailCard;
import Model.Player;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 * Contains needed signatures to make a new instance of a Charity window
 */
public class CharityUI extends JFrame {
    private Image image;
    private JButton PliroseButton;
    private static JDialog charityWindow;
    private JOptionPane WindowInfo;
    private Player player;
    private MailCard mailcard;
    /**
     * <b>Constructor</b>Constructs a new instance of a Charity window
     */
    public CharityUI(Player player, MailCard mailcard) {
        this.player = player;
        this.mailcard = mailcard;

    }
    /**
     * <b>Transformer(mutative)</b>Initializes our componentsr<br>
     * <p><b>Postcondition:</b>The new components have been initialized</p>
     */
    public void initComponents(String[] info) {
        JFrame f = new JFrame();
        charityWindow = new JDialog(f,"Φιλανθρωπία", true);
        charityWindow.setLayout(new FlowLayout());
        PliroseButton = new JButton(info[3]);
        PliroseButton.addActionListener(new PayToJackpotListener());
        charityWindow.add(new JLabel(info[2]));
        ImageIcon computerdesktop = new ImageIcon("./resources/images/"+info[5]);
        image = computerdesktop.getImage();
        Image newimg = image.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        computerdesktop = new ImageIcon(newimg);
        JLabel cdpos = new JLabel(computerdesktop);
        cdpos.setSize(100,100);
        cdpos.setLocation(10,30);
        charityWindow.setLocationRelativeTo(null);
        charityWindow.add(cdpos);
        charityWindow.add(PliroseButton);
        charityWindow.setSize(400,200);
        charityWindow.setVisible(true);

    }
    /**
     * <b>Transformer(mutative)</b>Initializes our buttons<br>
     * <p><b>Postcondition:</b>Our buttons have been initialized</p>
     */
    private void init_buttons() {

    }
    /**
     * A class that manages the pay to jackpot button
     */
    private class PayToJackpotListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            CharityUI.charityWindow.setVisible(false);
            int timi = mailcard.getMoney();
            while(player.getMoney()<timi){
                LoanUI.tookloan = false;
                LoanUI l = new LoanUI(player,Controller.obj);
                l.initComponents();
                while(!LoanUI.tookloan){
                    System.out.print("");
                }
            }
            //player.setMoney(player.getMoney()-timi);
//            Jackpot.setMoney(Jackpot.getMoney()+timi);
//            Controller.obj.getJtxt().setText("Jackpot "+String.valueOf(Jackpot.getMoney())+" Euros");

            String info = Controller.obj.getInfoBox().getText();
            String[] text = info.split("\n");

            if(Controller.getTurn()==1) {
                Controller.obj.getMoney1().setText("Money: "+String.valueOf(player.getMoney())+" Euros");
            }
            else {
                Controller.obj.getMoney2().setText("Money: "+String.valueOf(player.getMoney())+" Euros");
            }
            Controller.obj.getWindow().repaint();
            text[3] = "-->You gave "+String.valueOf(timi)+" Euros to charity";

            Controller.obj.getInfoBox().setText(" ");

            for(int i=0; i< text.length; i++) {
                Controller.obj.getInfoBox().setText(Controller.obj.getInfoBox().getText()+text[i] + "\n");

            }
            Controller.obj.getWindow().repaint();

        }
    }
}

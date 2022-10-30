package View;

import Model.MailCard;
import Model.Player;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 * Contains needed signatures to make a new instance of an Advertisement window
 */
public class AdvertisementUI extends JFrame {
    private Image image;
    private JButton PouliseTinButton;
    private static JDialog adWindow;
    private JOptionPane WindowInfo;
    private Player player;
    private MailCard mailcard;
    /**
     * <b>Constructor</b>Constructs a new instance of an Advertisement window
     */
    public AdvertisementUI(Player player, MailCard mailcard) {
        this.player = player;
        this.mailcard = mailcard;
    }
    /**
     * <b>Transformer(mutative)</b>Initializes our componentsr<br>
     * <p><b>Postcondition:</b>The new components have been initialized</p>
     */
    public void initComponents(String[] info) {

        JFrame f = new JFrame();
        adWindow = new JDialog(f,"Διαφήμιση", true);
        adWindow.setLayout(new FlowLayout());
        PouliseTinButton = new JButton(info[3]);
        PouliseTinButton.addActionListener(new SellListener());
        adWindow.add(new JLabel(info[2]));
        ImageIcon computerdesktop = new ImageIcon("./resources/images/"+info[5]);
        image = computerdesktop.getImage();
        Image newimg = image.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        computerdesktop = new ImageIcon(newimg);
        JLabel cdpos = new JLabel(computerdesktop);
        cdpos.setSize(100,100);
        cdpos.setLocation(10,30);
        adWindow.setLocationRelativeTo(null);
        adWindow.add(cdpos);
        adWindow.add(PouliseTinButton);
        adWindow.setSize(400,200);
        adWindow.setVisible(true);

    }
    /**
     * <b>Transformer(mutative)</b>Initializes our buttons<br>
     * <p><b>Postcondition:</b>Our buttons have been initialized</p>
     */
    private void init_buttons() {

    }
    /**
     * A class that manages the sell button
     */
    private class SellListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            AdvertisementUI.adWindow.setVisible(false);
//            int timi = mailcard.getMoney();
//            player.setMoney(player.getMoney()+timi);

        }
    }
}

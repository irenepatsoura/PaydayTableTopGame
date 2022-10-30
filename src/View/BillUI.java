package View;

import Model.MailCard;
import Model.MailDeck;
import Model.Player;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 * Contains needed signatures to make a new instance of a Bill window
 */
public class BillUI extends JFrame {
    private Image image;
    private JButton KrataButton;
    private static JDialog billWindow;
    private JOptionPane WindowInfo;
    private Player player;
    private MailCard mailcard;
    /**
     * <b>Constructor</b>Constructs a new instance of a Bill window
     */
    public BillUI(Player player, MailCard mailcard) {
        this.player = player;
        this.mailcard = mailcard;
    }
    /**
     * <b>Transformer(mutative)</b>Initializes our componentsr<br>
     * <p><b>Postcondition:</b>The new components have been initialized</p>
     */
    public void initComponents(String[] info) {
        JFrame f = new JFrame();
        billWindow = new JDialog(f,"Εξόφληση Λογαριασμού", true);
        billWindow.setLayout(new FlowLayout());
        KrataButton = new JButton(info[3]);
        KrataButton.addActionListener(new KeepBillListener());
        billWindow.add(new JLabel(info[2]));
        ImageIcon computerdesktop = new ImageIcon("./resources/images/"+info[5]);
        image = computerdesktop.getImage();
        Image newimg = image.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        computerdesktop = new ImageIcon(newimg);
        JLabel cdpos = new JLabel(computerdesktop);
        cdpos.setSize(100,100);
        cdpos.setLocation(10,30);
        billWindow.setLocationRelativeTo(null);
        billWindow.add(cdpos);
        billWindow.add(KrataButton);
        billWindow.setSize(500,200);
        billWindow.setVisible(true);

    }
    /**
     * <b>Transformer(mutative)</b>Initializes our buttons<br>
     * <p><b>Postcondition:</b>Our buttons have been initialized</p>
     */
    private void init_buttons() {

    }
    /**
     * A class that manages the Keep bill button
     */
    private class KeepBillListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            player.addMail(mailcard);
            BillUI.billWindow.setVisible(false);
        }

    }
}

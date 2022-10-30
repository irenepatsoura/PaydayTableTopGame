package View;

import Controller.Controller;
import Model.MailCard;
import Model.Player;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 * Contains needed signatures to make a new instance of a Move to deal buyer Window
 */
public class MoveToDealBuyerUI extends JFrame {
    private Image image;
    private JButton OKButton;
    private static JDialog movetodealWindow;
    private JOptionPane WindowInfo;
    private Player player;
    private MailCard mailcard;
    /**
     * <b>Constructor</b>Constructs a new instance of a Move to deal buyer component
     */
    public MoveToDealBuyerUI(Player player, MailCard mailcard) {
        this.player = player;
        this.mailcard = mailcard;

    }
    /**
     * <b>Transformer(mutative)</b>Initializes our componentsr<br>
     * <p><b>Postcondition:</b>The new components have been initialized</p>
     */
    public void initComponents(String[] info) {
        JFrame f = new JFrame();
        movetodealWindow = new JDialog(f,"Μετακίνηση σε Θέση Συμφωνίας/Αγοραστή", true);
        movetodealWindow.setLayout(new FlowLayout());
        OKButton = new JButton(info[3]);
        OKButton.addActionListener(new GoToNextListener());
        movetodealWindow.add(new JLabel(info[2]));
        ImageIcon computerdesktop = new ImageIcon("./resources/images/"+info[5]);
        image = computerdesktop.getImage();
        Image newimg = image.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        computerdesktop = new ImageIcon(newimg);
        JLabel cdpos = new JLabel(computerdesktop);
        cdpos.setSize(100,100);
        cdpos.setLocation(10,30);
        movetodealWindow.setLocationRelativeTo(null);
        movetodealWindow.add(cdpos);
        movetodealWindow.add(OKButton);
        movetodealWindow.setSize(400,200);
        movetodealWindow.setVisible(true);

    }
    /**
     * <b>Transformer(mutative)</b>Initializes our buttons<br>
     * <p><b>Postcondition:</b>Our buttons have been initialized</p>
     */
    private void init_buttons() {

    }
    /**
     * A class that manages the go to next button
     */
    private class GoToNextListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            MoveToDealBuyerUI.movetodealWindow.setVisible(false);
//            player.moveToDeal(player.getPos().getNumOnBoard());

            String info = Controller.obj.getInfoBox().getText();
            String[] text = info.split("\n");

            text[3] = "-->If your position requires it Take another card.";

            Controller.obj.getInfoBox().setText(" ");

            for(int i=0; i< text.length; i++) {
                Controller.obj.getInfoBox().setText(Controller.obj.getInfoBox().getText()+text[i] + "\n");

            }
            Controller.obj.getWindow().repaint();
        }
    }
}

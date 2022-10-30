package View;

import Controller.Controller;
import Model.MailCard;
import Model.Player;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 * Contains needed signatures to make a new instance of a Pay the neighbor Window
 */
public class PayTheNeighborUI extends JDesktopPane {
    private Image image;
    private JButton PliroseButton;
    private JOptionPane WindowInfo;
    private JDesktopPane desktopPane;
    private Container contentPane;
    private static JDialog paytheneighborWindow;
    private Player player1, player2;
    private MailCard mailcard;
    /**
     * <b>Constructor</b>Constructs a new instance of a pay the neighbor component
     */
    public PayTheNeighborUI(Player player1,Player player2, MailCard mailcard) {
        this.player1 = player1;
        this.player2 = player2;
        this.mailcard = mailcard;
    }
    /**
     * <b>Transformer(mutative)</b>Initializes our componentsr<br>
     * <p><b>Postcondition:</b>The new components have been initialized</p>
     */
    public void initComponents(String[] info) {
        JFrame f = new JFrame();
        paytheneighborWindow = new JDialog(f,"Πλήρωσε τον Γείτονα", true);
        paytheneighborWindow.setLayout(new FlowLayout());
        PliroseButton = new JButton(info[3]);
        PliroseButton.addActionListener(new PayListener());
        paytheneighborWindow.add(new JLabel(info[2]));
        ImageIcon computerdesktop = new ImageIcon("./resources/images/"+info[5]);
        image = computerdesktop.getImage();
        Image newimg = image.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        computerdesktop = new ImageIcon(newimg);
        JLabel cdpos = new JLabel(computerdesktop);
        cdpos.setSize(100,100);
        cdpos.setLocation(10,30);
        paytheneighborWindow.setLocationRelativeTo(null);
        paytheneighborWindow.add(cdpos);
        paytheneighborWindow.add(PliroseButton);
        paytheneighborWindow.setSize(400,200);
        paytheneighborWindow.setVisible(true);

    }

    /**
     * <b>Transformer(mutative)</b>Initializes our buttons<br>
     * <p><b>Postcondition:</b>Our buttons have been initialized</p>
     */
    private void init_buttons() {

    }
    /**
     * A class that manages the pay next button
     */
    private class PayListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            PayTheNeighborUI.paytheneighborWindow.setVisible(false);
            int timi = mailcard.getMoney();
            while(player1.getMoney()<timi){
                LoanUI.tookloan = false;
                LoanUI l = new LoanUI(player1,Controller.obj);
                l.initComponents();
                while(!LoanUI.tookloan){
                    System.out.print("");
                }
            }
//            player1.setMoney(player1.getMoney()-timi);
//            player2.setMoney(player2.getMoney()+timi);

            String info = Controller.obj.getInfoBox().getText();
            String[] text = info.split("\n");


//            if(Controller.getTurn()==1) {
//                Controller.obj.getMoney1().setText("Money: "+String.valueOf(player1.getMoney())+" Euros");
//                Controller.obj.getMoney2().setText("Money: "+String.valueOf(player2.getMoney())+" Euros");
//            }
//            else {
//                Controller.obj.getMoney1().setText("Money: "+String.valueOf(player2.getMoney())+" Euros");
//                Controller.obj.getMoney2().setText("Money: "+String.valueOf(player1.getMoney())+" Euros");
//            }
            Controller.obj.getWindow().repaint();
            text[3] = "-->You paid your neighbor "+String.valueOf(timi)+" Euros";

            Controller.obj.getInfoBox().setText(" ");

            for(int i=0; i< text.length; i++) {
                Controller.obj.getInfoBox().setText(Controller.obj.getInfoBox().getText()+text[i] + "\n");

            }
            Controller.obj.getWindow().repaint();

        }
    }
}

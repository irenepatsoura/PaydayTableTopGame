package View;

import Controller.Controller;
import Model.MailCard;
import Model.Player;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 * Contains needed signatures to make a new instance of a take money from neighbor Window
 */
public class TakeMoneyFromNeighborUI extends JFrame {
    private Image image;
    private JButton TakeMoneyButton;
    private static JDialog takeMoneyWindow;
    private JOptionPane WindowInfo;
    private Player player1, player2;
    private MailCard mailcard;

    /**
     * <b>Constructor</b>Constructs a new instance of a take money from the neighbor component
     */
    public TakeMoneyFromNeighborUI(Player player1, Player player2, MailCard mailcard) {
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
        takeMoneyWindow = new JDialog(f,"Πάρε λεφτα απο τον Γείτονα", true);
        takeMoneyWindow.setLayout(new FlowLayout());
        TakeMoneyButton = new JButton(info[3]);
        TakeMoneyButton.addActionListener(new TakeMoneyListener());
        takeMoneyWindow.add(new JLabel(info[2]));
        ImageIcon computerdesktop = new ImageIcon("./resources/images/"+info[5]);
        image = computerdesktop.getImage();
        Image newimg = image.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        computerdesktop = new ImageIcon(newimg);
        JLabel cdpos = new JLabel(computerdesktop);
        cdpos.setSize(100,100);
        cdpos.setLocation(10,30);
        takeMoneyWindow.setLocationRelativeTo(null);
        takeMoneyWindow.add(cdpos);
        takeMoneyWindow.add(TakeMoneyButton);
        takeMoneyWindow.setSize(400,200);
        takeMoneyWindow.setVisible(true);

    }
    /**
     * <b>Transformer(mutative)</b>Initializes our buttons<br>
     * <p><b>Postcondition:</b>Our buttons have been initialized</p>
     */
    private void init_buttons() {

    }
    /**
     * A class that manages the take money button
     */
    private class TakeMoneyListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            TakeMoneyFromNeighborUI.takeMoneyWindow.setVisible(false);
            int timi = mailcard.getMoney();
            while(player2.getMoney()<timi){
                LoanUI.tookloan=false;
                LoanUI l = new LoanUI(player2,Controller.obj);
                l.initComponents();
                while(!LoanUI.tookloan){
                    System.out.print("");
                }
            }
            //player2.setMoney(player2.getMoney()-timi);
//            player1.setMoney(player1.getMoney()+timi);

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
            text[3] = "-->You earned "+String.valueOf(timi)+" Euros from your neighbor";

            Controller.obj.getInfoBox().setText(" ");

            for(int i=0; i< text.length; i++) {
                Controller.obj.getInfoBox().setText(Controller.obj.getInfoBox().getText()+text[i] + "\n");

            }
            Controller.obj.getWindow().repaint();

        }
    }
}

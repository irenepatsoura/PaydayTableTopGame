package View;

import Controller.Controller;
import Model.Player;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.management.PlatformLoggingMXBean;

/**
 * Contains needed signatures to make a new instance of a Crypto Thurdsay window
 */
public class CryptoThursdayUI {
    private Image image;
    private JButton BetButton, IgnoreButton, WonButton, LostButton, SteadyButton;
    private JLabel cryptopos;
    private static JDialog investWindow, AuksisiWindow, DropWindow, SteadyWindow;
    private Player player;
    private JFrame f = new JFrame();
    /**
     * <b>Constructor</b>Constructs a new instance of a Crypto Thurdsay window
     */
    public CryptoThursdayUI(Player player) {
        this.player = player;

    }
    /**
     * <b>Transformer(mutative)</b>Initializes our componentsr<br>
     * <p><b>Postcondition:</b>The new components have been initialized</p>
     */
    public void initComponents() {

        investWindow = new JDialog(f, "Crypto Thursday", true);
        investWindow.setLayout(new FlowLayout());
        BetButton = new JButton("Πόνταρε στο κρυπτονόμισμα");
        BetButton.addActionListener(new BetListener());
        IgnoreButton = new JButton("Παράβλεψε το ποντάρισμα");
        IgnoreButton.addActionListener(new IgnoreListener());
        investWindow.add(new JLabel("Ποντάρισμα σε κρυπτονόμισμα"));
        ImageIcon crypto = new ImageIcon("./images/crypto.jpeg");
        image = crypto.getImage();
        Image newimg = image.getScaledInstance(100,100, Image.SCALE_SMOOTH);
        crypto = new ImageIcon(newimg);
        cryptopos = new JLabel(crypto);
        cryptopos.setSize(200,100);
        investWindow.setLocationRelativeTo(null);
        investWindow.add(cryptopos);
        investWindow.add(BetButton);
        investWindow.add(IgnoreButton);
        investWindow.setSize(450,200);
        investWindow.setVisible(true);

    }

    public void auksisi() {
        JFrame f = new JFrame();
        AuksisiWindow = new JDialog(f,"Crypto Thursday", true);
        AuksisiWindow.setLayout(new FlowLayout());
        WonButton = new JButton("Κέρδισες 2400 Ευρω");
        WonButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CryptoThursdayUI.AuksisiWindow.setVisible(false);
                player.setMoney(player.getMoney()+2400);
                if(Controller.getTurn() == 1){
                    Controller.obj.getMoney1().setText("Money:"+player.getMoney()+" Euros");
                }else{
                    Controller.obj.getMoney2().setText("Money:"+player.getMoney()+" Euros");
                }
                Controller.obj.getWindow().repaint();
            }
        });
        AuksisiWindow.add(new JLabel("Το κρυπτονόμισμα εκτοξεύτηκε!"));
        ImageIcon crypto = new ImageIcon("./images/crypto.jpeg");
        image = crypto.getImage();
        Image newimg = image.getScaledInstance(100,100, Image.SCALE_SMOOTH);
        crypto = new ImageIcon(newimg);
        cryptopos = new JLabel(crypto);
        cryptopos.setSize(200,100);
        AuksisiWindow.setLocationRelativeTo(null);
        AuksisiWindow.add(cryptopos);
        AuksisiWindow.add(WonButton);
        AuksisiWindow.setSize(350,200);
        AuksisiWindow.setVisible(true);
    }

    public void ptwsh() {
        JFrame f = new JFrame();
        DropWindow = new JDialog(f,"Crypto Thursday", true);
        DropWindow.setLayout(new FlowLayout());
        LostButton = new JButton("Εχασες τα 300 Ευρω");
        LostButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                while(player.getMoney()<300){
                    LoanUI.tookloan = false;
                    LoanUI l = new LoanUI(player,Controller.obj);
                    l.initComponents();
                    while(!LoanUI.tookloan){
                        System.out.print("");
                    }
                }
                CryptoThursdayUI.DropWindow.setVisible(false);
                player.setMoney(player.getMoney()-300);
                if(Controller.getTurn() == 1){
                    Controller.obj.getMoney1().setText("Money:"+player.getMoney()+" Euros");
                }else{
                    Controller.obj.getMoney2().setText("Money:"+player.getMoney()+" Euros");
                }
                Controller.obj.getWindow().repaint();
            }
        });
        DropWindow.add(new JLabel("Το κρυπτονόμισμα έπεσε ακαριαία..."));
        ImageIcon crypto = new ImageIcon("./images/crypto.jpeg");
        image = crypto.getImage();
        Image newimg = image.getScaledInstance(100,100, Image.SCALE_SMOOTH);
        crypto = new ImageIcon(newimg);
        cryptopos = new JLabel(crypto);
        cryptopos.setSize(200,100);
        DropWindow.setLocationRelativeTo(null);
        DropWindow.add(cryptopos);
        DropWindow.add(LostButton);
        DropWindow.setSize(400,200);
        DropWindow.setVisible(true);
    }

    public void omalothta() {
        JFrame f = new JFrame();
        SteadyWindow = new JDialog(f,"Crypto Thursday", true);
        SteadyWindow.setLayout(new FlowLayout());
        SteadyButton = new JButton("Παίρνεις τα 300 Ευρώ πίσω");
        SteadyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CryptoThursdayUI.SteadyWindow.setVisible(false);
            }
        });
        SteadyWindow.add(new JLabel("Η αξία του κρυπτονομίσματος παρέμεινε σταθερή"));
        ImageIcon crypto = new ImageIcon("./images/crypto.jpeg");
        image = crypto.getImage();
        Image newimg = image.getScaledInstance(100,100, Image.SCALE_SMOOTH);
        crypto = new ImageIcon(newimg);
        cryptopos = new JLabel(crypto);
        cryptopos.setSize(200,100);
        SteadyWindow.setLocationRelativeTo(null);
        SteadyWindow.add(cryptopos);
        SteadyWindow.add(SteadyButton);
        SteadyWindow.setSize(450,200);
        SteadyWindow.setVisible(true);
    }

    /**
     * <b>Transformer(mutative)</b>Initializes our buttons<br>
     * <p><b>Postcondition:</b>Our buttons have been initialized</p>
     */
    private void init_buttons() {

    }
    /**
     * A class that manages the bet button
     */
    private class BetListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            CryptoThursdayUI.investWindow.setVisible(false);
            int zaria = Controller.roll_dice();
            if(zaria == 1 || zaria == 2) {

                ptwsh();
            }
            else if(zaria == 3 || zaria == 4) {

                omalothta();
            }
            else if(zaria == 5 || zaria ==6) {

                auksisi();
            }
            else {
                System.out.println("Lathos zaria");
                System.out.println(zaria);
            }

        }
    }
    /**
     * A class that manages the ignore button
     */
    private class IgnoreListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            CryptoThursdayUI.investWindow.setVisible(false);
            f.dispose();
        }
    }
}

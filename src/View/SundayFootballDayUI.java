package View;

import Controller.Controller;
import Model.Player;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 * Contains needed signatures to make a new instance of a sunday football day Window
 */
public class SundayFootballDayUI {
    private Image image;
    private JButton BarcelonaButton;
    private JButton RMButton;
    private JButton DrawButton;
    private JButton NoPredictionButton;
    private JButton WinButton;
    private JButton LoseButton;
    private static JDialog pontarismaWindow, FCBWinnerWindow, RMWinnerWindow, drawWindow, FCBLoserWindow, RMLoserWindow;
    private JLabel fcbrmpos;
    private int zaria;
    private JFrame f = new JFrame();
    private Player player;
    /**
     * <b>Constructor</b>Constructs a new instance of a pay the sunday football component
     */
    public SundayFootballDayUI(Player player) {
        this.player = player;

    }

    public int getZaria() {
        return zaria;
    }

    public void setZaria(int zaria) {
        this.zaria = zaria;
    }

    /**
     * <b>Transformer(mutative)</b>Initializes our componentsr<br>
     * <p><b>Postcondition:</b>The new components have been initialized</p>
     */
    public void initComponents() {

        pontarismaWindow = new JDialog(f, "Ποδοσφαιρικός Αγώνας Κυριακής", true);
        pontarismaWindow.setLayout(new FlowLayout());
        WinButton = new JButton("Νίκη Μπαρτσελόνα");
        WinButton.addActionListener(new BarcelonaListener());
        LoseButton = new JButton("Νίκη Ρεάλ");
        LoseButton.addActionListener(new RMListener());
        DrawButton = new JButton("Ισοπαλία");
        DrawButton.addActionListener(new DrawListener());
        NoPredictionButton = new JButton("Δεν θέλω να ποντάρω");
        NoPredictionButton.addActionListener(new NoPredicitonListener());
        pontarismaWindow.add(new JLabel("Στοιχηματίστε 500 Ευρώ για το ντέρμπι Barcelona-Real"));
        ImageIcon fcbreal = new ImageIcon("./images/Barcelona_Real.jpg");
        image = fcbreal.getImage();
        Image newimg = image.getScaledInstance(200,100, Image.SCALE_SMOOTH);
        fcbreal = new ImageIcon(newimg);
        fcbrmpos = new JLabel(fcbreal);
        fcbrmpos.setSize(200,100);
        fcbrmpos.setLocation(0,0);
        pontarismaWindow.setLocationRelativeTo(null);
        pontarismaWindow.add(fcbrmpos);
        pontarismaWindow.add(WinButton);
        pontarismaWindow.add(LoseButton);
        pontarismaWindow.add(DrawButton);
        pontarismaWindow.add(NoPredictionButton);
        pontarismaWindow.setSize(600,200);
        pontarismaWindow.setVisible(true);

    }

    public void nikifbc() {
        JFrame f = new JFrame();
        FCBWinnerWindow = new JDialog(f,"Ποδοσφαιρικός Αγώνας Κυριακής", true);
        FCBWinnerWindow.setLayout(new FlowLayout());
        BarcelonaButton = new JButton("Κέρδισες 1000 Ευρω");
        BarcelonaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SundayFootballDayUI.FCBWinnerWindow.setVisible(false);
                player.setMoney(player.getMoney()+1000);
                if(Controller.getTurn() == 1){
                    Controller.obj.getMoney1().setText("Money:"+player.getMoney()+" Euros");
                }else{
                    Controller.obj.getMoney2().setText("Money:"+player.getMoney()+" Euros");
                }
                Controller.obj.getWindow().repaint();
            }
        });
        FCBWinnerWindow.add(new JLabel("Σωστή Πρόβλεψη!!!! Barcelona-Real 1-0"));
        ImageIcon fcbreal = new ImageIcon("./images/Barcelona_Real.jpg");
        image = fcbreal.getImage();
        Image newimg = image.getScaledInstance(200,100, Image.SCALE_SMOOTH);
        fcbreal = new ImageIcon(newimg);
        fcbrmpos = new JLabel(fcbreal);
        fcbrmpos.setSize(250,100);
        fcbrmpos.setLocation(0,0);
        FCBWinnerWindow.setLocationRelativeTo(null);
        FCBWinnerWindow.add(fcbrmpos);
        FCBWinnerWindow.add(BarcelonaButton);
        FCBWinnerWindow.setSize(500,200);
        FCBWinnerWindow.setVisible(true);
    }

    public void nikiRM() {
        JFrame f = new JFrame();
        RMWinnerWindow = new JDialog(f,"Ποδοσφαιρικός Αγώνας Κυριακής", true);
        RMWinnerWindow.setLayout(new FlowLayout());
        RMButton = new JButton("Κέρδισες 1000 Ευρω");
        RMButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SundayFootballDayUI.RMWinnerWindow.setVisible(false);
                player.setMoney(player.getMoney()+1000);
                if(Controller.getTurn() == 1){
                    Controller.obj.getMoney1().setText("Money:"+player.getMoney()+" Euros");
                }else{
                    Controller.obj.getMoney2().setText("Money:"+player.getMoney()+" Euros");
                }
                Controller.obj.getWindow().repaint();
            }
        });
        RMWinnerWindow.add(new JLabel("Σωστή Πρόβλεψη!!!! Barcelona-Real 0-1"));
        ImageIcon fcbreal = new ImageIcon("./images/Barcelona_Real.jpg");
        image = fcbreal.getImage();
        Image newimg = image.getScaledInstance(200,100, Image.SCALE_SMOOTH);
        fcbreal = new ImageIcon(newimg);
        fcbrmpos = new JLabel(fcbreal);
        fcbrmpos.setSize(250,100);
        fcbrmpos.setLocation(0,0);
        RMWinnerWindow.setLocationRelativeTo(null);
        RMWinnerWindow.add(fcbrmpos);
        RMWinnerWindow.add(RMButton);
        RMWinnerWindow.setSize(500,200);
        RMWinnerWindow.setVisible(true);
    }

    public void isopalia() {
        JFrame f = new JFrame();
        drawWindow = new JDialog(f,"Ποδοσφαιρικός Αγώνας Κυριακής", true);
        drawWindow.setLayout(new FlowLayout());
        DrawButton = new JButton("Κέρδισες 1000 Ευρω");
        DrawButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SundayFootballDayUI.drawWindow.setVisible(false);
                player.setMoney(player.getMoney()+1000);
                if(Controller.getTurn() == 1){
                    Controller.obj.getMoney1().setText("Money:"+player.getMoney()+" Euros");
                }else{
                    Controller.obj.getMoney2().setText("Money:"+player.getMoney()+" Euros");
                }
                Controller.obj.getWindow().repaint();
            }
        });
        drawWindow.add(new JLabel("Σωστή Πρόβλεψη!!!! Barcelona-Real 1-1"));
        ImageIcon fcbreal = new ImageIcon("./images/Barcelona_Real.jpg");
        image = fcbreal.getImage();
        Image newimg = image.getScaledInstance(200,100, Image.SCALE_SMOOTH);
        fcbreal = new ImageIcon(newimg);
        fcbrmpos = new JLabel(fcbreal);
        fcbrmpos.setSize(250,100);
        fcbrmpos.setLocation(0,0);
        drawWindow.setLocationRelativeTo(null);
        drawWindow.add(fcbrmpos);
        drawWindow.add(DrawButton);
        drawWindow.setSize(500,200);
        drawWindow.setVisible(true);

    }

    public void httaFCB() {
        JFrame f = new JFrame();
        FCBLoserWindow = new JDialog(f,"Ποδοσφαιρικός Αγώνας Κυριακής", true);
        FCBLoserWindow.setLayout(new FlowLayout());
        BarcelonaButton = new JButton("Εχασες τα 500 Ευρώ");
        BarcelonaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                while(player.getMoney()<500){
                    LoanUI.tookloan=false;
                    LoanUI l = new LoanUI(player,Controller.obj);
                    l.initComponents();
                    while(!LoanUI.tookloan){
                        System.out.print("");
                    }
                }
                SundayFootballDayUI.FCBLoserWindow.setVisible(false);
                player.setMoney(player.getMoney()-500);
                if(Controller.getTurn() == 1){
                    Controller.obj.getMoney1().setText("Money:"+player.getMoney()+" Euros");
                }else{
                    Controller.obj.getMoney2().setText("Money:"+player.getMoney()+" Euros");
                }
                Controller.obj.getWindow().repaint();
            }
        });
        FCBLoserWindow.add(new JLabel("Λάθος Πρόβλεψη... Barcelona-Real 0-1"));
        ImageIcon fcbreal = new ImageIcon("./images/Barcelona_Real.jpg");
        image = fcbreal.getImage();
        Image newimg = image.getScaledInstance(200,100, Image.SCALE_SMOOTH);
        fcbreal = new ImageIcon(newimg);
        fcbrmpos = new JLabel(fcbreal);
        fcbrmpos.setSize(250,100);
        fcbrmpos.setLocation(0,0);
        FCBLoserWindow.setLocationRelativeTo(null);
        FCBLoserWindow.add(fcbrmpos);
        FCBLoserWindow.add(BarcelonaButton);
        FCBLoserWindow.setSize(500,200);
        FCBLoserWindow.setVisible(true);
    }

    public void httaRM() {
        JFrame f = new JFrame();
        RMLoserWindow = new JDialog(f,"Ποδοσφαιρικός Αγώνας Κυριακής", true);
        RMLoserWindow.setLayout(new FlowLayout());
        RMButton = new JButton("Εχασες τα 500 Ευρώ");
        RMButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                while(player.getMoney()<500){
                    LoanUI.tookloan = false;
                    LoanUI l = new LoanUI(player,Controller.obj);
                    l.initComponents();
                    while(!LoanUI.tookloan){
                        System.out.print("");
                    }
                }
                SundayFootballDayUI.RMLoserWindow.setVisible(false);
                player.setMoney(player.getMoney()-500);
                if(Controller.getTurn() == 1){
                    Controller.obj.getMoney1().setText("Money:"+player.getMoney()+" Euros");
                }else{
                    Controller.obj.getMoney2().setText("Money:"+player.getMoney()+" Euros");
                }
                Controller.obj.getWindow().repaint();
            }
        });
        RMLoserWindow.add(new JLabel("Λάθος Πρόβλεψη... Barcelona-Real 1-0"));
        ImageIcon fcbreal = new ImageIcon("./images/Barcelona_Real.jpg");
        image = fcbreal.getImage();
        Image newimg = image.getScaledInstance(200,100, Image.SCALE_SMOOTH);
        fcbreal = new ImageIcon(newimg);
        fcbrmpos = new JLabel(fcbreal);
        fcbrmpos.setSize(250,100);
        fcbrmpos.setLocation(0,0);
        RMLoserWindow.setLocationRelativeTo(null);
        RMLoserWindow.add(fcbrmpos);
        RMLoserWindow.add(RMButton);
        RMLoserWindow.setSize(500,200);
        RMLoserWindow.setVisible(true);
    }
    /**
     * <b>Transformer(mutative)</b>Initializes our buttons<br>
     * <p><b>Postcondition:</b>Our buttons have been initialized</p>
     */
    private void init_buttons() {



    }
    /**
     * A class that manages the barcelona button
     */
    private class BarcelonaListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            SundayFootballDayUI.pontarismaWindow.setVisible(false);
                setZaria(Controller.roll_dice());
                if(getZaria() == 1 || getZaria() == 2) {
                    nikifbc();
                }
                else {
                    httaFCB();
                }

        }
    }
    /**
     * A class that manages the draw button
     */
    private class DrawListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            SundayFootballDayUI.pontarismaWindow.setVisible(false);
            setZaria(Controller.roll_dice());
            if(getZaria() == 3 || getZaria() == 4) {
                isopalia();
            }
            else {
                httaFCB();
            }

        }
    }
    /**
     * A class that manages the rm button
     */
    private class RMListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            SundayFootballDayUI.pontarismaWindow.setVisible(false);
            setZaria(Controller.roll_dice());
            if(getZaria() == 5 || getZaria() == 6) {
                nikiRM();
            }
            else {
                httaRM();
            }

        }
    }
    /**
     * A class that manages the no prediction button
     */
    private class NoPredicitonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
           f.dispose();
        }
    }
}

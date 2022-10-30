package View;

import Controller.Controller;
import Model.*;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collections;

/**
 * Contains needed signatures to make a new instance of a Board window
 */
public class BoardUI {
    private Player P1,P2;
    private Image image;
    private JButton rollDice, rollDice2, myDealCards, myDealCards2, getLoan, getLoan2, endTurn, endTurn2;
    private JButton dealCards, mailCards;
    private JLabel jtxt, pl1, pl2, money1, money2, loan1, loan2, bills1, bills2 ,diceOnePos, diceTwoPos;
    private JFrame window;
    private JTextArea InfoBox;
    private JPanel player1_field, player2_field;
    private Pioni pioni1, pioni2;
    private JLabel[] LabelArray = new JLabel[32];
    public JLayeredPane layer, layer1, layer2;
    public boolean p1_rolled_dice= false, p2_rolled_dice= false;
    public int drawncards=0;
    public boolean end_turn1=false, end_turn2=false;
    public boolean finished_deal = false;
    private int howmanytodrw = 0;
    /**
     * <b>Constructor</b>Constructs a new instance of a Board window
     */
    public BoardUI() {


    }

    public void setJtxt(JLabel jtxt) {
        this.jtxt = jtxt;
    }

    public JLabel getJtxt() {
        return jtxt;
    }

    public void setWindow(JFrame window) {
        this.window = window;
    }

    public JFrame getWindow() {
        return window;
    }

    public JLabel getLoan1() {
        return loan1;
    }

    public void setLoan1(JLabel loan1) {
        this.loan1 = loan1;
    }

    public JLabel getLoan2() {
        return loan2;
    }

    public void setLoan2(JLabel loan2) {
        this.loan2 = loan2;
    }

    public JLabel getBills1() {
        return bills1;
    }

    public void setBills1(JLabel bills1) {
        this.bills1 = bills1;
    }

    public JLabel getBills2() {
        return bills2;
    }

    public void setBills2(JLabel bills2) {
        this.bills2 = bills2;
    }

    public JLabel getMoney1() {
        return money1;
    }

    public void setMoney1(JLabel money1) {
        this.money1 = money1;
    }

    public JLabel getMoney2() {
        return money2;
    }

    public void setMoney2(JLabel money2) {
        this.money2 = money2;
    }

    public JPanel getPlayer1_field() {
        return player1_field;
    }

    public void setPlayer1_field(JPanel player1_field) {
        this.player1_field = player1_field;
    }

    public JPanel getPlayer2_field() {
        return player2_field;
    }

    public void setPlayer2_field(JPanel player2_field) {
        this.player2_field = player2_field;
    }

    public void setInfoBox(JTextArea infoBox) {
        InfoBox = infoBox;
    }

    public JTextArea getInfoBox() {
        return InfoBox;
    }

    public void setP2(Player p2) {
        P2 = p2;
    }

    public Player getP2() {
        return P2;
    }

    public void setP1(Player p1) {
        P1 = p1;
    }

    public Player getP1() {
        return P1;
    }
    public void movetodealuip1(){


//                System.out.println(getP1().getPos());
//                System.out.println(getP2().getPos());

        int num1 = 0;
        int num2 = 0;

        if(getP1().getPos() != null) num1 = getP1().getPos().getNumOnBoard();
        if(getP2().getPos() != null) num2 = getP2().getPos().getNumOnBoard();

        if ((getP1().getPos() == null && getP2().getPos() == null) || (num1 == num2)) {
            layer2 = new JLayeredPane();
            layer2.setBounds(layer.getBounds());
//                    System.out.println("1 "+layer.getBounds());
            if (getP2().getPos() == null) {
                JLabel pos = new JLabel();
                pos.setIcon(LabelArray[0].getIcon());
                pos.setBounds(0, 0, 100, 100);
                layer2.add(pos, new Integer(1));
                layer2.add(getP2().getPawn().Model, new Integer(2));
                layer2.setVisible(true);
                window.remove(layer);
                window.add(layer2);
                window.repaint();

            } else {
                JLabel pos = new JLabel();
                pos.setIcon(LabelArray[num2].getIcon());
                pos.setBounds(0, 0, 100, 100);
                layer2.add(pos, new Integer(1));
                layer2.add(getP2().getPawn().Model, new Integer(2));
                layer2.setVisible(true);
                window.remove(layer);
                window.add(layer2);
                window.repaint();

            }
        } else {
            window.remove(layer1);
            LabelArray[num1].setVisible(true);
        }


        getP1().moveToDeal(getP1().getPos().getNumOnBoard());


        System.out.println(getP1().getPos());

        num1 = 0;
        num2 = 0;

        if(getP1().getPos() != null) num1 = getP1().getPos().getNumOnBoard();
        if(getP2().getPos() != null) num2 = getP2().getPos().getNumOnBoard();


        if ((getP1().getPos() == null && getP2().getPos() == null) || (num1 == num2)) {
            layer = new JLayeredPane();
            layer.setBounds(layer2.getBounds());
            if (getP2().getPos() == null) {
                JLabel pos = new JLabel();
                pos.setIcon(LabelArray[0].getIcon());
                pos.setBounds(0, 0, 100, 100);
                layer.add(pos, new Integer(1));
                layer.add(getP2().getPawn().Model, new Integer(2));
                layer.setVisible(true);
                window.remove(layer2);
                window.add(layer);
                window.repaint();

            } else {
                JLabel pos = new JLabel();
                pos.setIcon(LabelArray[num2].getIcon());
                pos.setBounds(0, 0, 100, 100);
                layer.add(pos, new Integer(1));
                layer.add(getP2().getPawn().Model, new Integer(2));
                layer.add(getP1().getPawn().Model, new Integer(2));
                layer.setVisible(true);
                window.remove(layer2);
                window.remove(layer1);
                window.add(layer);
                window.repaint();

            }
        } else {
            layer1 = new JLayeredPane();
            layer1.setBounds(LabelArray[num1].getBounds());
            LabelArray[num1].setVisible(false);
            System.out.println("2 "+layer1.getBounds());
            JLabel pos = new JLabel();
            pos.setIcon(LabelArray[num1].getIcon());
            pos.setBounds(0, 0, 100, 100);
            layer1.add(pos, new Integer(1));
            layer1.add(getP1().getPawn().Model, new Integer(2));
            layer1.setVisible(true);
            window.add(layer1);
            window.repaint();

        }
        p1_rolled_dice = true;

    }


    public void movetodealuip2(){


        int num1 = 0;
        int num2 = 0;

        if (getP1().getPos() != null) num1 = getP1().getPos().getNumOnBoard();
        if (getP2().getPos() != null) num2 = getP2().getPos().getNumOnBoard();

        if ((getP1().getPos() == null && getP2().getPos() == null) || (num1 == num2)) {
            layer1 = new JLayeredPane();
            layer1.setBounds(layer.getBounds());
            if (getP1().getPos() == null) {
                JLabel pos = new JLabel();
                pos.setIcon(LabelArray[0].getIcon());
                pos.setBounds(0, 0, 100, 100);
                layer1.add(pos, new Integer(1));
                layer1.add(getP1().getPawn().Model, new Integer(2));
                layer1.setVisible(true);
                window.remove(layer);
                window.add(layer1);
                window.repaint();

            } else {
                JLabel pos = new JLabel();
                pos.setIcon(LabelArray[num1].getIcon());
                pos.setBounds(0, 0, 100, 100);
                layer1.add(pos, new Integer(1));
                layer1.add(getP1().getPawn().Model, new Integer(2));
                layer1.setVisible(true);
                window.remove(layer);
                window.add(layer1);
                window.repaint();

            }
        } else {
            window.remove(layer2);
            LabelArray[num2].setVisible(true);
        }


        getP2().moveToDeal(getP2().getPos().getNumOnBoard());


        num1 = 0;
        num2 = 0;

        if (getP1().getPos() != null) num1 = getP1().getPos().getNumOnBoard();
        if (getP2().getPos() != null) num2 = getP2().getPos().getNumOnBoard();


        if ((getP1().getPos() == null && getP2().getPos() == null) || (num1 == num2)) {
            layer = new JLayeredPane();
            layer.setBounds(layer1.getBounds());
            if (getP1().getPos() == null) {
                JLabel pos = new JLabel();
                pos.setIcon(LabelArray[0].getIcon());
                pos.setBounds(0, 0, 100, 100);
                layer.add(pos, new Integer(1));
                layer.add(getP1().getPawn().Model, new Integer(2));
                layer.setVisible(true);
                window.remove(layer1);
                window.add(layer);
                window.repaint();

            } else {
                JLabel pos = new JLabel();
                pos.setIcon(LabelArray[num1].getIcon());
                pos.setBounds(0, 0, 100, 100);
                layer.add(pos, new Integer(1));
                layer.add(getP1().getPawn().Model, new Integer(2));
                layer.add(getP2().getPawn().Model, new Integer(2));
                layer.setVisible(true);
                window.remove(layer1);
                window.remove(layer2);
                window.add(layer);
                window.repaint();

            }
        } else {
            layer2 = new JLayeredPane();
            layer2.setBounds(LabelArray[num2].getBounds());
            LabelArray[num2].setVisible(false);
            JLabel pos = new JLabel();
            pos.setIcon(LabelArray[num2].getIcon());
            pos.setBounds(0, 0, 100, 100);
            layer2.add(pos, new Integer(1));
            layer2.add(getP2().getPawn().Model, new Integer(2));
            layer2.setVisible(true);
            window.add(layer2);
            window.repaint();

        }
        p2_rolled_dice = true;


    }

    public ImageIcon getDice(int zaria) {
        if(zaria == 1) {
            ImageIcon diceOne = new ImageIcon("./images/dice-1.jpg");
            image = diceOne.getImage();
            Image newimg = image.getScaledInstance(60, 60, Image.SCALE_SMOOTH);
            diceOne = new ImageIcon(newimg);
            return diceOne;
        }
        else if(zaria == 2) {
            ImageIcon diceTwo = new ImageIcon("./images/dice-2.jpg");
            image = diceTwo.getImage();
            Image newimg = image.getScaledInstance(60, 60, Image.SCALE_SMOOTH);
            diceTwo = new ImageIcon(newimg);
            return diceTwo;
        }
        else if(zaria == 3) {
            ImageIcon diceThree = new ImageIcon("./images/dice-3.jpg");
            image = diceThree.getImage();
            Image newimg = image.getScaledInstance(60, 60, Image.SCALE_SMOOTH);
            diceThree = new ImageIcon(newimg);
            return diceThree;
        }
        else if(zaria == 4) {
            ImageIcon diceFour = new ImageIcon("./images/dice-4.jpg");
            image = diceFour.getImage();
            Image newimg = image.getScaledInstance(60, 60, Image.SCALE_SMOOTH);
            diceFour = new ImageIcon(newimg);
            return diceFour;
        }
        else if( zaria == 5) {
            ImageIcon diceFive = new ImageIcon("./images/dice-5.jpg");
            image = diceFive.getImage();
            Image newimg = image.getScaledInstance(60, 60, Image.SCALE_SMOOTH);
            diceFive = new ImageIcon(newimg);
            return diceFive;
        }
        else if(zaria == 6) {
            ImageIcon diceSix = new ImageIcon("./images/dice-6.jpg");
            image = diceSix.getImage();
            Image newimg = image.getScaledInstance(60, 60, Image.SCALE_SMOOTH);
            diceSix = new ImageIcon(newimg);
            return diceSix;
        }
        else {
            System.out.println("Wrong number on dice roll");
            return null;
        }
    }



    public Icon resizeIcon(ImageIcon icon, int resizedWidth, int resizedHeight ) {
        image = icon.getImage();
        Image resizedImage = image.getScaledInstance(resizedWidth, resizedHeight, Image.SCALE_SMOOTH);
        return new ImageIcon(resizedImage);
    }

    public void showDealCard() {
        boolean go_on = false;
        if((Controller.getTurn() == 1 &&  !finished_deal && getP1().getPos() instanceof DealPosition)
                ||(Controller.getTurn() == 2 && !finished_deal && getP2().getPos() instanceof DealPosition)){
            go_on = true;
        }
        if(!go_on)return;
        if(DealDeck.dealcards.size() == 0){
            DealDeck.dealcards.addAll(DealDeck.discardPile);
            DealDeck.discardPile.clear();
            Collections.shuffle(DealDeck.dealcards);
        }
        DealCard dealcard = DealDeck.dealcards.get(0);

        System.out.println("Deal Card");
        DealDeck.dealcards.remove(0);
        int i = dealcard.getIndex();
        String[][] dealCards = DealDeck.pdv.dealCards;
        if(Controller.getTurn() == 1) {
            DealCardsUI cmpnt = new DealCardsUI(P1, dealcard);
            cmpnt.initComponents(dealCards[i]);
        }
        else {
            DealCardsUI cmpnt = new DealCardsUI(P2, dealcard);
            cmpnt.initComponents(dealCards[i]);
        }

    }

    public void showMailCard() {
        if(MailDeck.mailcards.size()==0){
            MailDeck.mailcards.addAll(MailDeck.discardPile);
            MailDeck.discardPile.clear();
            Collections.shuffle(MailDeck.mailcards);
        }
        MailCard mailcard = MailDeck.mailcards.get(0);
        MailDeck.discardPile.add(mailcard);
        MailPosition currPos;
        if(Controller.getTurn()==1) {
            mailcard.setP(getP1());

            getMoney1().setText("Money: "+String.valueOf(getP1().getMoney())+" Euros");
            getBills1().setText("Bills: "+String.valueOf(getP1().getBill())+" Euros");
        }
        else {
            mailcard.setP(getP2());

            getMoney2().setText("Money: "+String.valueOf(getP2().getMoney())+" Euros");
            getBills2().setText("Bills: "+String.valueOf(getP2().getBill())+" Euros");
        }


        MailDeck.mailcards.remove(0);
        int i = mailcard.getIndex();
        String[][] mailCards = MailDeck.pdv.mailCards;
        if(Controller.getTurn() == 1) {
            if (mailcard.getType().equals("Bill")) {
                BillUI cmpnt = new BillUI(P1, mailcard);
                cmpnt.initComponents(mailCards[i]);
            }
            else if(mailcard.getType().equals("Advertisment")) {
                AdvertisementUI cmpnt = new AdvertisementUI(P1, mailcard);
                cmpnt.initComponents(mailCards[i]);
            }
            else if(mailcard.getType().equals("Charity")) {
                CharityUI cmpnt = new CharityUI(P1, mailcard);
                cmpnt.initComponents(mailCards[i]);
            }
            else if(mailcard.getType().equals("Move to Deal/Buyer")) {
                MoveToDealBuyerUI cmpnt = new MoveToDealBuyerUI(P1, mailcard);
                cmpnt.initComponents(mailCards[i]);
            }
            else if(mailcard.getType().equals("Pay the Neighbor")) {
                PayTheNeighborUI cmpnt = new PayTheNeighborUI(P1, P2, mailcard);
                cmpnt.initComponents(mailCards[i]);
            }
            else if(mailcard.getType().equals("Take money from the Neighbor")) {
                TakeMoneyFromNeighborUI cmpnt = new TakeMoneyFromNeighborUI(P1, P2, mailcard);
                cmpnt.initComponents(mailCards[i]);
            }
            else {
                System.out.println("Wrong type of mail card");
            }

        }
        else if(Controller.getTurn() == 2) {
            if (mailcard.getType().equals("Bill")) {
                BillUI cmpnt = new BillUI(P2, mailcard);
                cmpnt.initComponents(mailCards[i]);
            }
            else if(mailcard.getType().equals("Advertisment")) {
                AdvertisementUI cmpnt = new AdvertisementUI(P2, mailcard);
                cmpnt.initComponents(mailCards[i]);
            }
            else if(mailcard.getType().equals("Charity")) {
                CharityUI cmpnt = new CharityUI(P2, mailcard);
                cmpnt.initComponents(mailCards[i]);
            }
            else if(mailcard.getType().equals("Move to Deal/Buyer")) {
                MoveToDealBuyerUI cmpnt = new MoveToDealBuyerUI(P2, mailcard);
                cmpnt.initComponents(mailCards[i]);
            }
            else if(mailcard.getType().equals("Pay the Neighbor")) {
                PayTheNeighborUI cmpnt = new PayTheNeighborUI(P2, P1, mailcard);
                cmpnt.initComponents(mailCards[i]);
            }
            else if(mailcard.getType().equals("Take money from the Neighbor")) {
                TakeMoneyFromNeighborUI cmpnt = new TakeMoneyFromNeighborUI(P2, P1, mailcard);
                cmpnt.initComponents(mailCards[i]);
            }
            else {
                System.out.println("Wrong type of mail card");
            }

        }
        else {
            System.out.println("Wrong turn integer");
        }
    }

    public void makeYellowLabels() {
        JPanel panel1 = new JPanel();
        panel1.setOpaque(true);
        panel1.setBackground(Color.gray);
        JLabel start1 = new JLabel("Start", JLabel.CENTER);

        start1.setForeground(Color.BLACK);
        panel1.add(start1);
        panel1.setBounds(0, 90, 100, 20);
        window.add(panel1);

        int cntr = 0;
        int cntr2 = 0;
        int cntr3 = 0;
        int cntr4 = 0;
        int cntr5 = 0;
        int cntr6 = 0;
        int cntr7 = 0;
        for(int i=1; i<32; i++ ) {
            if(i%7==1) {
                cntr++;
                JPanel panel = new JPanel();
                panel.setOpaque(true);
                panel.setBackground(Color.yellow);
                JLabel label = new JLabel("Monday "+ i, JLabel.CENTER);

                label.setForeground(Color.BLACK);
                panel.add(label);
                if(cntr ==1) panel.setBounds( 100, ((cntr-1)*100)+90, 100, 20);

                else panel.setBounds( 100, ((cntr-1)*100)+90+(cntr-1)*15, 100, 20);
                window.add(panel);

            }
            if(i%7==2) {
                cntr2++;
                JPanel panel = new JPanel();
                panel.setOpaque(true);
                panel.setBackground(Color.yellow);
                JLabel label = new JLabel("Tuesday "+ i, JLabel.CENTER);

                label.setForeground(Color.BLACK);
                panel.add(label);
                if(cntr2 ==1) panel.setBounds( 200, ((cntr2-1)*100)+90, 100, 20);

                else panel.setBounds( 200, ((cntr2-1)*100)+90+(cntr2-1)*15, 100, 20);
                window.add(panel);
            }
            if(i%7==3) {
                cntr3++;
                JPanel panel = new JPanel();
                panel.setOpaque(true);
                panel.setBackground(Color.yellow);
                JLabel label = new JLabel("Wednes. "+ i, JLabel.CENTER);

                label.setForeground(Color.BLACK);
                panel.add(label);
                if(cntr3 ==1) panel.setBounds( 300, ((cntr3-1)*100)+90, 100, 20);

                else panel.setBounds( 300, ((cntr3-1)*100)+90+(cntr3-1)*15, 100, 20);
                window.add(panel);
            }
            if(i%7==4) {
                cntr4++;
                JPanel panel = new JPanel();
                panel.setOpaque(true);
                panel.setBackground(Color.yellow);
                JLabel label = new JLabel("Thursday "+ i, JLabel.CENTER);

                label.setForeground(Color.BLACK);
                panel.add(label);
                if(cntr4 ==1) panel.setBounds( 400, ((cntr4-1)*100)+90, 100, 20);

                else panel.setBounds( 400, ((cntr4-1)*100)+90+(cntr4-1)*15, 100, 20);
                window.add(panel);
            }
            if(i%7==5) {
                cntr5++;
                JPanel panel = new JPanel();
                panel.setOpaque(true);
                panel.setBackground(Color.yellow);
                JLabel label = new JLabel("Friday "+ i, JLabel.CENTER);

                label.setForeground(Color.BLACK);
                panel.add(label);
                if(cntr5 ==1) panel.setBounds( 500, ((cntr5-1)*100)+90, 100, 20);

                else panel.setBounds( 500, ((cntr5-1)*100)+90+(cntr5-1)*15, 100, 20);
                window.add(panel);
            }
            if(i%7==6) {
                cntr6++;
                JPanel panel = new JPanel();
                panel.setOpaque(true);
                panel.setBackground(Color.yellow);
                JLabel label = new JLabel("Saturday "+ i, JLabel.CENTER);

                label.setForeground(Color.BLACK);
                panel.add(label);
                if(cntr6 ==1) panel.setBounds( 600, ((cntr6-1)*100)+90, 100, 20);

                else panel.setBounds( 600, ((cntr6-1)*100)+90+(cntr6-1)*15, 100, 20);
                window.add(panel);
            }
            if(i%7==0) {
                cntr7++;
                JPanel panel = new JPanel();
                panel.setOpaque(true);
                panel.setBackground(Color.yellow);
                JLabel label = new JLabel("Sunday "+ i, JLabel.CENTER);

                label.setForeground(Color.BLACK);
                panel.add(label);
                if(cntr7 ==1) panel.setBounds( 0, ((cntr7-1)*100)+90+115, 100, 20);

                else panel.setBounds( 0, ((cntr7-1)*100)+90+115+(cntr7-1)*15, 100, 20);
                window.add(panel);
            }

        }
    }

    public void setWeek(int k, int y) {
        if(k==0) {
            for(int i=k; i<6; i++) {
                if (Board.position.get(i) instanceof MailPosition) {
                    if (((MailPosition) Board.position.get(i)).getNumberOfMailCards() == 1) {
                        ImageIcon mail1 = new ImageIcon("./images/mc1.png");
                        image = mail1.getImage();
                        Image newimg = image.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
                        mail1 = new ImageIcon(newimg);
                        JLabel mail1pos = new JLabel(mail1);
                        mail1pos.setSize(100, 100);
                        mail1pos.setLocation((i+1) * 100, y);
                        window.add(mail1pos);
                        LabelArray[i+1] = mail1pos;

                    } else if (((MailPosition) Board.position.get(i)).getNumberOfMailCards() == 2) {
                        ImageIcon mail2 = new ImageIcon("./images/mc2.png");
                        image = mail2.getImage();
                        Image newimg = image.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
                        mail2 = new ImageIcon(newimg);
                        JLabel mail2pos = new JLabel(mail2);
                        mail2pos.setSize(100, 100);
                        mail2pos.setLocation((i+1) * 100, y);
                        window.add(mail2pos);
                        LabelArray[i+1] = mail2pos;

                    } else {
                        System.out.println("Wrong number of mail cards");
                    }
                } else if (Board.position.get(i) instanceof DealPosition) {
                    ImageIcon deal = new ImageIcon("./images/deal.png");
                    image = deal.getImage();
                    Image newimg = image.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
                    deal = new ImageIcon(newimg);
                    JLabel dealpos = new JLabel(deal);
                    dealpos.setSize(100, 100);
                    dealpos.setLocation((i+1) * 100, y);
                    window.add(dealpos);
                    LabelArray[i+1] = dealpos;

                } else if (Board.position.get(i) instanceof Laxio) {
                    ImageIcon laxio = new ImageIcon("./images/sweep.png");
                    image = laxio.getImage();
                    Image newimg = image.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
                    laxio = new ImageIcon(newimg);
                    JLabel laxiopos = new JLabel(laxio);
                    laxiopos.setSize(100, 100);
                    laxiopos.setLocation((i+1) * 100, y);
                    window.add(laxiopos);
                    LabelArray[i+1] = laxiopos;

                } else if (Board.position.get(i) instanceof Lotaria) {
                    ImageIcon lotaria = new ImageIcon("./images/lottery.png");
                    /*Image*/ image = lotaria.getImage();
                    Image newimg = image.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
                    lotaria = new ImageIcon(newimg);
                    JLabel lotariapos = new JLabel(lotaria);
                    lotariapos.setSize(100, 100);
                    lotariapos.setLocation((i+1) * 100, y);
                    window.add(lotariapos);
                    LabelArray[i+1] = lotariapos;

                } else if (Board.position.get(i) instanceof Radio) {
                    ImageIcon radio = new ImageIcon("./images/radio.png");
                    /*Image*/ image = radio.getImage();
                    Image newimg = image.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
                    radio = new ImageIcon(newimg);
                    JLabel radiopos = new JLabel(radio);
                    radiopos.setSize(100, 100);
                    radiopos.setLocation((i+1) * 100, y);
                    window.add(radiopos);
                    LabelArray[i+1] = radiopos;

                } else if (Board.position.get(i) instanceof Agorastis) {
                    ImageIcon buyer = new ImageIcon("./images/buyer.png");
                    /*Image*/ image = buyer.getImage();
                    Image newimg = image.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
                    buyer = new ImageIcon(newimg);
                    JLabel buyerpos = new JLabel(buyer);
                    buyerpos.setSize(100, 100);
                    buyerpos.setLocation((i+1) * 100, y);
                    window.add(buyerpos);
                    LabelArray[i+1] = buyerpos;

                } else if (Board.position.get(i) instanceof FamilyCasinoNight) {
                    ImageIcon casino = new ImageIcon("./images/casino.png");
                    /*Image*/ image = casino.getImage();
                    Image newimg = image.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
                    casino = new ImageIcon(newimg);
                    JLabel casinopos = new JLabel(casino);
                    casinopos.setSize(100, 100);
                    casinopos.setLocation((i+1) * 100, y);
                    window.add(casinopos);
                    LabelArray[i+1] = casinopos;

                } else if (Board.position.get(i) instanceof AgoraMeEkptwsh) {
                    ImageIcon yard = new ImageIcon("./images/yard.png");
                    /*Image*/ image = yard.getImage();
                    Image newimg = image.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
                    yard = new ImageIcon(newimg);
                    JLabel yardpos = new JLabel(yard);
                    yardpos.setSize(100, 100);
                    yardpos.setLocation((i+1) * 100, y);
                    window.add(yardpos);
                    LabelArray[i+1] = yardpos;

                } else {
                    System.out.println("Wrong type of position on bord");
                }
            }
        }


        else if(k==27) {
            for(int i=k; i<k+4; i++) {
                if(Board.position.get(i) instanceof MailPosition) {
                    if(((MailPosition) Board.position.get(i)).getNumberOfMailCards() == 1) {
                        ImageIcon mail1 = new ImageIcon("./images/mc1.png");
                        image = mail1.getImage();
                        Image newimg = image.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
                        mail1 = new ImageIcon(newimg);
                        JLabel mail1pos = new JLabel(mail1);
                        mail1pos.setSize(100,100);
                        mail1pos.setLocation((i-k)*100,y);
                        window.add(mail1pos);
                        LabelArray[i+1] = mail1pos;

                    }
                    else if(((MailPosition) Board.position.get(i)).getNumberOfMailCards() == 2) {
                        ImageIcon mail2 = new ImageIcon("./images/mc2.png");
                        image = mail2.getImage();
                        Image newimg = image.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
                        mail2 = new ImageIcon(newimg);
                        JLabel mail2pos = new JLabel(mail2);
                        mail2pos.setSize(100,100);
                        mail2pos.setLocation((i-k)*100,y);
                        window.add(mail2pos);
                        LabelArray[i+1] = mail2pos;

                    }
                    else {
                        System.out.println("Wrong number of mail cards");
                    }
                }
                else if(Board.position.get(i) instanceof DealPosition) {
                    ImageIcon deal = new ImageIcon("./images/deal.png");
                    image = deal.getImage();
                    Image newimg = image.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
                    deal = new ImageIcon(newimg);
                    JLabel dealpos = new JLabel(deal);
                    dealpos.setSize(100,100);
                    dealpos.setLocation((i-k)*100,y);
                    window.add(dealpos);
                    LabelArray[i+1] = dealpos;

                }
                else if(Board.position.get(i) instanceof Laxio) {
                    ImageIcon laxio = new ImageIcon("./images/sweep.png");
                    image = laxio.getImage();
                    Image newimg = image.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
                    laxio = new ImageIcon(newimg);
                    JLabel laxiopos = new JLabel(laxio);
                    laxiopos.setSize(100,100);
                    laxiopos.setLocation((i-k)*100,y);
                    window.add(laxiopos);
                    LabelArray[i+1] = laxiopos;

                }
                else if(Board.position.get(i) instanceof Lotaria) {
                    ImageIcon lotaria = new ImageIcon("./images/lottery.png");
                    image = lotaria.getImage();
                    Image newimg = image.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
                    lotaria = new ImageIcon(newimg);
                    JLabel lotariapos = new JLabel(lotaria);
                    lotariapos.setSize(100,100);
                    lotariapos.setLocation((i-k)*100,y);
                    window.add(lotariapos);
                    LabelArray[i+1] = lotariapos;

                }
                else if(Board.position.get(i) instanceof Radio) {
                    ImageIcon radio = new ImageIcon("./images/radio.png");
                    image = radio.getImage();
                    Image newimg = image.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
                    radio = new ImageIcon(newimg);
                    JLabel radiopos = new JLabel(radio);
                    radiopos.setSize(100,100);
                    radiopos.setLocation((i-k)*100,y);
                    window.add(radiopos);
                    LabelArray[i+1] = radiopos;

                }
                else if(Board.position.get(i) instanceof Agorastis) {
                    ImageIcon buyer = new ImageIcon("./images/buyer.png");
                    image = buyer.getImage();
                    Image newimg = image.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
                    buyer = new ImageIcon(newimg);
                    JLabel buyerpos = new JLabel(buyer);
                    buyerpos.setSize(100,100);
                    buyerpos.setLocation((i-k)*100,y);
                    window.add(buyerpos);
                    LabelArray[i+1] = buyerpos;
                }
                else if(Board.position.get(i) instanceof FamilyCasinoNight) {
                    ImageIcon casino = new ImageIcon("./images/casino.png");
                    image = casino.getImage();
                    Image newimg = image.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
                    casino = new ImageIcon(newimg);
                    JLabel casinopos = new JLabel(casino);
                    casinopos.setSize(100,100);
                    casinopos.setLocation((i-k)*100,y);
                    window.add(casinopos);
                    LabelArray[i+1] = casinopos;

                }
                else if(Board.position.get(i) instanceof AgoraMeEkptwsh) {
                    ImageIcon yard = new ImageIcon("./images/yard.png");
                    image = yard.getImage();
                    Image newimg = image.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
                    yard = new ImageIcon(newimg);
                    JLabel yardpos = new JLabel(yard);
                    yardpos.setSize(100,100);
                    yardpos.setLocation((i-k)*100,y);
                    window.add(yardpos);
                    LabelArray[i+1] = yardpos;
                }
                else if(Board.position.get(i) instanceof PayDayPosition) {
                    ImageIcon payday = new ImageIcon("./images/pay.png");
                    image = payday.getImage();
                    Image newimg = image.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
                    payday = new ImageIcon(newimg);
                    JLabel paydaypos = new JLabel(payday);
                    paydaypos.setSize(100, 100);
                    paydaypos.setLocation((i - k) * 100, y);
                    window.add(paydaypos);
                    LabelArray[i+1] = paydaypos;
                }
                else {
                    System.out.println("Wrong type of position on bord");
                }
            }

        }


        else {
            for(int i=k; i<k+7; i++) {
                if(Board.position.get(i) instanceof MailPosition) {
                    if(((MailPosition) Board.position.get(i)).getNumberOfMailCards() == 1) {
                        ImageIcon mail1 = new ImageIcon("./images/mc1.png");
                        image = mail1.getImage();
                        Image newimg = image.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
                        mail1 = new ImageIcon(newimg);
                        JLabel mail1pos = new JLabel(mail1);
                        mail1pos.setSize(100,100);
                        mail1pos.setLocation((i-k)*100,y);
                        window.add(mail1pos);
                        LabelArray[i+1] = mail1pos;
                    }
                    else if(((MailPosition) Board.position.get(i)).getNumberOfMailCards() == 2) {
                        ImageIcon mail2 = new ImageIcon("./images/mc2.png");
                        image = mail2.getImage();
                        Image newimg = image.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
                        mail2 = new ImageIcon(newimg);
                        JLabel mail2pos = new JLabel(mail2);
                        mail2pos.setSize(100,100);
                        mail2pos.setLocation((i-k)*100,y);
                        window.add(mail2pos);
                        LabelArray[i+1] = mail2pos;
                    }
                    else {
                        System.out.println("Wrong number of mail cards");
                    }
                }
                else if(Board.position.get(i) instanceof DealPosition) {
                    ImageIcon deal = new ImageIcon("./images/deal.png");
                    image = deal.getImage();
                    Image newimg = image.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
                    deal = new ImageIcon(newimg);
                    JLabel dealpos = new JLabel(deal);
                    dealpos.setSize(100,100);
                    dealpos.setLocation((i-k)*100,y);
                    window.add(dealpos);
                    LabelArray[i+1] = dealpos;
                }
                else if(Board.position.get(i) instanceof Laxio) {
                    ImageIcon laxio = new ImageIcon("./images/sweep.png");
                    image = laxio.getImage();
                    Image newimg = image.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
                    laxio = new ImageIcon(newimg);
                    JLabel laxiopos = new JLabel(laxio);
                    laxiopos.setSize(100,100);
                    laxiopos.setLocation((i-k)*100,y);
                    window.add(laxiopos);
                    LabelArray[i+1] = laxiopos;
                }
                else if(Board.position.get(i) instanceof Lotaria) {
                    ImageIcon lotaria = new ImageIcon("./images/lottery.png");
                    image = lotaria.getImage();
                    Image newimg = image.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
                    lotaria = new ImageIcon(newimg);
                    JLabel lotariapos = new JLabel(lotaria);
                    lotariapos.setSize(100,100);
                    lotariapos.setLocation((i-k)*100,y);
                    window.add(lotariapos);
                    LabelArray[i+1] = lotariapos;
                }
                else if(Board.position.get(i) instanceof Radio) {
                    ImageIcon radio = new ImageIcon("./images/radio.png");
                    image = radio.getImage();
                    Image newimg = image.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
                    radio = new ImageIcon(newimg);
                    JLabel radiopos = new JLabel(radio);
                    radiopos.setSize(100,100);
                    radiopos.setLocation((i-k)*100,y);
                    window.add(radiopos);
                    LabelArray[i+1] = radiopos;
                }
                else if(Board.position.get(i) instanceof Agorastis) {
                    ImageIcon buyer = new ImageIcon("./images/buyer.png");
                    image = buyer.getImage();
                    Image newimg = image.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
                    buyer = new ImageIcon(newimg);
                    JLabel buyerpos = new JLabel(buyer);
                    buyerpos.setSize(100,100);
                    buyerpos.setLocation((i-k)*100,y);
                    window.add(buyerpos);
                    LabelArray[i+1] = buyerpos;
                }
                else if(Board.position.get(i) instanceof FamilyCasinoNight) {
                    ImageIcon casino = new ImageIcon("./images/casino.png");
                    image = casino.getImage();
                    Image newimg = image.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
                    casino = new ImageIcon(newimg);
                    JLabel casinopos = new JLabel(casino);
                    casinopos.setSize(100,100);
                    casinopos.setLocation((i-k)*100,y);
                    window.add(casinopos);
                    LabelArray[i+1] = casinopos;
                }
                else if(Board.position.get(i) instanceof AgoraMeEkptwsh) {
                    ImageIcon yard = new ImageIcon("./images/yard.png");
                    image = yard.getImage();
                    Image newimg = image.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
                    yard = new ImageIcon(newimg);
                    JLabel yardpos = new JLabel(yard);
                    yardpos.setSize(100,100);
                    yardpos.setLocation((i-k)*100,y);
                    window.add(yardpos);
                    LabelArray[i+1] = yardpos;
                }
                else {
                    System.out.println("Wrong type of position on bord");
                }
            }
        }
    }

    /**
     * <b>Transformer(mutative)</b>Initializes our componentsr<br>
     * <p><b>Postcondition:</b>The new components have been initialized</p>
     */
    public void initComponets() {

        window = new JFrame("PayDay Virtual Game");
        window.setSize(1080, 720);
        window.getContentPane().setBackground(new Color(0, 102, 0));

        ImageIcon paydaylogo = new ImageIcon(("./images/logo.png"));
        image = paydaylogo.getImage();
        Image newim = image.getScaledInstance(700, 95, Image.SCALE_SMOOTH);
        paydaylogo = new ImageIcon(newim);
        JLabel paydaylogopos = new JLabel(paydaylogo);
        paydaylogopos.setSize(700, 95);
        paydaylogopos.setLocation(0, 0);
        window.add(paydaylogopos);

        JPanel panel = new JPanel();
        panel.setOpaque(true);
        panel.setBackground(Color.yellow);
        JLabel start1 = new JLabel("Start", JLabel.CENTER);

        start1.setForeground(Color.BLACK);
        panel.add(start1);
        panel.setBounds(0, 90, 100, 20);
        window.add(panel);


        ImageIcon start = new ImageIcon("./images/start.png");
        image = start.getImage();
        Image newim2 = image.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        start = new ImageIcon(newim2);
        JLabel startpos = new JLabel(start);
        startpos.setSize(100, 100);
        startpos.setLocation(0, 110);
        window.add(startpos);
        LabelArray[0] = startpos;

        setWeek(0, 110);
        setWeek(6, 225);
        setWeek(13, 340);
        setWeek(20, 455);
        setWeek(27, 570);

        makeYellowLabels();

        //JACKPOT

        ImageIcon jackpot = new ImageIcon("./images/jackpot.png");
        image = jackpot.getImage();
        Image newimg = image.getScaledInstance(200, 75, Image.SCALE_SMOOTH);
        jackpot = new ImageIcon(newimg);
        JLabel jackpotpos = new JLabel(jackpot);
        jackpotpos.setSize(200, 75);
        jackpotpos.setLocation(450, 565);
        window.add(jackpotpos);

        jtxt = new JLabel("Jackpot: " + Model.Jackpot.getMoney() + " Euros");
        jtxt.setBounds(475, 625, 230, 75);
        jtxt.setForeground(Color.white);
        jtxt.setFont(new Font("Arial", Font.PLAIN, 20));
        window.add(jtxt);


        //INFOBOX

        if (Controller.getHowManyMonths() == 1) InfoBox = new JTextArea("Info Box\n" +
                (Controller.getHowManyMonths() - Model.PayDayPosition.getMonth()) + " Month Left\n" +
                " Turn: Player " + Controller.getTurn() + "\n" +
                "-->Action");
        else InfoBox = new JTextArea(" Info Box\n" + " " +
                (Controller.getHowManyMonths() - Model.PayDayPosition.getMonth()) + " Months Left\n" +
                " Turn: Player " + Controller.getTurn() + "\n" +
                " -->Action");
        InfoBox.setFocusable(false);
        InfoBox.setBorder(new LineBorder(Color.BLACK, 3));
        InfoBox.setBounds(720, 225, 300, 100);
        window.add(InfoBox);


        //PLAYER 1 FIELD

        player1_field = new JPanel();
        player1_field.setBounds(720, 10, 300, 207);
        panel.setBackground(Color.LIGHT_GRAY);

        pl1 = new JLabel("Player 1");
        pl1.setBounds(10, 15, 50, 15);
        pl1.setForeground(Color.BLACK);
        pl1.setFont(new Font("TimesNewRoman", Font.BOLD, 12));

        money1 = new JLabel("Money: "+String.valueOf(getP1().getMoney())+" Euros");
        money1.setBounds(10, 45, 120, 15);
        money1.setForeground(Color.BLACK);
        money1.setFont(new Font("Arial", Font.PLAIN, 12));

        loan1 = new JLabel("Loan: 0 Euros");
        loan1.setBounds(10, 70, 120, 15);
        loan1.setForeground(Color.BLACK);
        loan1.setFont(new Font("Arial", Font.PLAIN, 12));

        bills1 = new JLabel("Bills: 0 Euros");
        bills1.setBounds(10, 95, 120, 15);
        bills1.setForeground(Color.BLACK);
        bills1.setFont(new Font("Arial", Font.PLAIN, 12));

        ImageIcon diceOne = new ImageIcon("./images/dice-1.jpg");
        image = diceOne.getImage();
        newimg = image.getScaledInstance(60, 60, Image.SCALE_SMOOTH);
        diceOne = new ImageIcon(newimg);
        JLabel diceOnePos = new JLabel(diceOne);
        diceOnePos.setBounds(160, 105, 60, 60);
        player1_field.add(diceOnePos);

        rollDice = new JButton("Roll Dice");
        rollDice.setBounds(10, 115, 120, 20);
        rollDice.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(Controller.getTurn() == 2 || p1_rolled_dice)return;
                int zaria = P1.getZaria();


                zaria = getP1().get_zaria();
                getP1().setZaria(zaria);
                diceOnePos.setIcon(getDice(zaria));
                diceOnePos.repaint();


                int num1 = 0;
                int num2 = 0;

                if(getP1().getPos() != null) num1 = getP1().getPos().getNumOnBoard();
                if(getP2().getPos() != null) num2 = getP2().getPos().getNumOnBoard();

                if ((getP1().getPos() == null && getP2().getPos() == null) || (num1 == num2)) {
                    layer2 = new JLayeredPane();
                    layer2.setBounds(layer.getBounds());

                    if (getP2().getPos() == null) {
                        JLabel pos = new JLabel();
                        pos.setIcon(LabelArray[0].getIcon());
                        pos.setBounds(0, 0, 100, 100);
                        layer2.add(pos, new Integer(1));
                        layer2.add(getP2().getPawn().Model, new Integer(2));
                        layer2.setVisible(true);
                        window.remove(layer);
                        window.add(layer2);
                        window.repaint();

                    } else {
                        JLabel pos = new JLabel();
                        pos.setIcon(LabelArray[num2].getIcon());
                        pos.setBounds(0, 0, 100, 100);
                        layer2.add(pos, new Integer(1));
                        layer2.add(getP2().getPawn().Model, new Integer(2));
                        layer2.setVisible(true);
                        window.remove(layer);
                        window.add(layer2);
                        window.repaint();

                    }
                } else {
                    window.remove(layer1);
                    LabelArray[num1].setVisible(true);
                }


                if (getP1().getPos() == null || getP1().getPos() instanceof PayDayPosition) getP1().setPos(Board.position.get(zaria - 1));
                else{
                    if(getP1().getPos().getNumOnBoard() + zaria - 1 < Board.position.size()) {
                        getP1().setPos(Board.position.get(getP1().getPos().getNumOnBoard() + zaria - 1));
                    }else{
                        getP1().setPos(Board.position.get(Board.position.size()-1));
                    }
                }


                System.out.println(getP1().getPos());

                num1 = 0;
                num2 = 0;

                if(getP1().getPos() != null) num1 = getP1().getPos().getNumOnBoard();
                if(getP2().getPos() != null) num2 = getP2().getPos().getNumOnBoard();


                if ((getP1().getPos() == null && getP2().getPos() == null) || (num1 == num2)) {
                    layer = new JLayeredPane();
                    layer.setBounds(layer2.getBounds());
                    if (getP2().getPos() == null) {
                        JLabel pos = new JLabel();
                        pos.setIcon(LabelArray[0].getIcon());
                        pos.setBounds(0, 0, 100, 100);
                        layer.add(pos, new Integer(1));
                        layer.add(getP2().getPawn().Model, new Integer(2));
                        layer.setVisible(true);
                        window.remove(layer2);
                        window.add(layer);
                        window.repaint();

                    } else {
                        JLabel pos = new JLabel();
                        pos.setIcon(LabelArray[num2].getIcon());
                        pos.setBounds(0, 0, 100, 100);
                        layer.add(pos, new Integer(1));
                        layer.add(getP2().getPawn().Model, new Integer(2));
                        layer.add(getP1().getPawn().Model, new Integer(2));
                        layer.setVisible(true);
                        window.remove(layer2);
                        window.remove(layer1);
                        window.add(layer);
                        window.repaint();

                    }
                } else {
                    layer1 = new JLayeredPane();
                    layer1.setBounds(LabelArray[num1].getBounds());
                    LabelArray[num1].setVisible(false);
                    System.out.println("2 "+layer1.getBounds());
                    JLabel pos = new JLabel();
                    pos.setIcon(LabelArray[num1].getIcon());
                    pos.setBounds(0, 0, 100, 100);
                    layer1.add(pos, new Integer(1));
                    layer1.add(getP1().getPawn().Model, new Integer(2));
                    layer1.setVisible(true);
                    window.add(layer1);
                    window.repaint();

                }
                p1_rolled_dice = true;

            }
        });

        myDealCards = new JButton("My Deal Cards");
        myDealCards.setBounds(10, 145, 120, 20);
        myDealCards.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame f = new JFrame();
                JDialog win = new JDialog(f, "P1: My DealCards", true);
                win.setLayout(new FlowLayout());
                for(int i=0; i<getP1().getDeals().size(); i++) {
                    DealCard dealcard = (DealCard) getP1().getDeals().get(i);
                    int index = dealcard.getIndex();
                    String[][] dealCards = DealDeck.pdv.dealCards;
                    ImageIcon car = new ImageIcon("./resources/images/"+dealCards[index][5]);
                    image = car.getImage();
                    Image newimg = image.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
                    car = new ImageIcon(newimg);
                    JLabel carpos = new JLabel(car);
                    carpos.setSize(100,100);
                    carpos.setLocation(0,0);
                    win.add(carpos);
                }
                win.setSize(600,600);
                win.setLocationRelativeTo(null);
                win.setVisible(true);

            }
        });

        getLoan = new JButton("Get Loan");
        getLoan.setBounds(10, 175, 100, 20);
        getLoan.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LoanUI loan = new LoanUI(getP1(), BoardUI.this);
                loan.initComponents();
            }
        });

        endTurn = new JButton("End Turn");
        endTurn.setBounds(120, 175, 100, 20);
        endTurn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(Controller.getTurn() == 2)return;
                end_turn1 = true;
                end_turn2 = false;
                howmanytodrw=0;
                Controller.setTurn(2);
            }
        });

        player1_field.setLayout(null);
        player1_field.add(rollDice);
        player1_field.add(myDealCards);
        player1_field.add(getLoan);
        player1_field.add(endTurn);
        player1_field.add(pl1);
        player1_field.add(money1);
        player1_field.add(loan1);
        player1_field.add(bills1);
        player1_field.setBorder(new LineBorder(Color.BLUE, 3));
        window.add(player1_field);


        //PLAYER 2 FIELD

        player2_field = new JPanel();
        player2_field.setBounds(720, 442, 300, 207);
        panel.setBackground(Color.LIGHT_GRAY);

        pl2 = new JLabel("Player 2");
        pl2.setBounds(10, 15, 50, 15);
        pl2.setForeground(Color.BLACK);
        pl2.setFont(new Font("TimesNewRoman", Font.BOLD, 12));

        money2 = new JLabel("Money: 0 Euros");
        money2.setBounds(10, 45, 120, 15);
        money2.setForeground(Color.BLACK);
        money2.setFont(new Font("Arial", Font.PLAIN, 12));

        loan2 = new JLabel("Loan: 0 Euros");
        loan2.setBounds(10, 70, 120, 15);
        loan2.setForeground(Color.BLACK);
        loan2.setFont(new Font("Arial", Font.PLAIN, 12));

        bills2 = new JLabel("Bills: 0 Euros");
        bills2.setBounds(10, 95, 120, 15);
        bills2.setForeground(Color.BLACK);
        bills2.setFont(new Font("Arial", Font.PLAIN, 12));

        JLabel diceTwoPos = new JLabel(diceOne);
        diceTwoPos.setBounds(160, 105, 60, 60);
        player2_field.add(diceTwoPos);

        rollDice2 = new JButton("Roll Dice");
        rollDice2.setBounds(10, 115, 120, 20);
        rollDice2.addActionListener(e -> {
            if(Controller.getTurn()==1 || p2_rolled_dice)return;
            int zaria = P2.getZaria();
            //System.out.println(zaria);


            zaria = getP2().get_zaria();
            getP2().setZaria(zaria);
            diceTwoPos.setIcon(getDice(zaria));
            diceTwoPos.repaint();


            int num1 = 0;
            int num2 = 0;

            if (getP1().getPos() != null) num1 = getP1().getPos().getNumOnBoard();
            if (getP2().getPos() != null) num2 = getP2().getPos().getNumOnBoard();

            if ((getP1().getPos() == null && getP2().getPos() == null) || (num1 == num2)) {
                layer1 = new JLayeredPane();
                layer1.setBounds(layer.getBounds());
                if (getP1().getPos() == null) {
                    JLabel pos = new JLabel();
                    pos.setIcon(LabelArray[0].getIcon());
                    pos.setBounds(0, 0, 100, 100);
                    layer1.add(pos, new Integer(1));
                    layer1.add(getP1().getPawn().Model, new Integer(2));
                    layer1.setVisible(true);
                    window.remove(layer);
                    window.add(layer1);
                    window.repaint();

                } else {
                    JLabel pos = new JLabel();
                    pos.setIcon(LabelArray[num1].getIcon());
                    pos.setBounds(0, 0, 100, 100);
                    layer1.add(pos, new Integer(1));
                    layer1.add(getP1().getPawn().Model, new Integer(2));
                    layer1.setVisible(true);
                    window.remove(layer);
                    window.add(layer1);
                    window.repaint();

                }
            } else {
                window.remove(layer2);
                LabelArray[num2].setVisible(true);
            }


            if (getP2().getPos() == null || getP2().getPos() instanceof PayDayPosition) getP2().setPos(Board.position.get(zaria - 1));
            else {
                if(getP2().getPos().getNumOnBoard() + zaria - 1 < Board.position.size()) {
                    getP2().setPos(Board.position.get(getP2().getPos().getNumOnBoard() + zaria - 1));
                }else{
                    getP2().setPos(Board.position.get(Board.position.size()-1));
                }
            }

            System.out.println(getP2().getPos());
            num1 = 0;
            num2 = 0;

            if (getP1().getPos() != null) num1 = getP1().getPos().getNumOnBoard();
            if (getP2().getPos() != null) num2 = getP2().getPos().getNumOnBoard();


            if ((getP1().getPos() == null && getP2().getPos() == null) || (num1 == num2)) {
                layer = new JLayeredPane();
                layer.setBounds(layer1.getBounds());
                if (getP1().getPos() == null) {
                    JLabel pos = new JLabel();
                    pos.setIcon(LabelArray[0].getIcon());
                    pos.setBounds(0, 0, 100, 100);
                    layer.add(pos, new Integer(1));
                    layer.add(getP1().getPawn().Model, new Integer(2));
                    layer.setVisible(true);
                    window.remove(layer1);
                    window.add(layer);
                    window.repaint();

                } else {
                    JLabel pos = new JLabel();
                    pos.setIcon(LabelArray[num1].getIcon());
                    pos.setBounds(0, 0, 100, 100);
                    layer.add(pos, new Integer(1));
                    layer.add(getP1().getPawn().Model, new Integer(2));
                    layer.add(getP2().getPawn().Model, new Integer(2));
                    layer.setVisible(true);
                    window.remove(layer1);
                    window.remove(layer2);
                    window.add(layer);
                    window.repaint();

                }
            } else {
                layer2 = new JLayeredPane();
                layer2.setBounds(LabelArray[num2].getBounds());
                LabelArray[num2].setVisible(false);
                JLabel pos = new JLabel();
                pos.setIcon(LabelArray[num2].getIcon());
                pos.setBounds(0, 0, 100, 100);
                layer2.add(pos, new Integer(1));
                layer2.add(getP2().getPawn().Model, new Integer(2));
                layer2.setVisible(true);
                window.add(layer2);
                window.repaint();

            }
            p2_rolled_dice = true;

        });



        myDealCards2 = new JButton("My Deal Cards");
        myDealCards2.setBounds(10,145 , 120, 20);
        myDealCards2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame f = new JFrame();
                JDialog win = new JDialog(f, "P2: My DealCards", true);
                win.setLayout(new FlowLayout());
                for(int i=0; i<getP2().getDeals().size(); i++) {
                    DealCard dealcard = (DealCard) getP2().getDeals().get(i);
                    int index = dealcard.getIndex();
                    String[][] dealCards = DealDeck.pdv.dealCards;
                    ImageIcon car = new ImageIcon("./resources/images/"+dealCards[index][5]);
                    image = car.getImage();
                    Image newimg = image.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
                    car = new ImageIcon(newimg);
                    JLabel carpos = new JLabel(car);
                    carpos.setSize(100,100);
                    carpos.setLocation(0,0);
                    win.add(carpos);
                }
                win.setSize(600,600);
                win.setLocationRelativeTo(null);
                win.setVisible(true);
            }
        });

        getLoan2 = new JButton("Get Loan");
        getLoan2.setBounds(10,175 , 100, 20);
        getLoan2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LoanUI loan = new LoanUI(getP2(), BoardUI.this);
                loan.initComponents();
            }
        });

        endTurn2 = new JButton("End Turn");
        endTurn2.setBounds(120,175 , 100, 20);
        endTurn2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(Controller.getTurn()==1)return;
                end_turn2 = true;
                end_turn1=false;
                howmanytodrw=0;
                Controller.setTurn(1);
            }
        });

        player2_field.setLayout(null);
        player2_field.add(rollDice2);
        player2_field.add(myDealCards2);
        player2_field.add(getLoan2);
        player2_field.add(endTurn2);
        player2_field.add(pl2);
        player2_field.add(money2);
        player2_field.add(loan2);
        player2_field.add(bills2);
        player2_field.setBorder(new LineBorder(Color.YELLOW,3));
        window.add(player2_field);



        //DECKS

        ImageIcon iconM = new ImageIcon("./images/mailCard.png");
        mailCards = new JButton(iconM);
        mailCards.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Pressed:"+Controller.getTurn());
                System.out.println(P1.getPos());
                System.out.println(P2.getPos());
                if(Controller.getTurn()==1 && (getP1().getPos() instanceof MailPosition || Controller.MailPos1)) {
                    if(getP1().getPos() instanceof MailPosition)howmanytodrw = ((MailPosition) getP1().getPos()).getNumberOfMailCards();
                    if (drawncards < howmanytodrw) {
                        showMailCard();
                        drawncards++;
                    }
                }
                else if (Controller.getTurn()==2 && (getP2().getPos() instanceof MailPosition || Controller.MailPos2)) {
                    System.out.println("in2");
                    if(getP2().getPos() instanceof MailPosition)howmanytodrw = ((MailPosition) getP2().getPos()).getNumberOfMailCards();
                    if (drawncards < howmanytodrw) {
                        showMailCard();
                        drawncards++;
                    }
                }
            }
        });
        mailCards.setBounds(720,340,130, 80);
        int offset = mailCards.getInsets().left;
        mailCards.setIcon(resizeIcon(iconM, mailCards.getWidth() - offset, mailCards.getHeight() - offset ));
        window.add(mailCards);

        ImageIcon iconD = new ImageIcon("./images/dealCard.png");
        dealCards = new JButton(iconD);
        dealCards.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if((Controller.getTurn() == 1 && getP1().getPos() instanceof DealPosition && drawncards == 0) ||(Controller.getTurn() == 2 && getP2().getPos() instanceof DealPosition && drawncards == 0)) {
                    showDealCard();
                    drawncards++;
                }
            }
        });
        dealCards.setBounds(880,340,140, 80);
        int offsetD = dealCards.getInsets().left;
        dealCards.setIcon(resizeIcon(iconD, dealCards.getWidth() - offsetD, dealCards.getHeight() - offsetD ));
        window.add(dealCards);




        layer = new JLayeredPane();
        layer.setBounds(0,110,100,100);
        JLabel srtpos = new JLabel(startpos.getIcon());
        srtpos.setBounds(0,0,100,100);
        layer.add(srtpos,new Integer(1));
        getP1().getPawn().Model.setBounds(15,25,50,50);
        layer.add(getP1().getPawn().Model,new Integer(2));
        getP2().getPawn().Model.setBounds(40,25,50,50);
        layer.add(getP2().getPawn().Model,new Integer(2));
        LabelArray[0].setVisible(false);
        layer.setVisible(true);
        window.add(layer);
        window.setLayout(null);
        window.setLocationRelativeTo(null);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true);



    }

    public void agorastisUI() {
        JFrame f = new JFrame();
        JDialog win = new JDialog(f, "Sell A Deal", true);
        win.setLayout(new FlowLayout());
        JTextField field = new JTextField(10);
        JButton OKButton = new JButton("OK");
        OKButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(Controller.getTurn() == 1) {
                    if (Integer.parseInt(field.getText()) - 1 < getP1().getDeals().size()) {

                        int newmoney = getP1().getDeals().get(Integer.parseInt(field.getText()) - 1).getSellingCost();
                        getP1().getDeals().remove(Integer.parseInt(field.getText()) - 1);
                        getP1().setMoney(getP1().getMoney() + newmoney);
                        Controller.obj.getMoney1().setText("Money: " + String.valueOf(getP1().getMoney()) + " Euros");
                        Controller.obj.getWindow().repaint();
                        f.dispose();
                    } else {
                        field.setText("Wrong Input");
                    }
                }else{
                    if (Integer.parseInt(field.getText()) - 1 < getP2().getDeals().size()) {

                        int newmoney = getP2().getDeals().get(Integer.parseInt(field.getText()) - 1).getSellingCost();
                        getP2().getDeals().remove(Integer.parseInt(field.getText()) - 1);
                        getP2().setMoney(getP2().getMoney() + newmoney);
                        Controller.obj.getMoney2().setText("Money: " + String.valueOf(getP2().getMoney()) + " Euros");
                        Controller.obj.getWindow().repaint();
                        f.dispose();
                    } else {
                        field.setText("Wrong Input");
                    }
                }
            }
        });
        if(Controller.getTurn() == 1) {
            for (int i = 0; i < getP1().getDeals().size(); i++) {
                DealCard dealcard = (DealCard) getP1().getDeals().get(i);
                int index = dealcard.getIndex();
                String[][] dealCards = DealDeck.pdv.dealCards;
                ImageIcon car = new ImageIcon("./resources/images/" + dealCards[index][5]);
                image = car.getImage();
                Image newimg = image.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
                car = new ImageIcon(newimg);
                JLabel carpos = new JLabel(car);
                carpos.setSize(100, 100);
                carpos.setLocation(0, 0);
                win.add(carpos);
            }
        }else{
            for (int i = 0; i < getP2().getDeals().size(); i++) {
                DealCard dealcard = (DealCard) getP2().getDeals().get(i);
                int index = dealcard.getIndex();
                String[][] dealCards = DealDeck.pdv.dealCards;
                ImageIcon car = new ImageIcon("./resources/images/" + dealCards[index][5]);
                image = car.getImage();
                Image newimg = image.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
                car = new ImageIcon(newimg);
                JLabel carpos = new JLabel(car);
                carpos.setSize(100, 100);
                carpos.setLocation(0, 0);
                win.add(carpos);
            }
        }
        win.add(field);
        win.add(OKButton);
        win.setLocationRelativeTo(null);
        win.setSize(300,300);
        win.setVisible(true);
    }

    /**
     * <b>Transformer(mutative)</b>Initializes our buttons<br>
     * <p><b>Postcondition:</b>Our buttons have been initialized</p>
     */
    private void init_buttons() {

    }

    /**
     * <b>Transformer(mutative)</b>Shuffles board positions<br>
     * <p><b>Postcondition:</b>Board positions have been shuffled</p>
     */
    public void anakatema() {

    }
    /**
     * <b>Transformer(mutative)</b>Makes payment<br>
     * <p><b>Postcondition:</b>Payment has been done</p>
     */
    public void pliromi() {

    }
    public void playsFirst() {

    }
    public void months() {

    }
    /**
     * <b>Transformer(mutative)</b>Initializes our logo components<br>
     * <p><b>Postcondition:</b>The new components have been initialized</p>
     */
    public void makelogo() {

    }
    /**
     * <b>Transformer(mutative)</b>Initializes our position components<br>
     * <p><b>Postcondition:</b>The new components have been initialized</p>
     */
    public void makePositions(){

    }
    /**
     * <b>Transformer(mutative)</b>Initializes players fields<br>
     * <p><b>Postcondition:</b>The new components have been initialized</p>
     */
    public void makePlayerBox() {

    }
    /**
     * <b>Transformer(mutative)</b>Initializes our info window<br>
     * <p><b>Postcondition:</b>The new components have been initialized</p>
     */
    public void makeInfoBox() {

    }
    /**
     * <b>Transformer(mutative)</b>Initializes our deck components<br>
     * <p><b>Postcondition:</b>The new components have been initialized</p>
     */
    public void init_decks() {

    }
    /**
     * <b>Transformer(mutative)</b>Initializes jackpot component<br>
     * <p><b>Postcondition:</b>The new components have been initialized</p>
     */
    public void init_jackpot() {

    }


}

package View;

import Controller.Controller;
import Model.Player;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Arxikopoihsh {
    private JDialog window;
    private JFrame frame = new JFrame();
    private JButton OKButton;
    private BoardUI board;
    private Player player1, player2;
    private Rectangle rect;

    public BoardUI getBoard() {
        return board;
    }

    public void setBoard(BoardUI board) {
        this.board = board;
    }

    public Player getPlayer1() {
        return player1;
    }

    public void setPlayer1(Player player1) {
        this.player1 = player1;
    }

    public Player getPlayer2() {
        return player2;
    }

    public void setPlayer2(Player player2) {
        this.player2 = player2;
    }

    public Arxikopoihsh(BoardUI board, Player player1, Player player2) {
      this.board = board;
      this.player1 = player1;
      this.player2 = player2;
    }

    public JDialog getWindow() {
        return window;
    }

    public void setWindow(JDialog window) {
        this.window = window;
    }

    public JButton getOKButton() {
        return OKButton;
    }

    public JFrame getFrame() {
        return frame;
    }

    public void setFrame(JFrame frame) {
        this.frame = frame;
    }

    public void setOKButton(JButton OKButton) {
        this.OKButton = OKButton;
    }

    public void init_game() {

        setWindow(new JDialog(getFrame(), "Start", true));
        getWindow().setLayout(new FlowLayout());
        setOKButton(new JButton("YES"));

        String info = getBoard().getInfoBox().getText();
        String[] text = info.split("\n");

        Random rand = new Random();
        int months = (rand.nextInt(3)+1);
//        int months = 1;
        Controller.setHowManyMonths(months);
        int turn = (rand.nextInt(2)+1);
        Controller.setTurn(turn);



        getOKButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getWindow().setVisible(false);

                if(months==1) text[1] = String.valueOf(months)+" Month left";
                else text[1] = String.valueOf(months)+" Months left";
                text[2] = "Turn: Player "+String.valueOf(turn);
                text[3] = "--> "+text[2]+" roll the dice";

                getBoard().getInfoBox().setText(" ");

                for(int i=0; i< text.length; i++) {
                    getBoard().getInfoBox().setText(getBoard().getInfoBox().getText()+text[i] + "\n");
                }

                getBoard().getMoney1().setText("Money: 3500 Euros");
                getBoard().getMoney2().setText("Money: 3500 Euros");

                getWindow().dispose();
            }
        });


        getWindow().add(new JLabel("Are you ready to Start the Game?"));
        getWindow().setLocationRelativeTo(null);
        getWindow().add(getOKButton());
        getWindow().setSize(250,125);
        getWindow().setVisible(true);

//        String
//        board.setPlayer1_field();

    }

}

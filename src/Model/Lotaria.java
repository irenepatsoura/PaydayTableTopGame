package Model;

import Controller.Controller;
import View.LotteryUI;

import java.util.Random;

/**
 * Contains the needed signatures to create an instance of a Lotaria
 */
public class Lotaria extends Position {
    private Player p1;
    private Player p2;
    private Position pos;
    private String day;
    private int diceroll;
    private Jackpot jckpt;

    public Jackpot getJckpt() {
        return jckpt;
    }

    public void setJckpt(Jackpot jckpt) {
        this.jckpt = jckpt;
    }

    /**
     * <b>Transformer(mutative)</b>Sets the day<br>
     * <p><b>Postcondition:</b>The current day has been set</p>
     * @param day the current day
     */
    @Override
    public void setDay(String day) { this.day = day; }
    /**
     * <b>Accessor(selector)</b> Returns current day<br>
     * @return the current day
     */
    @Override
    public String getDay() { return day; }
    /**
     * <b>Accessor(selector)</b> Returns the current diceroll<br>
     * @return the current diceroll
     */
    public int getDiceroll() { return diceroll; }
    /**
     * <b>Transformer(mutative)</b>Sets the diceroll<br>
     * <p><b>Postcondition:</b>The diceroll has been set</p>
     * @param diceroll the current diceroll
     */
    public void setDiceroll(int diceroll) { this.diceroll = diceroll; }

    /**
     * <b>Transformer(mutative)</b>Sets the position<br>
     * <p><b>Postcondition:</b>The position has been set</p>
     * @param pos the position of the instance in the board
     */
    public void setPos(Position pos) { this.pos = pos; }
    /**
     * <b>Accessor(selector)</b> Returns the position of this block<br>
     * @return position of this block
     */
    public Position getPos() { return pos; }
    /**
     * <b>Transformer(mutative)</b>Sets the player2 in this block position<br>
     * <p><b>Postcondition:</b>The player2 has been set</p>
     * @param p2 the player2 in this board position
     */
    @Override
    public void setP2(Player p2) { this.p2 = p2; }
    /**
     * <b>Accessor(selector)</b> Returns the player2 on this position<br>
     * @return player2 on this position
     */
    @Override
    public Player getP2() { return p2; }
    /**
     * <b>Transformer(mutative)</b>Sets the player1 in this block position<br>
     * <p><b>Postcondition:</b>The player1 has been set</p>
     * @param p1 the player2 in this board position
     */
    @Override
    public void setP1(Player p1) { this.p1 = p1; }
    /**
     * <b>Accessor(selector)</b> Returns the player1 on this position<br>
     * @return player1 on this position
     */
    @Override
    public Player getP1() { return p1; }
    /**
     * <b>Transformer(mutative)</b>Performs the action of agorameekptwsh<br>
     * <p><b>Postcondition:</b>The action has been done</p>
     */

    @Override
    public void performAction() {
        getP1().setPos(this);
        setDiceroll(getP1().getZaria());

        if(getDiceroll() == 6) {
            Controller.jackpot.setP1(getP1());
            Controller.jackpot.performAction();
        }
        int num1,num2, luckynum;
        LotteryUI lottery = new LotteryUI(Controller.obj);

        num1 = lottery.initComponents();
        num2 = lottery.initComponents();

        while(true) {
            System.out.println("lala");
            Random rand = new Random();
            luckynum = rand.nextInt(6)+1;

            String info = Controller.obj.getInfoBox().getText();
            String[] text = info.split("\n");

            if (num1 == luckynum) {
                if(Controller.getTurn()==1) {
                    int newmoney = getP1().getMoney() + 1000;
                    getP1().setMoney(newmoney);
                    Controller.obj.getMoney1().setText("Money: "+getP1().getMoney());

                    text[3] = "-->Player1"+" You won 1000 Euros on Lottery";
                }
                else {
                    int newmoney = getP1().getMoney() + 1000;
                    getP1().setMoney(newmoney);
                    Controller.obj.getMoney2().setText("Money: "+getP1().getMoney());

                    text[3] = "-->Player2 You won 1000 Euros on Lottery";
                }
                Controller.obj.getInfoBox().setText(" ");

                for(int i=0; i< text.length; i++) {
                    Controller.obj.getInfoBox().setText(Controller.obj.getInfoBox().getText()+text[i] + "\n");

                }
                Controller.obj.getWindow().repaint();
                break;
            }

            else if(num2 == luckynum) {
                if(Controller.getTurn()==1) {
                    int newmoney = getP2().getMoney() + 1000;
                    getP2().setMoney(newmoney);
                    Controller.obj.getMoney2().setText("Money: "+getP2().getMoney());

                    text[3] = "-->Player2 You won 1000 Euros on Lottery";
                }
                else {
                    int newmoney = getP2().getMoney() + 1000;
                    getP2().setMoney(newmoney);
                    Controller.obj.getMoney1().setText("Money: "+getP2().getMoney());

                    text[3] = "-->Player1"+" You won 1000 Euros on Lottery";
                }
                Controller.obj.getInfoBox().setText(" ");

                for(int i=0; i< text.length; i++) {
                    Controller.obj.getInfoBox().setText(Controller.obj.getInfoBox().getText()+text[i] + "\n");

                }
                Controller.obj.getWindow().repaint();
                break;
            }


        }

//        System.out.println("Lotaria");

    }
}

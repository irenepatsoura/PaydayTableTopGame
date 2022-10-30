package Model;

import Controller.Controller;
import View.JackpotUI;

/**
 * Contains the needed signatures to create an instance of a Jackpot
 */
public class Jackpot extends Position {
    private Player p1 , p2;
    public static int money;
    /**
     * <b>Transformer(mutative)</b>Sets the player in this block position<br>
     * <p><b>Postcondition:</b>The player has been set</p>
     * @param p1 the player in this board position
     */
    @Override
    public void setP1(Player p1) {
        this.p1 = p1;
    }
    /**
     * <b>Accessor(selector)</b> Returns the player on this position<br>
     * @return player on this position
     */
    @Override
    public Player getP1() {
        return p1;
    }
    /**
     * <b>Accessor(selector)</b> Returns the money on this position<br>
     * @return money on this position
     */
    public static int getMoney() {
        return money;
    }
    /**
     * <b>Transformer(mutative)</b>Sets the money in this block position<br>
     * <p><b>Postcondition:</b>The money has been set</p>
     * @param money new money in this board position
     */
    public static void setMoney(int money) {
        Jackpot.money = money;
    }
    /**
     * <b>Transformer(mutative)</b>Performs the action of Jackpot<br>
     * <p><b>Postcondition:</b>The action has been done</p>
     */
    @Override
    public void performAction() {
        if(getMoney()>0) {
            int newmoney = getP1().getMoney() + getMoney();
            getP1().setMoney(newmoney);
            JackpotUI jackpotUI = new JackpotUI();
            jackpotUI.congrats();
            setMoney(0);
            Controller.obj.getJtxt().setText("Jackpot: " + getMoney() + " Euros");

            if (Controller.getTurn() == 1) {
                Controller.obj.getMoney1().setText("Money: " + getP1().getMoney());
            } else Controller.obj.getMoney2().setText("Money: " + getP1().getMoney());
            Controller.obj.getWindow().repaint();
        }
    }

}

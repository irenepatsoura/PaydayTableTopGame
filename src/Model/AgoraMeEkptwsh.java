package Model;

import Controller.Controller;
import View.LoanUI;

import java.util.ArrayList;

/**
 * Contains the needed signatures to create an instance of the position on the board AgoraMeEkptwsh
 */
public class AgoraMeEkptwsh extends Position {
    private Player p1,p2;
    private Position pos;
    private DealDeck deals;
    private DealCard deal;
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
     * <b>Transformer(mutative)</b>Sets the yard deal deck<br>
     * <p><b>Postcondition:</b>The deck has been set</p>
     * @param deals the deals of the instance in the board
     */
    public void setDeals(DealDeck deals) {
        this.deals = deals;
    }

    /**
     * <b>Accessor(selector)</b> Returns the yard deal<br>
     * @return the yard deal
     */
    public DealCard getDeal() {
        return deal;
    }

    /**
     * <b>Accessor(selector)</b> Returns the yard deal deck<br>
     * @return the yard deal deck
     */
    public DealDeck getDeals() {
        return deals;
    }

    /**
     * <b>Transformer(mutative)</b>Sets the yard deal card<br>
     * <p><b>Postcondition:</b>The deal card has been set</p>
     * @param deal the deal card of the instance in the board
     */
    public void setDeal(DealCard deal) {
        this.deal = deal;
    }

    /**
     * <b>Transformer(mutative)</b>Sets the position<br>
     * <p><b>Postcondition:</b>The position has been set</p>
     * @param pos the position of the instance in the board
     */
    public void setPos(Position pos) { this.pos = pos; }
    /**
     * <b>Transformer(mutative)</b>Sets the player in this block position<br>
     * <p><b>Postcondition:</b>The player has been set</p>
     * @param p1 the player in this board position
     */
    @Override
    public void setP1(Player p1) { this.p1 = p1; }
    /**
     * <b>Accessor(selector)</b> Returns the player on this position<br>
     * @return player on this position
     */
    @Override
    public Player getP1() { return p1; }


    /**
     * <b>Transformer(mutative)</b>Sets the player in this block position<br>
     * <p><b>Postcondition:</b>The player has been set</p>
     * @param p2 the player in this board position
     */
    @Override
    public void setP2(Player p2) {
        this.p2 = p2;
    }

    /**
     * <b>Accessor(selector)</b> Returns the player on this position<br>
     * @return player on this position
     */
    @Override
    public Player getP2() {
        return p2;
    }

    /**
     * <b>Accessor(selector)</b> Returns the position of this block<br>
     * @return position of this block
     */
    public Position getPos() { return pos; }
    /**
     * <b>Transformer(mutative)</b>Performs the action of agorameekptwsh<br>
     * <p><b>Postcondition:</b>The action has been done</p>
     */
    @Override
    public void performAction() {
        setDiceroll(getP1().getZaria());
        if(getDiceroll() == 6) {
            Controller.jackpot.setP1(getP1());
            Controller.jackpot.performAction();
        }
        getP1().setPos(this);
        setDiceroll(Controller.roll_dice());

        String info = Controller.obj.getInfoBox().getText();
        String[] text = info.split("\n");

        text[3] = "-->You paid "+String.valueOf(getDiceroll()*100)+" Euros for your new Deal";

        Controller.obj.getInfoBox().setText(" ");

        for(int i=0; i< text.length; i++) {
            Controller.obj.getInfoBox().setText(Controller.obj.getInfoBox().getText()+text[i] + "\n");

        }
        while(getP1().getMoney()<(100*getDiceroll())){
            LoanUI.tookloan = false;
            LoanUI l = new LoanUI(getP1(),Controller.obj);
            l.initComponents();
            while(!LoanUI.tookloan){
                System.out.print("");
            }
        }
        getP1().setMoney(getP1().getMoney()-(100*getDiceroll()));
        if(Controller.getTurn()==1) {
            Controller.obj.getMoney1().setText("Money: "+getP1().getMoney());
        }
        else Controller.obj.getMoney2().setText("Money: "+getP1().getMoney());
        Controller.obj.getWindow().repaint();
        getP1().addDeal(DealDeck.getCards());

        System.out.println("Yard sale");

    }
}

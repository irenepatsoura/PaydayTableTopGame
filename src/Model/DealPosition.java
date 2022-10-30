package Model;

import Controller.Controller;

import java.util.ArrayList;
/**
 * Contains the needed signatures to create an instance of a DealPosition
 */
public class DealPosition extends  Position {
    private Player p1,p2;
    private Position pos;
    private DealCard dealCard;
    private boolean buyIt;
    private ArrayList<DealCard> dealCards = new ArrayList<DealCard>();
    private String day;
    private int diceroll;
    private Jackpot jckpt;

    public Jackpot getJckpt() {
        return jckpt;
    }

    public void setJckpt(Jackpot jckpt) {
        this.jckpt = jckpt;
    }


    public DealCard getDealCard() {
        return dealCard;
    }

    public void setDealCard() {
        this.dealCard = getDealCards().get(0);
        dealCards.remove(0);
        setDealCards(getDealCards());
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
     * <b>Accessor(selector)</b> Returns the deal deck<br>
     * @return the deal deck
     */
    public ArrayList<DealCard> getDealCards() {
        return dealCards;
    }
    /**
     * <b>Transformer(mutative)</b>Sets the deal deck<br>
     * <p><b>Postcondition:</b>The deal deck has been set</p>
     * @param dealCards the current deal deck
     */
    public void setDealCards(ArrayList<DealCard> dealCards) {
        this.dealCards = dealCards;
    }
    /**
     * <b>Observer</b>Checks if player wants to buy the deal card
     * @return if player wants to buy it
     */
    public boolean isBuyIt() { return buyIt; }
    /**
     * <b>Transformer(mutative)</b>Sets the variable the checks if player wants to buy the card<br>
     * <p><b>Postcondition:</b>The variable has been set</p>
     * @param buyIt the current value
     */
    public void setBuyIt(boolean buyIt) { this.buyIt = buyIt; }
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

    @Override
    public Player getP2() {
        return p2;
    }

    @Override
    public void setP2(Player p2) {
        this.p2 = p2;
    }

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
     * <b>Transformer(mutative)</b>Performs the action of DealPosition<br>
     * <p><b>Postcondition:</b>The action has been done</p>
     */
    @Override
    public void performAction() {
    }
}

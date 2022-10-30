package Model;

import Controller.Controller;

import java.util.ArrayList;
/**
 * Contains the needed signatures to create an instance of the position on the board MailPosition
 */
public class MailPosition extends  Position {
    private Player p1, p2;
    private Position pos;
    private int numberOfMailCards;
    private String day;
    private int diceroll;
    private String type;
    private Jackpot jckpt;

    public MailPosition(int numberOfMailCards) {
        this.numberOfMailCards = numberOfMailCards;
    }

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
     * <b>Accessor(selector)</b> Returns the number of mail cards<br>
     * @return the number of mail cards
     */
    public int getNumberOfMailCards() {
        return numberOfMailCards;
    }
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

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

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
        getP1().draw_mail(getNumberOfMailCards());
        if(MailDeck.discardPile.size()>=2) {
            System.out.println(MailDeck.discardPile.get(MailDeck.discardPile.size() - 1).getType());
            System.out.println(MailDeck.discardPile.get(MailDeck.discardPile.size() - 2).getType());
        }
        if(getNumberOfMailCards()>1 && MailDeck.mailcards.get(0).getType().equals("Move to Deal/Buyer")) {
            MailDeck.discardPile.get(MailDeck.discardPile.size()-2).setP(getP1());
            MailDeck.discardPile.get(MailDeck.discardPile.size()-2).performAction();
            MailDeck.discardPile.get(MailDeck.discardPile.size()-1).setP(getP1());
            MailDeck.discardPile.get(MailDeck.discardPile.size()-1).performAction();
        }
        else {
            for (int i = 0; i < getNumberOfMailCards(); i++) {
                MailDeck.discardPile.get(MailDeck.discardPile.size()-1-i).setP(getP1());
                MailDeck.discardPile.get(MailDeck.discardPile.size()-1-i).performAction();
            }
        }



    }
}

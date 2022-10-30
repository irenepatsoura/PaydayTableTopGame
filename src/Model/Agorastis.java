package Model;

import Controller.Controller;

/**
 * Contains the needed signatures to create an instance of an agorastis
 */
public class Agorastis extends Position {
    private Player p1,p2;
    private Position pos;
    private String day;
    private int diceroll;
    private int indexOfcardOfChoice;
    private Jackpot jckpt;

    public Jackpot getJckpt() {
        return jckpt;
    }

    public void setJckpt(Jackpot jckpt) {
        this.jckpt = jckpt;
    }

    public int getIndexOfCardOfChoice() {
        return indexOfcardOfChoice;
    }

    public void setIndexOfCardOfChoice(int indexOfcardOfChoice) {
        this.indexOfcardOfChoice = indexOfcardOfChoice;
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
     * <b>Accessor(selector)</b> Returns the position of this block<br>
     * @return position of this block
     */
    public Position getPos() { return pos; }
    /**
     * <b>Transformer(mutative)</b>Performs the action of agorastis<br>
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

        if(getP1().getDeals().size()==0) {
            String info = Controller.obj.getInfoBox().getText();
            String[] text = info.split("\n");

            text[3] = "-->You don't have any Deal Cards yet";

            Controller.obj.getInfoBox().setText(" ");

            for(int i=0; i< text.length; i++) {
                Controller.obj.getInfoBox().setText(Controller.obj.getInfoBox().getText()+text[i] + "\n");

            }
            Controller.obj.getWindow().repaint();
            return;
        }

        Controller.obj.agorastisUI();


    }
}

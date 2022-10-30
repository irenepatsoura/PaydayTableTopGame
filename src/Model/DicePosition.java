package Model;
/**
 * Contains the needed signatures to create an instance of a DicePosition
 */
public class DicePosition extends Position {
    private Player p1, p2;
    private int money;
    private int diceNumber;
    /**
     * <b>Accessor(selector)</b> Returns the player1 on this position<br>
     * @return player1 on this position
     */
    @Override
    public Player getP1() {
        return p1;
    }
    /**
     * <b>Transformer(mutative)</b>Sets the player1 in this block position<br>
     * <p><b>Postcondition:</b>The player1 has been set</p>
     * @param p1 the player1 in this board position
     */
    @Override
    public void setP1(Player p1) {
        this.p1 = p1;
    }
    /**
     * <b>Accessor(selector)</b> Returns the player2 on this position<br>
     * @return player2 on this position
     */
    @Override
    public Player getP2() {
        return p2;
    }
    /**
     * <b>Transformer(mutative)</b>Sets the player2 in this block position<br>
     * <p><b>Postcondition:</b>The player2 has been set</p>
     * @param p2 the player2 in this board position
     */
    @Override
    public void setP2(Player p2) {
        this.p2 = p2;
    }
    /**
     * <b>Accessor(selector)</b> Returns the current dice number<br>
     * @return the current dice number
     */
    public int getDiceNumber() {
        return diceNumber;
    }
    /**
     * <b>Transformer(mutative)</b>Sets the dice number<br>
     * <p><b>Postcondition:</b>The new dice number has been set</p>
     * @param diceNumber the new dice number
     */
    public void setDiceNumber(int diceNumber) {
        this.diceNumber = diceNumber;
    }
    /**
     * <b>Accessor(selector)</b> Returns the money<br>
     * @return the money
     */
    public int getMoney() {
        return money;
    }
    /**
     * <b>Transformer(mutative)</b>Sets the money<br>
     * <p><b>Postcondition:</b>The new money has been set</p>
     * @param money the new money number
     */
    public void setMoney(int money) {
        this.money = money;
    }
    /**
     * <b>Transformer(mutative)</b>Performs the action of DicePosition<br>
     * <p><b>Postcondition:</b>The action has been done</p>
     */
    public void performAction() {}

}

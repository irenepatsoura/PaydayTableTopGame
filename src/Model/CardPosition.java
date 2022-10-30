package Model;
/**
 * Contains the needed signatures to create an instance of a CardPosition
 */
public class CardPosition extends Position {
    private Player p1,p2;
    private Position pos;
    /**
     * <b>Accessor(selector)</b> Returns the player on this position<br>
     * @return player on this position
     */
    @Override
    public Player getP1() {
        return p1;
    }
    /**
     * <b>Transformer(mutative)</b>Sets the player in this block position<br>
     * <p><b>Postcondition:</b>The player has been set</p>
     * @param p1 the player in this board position
     */
    @Override
    public void setP1(Player p1) {
        this.p1 = p1;
    }

    @Override
    public void setP2(Player p2) {
        this.p2 = p2;
    }

    @Override
    public Player getP2() {
        return p2;
    }

    /**
     * <b>Transformer(mutative)</b>Sets the position<br>
     * <p><b>Postcondition:</b>The position has been set</p>
     * @param pos the position of the instance in the board
     */
    public void setPos(Position pos) {
        this.pos = pos;
    }
    /**
     * <b>Accessor(selector)</b> Returns the position of this block<br>
     * @return position of this block
     */
    public Position getPos() {
        return pos;
    }
    /**
     * <b>Transformer(mutative)</b>Performs the action of CardPosition<br>
     * <p><b>Postcondition:</b>The action has been done</p>
     */
    @Override
    public void performAction() {

    }
}

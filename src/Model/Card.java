package Model;
/**
 * Contains the needed signatures to create an instance of a card
 */
public abstract class Card {
    /**
     * <b>Accessor(selector)</b> Returns the number on this card<br>
     * @return number of the card
     */
    public int getNumber(){

        return 0;
    }
    /**
     * <b>Accessor(selector)</b> Returns the string representation of the card<br>
     * @return string representation of a card
     */
    //returns a string represantation of a card
    public String toString(){

        return null;
    }
    /**
     * <b>Transformer(mutative)</b>Performs the action of card<br>
     * <p><b>Postcondition:</b>The action has been done</p>
     */
    public void performAction(){

    }

    public abstract int getSellingCost();
}

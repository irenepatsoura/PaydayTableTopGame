package Model;

import java.util.ArrayList;
/**
 * Contains the needed signatures to create an instance of a Deck
 */
public abstract class Deck {
    public ArrayList<Card> mailcards = new ArrayList<Card>();
    public ArrayList<Card> dealcards = new ArrayList<Card>();

    /**
     * <b>Transformer(selector)</b> Removes Card from Deck<br>
     * @param c The card that will be removed
     */
    public ArrayList<Card> removeCardfromDeck(Card c) {
        if(c instanceof DealCard) {
            int i = dealcards.indexOf(c);
            dealcards.remove(i);
            return dealcards;
        }
        else {
            int i = mailcards.indexOf(c);
            mailcards.remove(i);
            return mailcards;
        }
    }

}

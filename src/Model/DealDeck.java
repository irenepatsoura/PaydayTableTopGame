package Model;

import View.PayDayCards;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Contains the needed signatures to create an instance of a DealCard
 */
//i klasi apikonizi to deal deck kai i getcards epistrefei
//tn pano karta t deck
public class DealDeck extends Deck {
    public static ArrayList<DealCard> dealcards = new ArrayList<DealCard>();
    public static ArrayList<DealCard> discardPile = new ArrayList<DealCard>();
    public static PayDayCards pdv = new PayDayCards();
    /**
     * <b>Transformer</b>Initializes the deck and shuffles the deck<br>
     * <p><b>Postconditions</b>The deck list should be initialized an shuffled</p>
     */
    public static void initDeck() {
        pdv.readFile("./resources/dealCards_greeklish.csv", "Deal");
        String[][] DC = pdv.getDealCards();
        DealCard newdealcard;
        for(int i=0; i<DC.length; i++) {

//            System.out.println(DC[i][0]);
            if(DC[i][0].equals("Symfwnia")) {
//                System.out.println("card:"+new Model.DealCard(i, Integer.parseInt(DC[i][4]) ,Integer.parseInt(DC[i][3])));
                dealcards.add(new DealCard(i, Integer.parseInt(DC[i][4]) ,Integer.parseInt(DC[i][3])));
//                System.out.println(dealcards);
            }
            else {
                System.out.println("Wrong dealcard");
//                newdealcard = null;
            }
//            dealcards.add(newdealcard);

        }
//        System.out.println(dealcards);
        Collections.shuffle(dealcards);
        System.out.println(dealcards);
    }

    public static void setDiscardPile(ArrayList<DealCard> discardPile) {
        DealDeck.discardPile = discardPile;
    }

    public static ArrayList<DealCard> getDiscardPile() {
        return discardPile;
    }

    public static ArrayList<DealCard> getDealcards() {
        return dealcards;
    }

    public static void setDealcards(ArrayList<DealCard> dealcards) {
        DealDeck.dealcards = dealcards;
    }
    public static void addToDiscardPile(DealCard m) {
        discardPile.add(m);
    }

    public static DealCard getCards() {
        if(dealcards.size() == 0) {
            Collections.shuffle(discardPile);
            dealcards.addAll(discardPile);
            discardPile.clear();
        }

        DealCard firstDealCard = getDealcards().get(0);
        dealcards.remove(0);
        return firstDealCard;

    }

}

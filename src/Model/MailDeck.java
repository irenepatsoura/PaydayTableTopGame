package Model;

import View.PayDayCards;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Contains the needed signatures to create an instance of the position on the board MailDeck
 */
//i klasi apikonizi to deck tn mhnumatwn kai i getcards epistrefei
//tn pano karta t deck
public class MailDeck extends Deck {
    public static ArrayList<MailCard> discardPile = new ArrayList<MailCard>();
    public static ArrayList<MailCard> mailcards = new ArrayList<MailCard>();
    public static PayDayCards pdv = new PayDayCards();


    /**
     * <b>Transformer(mutative)</b>Initializes the deck<br>
     * <p><b>Postcondition:</b>The deck has been initialized</p>
     */
    public static void initDeck() {
        pdv.readFile("./resources/mailCards_greeklish.csv", "Mail");
        String[][] MC = pdv.getMailCards();
        for(int i=0; i<MC.length; i++) {
            MailCard newmailcard;
            System.out.println(MC[i][0]);
            if(MC[i][0].equals("Diafhmish")) {
                newmailcard = new MailCard("Advertisment",i,Integer.parseInt(MC[i][4]));
            }
            else if(MC[i][0].equals("Eksoflhsh Logariasmoy")) {
                newmailcard = new MailCard("Bill",i,Integer.parseInt(MC[i][4]));
            }
            else if(MC[i][0].equals("Filanthrwpia")) {
                newmailcard = new MailCard("Charity",i,Integer.parseInt(MC[i][4]));
            }
            else if(MC[i][0].equals("Plhrwse ton geitona")) {
                newmailcard = new MailCard("Pay the Neighbor",i,Integer.parseInt(MC[i][4]));
            }
            else if(MC[i][0].equals("Pare lefta apo to geitona")) {
                newmailcard = new MailCard("Take money from the Neighbor",i,Integer.parseInt(MC[i][4]));
            }
            else if(MC[i][0].equals("Metakinhsh se thesh Symfwnias/Agorasth")) {
                newmailcard = new MailCard("Move to Deal/Buyer",i,Integer.parseInt(MC[i][4]));
            }
            else {
                System.out.println("Wrong mailcard");
                newmailcard = null;
            }
            mailcards.add(newmailcard);
        }
        Collections.shuffle(mailcards);
        boolean isnotok = true;
        while(isnotok){
            int found = 0;
            for(int i = 0;i<mailcards.size()-1;i++){
                if(mailcards.get(i).getType().equals("Move to Deal/Buyer") && mailcards.get(i+1).getType().equals("Move to Deal/Buyer")) found++;
            }
            if(found==0){
                isnotok = false;
            }else{
                Collections.shuffle(mailcards);
            }
        }
        System.out.println("mail:"+mailcards);
    }
    /**
     * <b>Accessor(selector)</b> Returns deck<br>
     * @return
     */
//    public static MailCard getCards() {
//        if(mailcards.size() == 0) {
//            setMailcards(initDeck(discardPile));
//            discardPile.clear();
//        }
//
//        MailCard firstMailCard = getMailcards().get(0);
//        mailcards.remove(0);
//        return firstMailCard;

    /**
     * <b>Accessor(selector)</b> Returns discard pile of maildeck<br>
     * @return the discard pile
     */
    public static ArrayList<MailCard> getDiscardPile() {
        return discardPile;
    }
    /**
     * <b>Transformer(mutative)</b>Sets the discard pile<br>
     * <p><b>Postcondition:</b>The discard pile has been set</p>
     * @param discardPile the new discard pile
     */
    public static void setDiscardPile(ArrayList<MailCard> discardPile) {
        MailDeck.discardPile = discardPile;
    }
    public static void addToDiscardPile(MailCard m) {
        discardPile.add(m);
    }
//    public static void addToMails(MailCard m ) {
//        mailcards.add(m);
//    }
    /**
     * <b>Accessor(selector)</b> Returns the maildeck<br>
     * @return the mail deck
     */
    public static ArrayList<MailCard> getMailcards() {
        return mailcards;
    }
    /**
     * <b>Transformer(mutative)</b>Sets the mail deck<br>
     * <p><b>Postcondition:</b>The mail deck has been set</p>
     * @param mailcards the new mail deck
     */
    public static void setMailcards(ArrayList<MailCard> mailcards) {
        MailDeck.mailcards = mailcards;
    }
}

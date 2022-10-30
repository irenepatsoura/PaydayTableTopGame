package Model;

import Controller.Controller;
import View.Pioni;

import java.util.ArrayList;
/**
 * Contains the needed signatures to create an instance of a Player
 */
public class Player {
    private String name;
    private int bill, loan, money;
    private ArrayList<Card> mails = new ArrayList<Card>();
    private ArrayList<Card> deals = new ArrayList<Card>();
    private Position pos;
    private boolean hasPlayed;
    private boolean wantsToRepay;
    private Pioni pawn;
    private int zaria=0;

    /**
     * <b>Transformer(mutative)</b>Sets the player's diceroll<br>
     * <p><b>Postcondition:</b>The diceroll has been updated</p>
     * @param zaria the player's new diceroll
     */
    public void setZaria(int zaria) {
        this.zaria = zaria;
    }


    /**
     * <b>Accessor(selector)</b> Returns the dice roll of the player<br>
     * @return the dice roll of the player
     */
    public int getZaria() {
        return zaria;
    }

    public Player() {
        this.money = 3500;
        this.loan = 0;
        this.bill = 0;
    }

    /**
     * <b>Accessor(selector)</b> Returns the pawn of the player<br>
     * @return the pawn of the player
     */
    public Pioni getPawn() {
        return pawn;
    }

    /**
     * <b>Transformer(mutative)</b>Sets the player's pawn<br>
     * <p><b>Postcondition:</b>The pawn has been updated</p>
     * @param pawn the player's new pawn
     */
    public void setPawn(Pioni pawn) {
        this.pawn = pawn;
    }

    /**
     * <b>Transformer(mutative)</b>Sets the player's pawn<br>
     * <p><b>Postcondition:</b>The pawn has been updated</p>
     * @param filepath the pawns image filepath
     */
    public void init_pawn(String filepath) {
        pawn = new Pioni(filepath);

    }

    /**
     * <b>Transformer(mutative)</b>Initializes the player's dice roll<br>
     * <p><b>Postcondition:</b>The dice roll has been intialized</p>
     */
    public int get_zaria() {
        int zaria =  Controller.roll_dice();
        return zaria;
    }

    /**
     * <b>Accessor(selector)</b> Returns if the player wants to repay<br>
     * @return the decision of the player
     */
    public boolean isWantsToRepay() {
        return wantsToRepay;
    }

    /**
     * <b>Transformer(mutative)</b>Sets if the player wants to pay back a loan<br>
     * <p><b>Postcondition:</b>The decision has been updated</p>
     * @param wantsToRepay the player's new decision
     */
    public void setWantsToRepay(boolean wantsToRepay) {
        this.wantsToRepay = wantsToRepay;
    }

    /**
     * <b>Accessor(selector)</b> Returns the money of the player<br>
     * @param poso the player's debt that wants to repay
     * @return the money
     */
    public int repay(int poso) {
        return (int) Math.round((poso+500.0) / 1000) * 1000;
    }

    public ArrayList<Card> insertCardToDeck(Card c) {
        if(c instanceof DealCard) {
            DealCard i = (DealCard) c;
            getDeals().add(i);
            return getDeals();
        }
        else {
            MailCard i = (MailCard) c;
            getMails().add(i);
            return getMails();
        }
    }

    /**
     * <b>Transformer(mutative)</b>Removes player's card from deck<br>
     * <p><b>Postcondition:</b>The actions have been done</p>
     * @param c The card that is going to be removed
     */
    public void removeCardFromDeck(Card c) {
        if(c instanceof DealCard) {
            int i = deals.indexOf(c);
            getDeals().remove(i);
        }
        else if(c instanceof MailCard) {
            int i = mails.indexOf(c);
            getMails().remove(i);
        }
    }


    /**
     * <b>Accessor(selector)</b> Returns the bill<br>
     * @return the bill
     */
    public int getBill() {
        return bill;
    }
    /**
     * <b>Transformer(mutative)</b>Sets the bill<br>
     * <p><b>Postcondition:</b>The bill has been updated</p>
     * @param bill the new bill
     */
    public void setBill(int bill) {
        this.bill = bill;
    }
    /**
     * <b>Accessor(selector)</b> Returns the name of the player<br>
     * @return the name of the player
     */
    public String getName() {
        return name;
    }
    /**
     * <b>Transformer(mutative)</b>Sets the player's name<br>
     * <p><b>Postcondition:</b>The name has been updated</p>
     * @param name the player's new name
     */
    public void setName(String name) {

    }
    /**
     * <b>Accessor(selector)</b> Returns the money of the player<br>
     * @return the money of the player
     */
    public int getMoney() {
        return money;
    }
    /**
     * <b>Transformer(mutative)</b>Sets the player's money<br>
     * <p><b>Postcondition:</b>The money has been updated</p>
     * @param money the player's new money
     */
    public void setMoney(int money) {
        this.money = money;
    }

    /**
     * <b>Accessor(selector)</b> Returns the loan of the player<br>
     * @return the loan of the player
     */
    public int getLoan() {
        return loan;
    }
    /**
     * <b>Transformer(mutative)</b>Sets the player's loan<br>
     * <p><b>Postcondition:</b>The loan has been updated</p>
     * @param loan the player's new loan
     */
    public void setLoan(int loan) {
        this.loan = loan;
    }

    /**
     * <b>Accessor(selector)</b> Returns the dealcards<br>
     * @return dealcards
     */
    public ArrayList<Card> getDeals() {
        return deals;
    }

    public Card getDeal(int index) {
        return getDeals().get(index);
    }
    /**
     * <b>Transformer(mutative)</b>Sets the player's dealcards<br>
     * <p><b>Postcondition:</b>The dealcards has been updated</p>
     * @param deals the player's dealcards
     */
    public void setDeals(ArrayList<Card> deals) {

    }
    /**
     * <b>Accessor(selector)</b> Returns the mailcards<br>
     * @return mailcards
     */
    public ArrayList<Card> getMails() {
        return mails;
    }
    /**
     * <b>Transformer(mutative)</b>Sets the player's mailcards<br>
     * <p><b>Postcondition:</b>The mailcards has been updated</p>
     * @param mails the player's mailcards
     */
    public void setMails(ArrayList<Card> mails) {
        this.mails = mails;
    }

    /**
     * <b>Accessor(selector)</b> Returns if a player has played<br>
     * @return if player has played
     */
    public boolean isHasPlayed() {
        return hasPlayed;
    }
    /**
     * <b>Transformer(mutative)</b>Sets the player's has played variable<br>
     * <p><b>Postcondition:</b>The has played variable has been updated</p>
     * @param hasPlayed if the player has played
     */
    public void setHasPlayed(boolean hasPlayed) {

    }
    /**
     * <b>Accessor(selector)</b> Returns the position of this block<br>
     * @return position of this block
     */
    public Position getPos() {
        return pos;
    }
    /**
     * <b>Transformer(mutative)</b>Sets the position<br>
     * <p><b>Postcondition:</b>The position has been set</p>
     * @param pos the position of the instance in the board
     */
    public void setPos(Position pos) {
        this.pos = pos;

    }

    public void addDeal(DealCard deal) {
        System.out.println("Added: "+deal);
        deals.add(deal);
    }

    public void draw_mail(int num) {
        for(int i=0; i<num; i++) {
            //getMails().add(MailDeck.getCards());
        }

    }
    public void addMail(MailCard bill) {getMails().add(bill); }

    public void moveToDeal(int pos) {
        for(int i=(pos); i<Board.position.size(); i++) {
            if(Board.position.get(i) instanceof Agorastis || Board.position.get(i) instanceof DealPosition) {
                pos = i;
                break;
            }
            if(i == Board.position.size()-1)return;
        }
        setPos(Board.position.get(pos));
    }

}

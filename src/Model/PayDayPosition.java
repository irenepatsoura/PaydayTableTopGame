package Model;

import Controller.Controller;
import View.LoanUI;
import View.PaydayLoanPaymentUI;

/**
 * Contains the needed signatures to create an instance of the position on the board PayDayPosition
 */
public class PayDayPosition extends Position {
    private Player p1, p2;
    private Position pos;
    private static int month;
    private String day;
    private int diceroll;
    private Jackpot jckpt;


    public void setJckpt(Jackpot jckpt) {
        this.jckpt = jckpt;
    }

    public Jackpot getJckpt() {
        return jckpt;
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
     * <b>Accessor(selector)</b> Returns the month<br>
     * @return the month
     */
    public static int getMonth() { return month; }
    /**
     * <b>Transformer(mutative)</b>Sets the month<br>
     * <p><b>Postcondition:</b>The month has been set</p>
     * @param month the month
     */
    public void setMonth(int month) { this.month = month; }
    /**
     * <b>Transformer(mutative)</b>Sets the position<br>
     * <p><b>Postcondition:</b>The position has been set</p>
     * @param pos the position of the instance in the board
     */
    public void setPos(Position pos) { this.pos = pos; }
    /**
     * <b>Transformer(mutative)</b>Sets the player in this block position<br>
     * <p><b>Postcondition:</b>The player has been set</p>
     * @param p the player in this board position
     */
    @Override
    public void setP1(Player p) { this.p1 = p; }
    /**
     * <b>Accessor(selector)</b> Returns the player on this position<br>
     * @return player on this position
     */
    @Override
    public Player getP1() { return p1; }
    /**
     * <b>Accessor(selector)</b> Returns the position of this block<br>
     * @return position of this block
     */
    public Position getPos() { return pos; }
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
        getP1().setMoney(getP1().getMoney() + 3500);
        if(getP1().getBill() > getP1().getMoney()) {
            while(getP1().getBill()>getP1().getMoney()){
                LoanUI.tookloan = false;
                LoanUI l = new LoanUI(getP1(),Controller.obj);
                while(!LoanUI.tookloan){
                    System.out.print("");
                }
            }
//            getP1().setLoan(getP1().getLoan()+(getP1().getBill()-getP1().getMoney()));
//            getP1().take_loan(getP1().getBill() - getP1().getMoney()); //pairnoume daneio arketo wste na mas plhrwsei tous logariamous
        }

        getP1().setMoney(getP1().getMoney() - getP1().getBill()); // afairoume ta xrhmata gia tous logariasmous apo to portofoli mas
        getP1().setBill(0); // kseplhrwnoume tous logariamous

        for(int i=0; i<getP1().getMails().size(); i++) {
            MailDeck.addToDiscardPile((MailCard) getP1().getMails().get(0));
            getP1().getMails().remove(0);
            i--;
        }
//        getP1().setMails(null);
        if(getP1().getLoan() > 0) {
            if(getP1().getMoney() < (getP1().getLoan()*0.1)) {
                while(getP1().getMoney()<(getP1().getLoan()*0.1)){
                    LoanUI.tookloan = false;
                    LoanUI l = new LoanUI(getP1(),Controller.obj);
                    l.initComponents();
                    while(!LoanUI.tookloan){
                        System.out.print("");
                    }
                }
//                getP1().take_loan((getP1().getLoan()*0.1) - getP1().getMoney());
            }
            getP1().setMoney((int) (getP1().getMoney() - getP1().getLoan()*0.1));

//            int poso = 0; // to poso pou thelei na eksoflhsei sto daneio, tha to dialegei mesw parathurou dialogou sto view
//            if(getP1().isWantsToRepay()) getP1().setLoan(getP1().repay(poso));
            PaydayLoanPaymentUI p = new PaydayLoanPaymentUI(getP1(),Controller.obj);
            p.initComponents();
            while(!PaydayLoanPaymentUI.tookloan){
                System.out.print("");
            }
            PaydayLoanPaymentUI.tookloan = false;
        }
//        setMonth(getMonth()+1);
        if(Controller.getTurn() == 1){
            Controller.obj.getMoney1().setText("Money: "+ getP1().getMoney()+" Euros");
            Controller.obj.getLoan1().setText("Loan: "+getP1().getLoan()+" Euros");
            Controller.obj.getBills1().setText("Bills: "+getP1().getBill()+" Euros");
        }else{
            Controller.obj.getMoney2().setText("Money: "+ getP1().getMoney()+" Euros");
            Controller.obj.getLoan2().setText("Loan: "+getP1().getLoan()+" Euros");
            Controller.obj.getBills2().setText("Bills: "+getP1().getBill()+" Euros");
        }
        Controller.obj.getWindow().repaint();
        System.out.println("payday");
    }
}

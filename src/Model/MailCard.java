package Model;


import Controller.Controller;

import static java.lang.System.exit;

public class MailCard extends Card {
    private int mailCount;
    private String type;
    private int index;
    private boolean amesienergia;
    private int money;
    private boolean plirose;
    private Player p;

    public void setP(Player p) {
        this.p = p;
    }

    public Player getP() {
        return p;
    }

    public int getMailCount() {
        return mailCount;
    }

    public void setMailCount(int mailCount) {
        this.mailCount = mailCount;
    }

    public boolean isPlirose() {
        return plirose;
    }

    public void setPlirose(boolean plirose) {
        this.plirose = plirose;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public int getMoney() {
        return money;
    }

    public void setAmesienergia(boolean amesienergia) {
        this.amesienergia = amesienergia;
    }

    public boolean isAmesienergia() {
        return amesienergia;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public MailCard(String type, int index, int money) {
        this.type = type;
        this.index = index;
        this.money = money;
        if( getType().equals("Pay the Neighbor")) {
            setMoney(money);
            setPlirose(true);
        }
        else if (getType().equals("Take money from the Neighbor")) {
            setMoney(money);
            setPlirose(false);
        }
        else if(getType().equals("Charity")) {
            setPlirose(true);
            setMoney(money);
        }
        else if(getType().equals("Bill")) {
            setMoney(money);
            setPlirose(true);
        }
        else if(getType().equals("Move to Deal/Buyer")) {
            setPlirose(false);
            setMoney(money);

        }
        else if(getType().equals("Advertisment")) {
            setPlirose(false);
            setMoney(20);
        }
        else {
            System.out.println("Wrong Type");
        }
    }

    /**
     * <b>Transformer:</b> sets the card's type
     * <b>Postcondition:</b> the card's type has been set
     * @param type
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * <b>Accessor:</b> returns the card's type
     * <b>Postcondition:</b> the card's type has been returned
     * @return cards type
     */
    public String getType() {
        return this.type;
    }
    /**
     * <b>Accessor:</b> returns the card's number
     * @return cards number
     */

    @Override
    public int getNumber() {
        return 0;
    }
    /**
     * <b>Transformer(mutative)</b>Performs the action of MailCard<br>
     * <p><b>Postcondition:</b>The action has been done</p>
     */
    @Override
    public void performAction() {
        System.out.println("Type:"+getType()+" money:"+money);
        if(getType().equals("Bill"))
        {
            setAmesienergia(false);
        }

        else {
            setAmesienergia(true);
        }

        if(getType().equals("Move to Deal/Buyer")) {
            if(Controller.getTurn()==1) {
                Controller.obj.movetodealuip1();
                Controller.obj.getP1().getPos().setP1(Controller.obj.getP1());
                Controller.obj.getP1().getPos().setP2(Controller.obj.getP2());
                Controller.obj.getP1().getPos().performAction();
                if(Controller.obj.getP1().getPos() instanceof DealPosition) {
                    Controller.obj.finished_deal = false;
                    while (!Controller.obj.finished_deal) {
                        System.out.print("");
                    }
                }
            }
            else {
                Controller.obj.movetodealuip2();
                Controller.obj.getP2().getPos().setP1(Controller.obj.getP2());
                Controller.obj.getP2().getPos().setP2(Controller.obj.getP1());
                Controller.obj.getP2().getPos().performAction();
                if(Controller.obj.getP2().getPos() instanceof DealPosition) {
                    Controller.obj.finished_deal = false;
                    while (!Controller.obj.finished_deal) {
                        System.out.print("");
                    }
                }
            }

        }


        else if(getType().equals("Pay the Neighbor")) {
            if(Controller.getTurn() == 1){
                Controller.obj.getP1().setMoney(Controller.obj.getP1().getMoney()-money);
                Controller.obj.getP2().setMoney(Controller.obj.getP2().getMoney()+money);
            }else{
                Controller.obj.getP2().setMoney(Controller.obj.getP2().getMoney()-money);
                Controller.obj.getP1().setMoney(Controller.obj.getP1().getMoney()+money);
            }
        }
        else if(getType().equals("Take money from the Neighbor")) {
            if(Controller.getTurn() == 1){
                Controller.obj.getP1().setMoney(Controller.obj.getP1().getMoney()+money);
                Controller.obj.getP2().setMoney(Controller.obj.getP2().getMoney()-money);
            }else{
                Controller.obj.getP2().setMoney(Controller.obj.getP2().getMoney()+money);
                Controller.obj.getP1().setMoney(Controller.obj.getP1().getMoney()-money);
            }
        }
        else if(getType().equals("Charity")) {
            if(Controller.getTurn() == 1){
                Controller.obj.getP1().setMoney(Controller.obj.getP1().getMoney()-money);
                Jackpot.setMoney(Jackpot.getMoney()+money);
            }else{
                Controller.obj.getP2().setMoney(Controller.obj.getP2().getMoney()-money);
                Jackpot.setMoney(Jackpot.getMoney()+money);
            }
        }
        else if(getType().equals("Bill")){

            if(Controller.getTurn() == 1){
                Controller.obj.getP1().setBill(Controller.obj.getP1().getBill()+ money);
                System.out.println("Inbill:"+Controller.obj.getP1().getBill());
            }else{
                Controller.obj.getP2().setBill(Controller.obj.getP2().getBill()+money);

            }
        }else if(getType().equals("Advertisment")){
            if(Controller.getTurn() == 1){
                Controller.obj.getP1().setMoney(Controller.obj.getP1().getMoney()+money);

            }else{
                Controller.obj.getP2().setMoney(Controller.obj.getP2().getMoney()+money);;

            }
        }
        else {
            System.out.println("An error with the mail cards occurred");
            exit(0);
        }
        System.out.println("Bills:"+Controller.obj.getP1().getBill()+", "+Controller.obj.getP2().getBill());
        Controller.obj.getMoney1().setText("Money:"+ Controller.obj.getP1().getMoney()+" Euros");
        Controller.obj.getMoney2().setText("Money:"+ Controller.obj.getP2().getMoney()+" Euros");
        Controller.obj.getBills1().setText("Bills:"+ Controller.obj.getP1().getBill()+" Euros");
        Controller.obj.getBills2().setText("Bills:"+ Controller.obj.getP2().getBill()+" Euros");
        Controller.obj.getLoan1().setText("Loan:"+ Controller.obj.getP1().getLoan()+" Euros");
        Controller.obj.getLoan2().setText("Loan:"+ Controller.obj.getP2().getLoan()+" Euros");
        Controller.obj.getJtxt().setText("Jackpot: "+Jackpot.getMoney()+" Euros");
//        MailDeck.addToDiscardPile(this);
        Controller.obj.getWindow().repaint();


    }

    @Override
    public int getSellingCost() {
        return 0;
    }

    /**
     * Returns the representation of a card
     * <p><b>Postcondition</b> the string representation of a card is returned</p>
     * @return the string representation of a card
     */
    @Override
    public String toString() {
        return this.type.toString();
    }
}

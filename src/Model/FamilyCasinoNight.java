package Model;

import Controller.Controller;
import View.LoanUI;

/**
 * Contains the needed signatures to create an instance of a FamilyCasinoNight
 */
public class FamilyCasinoNight extends Position {
    private Player p1,p2;
    private Position pos;
    private String day;
    private int diceroll;
    private Jackpot jckpt;

    public void setJckpt(Jackpot jckpt) {
        this.jckpt = jckpt;
    }

    public Jackpot getJckpt() {
        return jckpt;
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
    /**
     * <b>Accessor(selector)</b> Returns the position of this block<br>
     * @return position of this block
     */
    public Position getPos() { return pos; }

    @Override
    public void setP2(Player p2) {
        this.p2 = p2;
    }

    @Override
    public Player getP2() {
        return p2;
    }

    /**
     * <b>Transformer(mutative)</b>Performs the action of FamilyCasinoNight<br>
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

        String info = Controller.obj.getInfoBox().getText();
        String[] text = info.split("\n");

        if(getDiceroll()%2 == 0) {
          int newmoney = getP1().getMoney() + 500;
          getP1().setMoney(newmoney);
          text[3] = "-->Player"+Controller.getTurn()+" You won 500 Euros in Casino";
        }
        else if(getDiceroll()%2 == 1) {
            while(getP1().getMoney()<500){
                LoanUI.tookloan=false;
                LoanUI l = new LoanUI(getP1(),Controller.obj);
                l.initComponents();
                while(!LoanUI.tookloan){
                    System.out.print("");
                }
            }
          int newmoney = getP1().getMoney() - 500;
          getP1().setMoney(newmoney);
          int jckptmoney = getJckpt().getMoney() + 500;

          text[3] = "-->Player"+Controller.getTurn()+" You paid 500 Euros to Jackpot";

          Jackpot.setMoney(jckptmoney);
          Controller.obj.getJtxt().setText("Jackpot: "+String.valueOf(Jackpot.getMoney())+" Euros");
          Controller.obj.getWindow().repaint();
        }

        if(Controller.getTurn()==1) Controller.obj.getMoney1().setText("Money: "+getP1().getMoney());

        else Controller.obj.getMoney2().setText("Money: "+getP1().getMoney());

        Controller.obj.getInfoBox().setText(text[0]+"\n"+text[1]+"\n"+text[2]+"\n"+text[3]+"\n");
        Controller.obj.getWindow().repaint();

//        System.out.println("Casino");

    }
}

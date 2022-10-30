package Model;

import Controller.Controller;

/**
 * Contains the needed signatures to create an instance of a Radio Position
 */
public class Radio extends Position {
    private Player p1;
    private Player p2;
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

    public void RadioContest() {
        int zaria_P1 = p1.get_zaria();
        int zaria_P2 = p2.get_zaria();

        String info = Controller.obj.getInfoBox().getText();
        String[] text = info.split("\n");

        while(zaria_P1==zaria_P2) {
            zaria_P1 = p1.get_zaria();
            zaria_P2 = p2.get_zaria();
//            RadioContest();
        }

        if (zaria_P1 > zaria_P2) {
            getP1().setMoney(getP1().getMoney() + 1000);
//            Controller.obj.getMoney1().setText("Money: "+getP1().getMoney());
            if(Controller.getTurn()==1) {
                text[3] = "-->Player1 You won 1000 Euros on Radio Contest";
                Controller.obj.getMoney1().setText("Money: " + getP1().getMoney());
            }
            else {
                text[3] = "-->Player2 You won 1000 Euros on Radio Contest";
                Controller.obj.getMoney2().setText("Money: " + getP1().getMoney());
            }
        }
        else {
            getP2().setMoney(getP2().getMoney() + 1000);
            if(Controller.getTurn()==1) {
                text[3] = "-->Player2 You won 1000 Euros on Radio Contest";
                Controller.obj.getMoney2().setText("Money: "+getP2().getMoney());
            }
            else {
                text[3] = "-->Player1 You won 1000 Euros on Radio Contest";
                Controller.obj.getMoney1().setText("Money: "+getP2().getMoney());
            }
        }
        Controller.obj.getInfoBox().setText(" ");

        for(int i=0; i< text.length; i++) {
            Controller.obj.getInfoBox().setText(Controller.obj.getInfoBox().getText()+text[i] + "\n");

        }
        Controller.obj.getWindow().repaint();


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
     * <b>Accessor(selector)</b> Returns the player1 on this position<br>
     * @return player1 on this position
     */
    @Override
    public Player getP1() { return p1; }
    /**
     * <b>Transformer(mutative)</b>Sets the player1 in this block position<br>
     * <p><b>Postcondition:</b>The player1 has been set</p>
     * @param p1 the player1 in this board position
     */
    @Override
    public void setP1(Player p1) { this.p1 = p1; }
    /**
     * <b>Accessor(selector)</b> Returns the player2 on this position<br>
     * @return player2 on this position
     */
    @Override
    public Player getP2() { return p2; }
    /**
     * <b>Transformer(mutative)</b>Sets the player2 in this block position<br>
     * <p><b>Postcondition:</b>The player2 has been set</p>
     * @param p2 the player2 in this board position
     */
    @Override
    public void setP2(Player p2) { this.p2 = p2; }
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

        RadioContest();

        System.out.println("Radio");

    }
}

package Model;
/**
 * Contains the needed signatures to create an instance of a Position
 */
public abstract class Position extends Board {
    private int numOnBoard, i, j;
    private String Day;
    private String type;
    //private Player player;
    private Player p1,p2;


    public Player getP1() {
        return p1;
    }

    public void setP1(Player p1) {
        this.p1 = p1;
    }

    public Player getP2() {
        return p2;
    }

    public void setP2(Player p2) {
        this.p2 = p2;
    }

    public void initIJ(int numOnBoard) {
        this.i = numOnBoard/7;
        this.j = numOnBoard%7;
    }

    public int getI() {
        return i;
    }

    public int getJ() {
        return j;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    /**
     * <b>Transformer(mutative)</b>Performs the action of agorameekptwsh<br>
     * <p><b>Postcondition:</b>The action has been done</p>
     */
    public void performAction() {
        System.out.println("Kurios Aggelis magoulakias");
    }

    /**
     * <b>Accessor(selector)</b> Returns the position of this block<br>
     * @return position of this block
     */
    public int getNumOnBoard() {
        return numOnBoard;
    }
    /**
     * <b>Transformer(mutative)</b>Sets the position<br>
     * <p><b>Postcondition:</b>The position has been set</p>
     * @param numOnBoard the position of the instance in the board
     */
    public void setNumOnBoard(int numOnBoard) {
        this.numOnBoard = numOnBoard;
    }
    /**
     * <b>Accessor(selector)</b> Returns current day<br>
     * @return the current day
     */
    public String getDay() {
        return Day;
    }
    /**
     * <b>Transformer(mutative)</b>Sets the day<br>
     * <p><b>Postcondition:</b>The current day has been set</p>
     * @param day the current day
     */
    public void setDay(String day) {
        Day = day;
    }
}

package Model;
/**
 * Contains the needed signatures to create an instance of a DealCard
 */
public class DealCard extends Card {

    private int buyingCost;
    private int sellingCost;
    private int index, billmoney;

    /**
     * <b>Accessor(selector)</b> Returns the index of the position of a card<br>
     * @return index of the card
     */
    public int getIndex() {
        return index;
    }
    /**
     * <b>Transformer(mutative)</b>Sets the index of the position of a card<br>
     * <p><b>Postcondition:</b>The action has been done</p>
     */
    public void setIndex(int index) {
        this.index = index;
    }
    /**
     * <b>Accessor(selector)</b> Returns the buying cost of a deal card<br>
     * @return buying cost of the deal card
     */
    public int getBuyingCost() {
        return buyingCost;
    }
    /**
     * <b>Accessor(selector)</b> Returns the selling cost of a deal card<br>
     * @return selling cost of the deal card
     */
    public int getSellingCost() {
        return sellingCost;
    }
    /**
     * <b>Transformer(mutative)</b>Sets the buying cost of a deal card<br>
     * <p><b>Postcondition:</b>The action has been done</p>
     */
    public void setBuyingCost(int buyingCost) {
        this.buyingCost = buyingCost;
    }
    /**
     * <b>Transformer(mutative)</b>Sets the selling cost of a deal card<br>
     * <p><b>Postcondition:</b>The action has been done</p>
     */
    public void setSellingCost(int sellingCost) {
        this.sellingCost = sellingCost;
    }

    /**
     * <b>Constructor</b>Constructs a new instance of a DealCard
     */
    public DealCard(){}
    public DealCard(int index, int sellingCost, int buyingCost) {
        this.index = index;
        this.sellingCost = sellingCost;
        this.buyingCost = buyingCost;
    }
    /**
     * <b>Accessor(selector)</b> Returns the number on this card<br>
     * @return number of the card
     */
    @Override
    public int getNumber() {
        return 0;
    }
    /**
     * <b>Transformer(mutative)</b>Performs the action of card<br>
     * <p><b>Postcondition:</b>The action has been done</p>
     */
    @Override
    public void performAction() {

    }

}

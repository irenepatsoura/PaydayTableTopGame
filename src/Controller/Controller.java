package Controller;

import Model.*;
import View.*;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Contains needed signatures to make a new instance of a Controller
 */
public class Controller {
    private Player P1,P2;
    private Board board;
    private boolean get_loan, end_turn;
    private static int turn;
    private int round, diceroll, new_month;
    private ArrayList<MailCard> mailcards = new ArrayList<MailCard>();
    private ArrayList<DealCard> dealcards = new ArrayList<DealCard>();
    private static int howManyMonths;
    public static Jackpot jackpot;
    public static boolean MailPos1=false,MailPos2=false;

    /**
     * <b>Constructor</b>Constructs a new instance of a Controller
     */


    public Controller() {
        P1 = new Player1();
        P2 = new Player2();
        this.new_month = 0;
        this.round = 0;
        this.turn = 0;
    }

    /**
     * <b>Transformer</b>Changes the value of the round
     * <p><b>Postconditions</b>The value of round should be changed</p>
     */
    public void setRound(int round) {
        this.round = round;
    }

    /**
     * <b>Accessor(selector)</b> get current round<br>
     * @return returns the current round
     */
    public int getRound() {
        return round;
    }

    /**
     * <b>Accessor(selector)</b> get current months<br>
     * @return returns the current month
     */
    public static int getHowManyMonths() {
        return howManyMonths;
    }

    /**
     * <b>Transformer</b>Changes the value that checks how many months in the game
     * <p><b>Postconditions</b>The value of months should be changed</p>
     */
    public static void setHowManyMonths(int howManyMonths) {
        Controller.howManyMonths = howManyMonths;
    }

    /**
     * <b>Transformer</b>Rolls the dice
     * <p><b>Postconditions</b>The dice should have a new value</p>
     * @return new dice value
     */
    public static int roll_dice() {
        Random rand = new Random();
        int randomNum = rand.nextInt(6)+1;
        return randomNum;
    }
    /**
     * <b>Observer</b>Checks if turn is over
     * @return if the turn is over
     */
    public boolean isEnd_turn() {
        return end_turn;
    }
    /**
     * <b>Transformer</b>Changes the value that checks if turn is over
     * <p><b>Postconditions</b>The end_turn variable's value should be updated</p>
     */
    public void setEnd_turn(boolean end_turn) {
        this.end_turn = end_turn;
    }
    /**
     * <b>Accessor(selector)</b> Returns if a player chose to get a loan<br>
     * @return if a player wants to get a loan
     */
    public boolean isGet_loan() {
        return get_loan;
    }
    /**
     * <b>Transformer</b>Changes the value that checks if a player wants a loan
     * <p><b>Postconditions</b>The value of get_loan should be changed</p>
     */
    public void setGet_loan(boolean get_loan) {
        this.get_loan = get_loan;
    }
    /**
     * <b>Accessor(selector)</b> get current turn<br>
     * @return returns the current turn
     */
    public static int getTurn() {
        return turn;
    }
    /**
     * <b>Transformer</b>Changes the value of the turn number
     * <p><b>Postconditions</b>The value of the turn number should be changed</p>
     */
    public static void setTurn(int turn) {
        Controller.turn = turn;
    }

    /**
     * <b>Accessor(selector)</b> get the month<br>
     * @return returns the month
     */
    public int get_new_month() {
        return this.new_month;

    }

    /**
     * <b>Observer</b>Checks if month is over
     * @return if the month is over
     */
    public boolean month_has_finished() {
        return false;
    }
    /**
     * <b>Observer</b>Checks if game is over
     * @return if the game is over
     */
    public boolean game_has_finished() {
        return false;
    }

    public static BoardUI obj;

    public static void main(String[] args) {
        Player player1 = new Player();
        Player player2 = new Player();

        boolean game_ended = false;

        player1.init_pawn("./images/pawn_yellow.png");
        player2.init_pawn("./images/pawn_blue.png");

        jackpot = new Jackpot();
        Jackpot.setMoney(0);

        obj = new BoardUI();

        System.out.println(player1);
        System.out.println(player2);
        Board obj2 = new Board();

        obj.setP1(player1);
        obj.setP2(player2);
        obj2.init_Board();
        obj.initComponets();


        Arxikopoihsh arxikopoihsh = new Arxikopoihsh(obj,player1,player2);
        arxikopoihsh.init_game();

        MailDeck.initDeck();
        DealDeck.initDeck();

        int currmonth1 = getHowManyMonths();
        int currmonth2 = getHowManyMonths();

        while(!game_ended) {
            obj.drawncards = 0;
            if (getTurn() == 1) {
                System.out.println("Months1:"+currmonth1+", "+getHowManyMonths()+", "+player1.getPos());
                if(player1.getPos() instanceof PayDayPosition && !(player2.getPos() instanceof PayDayPosition) && currmonth1 == getHowManyMonths()){
                    String info = Controller.obj.getInfoBox().getText();
                    String[] text = info.split("\n");
                    System.out.println("p1 in first if");
                    text[2] = "Turn: Player 2";
                    text[3] = "-->Player 2 It's your turn. Roll the dice";

                    Controller.obj.getInfoBox().setText(" ");

                    for(int i=0; i< text.length; i++) {
                        Controller.obj.getInfoBox().setText(Controller.obj.getInfoBox().getText()+text[i] + "\n");

                    }
                    Controller.obj.getWindow().repaint();
                    Controller.setTurn(2);
                    continue;
                }

                if(currmonth1!=getHowManyMonths())currmonth1 = getHowManyMonths();

                while (!obj.p1_rolled_dice) {
                    System.out.print("");

                }
                System.out.println("rolled dice1");

                LoanDecisionUI dec = new LoanDecisionUI(obj);
                dec.takeLoan();

                while (!dec.isPressedYes() && !dec.isPressedNo()) {
                    System.out.print("");
                }
                System.out.println("decided for loan");
                if (dec.isPressedYes()) {
                    while (!LoanUI.tookloan) {
                        System.out.print("");
                    }
                    System.out.println("tookloan");

                }
                System.out.println("done with loan");


                MailPos1 = false;

                if (player1.getPos() instanceof AgoraMeEkptwsh) {
                    AgoraMeEkptwsh balader = (AgoraMeEkptwsh) player1.getPos();
                    balader.setP1(player1);

                } else if (player1.getPos() instanceof Agorastis) {
                    Agorastis balader = (Agorastis) player1.getPos();
                    balader.setP1(player1);

                } else if (player1.getPos() instanceof DealPosition) {
                    DealPosition balader = (DealPosition) player1.getPos();
                    balader.setP1(player1);

                } else if (player1.getPos() instanceof FamilyCasinoNight) {
                    FamilyCasinoNight balader = (FamilyCasinoNight) player1.getPos();
                    balader.setP1(player1);

                } else if (player1.getPos() instanceof Laxio) {
                    Laxio balader = (Laxio) player1.getPos();
                    balader.setP1(player1);

                } else if (player1.getPos() instanceof Lotaria) {
                    Lotaria balader = (Lotaria) player1.getPos();
                    balader.setP1(player1);
                    balader.setP2(player2);

                } else if (player1.getPos() instanceof MailPosition) {
                    MailPosition balader = (MailPosition) player1.getPos();
                    balader.setP1(player1);
                    balader.setP2(player2);
                    MailPos1 = true;

                } else if (player1.getPos() instanceof PayDayPosition) {
                    PayDayPosition balader = (PayDayPosition) player1.getPos();
                    balader.setP1(player1);

                } else if (player1.getPos() instanceof Radio) {
                    Radio balader = (Radio) player1.getPos();
                    balader.setP1(player1);
                    balader.setP2(player2);

                }
                String[] txt = obj.getInfoBox().getText().split("\n");
                txt[3] = "--> Perform Action and end turn";

                obj.getInfoBox().setText(txt[0]+"\n"+txt[1]+"\n"+txt[2]+"\n"+txt[3]+"\n");

                System.out.println("performing act:" + player1.getPos());
                MailPosition thepos = null;
                if(MailPos1) {
                    thepos = (MailPosition) player1.getPos();
                }

                while (MailPos1) {
                    if(thepos!=null && obj.drawncards>= thepos.getNumberOfMailCards())break;
                    System.out.print("");
                }
                obj.drawncards = 0;
                System.out.println("drawn");
                if(thepos!=null) {
                    thepos.performAction();
                }else {
                    player1.getPos().performAction();
                }

                System.out.println("act performed");


                //crypto thursday for player1
                if(player1.getPos().getDay().equals("Thursday")) {
                    View.CryptoThursdayUI crypto = new CryptoThursdayUI(player1);
                    crypto.initComponents();
                }

                //sunday football match for player1
                if(player1.getPos().getDay().equals("Sunday")) {
                    View.SundayFootballDayUI football = new SundayFootballDayUI(player1);
                    football.initComponents();
                }

                obj.end_turn1 = false;
                while(!obj.end_turn1) {
                    System.out.print("");
                }
                obj.drawncards = 0;
                obj.p1_rolled_dice = false;
                Controller.obj.finished_deal = false;
                System.out.println("turn ended");
                String info = Controller.obj.getInfoBox().getText();
                String[] text = info.split("\n");

                text[2] = "Turn: Player 2";
                text[3] = "-->Player 2 It's your turn. Roll the dice";

                Controller.obj.getInfoBox().setText(" ");
                LoanUI.tookloan=false;
                for(int i=0; i< text.length; i++) {
                    Controller.obj.getInfoBox().setText(Controller.obj.getInfoBox().getText()+text[i] + "\n");

                }
                Controller.obj.getWindow().repaint();
                if(player1.getPos() instanceof PayDayPosition && player2.getPos() instanceof PayDayPosition){
                    Controller.setHowManyMonths(Controller.getHowManyMonths()-1);
                    System.out.println("p1 in last if");
                    Controller.setTurn(2);
                    if(Controller.getHowManyMonths() == 0)game_ended=true;
                }

            } else if (getTurn() == 2) {
                System.out.println("Months2:"+currmonth2+", "+getHowManyMonths()+", "+player2.getPos());
                if(!(player1.getPos() instanceof PayDayPosition) && player2.getPos() instanceof PayDayPosition && currmonth2 == getHowManyMonths()){
                    String info = Controller.obj.getInfoBox().getText();
                    String[] text = info.split("\n");
                    System.out.println("p2 in first if");

                    text[2] = "Turn: Player 1";
                    text[3] = "-->Player 1 It's your turn. Roll the dice";

                    Controller.obj.getInfoBox().setText(" ");

                    for(int i=0; i< text.length; i++) {
                        Controller.obj.getInfoBox().setText(Controller.obj.getInfoBox().getText()+text[i] + "\n");

                    }
                    Controller.obj.getWindow().repaint();
                    Controller.setTurn(1);
                    continue;
                }

                if(currmonth2!=getHowManyMonths())currmonth2 = getHowManyMonths();

                while (!obj.p2_rolled_dice) {
                    System.out.print("");

                }
                System.out.println("rolled dice2");


                LoanDecisionUI dec = new LoanDecisionUI(obj);
                dec.takeLoan();

                while (!dec.isPressedYes() && !dec.isPressedNo()) {
                    System.out.print("");
                }
                System.out.println("decided for loan");

                if (dec.isPressedYes()) {
                    while (!LoanUI.tookloan) {
                        System.out.print("");
                    }
                    System.out.println("took loan");
                }
                System.out.println("done with loan");

                MailPos2 = false;

                if (player2.getPos() instanceof AgoraMeEkptwsh) {
                    AgoraMeEkptwsh balader = (AgoraMeEkptwsh) player2.getPos();
                    balader.setP1(player2);
                    System.out.println("1");
                } else if (player2.getPos() instanceof Agorastis) {
                    Agorastis balader = (Agorastis) player2.getPos();
                    balader.setP1(player2);
                    System.out.println("2");
                } else if (player2.getPos() instanceof DealPosition) {
                    DealPosition balader = (DealPosition) player2.getPos();
                    balader.setP1(player2);
                    System.out.println("3");
                } else if (player2.getPos() instanceof FamilyCasinoNight) {
                    FamilyCasinoNight balader = (FamilyCasinoNight) player2.getPos();
                    balader.setP1(player2);
                    System.out.println("4");
                } else if (player2.getPos() instanceof Laxio) {
                    Laxio balader = (Laxio) player2.getPos();
                    balader.setP1(player2);
                    System.out.println("5");
                } else if (player2.getPos() instanceof Lotaria) {
                    Lotaria balader = (Lotaria) player2.getPos();
                    balader.setP1(player2);
                    balader.setP2(player1);
                    System.out.println("6");
                } else if (player2.getPos() instanceof MailPosition) {
                    MailPosition balader = (MailPosition) player2.getPos();
                    balader.setP1(player2);
                    balader.setP2(player1);
                    System.out.println("7");
                    MailPos2 = true;
                } else if (player2.getPos() instanceof PayDayPosition) {
                    PayDayPosition balader = (PayDayPosition) player2.getPos();
                    balader.setP1(player2);
                    System.out.println("8");
                } else if (player2.getPos() instanceof Radio) {
                    Radio balader = (Radio) player2.getPos();
                    balader.setP1(player2);
                    balader.setP2(player1);
                    System.out.println("9");
                }
                MailPosition thepos = null;
                if(MailPos2) {
                    thepos = (MailPosition) player2.getPos();
                }
                System.out.println("perform act:" + player2.getPos());
                String[] txt = obj.getInfoBox().getText().split("\n");
                txt[3] = "--> Perform Action and end turn";


                obj.getInfoBox().setText(txt[0]+"\n"+txt[1]+"\n"+txt[2]+"\n"+txt[3]+"\n");
                while (MailPos2) {
                    if(thepos!=null && obj.drawncards>= thepos.getNumberOfMailCards())break;
                    System.out.print("");
                }
                obj.drawncards = 0;
                System.out.println("drawn");
                LoanUI.tookloan=false;
                if(thepos!=null){
                    thepos.performAction();
                }else {
                    player2.getPos().performAction();
                }
                obj.p2_rolled_dice = false;

                System.out.println("act performed");


                //crypto thursday for player2
                if(player2.getPos().getDay().equals("Thursday")) {
                    View.CryptoThursdayUI crypto = new CryptoThursdayUI(player2);
                    crypto.initComponents();
                }

                //sunday football match for player2
                if(player2.getPos().getDay().equals("Sunday")) {
                    View.SundayFootballDayUI football = new SundayFootballDayUI(player2);
                    football.initComponents();
                }

                obj.end_turn2=false;
                while(!obj.end_turn2) {
                    System.out.print("");
                }
                Controller.obj.finished_deal = false;
                obj.drawncards = 0;
                System.out.println("turned ended");
                String info = Controller.obj.getInfoBox().getText();
                String[] text = info.split("\n");

                text[2] = "Turn: Player 1";
                text[3] = "-->Player 1 It's your turn. Roll the dice";

                Controller.obj.getInfoBox().setText(" ");

                for(int i=0; i< text.length; i++) {
                    Controller.obj.getInfoBox().setText(Controller.obj.getInfoBox().getText()+text[i] + "\n");

                }
                Controller.obj.getWindow().repaint();
                if(player1.getPos() instanceof PayDayPosition && player2.getPos() instanceof PayDayPosition){
                    Controller.setHowManyMonths(Controller.getHowManyMonths()-1);
                    System.out.println("p2 in last if");
                    Controller.setTurn(1);
                    if(Controller.getHowManyMonths() == 0)game_ended=true;
                }

            } else {
                System.out.println("Wrong number of turn");
            }
        }

        WinnerDialog w = new WinnerDialog();
        w.initComponents();



    }

}

package Model;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Contains the needed signatures to create an instance of a board
 */
public class Board {
    public static ArrayList<Position> position = new ArrayList<Position>();

    /**
     * <b>Accessor(selector)</b> Returns the positions of the board<br>
     * @return positions of the board
     */
    public static ArrayList<Position> getPosition() {
        return position;
    }
    /**
     * <b>Transformer(mutative)</b>Sets the position<br>
     * <p><b>Postcondition:</b>The position has been set</p>
     * @param position the position of the instance in the board
     */
    public static void setPosition(ArrayList<Position> position) {
        Board.position = position;
    }

    /**
     * <b>Transformer(mutative)</b>Initializes th Board<br>
     * <p><b>Postcondition:</b>The action has been done</p>
     */
    public void init_Board() {
        for(int i=0; i<4; i++) {
            position.add(new MailPosition(2));
        }
        for(int i=0; i<4; i++) {
            position.add(new MailPosition(1));
        }
        for(int i=0; i<5; i++) {
            position.add(new DealPosition());
        }
        for(int i=0; i<2; i++) {
            position.add(new Laxio());
            position.add(new Radio());
            position.add(new FamilyCasinoNight());
            position.add(new AgoraMeEkptwsh());
        }
        for(int i=0; i<3; i++) {
            position.add(new Lotaria());
        }
        for(int i=0; i<6; i++) {
            position.add(new Agorastis());
        }
        Collections.shuffle(position);
        position.add(new PayDayPosition());

        for(int i=0; i<31; i++) {
            position.get(i).setNumOnBoard(i+1);
            position.get(i).initIJ(i+1);
            if((i+1)%7 == 0) {
                position.get(i).setDay("Sunday");
            }
            else if((i+1)%7 == 4) {
                position.get(i).setDay("Thursday");
            }
            else {
                position.get(i).setDay(" ");
            }
        }
    }
}


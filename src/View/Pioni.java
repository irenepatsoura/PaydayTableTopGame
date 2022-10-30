package View;

import Model.Position;

import javax.swing.*;
import java.awt.*;

public class Pioni {
    public JLabel Model;
//    public Position pos;
    public Point originPoint;


    public Pioni(String filepath) {
        ImageIcon pawn = new ImageIcon(filepath);
        Image image = pawn.getImage();
        Image newimg = image.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
        pawn = new ImageIcon(newimg);

        Model = new JLabel(pawn);
        Model.setSize(50,50);
        Model.setLocation(25,120);
    }


//    public void setloc(Position pos) {
//        originPoint = new Point(0,95);
//        Model.setLocation((100*pos.getJ())+originPoint.x,(100*pos.getI())+originPoint.y);
//    }


}

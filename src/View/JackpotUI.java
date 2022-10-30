package View;

import Model.Jackpot;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JackpotUI {
    private Image image;
    private  JLabel luckypos;
    private JButton b;
    private static JDialog JackpotWindow;
    private JFrame f = new JFrame();



    public void congrats() {
        JackpotWindow = new JDialog(f, "Winner of Jackpot", true);
        JackpotWindow.setLayout(new FlowLayout());
        b = new JButton("Παρέ τα χρήματα σου!");
        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JackpotUI.JackpotWindow.setVisible(false);
                f.dispose();
            }
        });
        ImageIcon lucky = new ImageIcon("./images/jackpot.png");
        image = lucky.getImage();
        Image newimg = image.getScaledInstance(100,100,Image.SCALE_SMOOTH);
        lucky = new ImageIcon(newimg);
        luckypos = new JLabel(lucky);
        luckypos.setSize(200,100);
        JackpotWindow.setLocationRelativeTo(null);
        JackpotWindow.add(luckypos);
        JackpotWindow.add(b);
        JackpotWindow.setSize(300,200);
        JackpotWindow.setVisible(true);

    }
}

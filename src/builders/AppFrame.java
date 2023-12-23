package builders;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class AppFrame extends JFrame{

    public AppFrame(){
        this.setTitle("AlgoVisualizer");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.setSize(1200, 700);
        this.setLayout(null);


        this.requestFocusInWindow();
        this.repaint();
        this.setVisible(true);


    }



}

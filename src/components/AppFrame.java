//package components;
//
//import components.sliders.BarSlider;
//import components.sliders.SpeedSlider;
//import java.awt.*;
//import javax.swing.*;
//
///**
// * This class is responsible for building the frame of the application.
// */
//public class AppFrame extends JFrame{
//
//    BarPanel barPanel;
//
//    JPanel topPanel;
//    JPanel middlePanel;
//    JPanel bottomPanel;
//
//    final int MIN_AMOUNT_BARS = 1;
//    final int MAX_AMOUNT_BARS = 100;
//
//    final int MIN_SORTING_SPEED = 1;
//    final int MAX_SORTING_SPEED = 100;
//
//    public AppFrame(){
//        this.setTitle("Sorting Algorithms Visualizer");
//        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        this.setSize(1200, 700);
//        this.getContentPane().setBackground(Color.BLACK);
//        this.setLayout(new GridLayout(3, 1));
//        this.requestFocusInWindow();
//        this.repaint();
//        this.setVisible(true);
//
//        topPanel = new JPanel();
//        topPanel.setLayout(new FlowLayout(FlowLayout.LEADING));
//        topPanel.setBackground(Color.BLACK);
//
//        middlePanel = new JPanel();
//        middlePanel.setLayout(new FlowLayout(FlowLayout.LEADING));
//        middlePanel.setBackground(Color.BLACK);
//
//        bottomPanel = new JPanel();
//        bottomPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
//        bottomPanel.setBackground(Color.BLACK);
//
//        setUpBars();
//        setUpSliders();
//        setUpAlgoOptionsBtn();
//    }
//
//    private void setUpBars(){
//        this.barPanel = new BarPanel();
//        this.barPanel.setBounds(0, 0, 800, 300);
//        this.barPanel.setNumberOfBars((MAX_AMOUNT_BARS + MIN_AMOUNT_BARS)/2);
//        this.barPanel.setSpeed((MAX_SORTING_SPEED + MIN_SORTING_SPEED)/2);
//        barPanel.setBackground(Color.BLACK);
//        bottomPanel.add(barPanel);
//    }
//
//    private void setUpSliders(){
//        JPanel barAmountPanel = new JPanel();
//        barAmountPanel.setLayout(new GridLayout(2, 1));
//
//        JLabel barAmountLabel = new JLabel("Bars: " + (MAX_AMOUNT_BARS+MIN_AMOUNT_BARS)/2);
//        barAmountLabel.setForeground(Color.WHITE);
//        BarSlider barSlider = new BarSlider(barPanel, barAmountLabel, MIN_AMOUNT_BARS, MAX_AMOUNT_BARS);
//
//        barAmountPanel.add(barSlider);
//        barAmountPanel.add(barAmountLabel);
//        barAmountPanel.setBackground(Color.BLACK);
//
//        topPanel.add(barAmountPanel);
//
//
//        JPanel speedPanel = new JPanel(new GridLayout(2, 1));
//
//        JLabel speedLabel = new JLabel("Speed: " + (MAX_SORTING_SPEED + MIN_SORTING_SPEED)/2);
//        speedLabel.setForeground(Color.WHITE);
//        SpeedSlider speedSlider = new SpeedSlider(barPanel, speedLabel, MIN_SORTING_SPEED, MAX_SORTING_SPEED);
//
//        speedPanel.add(speedSlider);
//        speedPanel.add(speedLabel);
//        speedPanel.setBackground(Color.BLACK);
//
//        topPanel.add(speedPanel);
//
//        this.add(topPanel);
//    }
//
//    private void setUpAlgoOptionsBtn(){
//        new AlgoOptionsBtn(middlePanel, this.barPanel);
//        this.add(middlePanel);
//        this.add(bottomPanel);
//    }
//}

package components;

import components.sliders.BarSlider;
import components.sliders.SpeedSlider;

import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import javax.swing.*;
import java.awt.*;

/**
 * This class is responsible for building the frame of the application.
 */
public class AppFrame extends JFrame {

    BarPanel barPanel;

    JPanel topPanel;
    JPanel middlePanel;
    JPanel bottomPanel;

    final int MIN_AMOUNT_BARS = 1;
    final int MAX_AMOUNT_BARS = 100;

    final int MIN_SORTING_SPEED = 1;
    final int MAX_SORTING_SPEED = 100;

    public AppFrame() {
        this.setTitle("Sorting Algorithms Visualizer");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1200, 700);
        this.getContentPane().setBackground(Color.BLACK);
        this.setLayout(new BorderLayout());

        topPanel = new JPanel();
        topPanel.setLayout(new FlowLayout());
        topPanel.setBackground(Color.BLACK);

        middlePanel = new JPanel();
        middlePanel.setLayout(new FlowLayout());
        middlePanel.setBackground(Color.BLACK);

        bottomPanel = new JPanel();
        bottomPanel.setLayout(new FlowLayout());
        bottomPanel.setBackground(Color.BLACK);

        setUpBars();
        setUpSliders();
        setUpAlgoOptionsBtn();

        this.setVisible(true);
    }

    private void setUpBars() {
        barPanel = new BarPanel();
        barPanel.setNumberOfBars((MAX_AMOUNT_BARS + MIN_AMOUNT_BARS) / 2);
        barPanel.setSpeed((MAX_SORTING_SPEED + MIN_SORTING_SPEED) / 2);
        barPanel.setBackground(Color.BLACK);
        bottomPanel.add(barPanel, BorderLayout.CENTER);
    }

    private void setUpSliders() {
        JLabel barAmountLabel = new JLabel("Bars: " + (MAX_AMOUNT_BARS + MIN_AMOUNT_BARS) / 2);
        barAmountLabel.setForeground(Color.WHITE);
        BarSlider barSlider = new BarSlider(barPanel, barAmountLabel, MIN_AMOUNT_BARS, MAX_AMOUNT_BARS);

        topPanel.add(barSlider);
        topPanel.add(barAmountLabel);

        JLabel speedLabel = new JLabel("Speed: " + (MAX_SORTING_SPEED + MIN_SORTING_SPEED) / 2);
        speedLabel.setForeground(Color.WHITE);
        SpeedSlider speedSlider = new SpeedSlider(barPanel, speedLabel, MIN_SORTING_SPEED, MAX_SORTING_SPEED);

        topPanel.add(speedSlider);
        topPanel.add(speedLabel);

        this.add(topPanel, BorderLayout.NORTH);
    }

    private void setUpAlgoOptionsBtn() {
        new AlgoOptionsBtn(middlePanel, this.barPanel);
        this.add(middlePanel, BorderLayout.CENTER);
        this.add(bottomPanel, BorderLayout.SOUTH);
    }
}


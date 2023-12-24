package components;

import components.sliders.BarSlider;
import components.sliders.SpeedSlider;
import javax.swing.*;

/**
 * This class is responsible for building the frame of the application.
 */
public class AppFrame extends JFrame{

    BarPanel barPanel;

    final int MIN_AMOUNT_BARS = 1;
    final int MAX_AMOUNT_BARS = 100;

    final int MIN_SORTING_SPEED = 1;
    final int MAX_SORTING_SPEED = 100;

    public AppFrame(){
        this.setTitle("Sorting Algorithms Visualizer");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1200, 700);
        this.setLayout(null);
        this.requestFocusInWindow();
        this.repaint();
        this.setVisible(true);

        setUpBars();
        setUpBarSlider();
        setUpSpeedSlider();
        setUpAlgoOptionsBtn();
    }

    private void setUpBars(){
        this.barPanel = new BarPanel();
        this.barPanel.setBounds(0, 200, 800, 300);
        this.barPanel.setNumberOfBars(50);
        this.add(this.barPanel);
    }

    private void setUpBarSlider(){
        JPanel panel = new JPanel();
        panel.setBounds(0, 0, 200, 200);

        JLabel label = new JLabel("Bars: " + (MAX_AMOUNT_BARS+MIN_AMOUNT_BARS)/2);
        BarSlider barSlider = new BarSlider(barPanel, label, MIN_AMOUNT_BARS, MAX_AMOUNT_BARS);

        panel.add(barSlider);
        panel.add(label);
        this.add(panel);
    }

    private void setUpSpeedSlider(){
        JPanel panel = new JPanel();
        panel.setBounds(200, 0, 200, 200);

        JLabel label = new JLabel("Speed: " + (MAX_SORTING_SPEED + MIN_SORTING_SPEED)/2);
        SpeedSlider speedSlider = new SpeedSlider(barPanel, label, MIN_SORTING_SPEED, MAX_SORTING_SPEED);

        panel.add(speedSlider);
        panel.add(label);
        this.add(panel);
    }

    private void setUpAlgoOptionsBtn(){
        new AlgoOptionsBtn(this, this.barPanel);
    }
}

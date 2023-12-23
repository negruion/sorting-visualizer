package builders;

import java.awt.*;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * This class is responsible for creating the slider that allows the user to choose the number of bars
 * that will be sorted.
 */
public class AppSlider implements ChangeListener {

    JFrame appFrame;
    JLabel label;
    JSlider slider;
    BarPanel barPanel;

    public AppSlider(JFrame appFrame){
        this.appFrame = appFrame;

        JPanel panel = new JPanel();
        panel.setBounds(0, 0, 400, 200);

        slider = new JSlider(10, 100, 50);
        slider.setPreferredSize(new Dimension(400, 200));
        slider.setPaintTicks(true);
        slider.setMajorTickSpacing(25);
        slider.setPaintLabels(true);
        slider.addChangeListener(this);

        barPanel = new BarPanel();
        barPanel.setBounds(0, 200, 800, 300);
        barPanel.setNumberOfBars(slider.getValue());

        AlgoBtn algoChoosing = new AlgoBtn(appFrame, barPanel);

        label = new JLabel("Choose the number of bars: " + slider.getValue());

        panel.add(label);
        panel.add(slider);
        appFrame.add(panel);
        appFrame.add(barPanel);
    }

    /**
     * This method is called whenever the slider is moved.
     * @param e  a ChangeEvent object
     */
    @Override
    public void stateChanged(ChangeEvent e){
        label.setText("Choose the number of bars: " + slider.getValue());
        int sliderValue = slider.getValue();

        barPanel.setNumberOfBars(sliderValue);

        barPanel.repaint();
    }

}

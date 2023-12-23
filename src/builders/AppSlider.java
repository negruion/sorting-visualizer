package builders;

import java.awt.*;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

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

        AlgoChoosingBtn algoChoosing = new AlgoChoosingBtn(appFrame, barPanel);

        label = new JLabel("Choose the number of bars: " + slider.getValue());

        panel.add(label);
        panel.add(slider);
        appFrame.add(panel);
        appFrame.add(barPanel);
    }

    @Override
    public void stateChanged(ChangeEvent e){
        label.setText("Choose the number of bars: " + slider.getValue());
        int sliderValue = slider.getValue();

        // Update the number of bars in the panel
        barPanel.setNumberOfBars(sliderValue);

        // Repaint the panel to reflect the changes
        barPanel.repaint();
    }

}

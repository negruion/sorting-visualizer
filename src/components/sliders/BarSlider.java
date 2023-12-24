package components.sliders;

import components.BarPanel;
import java.awt.*;
import javax.swing.*;

/**
 * This class is responsible for creating the slider that allows the user to choose the number of bars
 * that will be sorted.
 */
public class BarSlider extends SliderTemplate {
    public BarSlider(BarPanel barPanel, JLabel label, int min, int max) {
        super(min, max, (max + min) / 2);
        setPreferredSize(new Dimension(200, 50));
        setUI(new CustomSliderUI(this));

        addChangeListener(e -> {
            int val = getValue();
            barPanel.setNumberOfBars(val);
            label.setText("Bars: " + val);
            barPanel.repaint();
        });
    }
}


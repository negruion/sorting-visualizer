package components.sliders;

import java.awt.*;
import javax.swing.*;
import javax.swing.plaf.basic.BasicSliderUI;

/**
 * This class is responsible for creating the custom template for the app sliders.
 */
public class SliderTemplate extends JSlider {

    public SliderTemplate(int min, int max, int middle){
        super(min, max, middle);
    }

    public static class CustomSliderUI extends BasicSliderUI {
        public CustomSliderUI(JSlider slider) {
            super(slider);
        }

        @Override
        public void paintThumb(Graphics g) {
            Graphics2D g2d = (Graphics2D) g.create();
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

            Rectangle knobBounds = thumbRect;

            // Draw circle thumb
            g2d.setColor(Color.BLACK);
            g2d.fillOval(knobBounds.x, knobBounds.y, knobBounds.width, knobBounds.height);

            g2d.dispose();
        }

        @Override
        public void paintTrack(Graphics g) {
            Graphics2D g2d = (Graphics2D) g.create();
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

            Rectangle trackBounds = trackRect;

            int trackHeight = 3;
            int centerY = trackBounds.y + (trackBounds.height - trackHeight) / 2;

            g2d.setColor(Color.BLACK);
            g2d.fillRect(trackBounds.x, centerY, trackBounds.width, trackHeight);

            g2d.dispose();
        }

        @Override
        protected Dimension getThumbSize() {
            return new Dimension(16, 16);
        }

        @Override
        public void paintFocus(Graphics g) {
            // Remove the dashed border around the slider
        }
    }
}

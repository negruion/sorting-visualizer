package builders;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.swing.*;

/**
 * This class is responsible for generating the bars.
 */
public class BarPanel extends JPanel {

    private List<Rectangle> bars;

    public BarPanel(){
        this.bars = new ArrayList<>();
    }

    /**
     * Sets the number of bars.
     * @param numberOfBars the number of bars to set
     */
    public void setNumberOfBars(int numberOfBars) {
        generateRandomBars(numberOfBars);
    }

    /**
     * Generates random bars.
     * @param numberOfBars the number of bars to generate
     */
    private void generateRandomBars(int numberOfBars) {
        bars.clear();
        Random random = new Random();

        int totalSpacing = (numberOfBars - 1) * 5;
        int barWidth = (getWidth() - totalSpacing) / numberOfBars;

        for (int i = 0; i < numberOfBars; i++) {
            int x = i * (barWidth + 5); // Add 5 pixels of spacing
            int y = getHeight() - 1 - random.nextInt(300);

            Rectangle bar = new Rectangle(x, y, barWidth, getHeight() - y);
            bars.add(bar);
        }
    }

    /**
     * Paints the bars.
     * @param g the <code>Graphics</code> object to protect
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        for (Rectangle bar : bars) {
            g2d.setColor(Color.BLUE);
            g2d.fillRect(bar.x, bar.y, bar.width, bar.height);
        }
    }

    /**
     * Returns the list of bars.
     * @return the list of bars.
     */
    public List<Rectangle> getBars() {
        return bars;
    }
}
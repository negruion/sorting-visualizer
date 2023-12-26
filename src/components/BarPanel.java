package components;

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
    private int speed;

    // bars to be coloured
    int green=-1;
    int red=-1;

    public BarPanel(){
        this.setPreferredSize(new Dimension(1100,500));
        this.bars = new ArrayList<>();
    }

    /**
     * Sets the number of bars, and calls the method to generate them.
     * @param numberOfBars the number of bars to set
     */
    public void setNumberOfBars(int numberOfBars) {
        generateRandomBars(numberOfBars);
    }

    /**
     * Sets the speed.
     * @param speed the speed to set
     */
    public void setSpeed(int speed){
        this.speed = speed;
    }

    /**
     * Sets the green bar.
     * @param bar the bar to set
     */
    public void setGreenBar(int bar){
        green = bar;
    }

    /**
     * Sets the red bar.
     * @param bar the bar to set
     */
    public void setRedBar(int bar){
        red = bar;
    }

    /**
     * Resets the green and red bars.
     */
    public void barColourReset(){
        green = -1;
        red = -1;
        this.repaint();
    }

    /**
     * Returns the list of bars.
     * @return the list of bars.
     */
    public List<Rectangle> getBars() {
        return bars;
    }

    /**
     * Returns the speed.
     * @return the speed
     */
    public int getSpeed(){
        return this.speed;
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
            int x = i * (barWidth + 5); // Add 5 pixels of spacing in between bars
            int y = getHeight() - 1 - random.nextInt(500);

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

        for (int k = 0; k < bars.size(); k++) {
            Rectangle bar = bars.get(k);

            if (k == green) {  // Current bar (green)
                g2d.setColor(Color.GREEN);
            } else if (k == red) {  // Next bar (red)
                g2d.setColor(Color.RED);
            } else {
                g2d.setColor(Color.WHITE);
            }
            g2d.fillRect(bar.x, bar.y, bar.width, bar.height);
        }
    }
}
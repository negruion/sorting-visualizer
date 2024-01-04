package algorithms;

import components.BarPanel;
import java.awt.*;
import java.util.List;
import javax.swing.*;

/**
 * This class is responsible for sorting the bars using the insertion sort algorithm.
 */
public class InsertionSort {

    BarPanel barPanel;

    public InsertionSort(BarPanel barPanel) {
        this.barPanel = barPanel;
    }

    /**
     * Main method for sorting the bars.
     * @param speed the sorting speed
     */
    public void sort(int speed) {
        List<Rectangle> bars = barPanel.getBars();

        SwingWorker<Void, Void> worker = new SwingWorker<Void, Void>() {
            @Override
            protected Void doInBackground() throws Exception {
                for (int i = 1; i < bars.size(); i++) {
                    Rectangle key = bars.get(i);
                    int j = i - 1;

                    barPanel.setGreenBar(i);
                    barPanel.repaint();

                    try {
                        Thread.sleep(speed);
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }

                    while (j >= 0 && bars.get(j).getHeight() > key.getHeight()) {
                        Rectangle currentBar = bars.get(j);
                        Rectangle nextBar = bars.get(j + 1);

                        barPanel.setRedBar(j);
                        barPanel.repaint();

                        int x_1 = currentBar.x, y_1 = currentBar.y, x_2 = nextBar.x, y_2 = nextBar.y;
                        currentBar.setLocation(x_2, y_1);
                        nextBar.setLocation(x_1, y_2);

                        bars.set(j, nextBar);
                        bars.set(j + 1, currentBar);

                        j--;

                        SwingUtilities.invokeLater(() -> barPanel.repaint());

                        try {
                            Thread.sleep(speed);
                        } catch (InterruptedException ex) {
                            ex.printStackTrace();
                        }
                    }

                    bars.set(j + 1, key);
                }

                barPanel.barColourReset();
                barPanel.repaint();

                return null;
            }
        };

        worker.execute();
    }
}

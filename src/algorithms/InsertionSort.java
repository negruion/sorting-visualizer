package algorithms;

import builders.BarPanel;
import java.awt.*;
import java.util.List;
import javax.swing.*;

/**
 * This class is responsible for sorting the bars using the insertion sort algorithm.
 */
public class InsertionSort {

    BarPanel barPanel;

    public InsertionSort(BarPanel barPanel){
        this.barPanel = barPanel;
    }

    /**
     * Sorts the bars using the insertion sort algorithm.
     */
    public void sort() {
        List<Rectangle> bars = barPanel.getBars();

        Timer timer = new Timer(500, null);

        int[] i = { 1 };

        timer.addActionListener(e -> {
            if (i[0] < bars.size()) {
                Rectangle key = bars.get(i[0]);
                int j = i[0] - 1;

                while (j >= 0 && bars.get(j).getHeight() > key.getHeight()) {
                    Rectangle currentBar = bars.get(j);
                    Rectangle nextBar = bars.get(j + 1);

                    int x_1 = currentBar.x, y_1 = currentBar.y, x_2 = nextBar.x, y_2 = nextBar.y;
                    currentBar.setLocation(x_2, y_1);
                    nextBar.setLocation(x_1, y_2);

                    bars.set(j, nextBar);
                    bars.set(j + 1, currentBar);

                    j--;
                }

                bars.set(j + 1, key);
                i[0]++;

                barPanel.repaint();
            } else {
                timer.stop();
            }
        });

        timer.start();
    }

}

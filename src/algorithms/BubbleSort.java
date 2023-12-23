package algorithms;
import builders.BarPanel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.*;

public class BubbleSort {

    BarPanel barPanel;


    public BubbleSort(BarPanel barPanel){
        this.barPanel = barPanel;
    }

    public void sort() {
        List<Rectangle> bars = barPanel.getBars();
        boolean[] swapped = { false };

        Timer timer = new Timer(5, null);

        int[] i = { 0 };
        int[] j = { 0 };

        timer.addActionListener(e -> {
            swapped[0] = false;
            Rectangle currentBar = bars.get(j[0]);
            Rectangle nextBar = bars.get(j[0] + 1);

            if (currentBar.getHeight() > nextBar.getHeight()) {
                int x_1 = currentBar.x, y_1 = currentBar.y, x_2 = nextBar.x, y_2 = nextBar.y;
                currentBar.setLocation(x_2, y_1);
                nextBar.setLocation(x_1, y_2);

                bars.set(j[0], nextBar);
                bars.set(j[0] + 1, currentBar);
                swapped[0] = true;
            }

            barPanel.repaint();

            if (++j[0] >= bars.size() - i[0] - 1) {
                j[0] = 0;
                if (!swapped[0]) {
                    i[0]++;
                }
            }

            if (i[0] >= bars.size() - 1) {
                timer.stop();
            }
        });

        timer.start();
    }
}

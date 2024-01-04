package algorithms;

import components.BarPanel;
import java.awt.*;
import java.util.List;
import javax.swing.*;

public class SelectionSort {

    BarPanel barPanel;

    public SelectionSort(BarPanel barPanel) {
        this.barPanel = barPanel;
    }

    public void sort(int speed) {
        List<Rectangle> bars = barPanel.getBars();

        SwingWorker<Void, Void> worker = new SwingWorker<Void, Void>() {
            int i = 0;

            @Override
            protected Void doInBackground() throws Exception {
                while (i < bars.size() - 1) {
                    int min_idx = i;

                    for (int j = i + 1; j < bars.size(); j++){
                        barPanel.setRedBar(j);
                        barPanel.repaint();
                        try {
                            Thread.sleep(speed);
                        } catch (InterruptedException ex) {
                            ex.printStackTrace();
                        }
                        if (bars.get(j).getHeight() < bars.get(min_idx).getHeight()){
                            min_idx = j;
                            barPanel.setMinRedBar(min_idx);
                            barPanel.repaint();
                        }
                    }

                    swapLocation(bars.get(min_idx), bars.get(i));
                    Rectangle temp = bars.get(min_idx);
                    bars.set(min_idx, bars.get(i));
                    bars.set(i, temp);

                    barPanel.setGreenBar(i);
                    barPanel.repaint();
                    i++;

                    try {
                        Thread.sleep(speed);
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }
                }
                barPanel.barColourReset();
                barPanel.repaint();

                return null;
            }
        };

        worker.execute();
    }

    private void swapLocation(Rectangle bar1, Rectangle bar2) {
        int x_1 = bar1.x, y_1 = bar1.y, x_2 = bar2.x, y_2 = bar2.y;
        bar1.setLocation(x_2, y_1);
        bar2.setLocation(x_1, y_2);
    }
}

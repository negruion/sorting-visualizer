package algorithms;

import builders.BarPanel;
import java.awt.*;
import java.util.List;
import javax.swing.*;

public class SelectionSort {
    BarPanel barPanel;
    public SelectionSort(BarPanel barPanel){
        this.barPanel = barPanel;
    }

    public void sort() {
        List<Rectangle> bars = barPanel.getBars();

        Timer timer = new Timer(500, null);

        int[] i = { 0 };

        timer.addActionListener(e -> {
            if(i[0] < bars.size() - 1){
                int min_idx = i[0];

                for (int j = i[0] + 1; j < bars.size(); j++)
                    if (bars.get(j).getHeight() < bars.get(min_idx).getHeight())
                        min_idx = j;

                swapLocation(bars.get(min_idx), bars.get(i[0]));
                Rectangle temp = bars.get(min_idx);
                bars.set(min_idx, bars.get(i[0]));
                bars.set(i[0], temp);

                barPanel.repaint();
                i[0]++;
            }else{
                timer.stop();
                System.out.println("Selection Sort");
                for(Rectangle bar : bars){
                    System.out.println(bar.getHeight());
                }
            }
        });

        timer.start();
    }
    private void swapLocation(Rectangle bar1, Rectangle bar2){
        int x_1 = bar1.x, y_1 = bar1.y, x_2 = bar2.x, y_2 = bar2.y;
        bar1.setLocation(x_2, y_1);
        bar2.setLocation(x_1, y_2);
    }
}

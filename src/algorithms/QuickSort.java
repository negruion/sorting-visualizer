package algorithms;

import components.BarPanel;
import java.awt.*;
import java.util.List;
import javax.swing.*;

public class QuickSort {
    BarPanel barPanel;
    int speed;
    public QuickSort(BarPanel barPanel){
        this.barPanel = barPanel;
    }

    public void sort(int speed){
        this.speed = speed;
        List<Rectangle> bars = barPanel.getBars();
        doQuickSort(bars, 0,bars.size()-1);
        barPanel.repaint();
    }
    private void doQuickSort(List<Rectangle> bars, int low, int high)
    {
        Timer timer = new Timer(speed*10, null);

        int[] i = {low};
        int[] j = {high};

        timer.addActionListener(e -> {
            if (i[0] < j[0]) {
                int pi = partition(bars, i[0], j[0]);

                doQuickSort(bars, i[0], pi - 1);
                doQuickSort(bars, pi + 1, j[0]);

                barPanel.repaint();
            }
            timer.stop();
            barPanel.repaint();
        });
        timer.start();
    }

    private int partition(List<Rectangle> bars, int low, int high)
    {
        Rectangle pivot = bars.get(high);

        barPanel.setBlueBar(high);
        barPanel.repaint();

        int i = (low - 1);
        for(int j=low;j<=high-1;j++){
            if (bars.get(j).getHeight() < pivot.getHeight()) {

                i++;
                swapLocation(bars.get(i), bars.get(j));
                Rectangle temp = bars.get(i);
                bars.set(i, bars.get(j));
                bars.set(j, temp);
            }
        }
        swapLocation(bars.get(i+1), bars.get(high));
        Rectangle temp = bars.get(i+1);
        bars.set(i+1, bars.get(high));
        bars.set(high, temp);
        barPanel.repaint();

        return (i + 1);
    }

    private void swapLocation(Rectangle bar1, Rectangle bar2){
        int x_1 = bar1.x, y_1 = bar1.y, x_2 = bar2.x, y_2 = bar2.y;
        bar1.setLocation(x_2, y_1);
        bar2.setLocation(x_1, y_2);
    }
}

package algorithms;

import builders.BarPanel;
import java.awt.*;
import java.util.List;

public class QuickSort {
    BarPanel barPanel;
    public QuickSort(BarPanel barPanel){
        this.barPanel = barPanel;
    }

    public void sort(){
        List<Rectangle> bars = barPanel.getBars();
        doQuickSort(bars, 0,bars.size()-1);

        System.out.println("Quick Sort");
        for(Rectangle bar : bars){
            System.out.println(bar.getHeight());
        }
        barPanel.repaint();
    }
    public void doQuickSort(List<Rectangle> bars, int low, int high)
    {
        if (low < high) {
            int pi = partition(bars, low, high);

            doQuickSort(bars, low, pi - 1);
            doQuickSort(bars, pi + 1, high);
        }
    }

    private int partition(List<Rectangle> bars, int low, int high)
    {
        Rectangle pivot = bars.get(high);

        int i = (low - 1);

        for (int j = low; j <= high - 1; j++) {

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
        return (i + 1);
    }

    private void swapLocation(Rectangle bar1, Rectangle bar2){
        int x_1 = bar1.x, y_1 = bar1.y, x_2 = bar2.x, y_2 = bar2.y;
        bar1.setLocation(x_2, y_1);
        bar2.setLocation(x_1, y_2);
    }
}

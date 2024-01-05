//package algorithms;
//
//import components.BarPanel;
//import java.awt.*;
//import java.util.ArrayList;
//import java.util.List;
//import javax.swing.*;
//
//public class MergeSort {
//    private BarPanel barPanel;
//    private List<Step> steps;
//    private int currentStep;
//
//    public MergeSort(BarPanel barPanel) {
//        this.barPanel = barPanel;
//        this.steps = new ArrayList<>();
//        this.currentStep = 0;
//    }
//
//    public void sort(int speed) {
//        List<Rectangle> bars = barPanel.getBars();
//        Timer timer = new Timer(speed*10, null);
//
//        timer.addActionListener(e -> {
//            if (currentStep < steps.size()) {
//                Step step = steps.get(currentStep++);
//                merge(bars, step.getLeft(), step.getMiddle(), step.getRight());
//                barPanel.repaint();
//            } else {
//                timer.stop();
//                barPanel.repaint();
//            }
//        });
//
//        currentStep = 0;
//        steps.clear();
//        generateMergeSortSteps(bars, 0, bars.size() - 1);
//
//        timer.start();
//    }
//
//    private void generateMergeSortSteps(List<Rectangle> bars, int l, int r) {
//        if (l < r) {
//            int m = l + (r - l) / 2;
//            generateMergeSortSteps(bars, l, m);
//            generateMergeSortSteps(bars, m + 1, r);
//            steps.add(new Step(l, m, r));
//        }
//    }
//
//    private void merge(List<Rectangle> bars, int l, int m, int r) {
//        int n1 = m - l + 1;
//        int n2 = r - m;
//
//        // Create temp arrays
//        List<Rectangle> L = new ArrayList<>(n1);
//        List<Rectangle> R = new ArrayList<>(n2);
//
//        // Copy data to temp arrays
//        for (int i = 0; i < n1; i++)
//            L.add(new Rectangle(bars.get(l + i)));
//        for (int j = 0; j < n2; j++)
//            R.add(new Rectangle(bars.get(m + 1 + j)));
//
//        int i = 0, j = 0;
//        int k = l;
//
//        while (i < n1 && j < n2) {
//            if (L.get(i).getHeight() <= R.get(j).getHeight()) {
//                L.get(i).setLocation(bars.get(k).x, L.get(i).y);
//                bars.set(k, new Rectangle(L.get(i)));
//                i++;
//            } else {
//                R.get(j).setLocation(bars.get(k).x, R.get(j).y);
//                bars.set(k, new Rectangle(R.get(j)));
//                j++;
//            }
//            k++;
//        }
//
//        // Copy remaining elements of L[] if any
//        while (i < n1) {
//            L.get(i).setLocation(bars.get(k).x, L.get(i).y);
//            bars.set(k, new Rectangle(L.get(i)));
//            i++;
//            k++;
//        }
//
//        // Copy remaining elements of R[] if any
//        while (j < n2) {
//            R.get(j).setLocation(bars.get(k).x, R.get(j).y);
//            bars.set(k, new Rectangle(R.get(j)));
//            j++;
//            k++;
//        }
//    }
//
//    private static class Step {
//        private final int left;
//        private final int middle;
//        private final int right;
//
//        public Step(int left, int middle, int right) {
//            this.left = left;
//            this.middle = middle;
//            this.right = right;
//        }
//
//        public int getLeft() {
//            return left;
//        }
//
//        public int getMiddle() {
//            return middle;
//        }
//
//        public int getRight() {
//            return right;
//        }
//    }
//}

package algorithms;

import components.BarPanel;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;

public class MergeSort {

    private BarPanel barPanel;
    private List<Step> steps;
    private int currentStep;
    private int speed;

    public MergeSort(BarPanel barPanel) {
        this.barPanel = barPanel;
        this.steps = new ArrayList<>();
        this.currentStep = 0;
    }

    public void sort(int speed) {
        this.speed = speed;
        List<Rectangle> bars = barPanel.getBars();

        SwingWorker<Void, Void> worker = new SwingWorker<Void, Void>() {
            @Override
            protected Void doInBackground() throws Exception {
                currentStep = 0;
                steps.clear();
                generateMergeSortSteps(bars, 0, bars.size() - 1);
                for (Step step : steps) {
                    barPanel.setBlueBar(step.getMiddle());
                    barPanel.repaint();
                    merge(bars, step.getLeft(), step.getMiddle(), step.getRight());
                    SwingUtilities.invokeLater(() -> barPanel.repaint());
                    Thread.sleep(speed);
                }

                SwingUtilities.invokeLater(() -> {
                    barPanel.barColourReset(); // Reset color after sorting
                    barPanel.repaint();
                });
                return null;
            }
        };

        worker.execute();
    }

    private void generateMergeSortSteps(List<Rectangle> bars, int l, int r) {
        if (l < r) {
            int m = l + (r - l) / 2;
            generateMergeSortSteps(bars, l, m);
            generateMergeSortSteps(bars, m + 1, r);
            steps.add(new Step(l, m, r));
        }
    }

    private void merge(List<Rectangle> bars, int l, int m, int r) {
        int n1 = m - l + 1;
        int n2 = r - m;

        barPanel.setGreenBar(l);
        barPanel.setAddGreenBar(r);
        SwingUtilities.invokeLater(() -> barPanel.repaint());

        // Create temp arrays
        List<Rectangle> L = new ArrayList<>(n1);
        List<Rectangle> R = new ArrayList<>(n2);

        // Copy data to temp arrays
        for (int i = 0; i < n1; i++){
            L.add(new Rectangle(bars.get(l + i)));
            barPanel.setRedBar(l+i);
            SwingUtilities.invokeLater(() -> barPanel.repaint());
            try {
                Thread.sleep(speed);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        for (int j = 0; j < n2; j++) {
            R.add(new Rectangle(bars.get(m + 1 + j)));
            barPanel.setRedBar(m+1+j);
            SwingUtilities.invokeLater(() -> barPanel.repaint());
            try {
                Thread.sleep(speed);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        int i = 0, j = 0;
        int k = l;

        while (i < n1 && j < n2) {
            final int finalI = i;
            final int finalJ = j;

            try {
                Thread.sleep(speed);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }

            if (L.get(i).getHeight() <= R.get(j).getHeight()) {
                L.get(i).setLocation(bars.get(k).x, L.get(i).y);
                bars.set(k, new Rectangle(L.get(i)));
                i++;
            } else {
                R.get(j).setLocation(bars.get(k).x, R.get(j).y);
                bars.set(k, new Rectangle(R.get(j)));
                j++;
            }
            k++;
        }

        // Copy remaining elements of L[] if any
        while (i < n1) {
            L.get(i).setLocation(bars.get(k).x, L.get(i).y);
            bars.set(k, new Rectangle(L.get(i)));
            i++;
            k++;
        }

        // Copy remaining elements of R[] if any
        while (j < n2) {
            R.get(j).setLocation(bars.get(k).x, R.get(j).y);
            bars.set(k, new Rectangle(R.get(j)));
            j++;
            k++;
        }
    }

    private static class Step {
        private final int left;
        private final int middle;
        private final int right;

        public Step(int left, int middle, int right) {
            this.left = left;
            this.middle = middle;
            this.right = right;
        }

        public int getLeft() {
            return left;
        }

        public int getMiddle() {
            return middle;
        }

        public int getRight() {
            return right;
        }
    }
}

package components;

import algorithms.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 * This class is used to create the buttons for the algorithms.
 */
public class AlgoOptionsBtn implements ActionListener {

        // Initializing the buttons for the algorithms.
    JButton bubbleSortBtn;
    JButton mergeSortBtn;
    JButton insertionSortBtn;
    JButton selectionSortBtn;
    JButton quickSortBtn;
    JButton startBtn;

        // Initializing the algorithm name.
    String algo = "bubble"; // TODO: implement enum instead of string

            // Initializing the panel with the bars.
    BarPanel barPanel;

        // Initializing the algorithms.
    BubbleSort bubbleSort;
    MergeSort mergeSort;
    InsertionSort insertionSort;
    SelectionSort selectionSort;
    QuickSort quickSort;

    int speed;


    public AlgoOptionsBtn(JFrame appFrame, BarPanel barPanel){
        this.barPanel = barPanel;

        bubbleSortBtn = new JButton("Bubble Sort");
        bubbleSortBtn.setBounds(0, 600, 100, 30);
        bubbleSortBtn.setBackground(Color.RED);
        bubbleSortBtn.setFocusable(false);
        bubbleSortBtn.addActionListener(this);
        appFrame.add(bubbleSortBtn);

        mergeSortBtn = new JButton("Merge Sort");
        mergeSortBtn.setBounds(110, 600, 100, 30);
        mergeSortBtn.setBackground(Color.GRAY);
        mergeSortBtn.setFocusable(false);
        mergeSortBtn.addActionListener(this);
        appFrame.add(mergeSortBtn);

        insertionSortBtn = new JButton("Insertion Sort");
        insertionSortBtn.setBounds(220, 600, 100, 30);
        insertionSortBtn.setBackground(Color.GRAY);
        insertionSortBtn.setFocusable(false);
        insertionSortBtn.addActionListener(this);
        appFrame.add(insertionSortBtn);

        selectionSortBtn = new JButton("Selection Sort");
        selectionSortBtn.setBounds(330, 600, 100, 30);
        selectionSortBtn.setBackground(Color.GRAY);
        selectionSortBtn.setFocusable(false);
        selectionSortBtn.addActionListener(this);
        appFrame.add(selectionSortBtn);

        quickSortBtn = new JButton("Quick Sort");
        quickSortBtn.setBounds(440, 600, 100, 30);
        quickSortBtn.setBackground(Color.GRAY);
        quickSortBtn.setFocusable(false);
        quickSortBtn.addActionListener(this);
        appFrame.add(quickSortBtn);

        startBtn = new JButton("Start");
        startBtn.setBounds(550, 600, 100, 30);
        startBtn.setBackground(Color.GRAY);
        startBtn.setFocusable(false);
        startBtn.addActionListener(this);
        appFrame.add(startBtn);

        bubbleSort = new BubbleSort(barPanel);
        mergeSort = new MergeSort(barPanel);
        insertionSort = new InsertionSort(barPanel);
        selectionSort = new SelectionSort(barPanel);
        quickSort = new QuickSort(barPanel);
    }

    /**
     * Invoked when an action occurs.
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == bubbleSortBtn){
            setBtnGray();
            bubbleSortBtn.setBackground(Color.RED);
            algo = "bubble";
        }else if(e.getSource() == mergeSortBtn){
            setBtnGray();
            mergeSortBtn.setBackground(Color.RED);
            algo = "merge";
        }else if(e.getSource() == insertionSortBtn){
            setBtnGray();
            insertionSortBtn.setBackground(Color.RED);
            algo = "insertion";
        }else if(e.getSource() == selectionSortBtn){
            setBtnGray();
            selectionSortBtn.setBackground(Color.RED);
            algo = "selection";
        }else if(e.getSource() == quickSortBtn){
            setBtnGray();
            quickSortBtn.setBackground(Color.RED);
            algo = "quick";
        } else{
            speed = barPanel.getSpeed();
            switch (algo){
                case "bubble" -> bubbleSort.sort(speed);
                case "merge" -> mergeSort.sort(speed);
                case "insertion" -> insertionSort.sort(speed);
                case "selection" -> selectionSort.sort(speed);
                case "quick" -> quickSort.sort(speed);
            }
        }
    }

    /**
     * Set all buttons to gray.
     */
    private void setBtnGray(){
        bubbleSortBtn.setBackground(Color.GRAY);
        mergeSortBtn.setBackground(Color.GRAY);
        insertionSortBtn.setBackground(Color.GRAY);
        selectionSortBtn.setBackground(Color.GRAY);
        quickSortBtn.setBackground(Color.GRAY);
    }
}

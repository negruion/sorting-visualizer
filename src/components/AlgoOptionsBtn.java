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


    public AlgoOptionsBtn(JPanel topPanel, BarPanel barPanel){
        this.barPanel = barPanel;

        bubbleSortBtn = new JButton("Bubble Sort");
        bubbleSortBtn.setBounds(0, 600, 100, 30);
        bubbleSortBtn.setBackground(Color.GRAY);
        bubbleSortBtn.setForeground(Color.WHITE);
        bubbleSortBtn.setFocusable(false);
        bubbleSortBtn.addActionListener(this);
        topPanel.add(bubbleSortBtn);

        mergeSortBtn = new JButton("Merge Sort");
        mergeSortBtn.setBounds(110, 600, 100, 30);
        mergeSortBtn.setBackground(Color.WHITE);
        mergeSortBtn.setForeground(Color.BLACK);
        mergeSortBtn.setFocusable(false);
        mergeSortBtn.addActionListener(this);
        topPanel.add(mergeSortBtn);

        insertionSortBtn = new JButton("Insertion Sort");
        insertionSortBtn.setBounds(220, 600, 100, 30);
        insertionSortBtn.setBackground(Color.WHITE);
        insertionSortBtn.setForeground(Color.BLACK);
        insertionSortBtn.setFocusable(false);
        insertionSortBtn.addActionListener(this);
        topPanel.add(insertionSortBtn);

        selectionSortBtn = new JButton("Selection Sort");
        selectionSortBtn.setBounds(330, 600, 100, 30);
        selectionSortBtn.setBackground(Color.WHITE);
        selectionSortBtn.setForeground(Color.BLACK);
        selectionSortBtn.setFocusable(false);
        selectionSortBtn.addActionListener(this);
        topPanel.add(selectionSortBtn);

        quickSortBtn = new JButton("Quick Sort");
        quickSortBtn.setBounds(440, 600, 100, 30);
        quickSortBtn.setBackground(Color.WHITE);
        quickSortBtn.setForeground(Color.BLACK);
        quickSortBtn.setFocusable(false);
        quickSortBtn.addActionListener(this);
        topPanel.add(quickSortBtn);

        startBtn = new JButton("Start");
        startBtn.setBounds(550, 600, 100, 30);
        startBtn.setBackground(Color.WHITE);
        startBtn.setForeground(Color.BLACK);
        startBtn.setFocusable(false);
        startBtn.addActionListener(this);
        topPanel.add(startBtn);

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
            resetButtonColour();
            bubbleSortBtn.setBackground(Color.GRAY);
            bubbleSortBtn.setForeground(Color.WHITE);
            algo = "bubble";
        }else if(e.getSource() == mergeSortBtn){
            resetButtonColour();
            mergeSortBtn.setBackground(Color.GRAY);
            mergeSortBtn.setForeground(Color.WHITE);
            algo = "merge";
        }else if(e.getSource() == insertionSortBtn){
            resetButtonColour();
            insertionSortBtn.setBackground(Color.GRAY);
            insertionSortBtn.setForeground(Color.WHITE);
            algo = "insertion";
        }else if(e.getSource() == selectionSortBtn){
            resetButtonColour();
            selectionSortBtn.setBackground(Color.GRAY);
            selectionSortBtn.setForeground(Color.WHITE);
            algo = "selection";
        }else if(e.getSource() == quickSortBtn){
            resetButtonColour();
            quickSortBtn.setBackground(Color.GRAY);
            quickSortBtn.setForeground(Color.WHITE);
            algo = "quick";
        } else{
            speed = barPanel.getSpeed();
            speed = (100*100)/(speed*speed) * 10;
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
    private void resetButtonColour(){
        bubbleSortBtn.setBackground(Color.WHITE);
        bubbleSortBtn.setForeground(Color.BLACK);

        mergeSortBtn.setBackground(Color.WHITE);
        mergeSortBtn.setForeground(Color.BLACK);

        insertionSortBtn.setBackground(Color.WHITE);
        insertionSortBtn.setForeground(Color.BLACK);

        selectionSortBtn.setBackground(Color.WHITE);
        selectionSortBtn.setForeground(Color.BLACK);

        quickSortBtn.setBackground(Color.WHITE);
        quickSortBtn.setForeground(Color.BLACK);
    }
}

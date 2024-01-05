package components;

import algorithms.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.*;

/**
 * This class is used to create the buttons for the algorithms.
 */
public class AlgorithmSelector implements ActionListener {

    BarPanel barPanel;
    JPanel topPanel;

    JButton bubbleSortBtn;
    JButton mergeSortBtn;
    JButton insertionSortBtn;
    JButton selectionSortBtn;
    JButton startBtn;

    BubbleSort bubbleSort;
    MergeSort mergeSort;
    InsertionSort insertionSort;
    SelectionSort selectionSort;

    private final List<JButton> algorithmButtons = new ArrayList<>();
    private final Map<JButton, Algorithms> buttonAlgorithmMap = new HashMap<>();

    enum Algorithms { BUBBLE, MERGE, INSERTION, SELECTION, QUICK }
    Algorithms algorithm;

    private int speed;
    private final int BUTTON_WIDTH = 100;
    private final int BUTTON_HEIGHT = 50;

    public AlgorithmSelector(JPanel topPanel, BarPanel barPanel){
        this.topPanel = topPanel;
        this.barPanel = barPanel;

        bubbleSortBtn = new JButton("Bubble Sort");
        setupButton(bubbleSortBtn, 0, 600);
        algorithmButtons.add(bubbleSortBtn);

        mergeSortBtn = new JButton("Merge Sort");
        setupButton(mergeSortBtn, 110, 600);
        algorithmButtons.add(mergeSortBtn);

        insertionSortBtn = new JButton("Insertion Sort");
        setupButton(insertionSortBtn, 220, 600);
        algorithmButtons.add(insertionSortBtn);

        selectionSortBtn = new JButton("Selection Sort");
        setupButton(selectionSortBtn, 330, 600);
        algorithmButtons.add(selectionSortBtn);

        startBtn = new JButton("Start");
        setupButton(startBtn, 550, 600);
        startBtn.setEnabled(false);

        buttonAlgorithmMap.put(bubbleSortBtn, Algorithms.BUBBLE);
        buttonAlgorithmMap.put(mergeSortBtn, Algorithms.MERGE);
        buttonAlgorithmMap.put(insertionSortBtn, Algorithms.INSERTION);
        buttonAlgorithmMap.put(selectionSortBtn, Algorithms.SELECTION);

        bubbleSort = new BubbleSort(barPanel);
        mergeSort = new MergeSort(barPanel);
        insertionSort = new InsertionSort(barPanel);
        selectionSort = new SelectionSort(barPanel);
    }

    /**
     * Invoked when an action occurs.
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent e){
        JButton clickedButton = (JButton) e.getSource();
        if(clickedButton == startBtn){
            speed = barPanel.getSpeed();
            speed = (100*100)/(speed*speed) * 10;
            switch (algorithm){
                case BUBBLE -> bubbleSort.sort(speed);
                case MERGE -> mergeSort.sort(speed);
                case INSERTION -> insertionSort.sort(speed);
                case SELECTION -> selectionSort.sort(speed);
            }
        }else{
            startBtn.setEnabled(true);
            resetButtonColour();
            clickedButton.setBackground(Color.GRAY);
            clickedButton.setForeground(Color.WHITE);
            algorithm = buttonAlgorithmMap.get(clickedButton);
        }
    }

    /**
     * Sets the button with specific styling.
     * @param button the button to be set
     * @param x the x coordinate
     * @param y the y coordinate
     */
    private void setupButton(JButton button, int x, int y){
        button.setBounds(x, y, BUTTON_WIDTH, BUTTON_HEIGHT);
        button.setBackground(Color.WHITE);
        button.setForeground(Color.BLACK);
        button.setFocusable(false);
        button.addActionListener(this);
        topPanel.add(button);
    }

    /**
     * Set all buttons to gray.
     */
    private void resetButtonColour(){
        for(JButton button : algorithmButtons){
            button.setBackground(Color.WHITE);
            button.setForeground(Color.BLACK);
        }
    }
}

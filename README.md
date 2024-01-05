# Sorting Visualizer

## Description

Sorting Visualizer is a Java Swing project designed to provide a visual representation of various sorting algorithms, including Bubble Sort, Merge Sort, Selection Sort, and Insertion Sort. The application uses bars to represent elements and allows users to observe the sorting process in real-time, enhancing their understanding of the algorithms.

## Features

- **Visualization of Sorting Algorithms:** Choose from Bubble Sort, Merge Sort, Selection Sort, and Insertion Sort to see the algorithms in action.
- **Adjustable Sorting Speed:** Control the speed of the sorting process with a user-friendly slider for dynamic visualization.
- **Customizable Number of Bars:** Use the slider to change the number of bars, providing flexibility in visualizing sorting algorithms with different data sizes.

## How to Use

1. **Clone the Repository:**
   - Clone the Sorting Visualizer repository to your local machine:

     ```bash
     git clone https://github.com/negruion/SortingVisualizer.git
     ```

2. **Go to the `src` Directory:**
   - Navigate to the `src` directory of the project:

     ```bash
     cd SortingVisualizer/src
     ```

3. **Compile the Java File:**
   - Compile the `SortingVisualizer.java` file using the Java compiler:

     ```bash
     javac SortingVisualizer.java
     ```

4. **Run the Application:**
   - Run the compiled Java program to start the Sorting Visualizer:

     ```bash
     java SortingVisualizer
     ```

## Project Structure

- `algorithms` package: Contains classes for implementing sorting algorithms (BubbleSort, MergeSort, SelectionSort, InsertionSort).
- `components` package: Includes the `BarPanel` class responsible for visualizing bars and managing the graphical interface.
- `SortingVisualizer.java`: Main class to run the Sorting Visualizer application.

## Dependencies

- Java Swing: Used for creating the graphical user interface.
- Java Standard Library: Utilized for general functionality and data manipulation.

import components.AppFrame;
import java.awt.*;

/**
 * The AlgoVisualizer Class is the entry point of the application.
 *
 * @author Ion Negru
 */
public class SortingAlgoVisualizer {

    /**
     * The main method is the entry point of the application. It creates an
     * instance of the AlgoVisualizer class and calls the start method.
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                SortingAlgoVisualizer algoVisualizer = new SortingAlgoVisualizer();
                algoVisualizer.start();
            }
        });
    }

    /**
     * Starts the application by creating an instance of the AppFrame class.
     */
    public void start() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                AppFrame appFrame = new AppFrame();
            }
        });
    }

}



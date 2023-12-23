import builders.AppFrame;
import builders.AppSlider;
import java.awt.*;

public class AlgoVisualizer {


    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                AlgoVisualizer algoVisualizer = new AlgoVisualizer();
                algoVisualizer.start();
            }
        });
    }

    public void start() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                AppFrame appFrame = new AppFrame();
                AppSlider appSlider = new AppSlider(appFrame);
            }
        });
    }

}



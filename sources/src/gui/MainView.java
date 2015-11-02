package gui;

import javax.swing.*;
import java.awt.*;

public class MainView extends JFrame {

    private static String title = "Virtual Camera";

    public MainView(){
        setTitle(title);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setSize(new Dimension(CameraView.SCEANE_HEIGHT, CameraView.SCEANE_HEIGHT));
    }
}

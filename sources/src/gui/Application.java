package gui;

import javax.swing.*;
import java.awt.*;

public class Application extends JFrame{

    public static void main(String[] args) {

        MainView view = new MainView();
        CameraView cameraView = new CameraView();
        cameraView.initScene();
        view.getContentPane().add(cameraView, BorderLayout.CENTER);
        view.setVisible(true);

        KeyListener keysListener = new KeyListener(cameraView);
        KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(keysListener);

    }

}

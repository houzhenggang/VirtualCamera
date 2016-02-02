package pl.edu.pw.ee.gui;

import pl.edu.pw.ee.engine.Engine;
import pl.edu.pw.ee.engine.setting.Settings;
import pl.edu.pw.ee.gui.input.MyKeyListener;

import javax.swing.*;
import java.awt.*;

public class Window extends JFrame {

    public Window(String title) {
        setTitle(title);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        ContentPanel contentPanel = new ContentPanel();
        getContentPane().add(contentPanel);
        pack();
        setResizable(false);
        setSize(Settings.DIMENSION);
        contentPanel.setSize(Settings.DIMENSION);
        Engine engine = new Engine();
        contentPanel.subscribeChangeNotifier(engine.getChangeNotifier());
        MyKeyListener myKeyListener = new MyKeyListener(engine);
        KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(myKeyListener);
        engine.projection();
    }

}

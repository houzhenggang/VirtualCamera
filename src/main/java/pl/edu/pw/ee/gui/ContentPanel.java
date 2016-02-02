package pl.edu.pw.ee.gui;

import pl.edu.pw.ee.engine.ChangeNotifier;
import pl.edu.pw.ee.engine.ScreenBuffer;

import javax.swing.*;
import java.awt.*;

public class ContentPanel extends JPanel {

    private ScreenBuffer screenBuffer;

    public ContentPanel() {
    }

    public void subscribeChangeNotifier(ChangeNotifier changeNotifier) {
        changeNotifier.subscribe(this::drawScene);
    }

    public void drawScene(ScreenBuffer screenBuffer) {
        this.screenBuffer = screenBuffer;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        if (screenBuffer != null) {
            g.drawImage(screenBuffer.getScreenBuffer(), 0, 0, (img, infoFlags, x, y, width, height) -> true);
        }
    }

}

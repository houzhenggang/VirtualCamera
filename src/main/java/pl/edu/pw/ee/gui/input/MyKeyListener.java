package pl.edu.pw.ee.gui.input;

import pl.edu.pw.ee.engine.CameraModifier;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.Map;

public class MyKeyListener implements KeyEventDispatcher {

    private Map<Character, KeyInputStrategy> keyInputStrategyMap;
    private CameraModifier cameraModifier;


    public MyKeyListener(CameraModifier cameraModifier) {
        keyInputStrategyMap = KeyInputStrategyProvider.createKeyInputStrategyMap(cameraModifier);
        this.cameraModifier = cameraModifier;
    }

    @Override
    public boolean dispatchKeyEvent(KeyEvent e) {
        KeyInputStrategy keyInputStrategy = keyInputStrategyMap.get(e.getKeyChar());
        if (keyInputStrategy != null) {
            keyInputStrategy.execute();
            cameraModifier.projection();
            return true;
        }
        return false;
    }
}

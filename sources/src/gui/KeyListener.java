package gui;

import java.awt.*;
import java.awt.event.KeyEvent;

public class KeyListener implements KeyEventDispatcher {

    private CameraView cameraView;
    private static final Double TRANSLATION_STEP = 0.75;
    private static final Double ROTATION_FI = 0.02;
    private static final Double ZOOM_STEP = 0.05;

    public KeyListener(CameraView cameraView){
        this.cameraView = cameraView;
    }

    @Override
    public boolean dispatchKeyEvent(KeyEvent e) {
        if (e.getKeyChar() == 'd') {
            cameraView.translateX(-TRANSLATION_STEP);
        } else if (e.getKeyChar() == 'a') {
            cameraView.translateX(TRANSLATION_STEP);
        } else if (e.getKeyChar() == '8') {
            cameraView.translateY(TRANSLATION_STEP);
        } else if (e.getKeyChar() == '2') {
            cameraView.translateY(-TRANSLATION_STEP);
        } else if (e.getKeyChar() == 'w') {
            cameraView.translateZ(-TRANSLATION_STEP);
        } else if (e.getKeyChar() == 's') {
            cameraView.translateZ(TRANSLATION_STEP);
        } else if (e.getKeyCode() == KeyEvent.VK_UP) {
            cameraView.rotateOX(-ROTATION_FI);
        } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            cameraView.rotateOX(ROTATION_FI);
        } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            cameraView.rotateOY(ROTATION_FI);
        } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            cameraView.rotateOY(-ROTATION_FI);
        } else if (e.getKeyChar() == 'e') {
            cameraView.rotateOZ(-ROTATION_FI);
        } else if (e.getKeyChar() == 'q') {
            cameraView.rotateOZ(ROTATION_FI);
        } else if (e.getKeyChar() == '+') {
            cameraView.zoom(ZOOM_STEP);
        } else if (e.getKeyChar() == '-') {
            cameraView.zoom(-ZOOM_STEP);
        } else if (e.getKeyChar() == 'r') {
            cameraView.initScene();
        } else if (e.getKeyChar() == 'c') {
            cameraView.changeMode();
        } else if (e.getKeyChar() == 'n') {
            cameraView.changeNetVisibility();
        }

        return false;
    }
}
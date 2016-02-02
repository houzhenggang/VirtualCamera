package pl.edu.pw.ee.gui.input;

import pl.edu.pw.ee.engine.CameraModifier;

import java.util.HashMap;
import java.util.Map;

public class KeyInputStrategyProvider {


    private KeyInputStrategyProvider() {

    }

    public static Map<Character, KeyInputStrategy> createKeyInputStrategyMap(CameraModifier cameraModifier) {
        Map<Character, KeyInputStrategy> keyInputStrategyMap = new HashMap<>();
        keyInputStrategyMap.put('1', cameraModifier::makeMetalSphere);
        keyInputStrategyMap.put('2', cameraModifier::makeMatSphere);
        keyInputStrategyMap.put('3', cameraModifier::makePlasticSphere);
        keyInputStrategyMap.put('4', cameraModifier::makeWoodSphere);
        return keyInputStrategyMap;
    }

}

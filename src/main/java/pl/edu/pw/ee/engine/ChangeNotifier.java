package pl.edu.pw.ee.engine;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;


public class ChangeNotifier {

    private List<Consumer<ScreenBuffer>> notifyFunctions = new ArrayList<>();

    public void subscribe(Consumer<ScreenBuffer> notifyFunction) {
        notifyFunctions.add(notifyFunction);
    }

    public void notifyThatChangeOccurs(ScreenBuffer screenBuffer) {
        notifyFunctions.forEach(notifyFunction -> notifyFunction.accept(screenBuffer));
    }
}

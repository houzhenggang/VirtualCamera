package pl.edu.pw.ee.engine;

import pl.edu.pw.ee.engine.geometry.ColoredPoint3D;
import pl.edu.pw.ee.engine.setting.Settings;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.List;

public class ScreenBuffer {

    private BufferedImage bufferedImage;
    private Graphics2D graphics;

    public ScreenBuffer(Dimension dimension) {
        bufferedImage = new BufferedImage(dimension.width, dimension.height, BufferedImage.TYPE_INT_RGB);
        graphics = (Graphics2D) bufferedImage.getGraphics();
        graphics.setColor(Settings.BACKGROUND_COLOR);
        graphics.fillRect(0, 0, dimension.width, dimension.height);
    }

    public void drawPoints(List<ColoredPoint3D> points) {
        points.forEach(point -> bufferedImage.setRGB((int)point.x, (int)point.y, (int)point.color.getRGB()));
    }

    public BufferedImage getScreenBuffer() {
        return bufferedImage;
    }

}

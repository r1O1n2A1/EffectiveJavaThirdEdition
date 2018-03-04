package creating.destroying.objects.flyweight;

import javafx.scene.effect.Light;
import javafx.scene.paint.Color;

/**
 * Concrete flyweigth object, add capabilities
 * for intrinsic data
 */
public class Line implements IShape {
    private Color color;

    public Line(Color c) {
        color = c;
    }

    @Override
    public Color getColor() {
        return color;
    }

}

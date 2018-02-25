package creating.destroying.objects.flyweight;

import javafx.scene.effect.Light.Point;
import javafx.scene.paint.Color;

/**
 * Flyweight interface
 *
 * Declares methods which flyweigth instances
 * can receive and use extrinsic data.
 */
public interface IShape {

    // operation(extrinsicData): void

    public Color getColor();

    public void draw(Point location);
}

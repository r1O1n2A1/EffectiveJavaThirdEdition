package creating.destroying.objects.flyweight;

import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.List;

/**
 * <b>Flyweight factory</b>
 * <p>
 * Responsible for the creation and management of the flyweights,
 * ensuring they are shared properly If the desired flyweight isn't
 * created yet it will create and return one. Otherwise, it will
 * return one from the current pool of flyweights
 */
public class LineFlyweightFactory {

    private static List<Line> pool = new ArrayList<Line>();

    public static Line getLine(Color c) {
        //check if we've already created a line with this color
        for (Line line : pool) {
            if (line.getColor().equals(c)) {
                return  line;
            }
        }
        // if not create one and save it to the the pool line
        Line line = new Line(c);
        pool.add(line);
        return line;
    }

}

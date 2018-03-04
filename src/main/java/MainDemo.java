import creating.destroying.objects.flyweight.Line;
import creating.destroying.objects.flyweight.LineFlyweightFactory;
import javafx.scene.paint.Color;
import org.apache.log4j.Logger;

public class MainDemo {
    private static final Logger logger = Logger.getLogger(MainDemo.class);
    private static final Color[] colors = {Color.ALICEBLUE, Color.AQUA, Color.BEIGE};

    public static void main(String[] args) {
       runFlyweightDesignPattern();
    }

    private static void runFlyweightDesignPattern() {
            /***** Flyweight Part *****/
        // concrete client - define factory
        for (int i = 0;  i < 20; i++) {
            Line line = LineFlyweightFactory.getLine(getRandomColor());
            line.draw(null);
        }
    }

    private static Color getRandomColor() {
        return colors[(int) (Math.random()*colors.length)];
    }
}

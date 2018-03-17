import creating.destroying.objects.builder.NutritionFacts;
import creating.destroying.objects.flyweight.Line;
import creating.destroying.objects.flyweight.LineFlyweightFactory;
import javafx.scene.paint.Color;
import org.apache.log4j.Logger;

public class MainDemo {
    private static final Logger logger = Logger.getLogger(MainDemo.class);
    private static final Color[] colors = {Color.ALICEBLUE, Color.AQUA, Color.BEIGE};

    public static void main(String[] args) {
        runFlyweightDesignPattern();
        buildNutritionFacts();
    }

    /**
     * Flyweight Part
     * concrete client - define factory
     */
    private static void runFlyweightDesignPattern() {
        for (int i = 0; i < 20; i++) {
            Line line = LineFlyweightFactory.getLine(getRandomColor());
            line.draw(null);
        }
    }

    private static Color getRandomColor() {
        return colors[(int) (Math.random() * colors.length)];
    }

    /**
     * Builder pattern
     * client side - construct object
     */
    private static void buildNutritionFacts() {
        NutritionFacts nutritionFacts = new NutritionFacts.Builder(12, 1)
                .calories(450)
                .fat(50)
                .sodium(12)
                .carbohydrate(5)
                .build();
        logger.info(nutritionFacts.toString());
    }
}

package creating.destroying.objects;

import creating.destroying.objects.builder.NutritionFacts;
import creating.destroying.objects.builder.hierarchies.AbstractPizza;
import creating.destroying.objects.builder.hierarchies.CalzonePizza;
import creating.destroying.objects.builder.hierarchies.TunaPizza;
import creating.destroying.objects.decorator.classic.*;
import creating.destroying.objects.decorator.lambda.PizzaDecoratorLambda;
import creating.destroying.objects.flyweight.Line;
import creating.destroying.objects.flyweight.LineFlyweightFactory;
import javafx.scene.paint.Color;
import org.apache.log4j.Logger;

public class MainDemo {
    private static final Logger logger = Logger.getLogger(MainDemo.class);
    private static final Color[] colors = {Color.ALICEBLUE, Color.AQUA, Color.BEIGE};

    public static void main(String[] args) {
//        runFlyweightDesignPattern();
        buildNutritionFacts();
        buildCalzonePizza();
        buildThonPizza();
//        decoratePizzaPreJdk8();
        decoratePizzaPostJdk8();
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

    private static void buildCalzonePizza() {
       CalzonePizza calzone = new CalzonePizza.Builder()
               .addIngredient(AbstractPizza.Ingredient.HAM)
               .addIngredient(AbstractPizza.Ingredient.MUSHROOM)
               .addIngredient(AbstractPizza.Ingredient.ONION)
               .isSauceInside()
               .build();
       logger.info(calzone);
    }

    private static void buildThonPizza() {
        TunaPizza thon = new TunaPizza.Builder()
                .addIngredient(AbstractPizza.Ingredient.MUSHROOM)
                .addIngredient(AbstractPizza.Ingredient.PEPPER)
                .addThon()
                .build();
        logger.info(thon);

    }

    /**
     * Decorator structural design pattern
     */
    private static void decoratePizzaPreJdk8() {
        IPizza pizza = new ProsciuttoPizza(new ChickenTikkaPizza(new BasicPizza()));
        logger.info(pizza.bakePizza());
    }

    private static void decoratePizzaPostJdk8() {
        logger.info(PizzaDecoratorLambda.bakePizza(
                new creating.destroying.objects.decorator.lambda.BasicPizza(),
                creating.destroying.objects.decorator.lambda.IPizza::withChickenTikka));
    }
}

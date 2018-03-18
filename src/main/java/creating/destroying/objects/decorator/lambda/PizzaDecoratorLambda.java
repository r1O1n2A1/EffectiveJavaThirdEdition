package creating.destroying.objects.decorator.lambda;

import java.util.function.Function;
import java.util.stream.Stream;

public class PizzaDecoratorLambda {
    private final Function<IPizza, IPizza> toppings;

    private PizzaDecoratorLambda(Function<IPizza, IPizza>... desiredToppings) {
        // chain of decoration to be applied
        this.toppings = Stream.of(desiredToppings)
                .reduce(Function.identity(), Function::andThen);
    }

    public static  String bakePizza(IPizza pizza, Function<IPizza, IPizza>... desiredToppings) {
        return  new PizzaDecoratorLambda(desiredToppings).bakePizza(pizza);
    }

    private String bakePizza(IPizza pizza) {
        return this.toppings.apply(pizza).bakePizza();
    }

}

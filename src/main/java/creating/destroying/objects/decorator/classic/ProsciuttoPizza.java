package creating.destroying.objects.decorator.classic;

public class ProsciuttoPizza extends PizzaDecorator {

    public ProsciuttoPizza(IPizza pizza) {
        super(pizza);
    }

    @Override
    public String bakePizza() {
        return super.bakePizza() + " with prosciutto topping";
    }
}

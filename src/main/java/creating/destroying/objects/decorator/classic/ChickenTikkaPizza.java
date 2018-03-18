package creating.destroying.objects.decorator.classic;

public class ChickenTikkaPizza extends PizzaDecorator {

    public ChickenTikkaPizza(IPizza pizza) {
        super(pizza);
    }

    @Override
    public String bakePizza() {
        return super.bakePizza() + " with chicken tooping";
    }
}

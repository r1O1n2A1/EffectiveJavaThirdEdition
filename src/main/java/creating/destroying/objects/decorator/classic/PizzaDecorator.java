package creating.destroying.objects.decorator.classic;

public abstract class PizzaDecorator implements IPizza {
    private final IPizza pizza;

    protected PizzaDecorator(IPizza pizza) {
        this.pizza = pizza;
    }

    @Override
    public String bakePizza() {
        return pizza.bakePizza();
    }
}

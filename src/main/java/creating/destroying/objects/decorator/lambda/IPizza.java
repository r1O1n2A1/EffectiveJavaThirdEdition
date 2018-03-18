package creating.destroying.objects.decorator.lambda;

public interface IPizza {
    String bakePizza();

    static IPizza withChickenTikka(IPizza pizza) {
        return new IPizza() {
            @Override
            public String bakePizza() {
                return pizza.bakePizza() + " with chicken";
            }
        };
    }

    static IPizza withProscuitto(IPizza pizza) {
        return () -> pizza.bakePizza() + " with proscuitto";
    }
}

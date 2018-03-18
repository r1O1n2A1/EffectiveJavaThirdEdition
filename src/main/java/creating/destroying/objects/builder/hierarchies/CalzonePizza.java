package creating.destroying.objects.builder.hierarchies;

public class CalzonePizza extends AbstractPizza {

    public final boolean sauceInside;

    public static class Builder extends AbstractPizza.Builder<Builder> {

        public boolean sauceInside = false;

        public Builder isSauceInside() {
            sauceInside = true;
            return this;
        }

        @Override
        public CalzonePizza build() {
            return new CalzonePizza(this);
        }

        @Override
        protected Builder self() {
            return this;
        }
    }

    CalzonePizza(Builder builder) {
        super(builder);
        sauceInside = builder.sauceInside;
    }

    @Override
    public String toString() {
        return "CalzonePizza{" +
                "sauceInside=" + sauceInside +
                ", ingredients=" + ingredients +
                '}';
    }
}

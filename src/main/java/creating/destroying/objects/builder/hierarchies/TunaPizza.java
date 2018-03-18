package creating.destroying.objects.builder.hierarchies;

public class TunaPizza extends AbstractPizza {
    public static boolean isTuna;

    public static class Builder extends AbstractPizza.Builder<Builder> {
        public static boolean isTuna = false;

        public Builder addThon() {
            isTuna = true;
            return this;
        }

        @Override
        public TunaPizza build() {
            return new TunaPizza(this);
        }


        @Override
        protected Builder self() {
            return this;
        }
    }


    private TunaPizza(Builder builder) {
        super(builder);
        isTuna = builder.isTuna;
    }

    @Override
    public String toString() {
        return "ThonPizza{" + "thon=" + isTuna + ", " +
                "ingredients=" + ingredients +
                '}';
    }
}

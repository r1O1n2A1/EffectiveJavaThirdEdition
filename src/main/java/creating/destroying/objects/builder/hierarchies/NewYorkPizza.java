package creating.destroying.objects.builder.hierarchies;

import java.util.Objects;

public class NewYorkPizza extends AbstractPizza {

    public enum Size {SMALL, MEDIUM, LARGE}

    private final Size size;

    public static class Builder extends AbstractPizza.Builder<Builder> {

        private final Size size;

        public Builder(Size size) {
            this.size = Objects.requireNonNull(size);
        }

        @Override
        public NewYorkPizza build() {
            return new NewYorkPizza(this);
        }

        @Override
        protected Builder self() {
            return this;
        }
    }

    NewYorkPizza(Builder builder) {
        super(builder);
        size = builder.size;
    }
}

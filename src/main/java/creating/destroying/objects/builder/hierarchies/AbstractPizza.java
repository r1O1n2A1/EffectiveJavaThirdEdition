package creating.destroying.objects.builder.hierarchies;

import java.util.EnumSet;
import java.util.Objects;
import java.util.Set;

/**
 * Abstract class have abstract builders,
 * concrete classes have concrete builders
 */
public abstract class AbstractPizza {

    public enum Ingredient{HAM, MUSHROOM, ONION, PEPPER, SAUSAGE}

    final Set<Ingredient> ingredients;

    /**
     * Builder is a generic Type with a recursive type parameter
     * This, with the self method allows chaining to work properly
     * without the need to cast.
     * Workaround for the fact that java lacks a self type is
     * known as the simulated self-type
     * @param <T>
     */
    abstract static class Builder<T extends Builder> {
        EnumSet<Ingredient> ingredients = EnumSet.noneOf(Ingredient.class);
        public T addIngredient(Ingredient ingredient) {
            ingredients.add(Objects.requireNonNull(ingredient));
            return self();
        }

        abstract AbstractPizza build();
        // subclasses must override this method to return "this"
        protected abstract T self();
    }

    AbstractPizza(Builder<?> builder) {
        ingredients = builder.ingredients;
    }

}

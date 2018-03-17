package creating.destroying.objects.builder.hierarchies;

import java.util.Set;

/**
 * Abstract class have abstract builders,
 * concrete classes have concrete builders
 */
public abstract class Pizza {

    public enum Ingredients{HAM, MUSHROOM, ONION, PEPPER, SAUSAGE};

    final Set<Ingredients> ingredients;



}

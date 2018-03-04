package creating.destroying.objects;

import creating.destroying.objects.flyweight.IShape;

/**
 * <b> Item1: Consider static factory method instead of constructors </b>
 * <p>
 * - unlike constructors, they have names
 * - unlike constructors, they are not required to create a new object
 * each time they re invoked (similar to the flyweight pattern) {@link IShape}
 * - unlike constructors, they can return any subtype of their return type
 * <p>
 *     The main limitation: the class without public or protected constructors
 * can not be subclassed
 *     Another limitation: They are hard to find for programmers
 * <p>
 *     common names: from, valueOf, of, getInstance, create, getType, newType ...
 */
public class StaticFactoryMethod {
    private String option1;
    private String option2;
    // add getters && setters

    private StaticFactoryMethod(String option1, String option2) {
        this.option1 = option1;
        this.option2 = option2;
    }


    public static StaticFactoryMethod getInstance(String option1, String option2) {
        return new StaticFactoryMethod(option1, option2);
    }


}

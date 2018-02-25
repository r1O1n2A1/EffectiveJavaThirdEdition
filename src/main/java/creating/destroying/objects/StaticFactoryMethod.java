package creating.destroying.objects;

import creating.destroying.objects.flyweight.IShape;

/**
 * <b> Item1: Consider static factory method instead of constructors </b>
 * <p>
 * - unlike constructors, they have names
 * - unlike constructors, they are not required to create a new object
 * each time they re invoked (similar to the flyweight pattern) {@link IShape}
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

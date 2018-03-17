package creating.destroying.objects.builder;

/**
 * Builder pattern
 * Class is immutable, client code easy to read and write
 */
public class NutritionFacts {

    private final int servingSize;
    private final int servings;
    private final int calories;
    private final int fat;
    private final int sodium;
    private final int carbohydrate;

    public static class Builder {
        // Required parameters
        private final int servingSize;
        private final int servings;

        // Optional parameters - initialized to default values
        private int calories    = 0;
        private int fat         = 0;
        private int sodium      = 0;
        private int carbohydrate= 0;

        public Builder(int servingSize, int servings) {
            this.servingSize = servingSize;
            this.servings    = servings;
        }

        public Builder calories(int val) {
            calories = val;
            return this;
        }
        public Builder fat(int val) {
            fat = val;
            return this;
        }
        public Builder sodium(int val) {
            sodium = val;
            return this;
        }
        public Builder carbohydrate(int val) {
            carbohydrate = val;
            return this;
        }

        public NutritionFacts build() {
            return new NutritionFacts(this);
        }
    }

    private NutritionFacts(Builder builder) {
        servingSize = builder.servingSize;
        servings    = builder.servings;
        calories    = builder.calories;
        fat         = builder.fat;
        sodium      = builder.sodium;
        carbohydrate= builder.carbohydrate;
    }

    @Override
    public String toString() {
        return "NutritionFacts{" +
                "servingSize=" + servingSize +
                ", servings=" + servings +
                ", calories=" + calories +
                ", fat=" + fat +
                ", sodium=" + sodium +
                ", carbohydrate=" + carbohydrate +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        NutritionFacts that = (NutritionFacts) o;

        if (servingSize != that.servingSize) return false;
        if (servings != that.servings) return false;
        if (calories != that.calories) return false;
        if (fat != that.fat) return false;
        if (sodium != that.sodium) return false;
        return carbohydrate == that.carbohydrate;
    }

    @Override
    public int hashCode() {
        int result = servingSize;
        result = 31 * result + servings;
        result = 31 * result + calories;
        result = 31 * result + fat;
        result = 31 * result + sodium;
        result = 31 * result + carbohydrate;
        return result;
    }
}

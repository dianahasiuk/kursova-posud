import java.util.Comparator;

public class DishComparators {
    public static Comparator<Dish> byName() {
        return Comparator.comparing(Dish::getName, String.CASE_INSENSITIVE_ORDER);
    }

    public static Comparator<Dish> byMaterial() {
        return Comparator.comparing(Dish::getMaterial, String.CASE_INSENSITIVE_ORDER);
    }

    public static Comparator<Dish> byPrice() {
        return Comparator.comparingDouble(Dish::getPrice);
    }

   
    public static Comparator<Dish> byNameThenMaterialThenPrice() {
        return Comparator.comparing(Dish::getName, String.CASE_INSENSITIVE_ORDER)
                .thenComparing(Dish::getMaterial, String.CASE_INSENSITIVE_ORDER)
                .thenComparingDouble(Dish::getPrice);
    }

    public static Comparator<Dish> byPriceThenNameThenMaterial() {
        return Comparator.comparingDouble(Dish::getPrice)
                .thenComparing(Dish::getName, String.CASE_INSENSITIVE_ORDER)
                .thenComparing(Dish::getMaterial, String.CASE_INSENSITIVE_ORDER);
    }

    public static Comparator<Dish> byMaterialThenNameThenPrice() {
        return Comparator.comparing(Dish::getMaterial, String.CASE_INSENSITIVE_ORDER)
                .thenComparing(Dish::getName, String.CASE_INSENSITIVE_ORDER)
                .thenComparingDouble(Dish::getPrice);
    }
}

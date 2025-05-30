import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Dish> allDishes = new ArrayList<>();

       
        allDishes.addAll(DishDataLoader.readDishesFromFile("input1.txt"));
        allDishes.addAll(DishDataLoader.readDishesFromFile("input2.txt"));
        allDishes.addAll(DishDataLoader.readDishesFromFile("input3.txt"));

        // Фільтрація за ціною
        List<Dish> cheap = new ArrayList<>();
        List<Dish> medium = new ArrayList<>();
        List<Dish> expensive = new ArrayList<>();

        for (Dish dish : allDishes) {
            if (dish.getPrice() <= 1.0) {
                cheap.add(dish);
            } else if (dish.getPrice() <= 10.0) {
                medium.add(dish);
            } else {
                expensive.add(dish);
            }
        }

        
        DishDataSaver.saveDishesToFile(cheap, "cheap.txt");
        DishDataSaver.saveDishesToFile(medium, "medium.txt");
        DishDataSaver.saveDishesToFile(expensive, "expensive.txt");

   
        javax.swing.SwingUtilities.invokeLater(() -> new DishSorterGUI(allDishes).setVisible(true));
    }
}

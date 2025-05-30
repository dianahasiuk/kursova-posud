import java.io.*;
import java.util.*;

public class DishDataLoader {
    public static List<Dish> readDishesFromFile(String filePath) {
        List<Dish> dishes = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(";");
                if (parts.length != 3) continue;

                try {
                    String name = parts[0].trim();
                    String material = parts[1].trim();
                    double price = Double.parseDouble(parts[2].trim());
                    dishes.add(new Dish(name, material, price));
                } catch (NumberFormatException ignored) {}
            }
        } catch (IOException e) {
            System.err.println("Помилка при читанні файлу: " + e.getMessage());
        }

        return dishes;
    }
}

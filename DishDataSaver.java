import java.io.*;
import java.util.List;

public class DishDataSaver {
    public static void saveDishesToFile(List<Dish> dishes, String filePath) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))) {
            for (Dish dish : dishes) {
                bw.write(String.format("%s;%s;%.2f", dish.getName(), dish.getMaterial(), dish.getPrice()));
                bw.newLine();
            }
        } catch (IOException e) {
            System.err.println("Помилка при записі у файл: " + e.getMessage());
        }
    }
}

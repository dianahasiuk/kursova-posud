import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class DishSorterGUI extends JFrame {
    private List<Dish> dishes;
    private JTable table;
    private DefaultTableModel tableModel;
    private JComboBox<String> sortCriteriaBox;

    public DishSorterGUI(List<Dish> dishes) {
        this.dishes = dishes;
        setTitle("Сортування посуду");
        setSize(600, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        tableModel = new DefaultTableModel(new Object[]{"Назва", "Матеріал", "Ціна"}, 0);
        table = new JTable(tableModel);
        loadTableData(dishes);

        sortCriteriaBox = new JComboBox<>(new String[]{
                "За назвою + матеріалом + ціною",
                "За ціною + назвою + матеріалом",
                "За матеріалом + назвою + ціною"
        });

        JButton sortButton = new JButton("Сортувати");
        sortButton.addActionListener(e -> sortAndDisplay());

        JPanel controlPanel = new JPanel();
        controlPanel.add(new JLabel("Сортувати:"));
        controlPanel.add(sortCriteriaBox);
        controlPanel.add(sortButton);

        add(new JScrollPane(table), BorderLayout.CENTER);
        add(controlPanel, BorderLayout.SOUTH);
    }

    private void loadTableData(List<Dish> dishes) {
        tableModel.setRowCount(0);
        for (Dish d : dishes) {
            tableModel.addRow(new Object[]{d.getName(), d.getMaterial(), d.getPrice()});
        }
    }

    private void sortAndDisplay() {
        String criteria = (String) sortCriteriaBox.getSelectedItem();
        if (criteria == null) return;

        switch (criteria) {
            case "За назвою + матеріалом + ціною" ->
                    dishes.sort(DishComparators.byNameThenMaterialThenPrice());
            case "За ціною + назвою + матеріалом" ->
                    dishes.sort(DishComparators.byPriceThenNameThenMaterial());
            case "За матеріалом + назвою + ціною" ->
                    dishes.sort(DishComparators.byMaterialThenNameThenPrice());
        }

        loadTableData(dishes);
    }
}

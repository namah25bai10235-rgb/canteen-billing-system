package src;

import java.io.*;
import java.util.ArrayList;

public class MenuManager {
    private ArrayList<MenuItem> menuItems;
    private final String filePath = "data/menu.csv";

    public MenuManager() {
        menuItems = new ArrayList<>();
        loadFromCsv();
    }

    public void addItem(MenuItem item) {
        menuItems.add(item);
        saveToCsv();
    }

    public void viewMenu() {
        if (menuItems.isEmpty()) {
            System.out.println("\nNo menu items available.");
            return;
        }

        System.out.println("\n========== MENU ==========");

        for (int i = 0; i < menuItems.size(); i++) {
            System.out.println((i + 1) + ". " + menuItems.get(i));
        }

        System.out.println("==========================");
    }

    public MenuItem getItem(int index) {
        if (index < 0 || index >= menuItems.size()) {
            return null;
        }

        return menuItems.get(index);
    }

    public int getItemCount() {
        return menuItems.size();
    }

    private void loadFromCsv() {
        File file = new File(filePath);

        if (!file.exists()) {
            return;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {

            String line;
            boolean firstLine = true;

            while ((line = reader.readLine()) != null) {

                if (firstLine) {
                    firstLine = false;
                    continue;
                }

                if (line.trim().isEmpty()) {
                    continue;
                }

                String[] parts = line.split(",");

                if (parts.length == 3) {
                    try {
                        String name = parts[0].trim();
                        double price = Double.parseDouble(parts[1].trim());
                        int quantity = Integer.parseInt(parts[2].trim());

                        if (!name.isEmpty() && price > 0 && quantity > 0) {
                            menuItems.add(
                                new MenuItem(name, price, quantity)
                            );
                        }

                    } catch (NumberFormatException e) {
                        System.out.println(
                            "Invalid record skipped: " + line
                        );
                    }
                }
            }

        } catch (IOException e) {
            System.out.println(
                "Error reading menu file: " + e.getMessage()
            );
        }
    }

    private void saveToCsv() {
        try {
            File file = new File(filePath);

            File parent = file.getParentFile();

            if (parent != null && !parent.exists()) {
                parent.mkdirs();
            }

            try (PrintWriter writer =
                     new PrintWriter(new FileWriter(file))) {

                writer.println("name,price,quantity");

                for (MenuItem item : menuItems) {
                    writer.println(
                        item.getName() + "," +
                        item.getPrice() + "," +
                        item.getQuantity()
                    );
                }
            }

        } catch (IOException e) {
            System.out.println(
                "Error saving menu file: " + e.getMessage()
            );
        }
    }
}
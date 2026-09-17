package src;

public class Main {

    public static void main(String[] args) {

        java.util.Scanner scanner = new java.util.Scanner(System.in);

        MenuManager menuManager = new MenuManager();
        OrderManager orderManager = new OrderManager();

        boolean running = true;

        while (running) {

            showMainMenu();

            int choice = InputValidator.readIntInRange(
                scanner,
                "\nEnter your choice: ",
                1,
                6
            );

            switch (choice) {

                case 1:
                    addMenuItem(scanner, menuManager);
                    break;

                case 2:
                    menuManager.viewMenu();
                    break;

                case 3:
                    createOrder(scanner, menuManager, orderManager);
                    break;

                case 4:
                    orderManager.viewCurrentOrder();
                    break;

                case 5:
                    BillCalculator.printBill(
                        orderManager.getOrderItems()
                    );
                    break;

                case 6:
                    running = false;
                    System.out.println(
                        "\nThank you for using Canteen Billing System."
                    );
                    break;
            }
        }

        scanner.close();
    }

    private static void showMainMenu() {

        System.out.println("\n====================================");
        System.out.println("       CANTEEN BILLING SYSTEM");
        System.out.println("====================================");
        System.out.println("1. Add Menu Item");
        System.out.println("2. View Menu");
        System.out.println("3. Create Order");
        System.out.println("4. View Current Order");
        System.out.println("5. Calculate Bill");
        System.out.println("6. Exit");
    }

    private static void addMenuItem(
            java.util.Scanner scanner,
            MenuManager menuManager) {

        System.out.println("\n----- ADD MENU ITEM -----");

        String name = InputValidator.readNonEmptyString(
            scanner,
            "Enter item name: "
        );

        double price = InputValidator.readPositiveDouble(
            scanner,
            "Enter price: "
        );

        int quantity = InputValidator.readPositiveInt(
            scanner,
            "Enter available quantity: "
        );

        MenuItem item = new MenuItem(name, price, quantity);

        menuManager.addItem(item);

        System.out.println("Menu item added successfully.");
    }

    private static void createOrder(
            java.util.Scanner scanner,
            MenuManager menuManager,
            OrderManager orderManager) {

        if (menuManager.getItemCount() == 0) {
            System.out.println("\nNo menu items available.");
            return;
        }

        orderManager.clearOrder();

        System.out.println("\n========== CREATE ORDER ==========");

        while (true) {

            menuManager.viewMenu();

            System.out.println("Enter 0 to finish the order.");

            int choice = InputValidator.readIntInRange(
                scanner,
                "Select item number: ",
                0,
                menuManager.getItemCount()
            );

            if (choice == 0) {
                break;
            }

            MenuItem selectedItem =
                menuManager.getItem(choice - 1);

            int alreadyOrdered =
                orderManager.getOrderedQuantity(selectedItem);

            int available =
                selectedItem.getQuantity() - alreadyOrdered;

            if (available <= 0) {
                System.out.println("This item is out of stock.");
                continue;
            }

            int quantity;

            while (true) {

                quantity = InputValidator.readPositiveInt(
                    scanner,
                    "Enter quantity: "
                );

                if (quantity <= available) {
                    break;
                }

                System.out.println(
                    "Only " + available + " available."
                );
            }

            boolean added =
                orderManager.addItem(selectedItem, quantity);

            if (added) {
                System.out.println("Item added to order.");
            }

            System.out.println();
        }

        if (orderManager.isEmpty()) {
            System.out.println("No items were added.");
        } else {
            System.out.println("Order created successfully.");
        }
    }
}
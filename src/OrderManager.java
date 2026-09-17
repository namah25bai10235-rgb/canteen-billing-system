package src;

import java.util.ArrayList;

public class OrderManager {
    private ArrayList<OrderItem> orderItems;

    public OrderManager() {
        orderItems = new ArrayList<>();
    }

    public boolean addItem(MenuItem menuItem, int quantity) {

        int existingQuantity = getOrderedQuantity(menuItem);

        if (existingQuantity + quantity > menuItem.getQuantity()) {
            System.out.println(
                "Not enough stock. Available: "
                + (menuItem.getQuantity() - existingQuantity)
            );
            return false;
        }

        for (OrderItem orderItem : orderItems) {

            if (orderItem.getMenuItem() == menuItem) {
                orderItem.setQuantity(
                    orderItem.getQuantity() + quantity
                );
                return true;
            }
        }

        orderItems.add(new OrderItem(menuItem, quantity));
        return true;
    }

    public int getOrderedQuantity(MenuItem menuItem) {

        for (OrderItem orderItem : orderItems) {

            if (orderItem.getMenuItem() == menuItem) {
                return orderItem.getQuantity();
            }
        }

        return 0;
    }

    public void viewCurrentOrder() {

        if (orderItems.isEmpty()) {
            System.out.println("\nCurrent order is empty.");
            return;
        }

        System.out.println("\n======= CURRENT ORDER =======");

        for (int i = 0; i < orderItems.size(); i++) {

            OrderItem item = orderItems.get(i);

            System.out.printf(
                "%d. %s x %d = Rs. %.2f%n",
                i + 1,
                item.getMenuItem().getName(),
                item.getQuantity(),
                item.getSubtotal()
            );
        }

        System.out.println("=============================");
    }

    public ArrayList<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void clearOrder() {
        orderItems.clear();
    }

    public boolean isEmpty() {
        return orderItems.isEmpty();
    }
}
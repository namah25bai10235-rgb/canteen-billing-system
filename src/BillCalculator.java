package src;

import java.util.ArrayList;

public class BillCalculator {

    public static double calculateTotal(ArrayList<OrderItem> orderItems) {

        double total = 0;

        for (OrderItem item : orderItems) {
            total += item.getSubtotal();
        }

        return total;
    }

    public static void printBill(ArrayList<OrderItem> orderItems) {

        if (orderItems.isEmpty()) {
            System.out.println("\nNo items in the order.");
            return;
        }

        System.out.println("\n========== FINAL BILL ==========");

        for (OrderItem item : orderItems) {

            System.out.printf(
                "%-20s %2d x Rs. %.2f = Rs. %.2f%n",
                item.getMenuItem().getName(),
                item.getQuantity(),
                item.getMenuItem().getPrice(),
                item.getSubtotal()
            );
        }

        double total = calculateTotal(orderItems);

        System.out.println("--------------------------------");
        System.out.printf("Total Bill: Rs. %.2f%n", total);
        System.out.println("================================");
    }
}
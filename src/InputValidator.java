package src;

import java.util.Scanner;

public class InputValidator {

    public static String readNonEmptyString(
            Scanner scanner, String prompt) {

        while (true) {

            System.out.print(prompt);
            String input = scanner.nextLine().trim();

            if (!input.isEmpty()) {
                return input;
            }

            System.out.println("Input cannot be empty.");
        }
    }

    public static double readPositiveDouble(
            Scanner scanner, String prompt) {

        while (true) {

            System.out.print(prompt);
            String input = scanner.nextLine().trim();

            try {
                double value = Double.parseDouble(input);

                if (value > 0) {
                    return value;
                }

                System.out.println("Value must be greater than 0.");

            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
            }
        }
    }

    public static int readPositiveInt(
            Scanner scanner, String prompt) {

        while (true) {

            System.out.print(prompt);
            String input = scanner.nextLine().trim();

            try {
                int value = Integer.parseInt(input);

                if (value > 0) {
                    return value;
                }

                System.out.println("Value must be greater than 0.");

            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid integer.");
            }
        }
    }

    public static int readIntInRange(
            Scanner scanner,
            String prompt,
            int min,
            int max) {

        while (true) {

            System.out.print(prompt);
            String input = scanner.nextLine().trim();

            try {
                int value = Integer.parseInt(input);

                if (value >= min && value <= max) {
                    return value;
                }

                System.out.println(
                    "Enter a number between " + min + " and " + max + "."
                );

            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid integer.");
            }
        }
    }
}
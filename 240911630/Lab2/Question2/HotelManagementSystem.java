package Question2;

import java.util.Scanner;

public class HotelManagementSystem{

    public enum RoomType {
        STANDARD(2500.0),
        DELUXE(4000.0),
        SUITE(6500.0);

        private final double baseTariffPerDay;

        RoomType(double baseTariffPerDay) {
            this.baseTariffPerDay = baseTariffPerDay;
        }

        public double getBaseTariff() {
            return baseTariffPerDay;
        }

        public double costForDays(int days) {
            if (days <= 0) {
                throw new IllegalArgumentException("Days must be > 0");
            }
            return baseTariffPerDay * days;
        }

        @Override
        public String toString() {
            String lower = name().toLowerCase();
            return Character.toUpperCase(lower.charAt(0)) + lower.substring(1);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Welcome to the Hotel Management System (Enum Demo)");
        System.out.println("Available room types:");
        for (RoomType rt : RoomType.values()) {
            System.out.printf("- %s (base tariff per day: %.2f)%n", rt, rt.getBaseTariff());
        }

        RoomType selectedType = null;
        while (selectedType == null) {
            System.out.print("Enter room type (STANDARD / DELUXE / SUITE): ");
            String input = sc.nextLine().trim();
            if (input.isEmpty()) {
                System.out.println("Please enter a room type.");
                continue;
            }
            String upper = input.toUpperCase();
            try {
                selectedType = RoomType.valueOf(upper);
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid room type. Try again (STANDARD / DELUXE / SUITE).");
            }
        }

        int days = 0;
        while (days <= 0) {
            System.out.print("Enter number of days stayed (> 0): ");
            if (sc.hasNextInt()) {
                days = sc.nextInt();
                sc.nextLine();
                if (days <= 0) {
                    System.out.println("Days must be greater than 0. Try again.");
                }
            } else {
                System.out.println("Please enter a whole number, e.g., 3.");
                sc.nextLine();
            }
        }

        double basePerDay = selectedType.getBaseTariff();
        double totalCost = selectedType.costForDays(days);

        System.out.println("\n--------- ROOM TARIFF SUMMARY ---------");
        System.out.printf("Room type: %s%n", selectedType);
        System.out.printf("Base tariff per day: %.2f%n", basePerDay);
        System.out.printf("Days stayed: %d%n", days);
        System.out.printf("TOTAL ROOM TARIFF: %.2f%n", totalCost);
        System.out.println("---------------------------------------");

        sc.close();
    }
}
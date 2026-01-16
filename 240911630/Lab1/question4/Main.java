package question4;

import java.util.Scanner;

abstract class Room {
    private int roomNumber;
    private double basePrice;

    public Room(int roomNumber, double basePrice) {
        this.roomNumber = roomNumber;
        this.basePrice = basePrice;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public double getBasePrice() {
        return basePrice;
    }

    public abstract double calculateTariff();

    public void displayRoomDetails() {
        System.out.println("Room " + roomNumber + " | Base Price: " + basePrice);
    }
}

interface Amenities {
    boolean provideWifi();
    boolean provideBreakfast();
}

class StandardRoom extends Room implements Amenities {
    private boolean airConditioned;
    private double acCharge;
    private boolean wifi;
    private boolean breakfast;

    public StandardRoom(int roomNumber, double basePrice, boolean airConditioned, double acCharge, boolean wifi, boolean breakfast) {
        super(roomNumber, basePrice);
        this.airConditioned = airConditioned;
        this.acCharge = acCharge;
        this.wifi = wifi;
        this.breakfast = breakfast;
    }

    @Override
    public double calculateTariff() {
        double tariff = getBasePrice();
        if (airConditioned) tariff += acCharge;
        return tariff;
    }

    @Override
    public boolean provideWifi() {
        return wifi;
    }

    @Override
    public boolean provideBreakfast() {
        return breakfast;
    }

    @Override
    public String toString() {
        return "Standard Room " + getRoomNumber() + " | Base: " + getBasePrice() +
               " | AC: " + (airConditioned ? "Yes" : "No") +
               " | Wifi: " + (wifi ? "Yes" : "No") +
               " | Breakfast: " + (breakfast ? "Yes" : "No") +
               " | Tariff: " + calculateTariff();
    }
}

class LuxuryRoom extends Room implements Amenities {
    private int amenitiesCount;
    private double perAmenityCharge;
    private double premiumServiceCharge;
    private boolean wifi;
    private boolean breakfast;

    public LuxuryRoom(int roomNumber, double basePrice, int amenitiesCount, double perAmenityCharge, double premiumServiceCharge, boolean wifi, boolean breakfast) {
        super(roomNumber, basePrice);
        this.amenitiesCount = amenitiesCount;
        this.perAmenityCharge = perAmenityCharge;
        this.premiumServiceCharge = premiumServiceCharge;
        this.wifi = wifi;
        this.breakfast = breakfast;
    }

    @Override
    public double calculateTariff() {
        return getBasePrice() + amenitiesCount * perAmenityCharge + premiumServiceCharge;
    }

    @Override
    public boolean provideWifi() {
        return wifi;
    }

    @Override
    public boolean provideBreakfast() {
        return breakfast;
    }

    @Override
    public String toString() {
        return "Luxury Room " + getRoomNumber() + " | Base: " + getBasePrice() +
               " | Amenities: " + amenitiesCount +
               " | Wifi: " + (wifi ? "Yes" : "No") +
               " | Breakfast: " + (breakfast ? "Yes" : "No") +
               " | Tariff: " + calculateTariff();
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Room r;

        r = new StandardRoom(101, 1500.0, true, 200.0, true, false);
        r.displayRoomDetails();
        System.out.println(r.toString());
        System.out.println("Calculated tariff via Room reference: " + r.calculateTariff());
        System.out.println();

        r = new LuxuryRoom(201, 3000.0, 3, 250.0, 500.0, true, true);
        r.displayRoomDetails();
        System.out.println(r.toString());
        System.out.println("Calculated tariff via Room reference: " + r.calculateTariff());
        System.out.println();

        System.out.print("Create (s)tandard or (l)uxury room now? (s/l): ");
        String choice = sc.nextLine().trim().toLowerCase();
        if (choice.equals("s")) {
            System.out.print("Room number: ");
            int rn = Integer.parseInt(sc.nextLine().trim());
            System.out.print("Base price: ");
            double bp = Double.parseDouble(sc.nextLine().trim());
            System.out.print("AC? (yes/no): ");
            boolean ac = sc.nextLine().trim().equalsIgnoreCase("yes");
            System.out.print("AC charge: ");
            double acCharge = Double.parseDouble(sc.nextLine().trim());
            System.out.print("Wifi? (yes/no): ");
            boolean wifi = sc.nextLine().trim().equalsIgnoreCase("yes");
            System.out.print("Breakfast? (yes/no): ");
            boolean breakfast = sc.nextLine().trim().equalsIgnoreCase("yes");
            r = new StandardRoom(rn, bp, ac, acCharge, wifi, breakfast);
            System.out.println(r);
            System.out.println("Tariff via Room reference: " + r.calculateTariff());
        } else if (choice.equals("l")) {
            System.out.print("Room number: ");
            int rn = Integer.parseInt(sc.nextLine().trim());
            System.out.print("Base price: ");
            double bp = Double.parseDouble(sc.nextLine().trim());
            System.out.print("Number of amenities: ");
            int am = Integer.parseInt(sc.nextLine().trim());
            System.out.print("Charge per amenity: ");
            double pac = Double.parseDouble(sc.nextLine().trim());
            System.out.print("Premium service charge: ");
            double psc = Double.parseDouble(sc.nextLine().trim());
            System.out.print("Wifi? (yes/no): ");
            boolean wifi = sc.nextLine().trim().equalsIgnoreCase("yes");
            System.out.print("Breakfast? (yes/no): ");
            boolean breakfast = sc.nextLine().trim().equalsIgnoreCase("yes");
            r = new LuxuryRoom(rn, bp, am, pac, psc, wifi, breakfast);
            System.out.println(r);
            System.out.println("Tariff via Room reference: " + r.calculateTariff());
        } else {
            System.out.println("Skipping interactive creation.");
        }

        sc.close();
    }
}

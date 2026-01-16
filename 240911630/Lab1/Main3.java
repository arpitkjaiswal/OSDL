import java.util.Scanner;

class Room {
    private int roomNumber;
    private double baseTariff;

    public Room(int roomNumber, double baseTariff) {
        this.roomNumber = roomNumber;
        this.baseTariff = baseTariff;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public double getBaseTariff() {
        return baseTariff;
    }

    public double calculateTariff() {
        return baseTariff;
    }

    @Override
    public String toString() {
        return "Room " + roomNumber + " | Base Tariff: " + baseTariff;
    }
}

class StandardRoom extends Room {
    private boolean airConditioned;
    private double acCharge;

    public StandardRoom(int roomNumber, double baseTariff, boolean airConditioned, double acCharge) {
        super(roomNumber, baseTariff);
        this.airConditioned = airConditioned;
        this.acCharge = acCharge;
    }

    @Override
    public double calculateTariff() {
        double tariff = getBaseTariff();
        if (airConditioned) tariff += acCharge;
        return tariff;
    }

    @Override
    public String toString() {
        return "Standard " + super.toString() + " | AC: " + (airConditioned ? "Yes" : "No") + " | Tariff: " + calculateTariff();
    }
}

class LuxuryRoom extends Room {
    private int amenitiesCount;
    private double perAmenityCharge;
    private double premiumServiceCharge;

    public LuxuryRoom(int roomNumber, double baseTariff, int amenitiesCount, double perAmenityCharge, double premiumServiceCharge) {
        super(roomNumber, baseTariff);
        this.amenitiesCount = amenitiesCount;
        this.perAmenityCharge = perAmenityCharge;
        this.premiumServiceCharge = premiumServiceCharge;
    }

    @Override
    public double calculateTariff() {
        return getBaseTariff() + amenitiesCount * perAmenityCharge + premiumServiceCharge;
    }

    @Override
    public String toString() {
        return "Luxury " + super.toString() + " | Amenities: " + amenitiesCount + " | Tariff: " + calculateTariff();
    }
}

public class Main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Room r; 

        r = new StandardRoom(101, 1500.0, true, 200.0);
        System.out.println("Using Room reference for StandardRoom:");
        System.out.println(r.toString());
        System.out.println("Calculated tariff via Room reference: " + r.calculateTariff());
        System.out.println();

       
        r = new LuxuryRoom(201, 3000.0, 3, 250.0, 500.0);
        System.out.println("Using Room reference for LuxuryRoom:");
        System.out.println(r.toString());
        System.out.println("Calculated tariff via Room reference: " + r.calculateTariff());
        System.out.println();

      
        System.out.print("Create (s)tandard or (l)uxury room now? (s/l): ");
        String choice = sc.nextLine().trim().toLowerCase();
        if (choice.equals("s")) {
            System.out.print("Room number: ");
            int rn = Integer.parseInt(sc.nextLine().trim());
            System.out.print("Base tariff: ");
            double bt = Double.parseDouble(sc.nextLine().trim());
            System.out.print("AC? (yes/no): ");
            boolean ac = sc.nextLine().trim().equalsIgnoreCase("yes");
            System.out.print("AC charge: ");
            double acCharge = Double.parseDouble(sc.nextLine().trim());
            r = new StandardRoom(rn, bt, ac, acCharge);
            System.out.println("Created: " + r);
            System.out.println("Tariff via Room reference: " + r.calculateTariff());
        } else if (choice.equals("l")) {
            System.out.print("Room number: ");
            int rn = Integer.parseInt(sc.nextLine().trim());
            System.out.print("Base tariff: ");
            double bt = Double.parseDouble(sc.nextLine().trim());
            System.out.print("Number of amenities: ");
            int am = Integer.parseInt(sc.nextLine().trim());
            System.out.print("Charge per amenity: ");
            double pac = Double.parseDouble(sc.nextLine().trim());
            System.out.print("Premium service charge: ");
            double psc = Double.parseDouble(sc.nextLine().trim());
            r = new LuxuryRoom(rn, bt, am, pac, psc);
            System.out.println("Created: " + r);
            System.out.println("Tariff via Room reference: " + r.calculateTariff());
        } else {
            System.out.println("Skipping interactive creation.");
        }

        sc.close();
    }
}

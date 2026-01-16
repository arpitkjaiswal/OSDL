import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Room> list = new ArrayList<>();

        System.out.print("Create Room or DeluxeRoom? (r/d): ");
        String type = sc.nextLine().trim().toLowerCase();

        if (type.equals("r")) {
            System.out.print("Room number: ");
            int rn = Integer.parseInt(sc.nextLine());
            System.out.print("Room type: ");
            String rt = sc.nextLine();
            System.out.print("Base price: ");
            double p = Double.parseDouble(sc.nextLine());
            list.add(new Room(rn, rt, p));
        } else if (type.equals("d")) {
            System.out.print("Room number: ");
            int rn = Integer.parseInt(sc.nextLine());
            System.out.print("Room type: ");
            String rt = sc.nextLine();
            System.out.print("Base price: ");
            double p = Double.parseDouble(sc.nextLine());
            System.out.print("Free WiFi? (yes/no): ");
            boolean wifi = sc.nextLine().trim().equalsIgnoreCase("yes");
            System.out.print("Complimentary breakfast? (yes/no): ");
            boolean breakfast = sc.nextLine().trim().equalsIgnoreCase("yes");
            list.add(new DeluxeRoom(rn, rt, p, wifi, breakfast));
        } else {
            System.out.println("Invalid choice.");
        }

        System.out.println("\n--- Rooms ---");
        for (Room r : list) System.out.println(r);

        sc.close();
    }
}


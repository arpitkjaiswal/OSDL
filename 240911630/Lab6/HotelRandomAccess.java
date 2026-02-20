import java.io.*;
import java.util.*;

public class HotelRandomAccess {
    static final String FILE_NAME = "hotel.dat";
    static final int STRING_SIZE = 20;
    static final int RECORD_SIZE = 4 + (STRING_SIZE * 2) + 8 + 1; // 53 bytes

   
    static void writeString(RandomAccessFile raf, String s) throws IOException {
        for (int i = 0; i < STRING_SIZE; i++) {
            if (i < s.length())
                raf.writeChar(s.charAt(i));
            else
                raf.writeChar(' ');
        }
    }

    // Read fixed-length string
    static String readString(RandomAccessFile raf) throws IOException {
        char[] chars = new char[STRING_SIZE];
        for (int i = 0; i < STRING_SIZE; i++) {
            chars[i] = raf.readChar();
        }
        return new String(chars).trim();
    }

    // Add new room
    static void addRoom(int roomNo, String type, double price, boolean status) throws Exception {
        RandomAccessFile raf = new RandomAccessFile(FILE_NAME, "rw");
        long pos = (roomNo - 1) * RECORD_SIZE;
        raf.seek(pos);

        raf.writeInt(roomNo);
        writeString(raf, type);
        raf.writeDouble(price);
        raf.writeBoolean(status);

        raf.close();
        System.out.println("Room added successfully.");
    }

    // Display room details
    static void displayRoom(int roomNo) throws Exception {
        RandomAccessFile raf = new RandomAccessFile(FILE_NAME, "r");
        long pos = (roomNo - 1) * RECORD_SIZE;

        if (pos >= raf.length()) {
            System.out.println("Room not found.");
            raf.close();
            return;
        }

        raf.seek(pos);
        int rn = raf.readInt();
        String type = readString(raf);
        double price = raf.readDouble();
        boolean status = raf.readBoolean();
        raf.close();

        System.out.println("Room No: " + rn);
        System.out.println("Room Type: " + type);
        System.out.println("Price per Night: " + price);
        System.out.println("Booked: " + status);
    }

   
    static void updateStatus(int roomNo, boolean newStatus) throws Exception {
        RandomAccessFile raf = new RandomAccessFile(FILE_NAME, "rw");
        long pos = (roomNo - 1) * RECORD_SIZE + 4 + (STRING_SIZE * 2) + 8; 
        raf.seek(pos);
        raf.writeBoolean(newStatus);
        raf.close();
        System.out.println("Booking status updated.");
    }

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. Add Room");
            System.out.println("2. View Room");
            System.out.println("3. Book/Vacate Room");
            System.out.println("4. Exit");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Room Number: ");
                    int rn = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Room Type: ");
                    String type = sc.nextLine();
                    System.out.print("Price per Night: ");
                    double price = sc.nextDouble();
                    addRoom(rn, type, price, false);
                    break;

                case 2:
                    System.out.print("Enter Room Number: ");
                    displayRoom(sc.nextInt());
                    break;

                case 3:
                    System.out.print("Room Number: ");
                    int r = sc.nextInt();
                    System.out.print("true = Book, false = Vacate: ");
                    boolean st = sc.nextBoolean();
                    updateStatus(r, st);
                    break;

                case 4:
                    System.out.println("Exiting...");
                    System.exit(0);
            }
        }
    }
}

import java.io.*;
import java.util.*;

class Room implements Serializable{
    int roomNumber;
    String roomType;
    double price;
    boolean booked;
    String guest;

Room(int rn,String rt,double p, boolean b, String g){
    roomNumber=rn;
    roomType=rt;
    price=p;
    booked=b;
    guest=g;


}
void display(){
    System.out.println("\nRoom No: " + roomNumber);
    System.out.println("Type: " + roomType);
    System.out.println("Price: " + price);
    System.out.println("Booked: " + booked);
    System.out.println("Guest: " + guest);

   }
 }

public class Hotel {
    static  final String FILE="rooms.ser";
    static Room[] rooms=new Room[50];
    static int count=0;

    static void save() throws Exception{
        ObjectOutputStream os=new ObjectOutputStream(new FileOutputStream(FILE));
        os.writeInt(count);
        os.writeObject(rooms);
        os.close();


    }
    static void load() throws Exception{
        File f =new File(FILE);
        if(!f.exists()) return;
        ObjectInputStream ois=new ObjectInputStream(new FileInputStream(FILE));
        count =ois.readInt();
        rooms=(Room[]) ois.readObject();
        ois.close();
        

    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        try{
            load();
            while(true){
                System.out.println("\n1.Add Room");
                System.out.println("2.Display All");
                System.out.println("3.Search Room");
                System.out.println("4.Book/Vacate");
                System.out.println("5.Exit");
                int ch = sc.nextInt();

                switch (ch) {

                    case 1:
                        System.out.print("Room Number: ");
                        int rn = sc.nextInt();
                        sc.nextLine();

                        System.out.print("Room Type: ");
                        String type = sc.nextLine();

                        System.out.print("Price: ");
                        double price = sc.nextDouble();
                        sc.nextLine();

                        rooms[count++] =
                                new Room(rn, type, price, false, "None");

                        save();
                        System.out.println("Room added.");
                        break;

                    case 2:
                        for (int i = 0; i < count; i++)
                            rooms[i].display();
                        break;

                    case 3:
                        System.out.print("Enter room number: ");
                        int s = sc.nextInt();

                        boolean found = false;
                        for (int i = 0; i < count; i++) {
                            if (rooms[i].roomNumber == s) {
                                rooms[i].display();
                                found = true;
                            }
                        }

                        if (!found)
                            System.out.println("Room not found");
                        break;

                    case 4:
                        System.out.print("Room number: ");
                        int u = sc.nextInt();
                        sc.nextLine();

                        for (int i = 0; i < count; i++) {
                            if (rooms[i].roomNumber == u) {
                                System.out.print("Guest name: ");
                                rooms[i].guest = sc.nextLine();
                                rooms[i].booked = !rooms[i].booked;
                                System.out.println("Status updated.");
                            }
                        }

                        save();
                        break;

                    case 5:
                        System.exit(0);
                }
            }
            
        }catch (Exception e){
            System.out.println("Error:"+e);
        }
    }

}


                

                

                

                
            

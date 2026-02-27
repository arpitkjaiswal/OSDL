class Pair<T,U>{
    private T roomNumber;
    private U GuestName;

    public Pair(T r,U g){
        this.roomNumber = r;
        this.GuestName=g;

    }
    public T getroomNumber(){
        return roomNumber;
    }
    public U getGuestname(){
        return GuestName;
    }
    public void display(){
        System.out.println("Room number "+ roomNumber + "GuestName"+GuestName);
    }
}
public class RoomBooking {
    public static void mains(String args[]){
        Pair<Integer, String> b1 = new Pair<>(11, "Arpit");
        Pair<Integer, String> b2 = new Pair<>(15, "Neha");
        Pair<Integer, String> b3 = new Pair<>(39, "Rahul");
        b1.display();
        b2.display();
        b3.display();

        Integer room = b1.getroomNumber();
        String guest = b1.getGuestname();
        System.out.println("From getters  Room: " + room + ", Guest: " + guest);

    }
    
}

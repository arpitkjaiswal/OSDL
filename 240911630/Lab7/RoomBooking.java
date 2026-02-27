

class Pair<T, U> {
    private T first;   
    private U second; 

    public Pair(T first, U second) {
        this.first = first;
        this.second = second;
    }

    public T getFirst() {
        return first;
    }

    public U getSecond() {
        return second;
    }

    public void displayPair() {
        System.out.println("Room Number: " + first + ", Guest Name: " + second);
    }
}

public class RoomBooking {
    public static void main(String[] args) {

      
        Pair<Integer, String> booking1 = new Pair<>(101, "Arpit");
        Pair<Integer, String> booking2 = new Pair<>(205, "Neha");
        Pair<Integer, String> booking3 = new Pair<>(309, "Rahul");

        booking1.displayPair();
        booking2.displayPair();
        booking3.displayPair();

       
        Integer room = booking1.getFirst();   
        String guest = booking1.getSecond(); 

     System.out.println("From getters Room: " + room + ", Guest: " + guest);
    }
}
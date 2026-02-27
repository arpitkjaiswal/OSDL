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

    public void displayBooking() {
        System.out.println("Room Number : " + first);
        System.out.println("Guest Name  : " + second);
        System.out.println("---------------------------");
    }
}

public class billingsystem {
    public static void main(String[] args) {
        Pair<Integer, String> booking1 =
                new Pair<>(101, "Rahul");
        Pair<Integer, String> booking2 =
                new Pair<>(102, "Ananya");
        Pair<Integer, String> booking3 =
                new Pair<>(103, "Vikram");
        booking1.displayBooking();
        booking2.displayBooking();
        booking3.displayBooking();
    }
}
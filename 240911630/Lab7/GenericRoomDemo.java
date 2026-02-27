class Room<T, U> {

    private T roomId;
    private U roomDetail;

    public Room(T roomId, U roomDetail) {
        this.roomId = roomId;
        this.roomDetail = roomDetail;
    }

    public T getRoomId() {
        return roomId;
    }

    public U getRoomDetail() {
        return roomDetail;
    }

    public void displayRoom() {
        System.out.println("Room ID/Number : " + roomId);
        System.out.println("Room Detail    : " + roomDetail);
        System.out.println("----------------------------");
    }
}

public class GenericRoomDemo {

    public static void main(String[] args) {
        Room<Integer, String> room1 =
                new Room<>(101, "Deluxe");

        Room<String, Double> room2 =
                new Room<>("A202", 4500.0);

        Room<Integer, Double> room3 =
                new Room<>(303, 6000.0);

        room1.displayRoom();
        room2.displayRoom();
        room3.displayRoom();
    }
}
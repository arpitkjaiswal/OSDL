class HotelRoomManagement {

    public static <T> void display(T data) {
        System.out.println("Value: " + data);
    }

    public static void main(String[] args) {
        Integer roomNumber = 101;
        String roomType = "Deluxe";
        Double price = 4500.0;
        Boolean isBooked = true;
        display(roomNumber);
        display(roomType);
        display(price);
        display(isBooked);
    }
}
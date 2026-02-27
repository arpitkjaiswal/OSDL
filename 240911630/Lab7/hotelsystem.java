class HotelRoomArrayManager {

    public static <T> void printArray(T[] array) {

        for (T element : array) {
            System.out.print(element + " ");
        }
        System.out.println();
        System.out.println("----------------------------");
    }

    public static void main(String[] args) {

        Integer[] roomNumbers = {101, 102, 103, 104};
        String[] roomTypes = {"Single", "Double", "Deluxe", "Suite"};
        Double[] roomPrices = {2500.0, 3500.0, 4500.0, 6000.0};
        System.out.println("Room Numbers:");
        printArray(roomNumbers);
        System.out.println("Room Types:");
        printArray(roomTypes);
        System.out.println("Room Prices:");
        printArray(roomPrices);
    }
}
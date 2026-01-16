
class Room {
    private int roomNumber;
    private String roomType;
    private double basePrice;

    public Room(int roomNumber, String roomType) {
        this(roomNumber, roomType, 0.0);
    }

    public Room(int roomNumber, String roomType, double basePrice) {
        this.roomNumber = roomNumber;
        this.roomType = roomType;
        setBasePrice(basePrice);
    }

    public void setBasePrice(double basePrice) {
        if (basePrice > 0) this.basePrice = basePrice;
        else this.basePrice = 0.0;
    }

    @Override
    public String toString() {
        return "Room " + roomNumber + " | " + roomType + " | Price: " + basePrice;
    }
}

class DeluxeRoom extends Room {
    private boolean freeWifi;
    private boolean complimentaryBreakfast;

    public DeluxeRoom(int roomNumber, String roomType, boolean freeWifi, boolean complimentaryBreakfast) {
        super(roomNumber, roomType);
        this.freeWifi = freeWifi;
        this.complimentaryBreakfast = complimentaryBreakfast;
    }

    public DeluxeRoom(int roomNumber, String roomType, double basePrice, boolean freeWifi, boolean complimentaryBreakfast) {
        super(roomNumber, roomType, basePrice);
        this.freeWifi = freeWifi;
        this.complimentaryBreakfast = complimentaryBreakfast;
    }

    @Override
    public String toString() {
        return super.toString() + " | WiFi: " + (freeWifi ? "Yes" : "No") + " | Breakfast: " + (complimentaryBreakfast ? "Yes" : "No");
    }
}


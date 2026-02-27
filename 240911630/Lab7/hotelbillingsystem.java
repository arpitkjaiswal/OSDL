class RoomCharges<T extends Number> {

    private T price;
    private T discount;

    public RoomCharges(T price, T discount) {
        this.price = price;
        this.discount = discount;
    }

    public double getTotalPrice() {
        return price.doubleValue();
    }

    public double getDiscountedPrice() {
        return price.doubleValue() - discount.doubleValue();
    }

    public void displayDetails() {
        System.out.println("Room Price       : " + price);
        System.out.println("Discount         : " + discount);
        System.out.println("Total Price      : " + getTotalPrice());
        System.out.println("Discounted Price : " + getDiscountedPrice());
        System.out.println("------------------------------");
    }
}

public class hotelbillingsystem {

    public static void main(String[] args) {

        RoomCharges<Integer> room1 =
                new RoomCharges<>(5000, 500);

        RoomCharges<Double> room2 =
                new RoomCharges<>(4500.50, 300.25);

        room1.displayDetails();
        room2.displayDetails();
    }
}
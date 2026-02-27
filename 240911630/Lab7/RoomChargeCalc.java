class RoomP< T extends  Number>{
    private T roomprice;
    private T discount;
    public RoomP(T roomprice,T discount){
        this.roomprice=roomprice;
        this.discount=discount;

    }
    public Double getPrice(){
        return roomprice.doubleValue();
    }
    public double Discount(){
        return roomprice.doubleValue() - discount.doubleValue();
    }
    public void displayDetails(){
        System.out.println("Room price: " + roomprice);
        System.out.println("Discount: " + discount);
        System.out.println("Total price: " + getPrice());
        System.out.println("Discounted price: " + Discount());
    }

}


public class RoomChargeCalc {
    public static void main(String args[]){
        RoomP <Double> R1=new RoomP<>(450000.0,4000.0);
        R1.displayDetails();
        RoomP <Integer> R2=new RoomP<>(345000,3489);
        R2.displayDetails();

    }
    
}

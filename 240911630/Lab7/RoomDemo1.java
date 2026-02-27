class Room<T,U>{
    private T  roomId;
    private U attribute;
    public Room(T roomId, U attribute){
        this.roomId=roomId;
        this.attribute=attribute;

    }
    public T getRoomId(){
        return roomId;
    }
    public U getprice(){
        return attribute;
    }
    public void displayDetails(){
        System.out.println("Room ID : "+ roomId +",Price :"+attribute);
    }

}
public class RoomDemo1{
    public static void main(String args[]){
        Room<Integer,String> r1=new Room<>(430,"Royal Suite");
        Room<String,Double> r2=new Room<>("A-20",3456.99);
        Room<Integer,Double> r3=new Room<>(24,5699.78);
        r1.displayDetails();
        r2.displayDetails();
        r3.displayDetails();





    }
}
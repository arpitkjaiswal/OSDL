public class RoomDemo2 {
    public static <T> void display(T data){
        System.out.println(((data)));
    }
 public static void main(String args[]){
    Integer RoomNumber=405;
    String RoomType="Royal Suite";
    Double price=250000.00;
    Boolean status=true;

    display(RoomNumber);
    display(RoomType);
    display(price);
    display(status);


 }   
}

public class RoomArray {
    public static <T> void takes(T[] a){
        for(T i: a){
            System.out.println(i);
        }
    }
    public static void main(String  args[]){
        Integer[] n={12,34,56,78};
        String[] t={"Suite","Deleux","Royal Suite","Empathy Suite"};
        Double[] p={3456.00,4567.00,7890.00,3452.00};
        System.out.println("Room Numbers:");
        takes(n);
        System.out.println("Room Types:");
        takes(t);
        System.out.println("Room Prices:");
        takes(p);

    }
    
}

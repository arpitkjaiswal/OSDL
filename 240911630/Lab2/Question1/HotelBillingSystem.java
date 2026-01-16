package Question1;

import java.util.*;
public class HotelBillingSystem {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter room tariff (per day): ");
        int roomTariffPrimitive=sc.nextInt();
         

        System.out.print("Enter number of days Stayed");
        int daysPrimitive=sc.nextInt();

        System.out.print("Enter service Charges: ");
        double serviceChargesPrimitive=sc.nextDouble();

          //Autoboxing
        Integer roomTariff =roomTariffPrimitive;
        Integer daysStayed=daysPrimitive;
        Double serviceCharge =serviceChargesPrimitive;
   
        //Unboxing
        int tariff=roomTariff;
        int days =daysStayed;
        double service=serviceCharge;



        double totalBill=(tariff*days)+service;

        System.out.println("\n--- Hotel Bill Details ---");
        System.out.println("Room Tariff (per day): " + tariff);
        System.out.println("Number of Days Stayed: " + days);
        System.out.println("Service Charges: " + service);
        System.out.println("Total Bill Amount: " + totalBill);
        
        sc.close();
        
    }


}
    


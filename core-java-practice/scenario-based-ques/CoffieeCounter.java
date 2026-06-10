import java.util.*;

public class CoffieeCounter {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String coffeeType = sc.nextLine();
        HashMap<String, Integer> menu = new HashMap<>();
        menu.put("Espresso", 100);
        menu.put("Latte", 150);
        menu.put("Cappuccino", 120);
        menu.put("Americano", 110);
        int quantity = sc.nextInt();
        int basebill = menu.get(coffeeType) * quantity;
        double gst = basebill * 0.18;
        double totalbill = basebill + gst;
        System.out.println("Base bill: " + basebill);
        System.out.println("GST (18%): " + gst);
        System.out.println("Total bill: " + totalbill);
    }
}

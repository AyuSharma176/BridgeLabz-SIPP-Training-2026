import java.util.*;

public class VehicleParking {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        List<String> vehicleList=new ArrayList<>();
        
            String status=sc.next();
            String vehicleNo=sc.nextLine();
            
            if(status.equals("entry")){
                vehicleList.add(vehicleNo);
            }
            else if(status.equals("exit")){
                vehicleList.remove(vehicleNo);
            }
        
    }
}

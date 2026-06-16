
import java.util.*;
public class BMICalculator {
    public static String getStatus(double bmi){
        if(bmi<18.5) return "Underweight";
        if(bmi<25) return "Normal";
        if(bmi<30) return "Overweight";
        return "Obese";
    }
    public static String[][] process(double[][] data){
        String[][] result=new String[data.length][4];
        for(int i=0;i<data.length;i++){
            double w=data[i][0], h=data[i][1]/100.0;
            double bmi=w/(h*h);
            result[i][0]=String.valueOf(data[i][1]);
            result[i][1]=String.valueOf(w);
            result[i][2]=String.format("%.2f",bmi);
            result[i][3]=getStatus(bmi);
        }
        return result;
    }
    public static void main(String[] args){}
}
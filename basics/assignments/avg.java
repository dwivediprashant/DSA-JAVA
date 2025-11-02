import java.util.*;
public class avg {
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        //average of three number--
        System.out.print("Enter 3 values : ");
        int num1=sc.nextInt();
        int num2=sc.nextInt();
        int num3=sc.nextInt();
        int avg=num1+num2+num3;
        avg=avg/3;
        System.out.print("Avrage : "+ avg);
        sc.close();
    }
    
}
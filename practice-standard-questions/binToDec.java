import java.util.*;
public class binToDec {
    public static void binToDecimal(int bin){
        int pow=1;
        int decimal=0;
        int lastDig;
        while(bin>0){
            lastDig=bin%10;
            decimal+=lastDig*pow;
            bin/=10;
            pow*=2;
        }
        System.out.print("Decimal value = "+decimal);
    }
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter binary value :");
        int bin=sc.nextInt();
        binToDecimal(bin);
    }
    
}
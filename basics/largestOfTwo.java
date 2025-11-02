import java.util.*;
public class largestOfTwo {
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter two numbbers : ");
        int num1=sc.nextInt();
        int num2=sc.nextInt();
        if(num1>num2){
            System.out.print(num1 + " is larger .");
        }else{
            System.out.print(num2 + " is larger .");
        }
        sc.close();
    }
    
}
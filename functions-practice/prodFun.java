import java.util.*;
public class prodFun{
    public static int product(int num1,int num2){
        return num1*num2;
    }
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter first num :");
        int num1=sc.nextInt();
        System.out.print("Enter second num :");
        int num2=sc.nextInt();
        System.out.print(product(num1,num2)); 
        sc.close();
    }
    
}
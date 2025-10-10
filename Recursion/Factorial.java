import java.util.*;
public class Factorial {
    public static int fact(int n){
        if(n==0){
            return 1;
        }
        int factN=fact(n-1);
        int fact=n*factN;
        return fact;
    }
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter a number : ");
        int n=sc.nextInt();
        System.out.print("Factorial : "+fact(n));
    }
    
}
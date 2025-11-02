import java.util.*;
public class Fibonacci {
    public static int fibonacci(int n){
        if(n==0 || n==1){
            return n;
        }
        return fibonacci(n-1)+fibonacci(n-2);
        
    }
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter index : ");
        int n=sc.nextInt();
        System.out.print(fibonacci(n));
        sc.close();
    }
    
}
import java.util.*;
public class Power {
    public static int pow(int x,int n){
        if(n==1){
            return x;
        }
        return x*pow(x,n-1);
        
    }
    public static int optimizePow(int x, int n){
        if(n==1){
            return x;
        }
        int half=optimizePow(x,n/2);
        if(n%2==0){
            return half*half;
        }
        return x*half*half;
    }
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int x=2;
        int n=2147483647;
        System.out.print(optimizePow(x,n));
    }
    
}
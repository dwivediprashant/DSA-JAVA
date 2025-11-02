import java.util.*;
public class Pairing {
    public static int pair(int n){
        
        return (n-1)*pairFriendsWays(n-2);
    }
    public static int single(int n){
        
        return pairFriendsWays(n-1);
    }
    public static int pairFriendsWays(int n){
        if(n==1 || n==2){
            return n;
        }
       
        return single(n)+pair(n);
    }
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int n=5;
        System.out.print(pairFriendsWays(n));
        sc.close();
    }
    
}
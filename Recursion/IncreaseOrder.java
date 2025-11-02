import java.util.*;
public class IncreaseOrder {
    public static void print(int st,int n){
        if(st==n){
            System.out.print(n+" ");
            return;
        }
        System.out.print(st+" ");
        print(st+1,n);
    }
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter start number : ");
        int st=sc.nextInt();
        System.out.print("Enter end number : ");
        int n=sc.nextInt();
        print(st,n);
        sc.close();
    }
    
}
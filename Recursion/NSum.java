import java.util.*;
public class NSum {
    public static int SumOfN(int n){
        if(n==1){
            return 1;
        }
        int snm1=SumOfN(n-1);
        int sn=n+snm1;
        return sn;
    }
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter limit : ");
        int n=sc.nextInt();
        System.out.print("Sum = "+SumOfN(n));
        sc.close();
    }
    
}
import java.util.*;
public class revNum  {
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter a number: ");
        int num=sc.nextInt();
        int reverse=0;
        while(num>0){
            int rem=num%10;
            reverse=reverse*10 + rem;
            num/=10;
        }
        System.out.print(reverse);
    }
    
}
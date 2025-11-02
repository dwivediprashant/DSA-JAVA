import java.util.*;
public class pallindrome {
    public static boolean isPallinderome(int num){
        int reverse=0;
        int copyNum=num;
        int rem;
        while(copyNum>0){
            rem=copyNum%10;
            reverse*=10;
            reverse+=rem;
            
            copyNum/=10;
        }
        return reverse==num;
    }
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter a number : ");
        int num=sc.nextInt();
        System.out.print(isPallinderome(num));
        sc.close();
    }
    
}
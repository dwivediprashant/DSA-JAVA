import java.util.*;
public class printRevOfNum {
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter a number: ");
        int num=sc.nextInt();
        System.out.print("Reverse of number : ");
        while(num>0){
            
            System.out.print(num%10);
            num/=10;
        }
    }
    
}
import java.util.*;
public class factorial {
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter a number :");
        int num=sc.nextInt();
        if(num==1 || num==0){
            System.out.print("factorial of "+num+" is : 1");
        }
        int fact=1;
        while(num>1){
            fact*=num;
            num--;
        }
        System.out.print("factorial is "+ fact);
        sc.close();
    }
    
}
import java.util.*;
public class largestOfThree {
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int num1=sc.nextInt();
        int num2=sc.nextInt();
        int num3=sc.nextInt();

        if(num1>num2 && num1>num3){
            System.out.print(num1+" is largest.");
        }else {
            if(num2>num3){
                System.out.print(num2+" is largest.");
            }else{
                System.out.print(num3+" is largest.");
            }
        }
    }
    
}
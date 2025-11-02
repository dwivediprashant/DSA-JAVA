import java.util.*;
public class primeNum {
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter a number :");
        int num=sc.nextInt();
        if(num==2){
            System.out.print(num + " is a prime.");
        }else{
                boolean isPrime=false;
                for(int i=2;i<=Math.sqrt(num);i++){
                    if(num%i==0){
                        System.out.print(num +" is not a prime.");
                        isPrime=true;
                        break;
                    }
                }
                if(!isPrime)
                System.out.print(num +" is a prime number.");
        }
        sc.close();
        
    }
    
}
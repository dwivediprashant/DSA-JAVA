import java.util.*;
public class primeInRange {
     public static boolean checkPrime(int num){
        if(num==2 ){
            return true;
        }
        for(int i=2;i<=Math.sqrt(num);i++){
            if(num%i==0){
                return false;
            }
        }
        return true;
    }
    public static void checkPrimeInRng(int rng){
        
        for(int i=2;i<=rng;i++){
            if(checkPrime(i)){
                System.out.print(i+"\n");
            }
        }
    }
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter a range :");
        int rng=sc.nextInt();
        checkPrimeInRng(rng);
        sc.close();
    }
    
}
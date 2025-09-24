import java.util.*;
public class subArr {
    public static void subArr(int [ ] arr){
        int ts=0;
        int sumSubArr=0;
        for(int start=0;start<arr.length;start++){
            
            for(int end=start;end<arr.length;end++){
                System.out.print(" { ");
                sumSubArr=0;
                for(int k=start;k<=end;k++){
                    System.out.print( arr[k]+ "  ");
                    sumSubArr+=arr[k];
                }
                ts++;
                System.out.print(" } ");
                System.out.println("Sum of this sub arrays: "+ sumSubArr);
            }
            
        }
        System.out.println("Total sub arrays: "+ ts);
        
    }
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int[] arr={1,2,3,4,5};
        subArr(arr);
    }
    
}
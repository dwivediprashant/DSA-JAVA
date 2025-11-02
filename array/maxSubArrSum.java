import java.util.*;
public class maxSubArrSum {
    public static void maxMinSubArr(int [ ] arr){
        int sumSubArr=0;
        int maxSubArrSum=arr[0];
        int minSubArrSum=arr[0];
        for(int start=0;start<arr.length;start++){
            
            for(int end=start;end<arr.length;end++){
                // System.out.print(" { ");
                sumSubArr=0;
                for(int k=start;k<=end;k++){
                    // System.out.print( arr[k]+ "  ");
                    sumSubArr+=arr[k];
                }
                // ts++;
                // System.out.print(" } ");
                // System.out.println("Sum of this sub arrays: "+ sumSubArr);
                if(sumSubArr>maxSubArrSum){
                    maxSubArrSum=sumSubArr;
                }
                if(sumSubArr<minSubArrSum){
                    minSubArrSum=sumSubArr;
                }
            }
            
        }
        // System.out.println("Total sub arrays: "+ ts);
        System.out.println("Maximum sum of sub array : "+ maxSubArrSum);
        System.out.print("Minimum sum of sub array : "+ minSubArrSum);

    }
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int[] arr={-17,10,-45,34,21,12};
        maxMinSubArr(arr);
        sc.close();
    }
    
}
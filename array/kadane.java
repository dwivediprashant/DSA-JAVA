import java.util.*;
public class kadane {
    //kadane approach for max subarray sum
    public static int kadane(int[]arr){
        int maxSum=Integer.MIN_VALUE;
        int currSum=0;
        for(int i=0;i<arr.length;i++){
            currSum+=arr[i];
            if(currSum>maxSum){//these 2 if case's order matters
                maxSum=currSum;
            }
            if(currSum<0){
                currSum=0;
            }
            
        }
        return maxSum;
    }
    //kadane for min sum subaarray
    public static int kadaneForMin(int[]arr){
        int minSum=Integer.MAX_VALUE;
        int currSum=0;
        for(int i=0;i<arr.length;i++){
            currSum+=arr[i];
            if(currSum<minSum){//these 2 if case's order matters
                minSum=currSum;
            }
            if(currSum>0){
                currSum=0;
            }
            
        }
        return minSum;
    }
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int[] arr={-2,-4,-3,-2,-1,-14};
        System.out.println("Maximum sum among all subarray : "+kadane(arr));
        System.out.print("Minimum sum among all subarray : "+kadaneForMin(arr));
    }
    
}
import java.util.*;
public class prefixSumForMaxSubArrSum {
    public static int[] getPrefixSum(int[]arr){
        int prefixSum[]= new int[arr.length];
        prefixSum[0]=arr[0];
        for(int i=1;i<arr.length;i++){
            prefixSum[i]=arr[i]+prefixSum[i-1];
        }
        return prefixSum;
    }
    public static void maxSubArrSum(int[] arr,int [ ] prefixSum){
        int max=arr[0];
        int min=arr[0];
        for(int i=0;i<arr.length;i++){
            
            for(int j= i;j<arr.length;j++){
                int currSum=i==0?prefixSum[j]:prefixSum[j]-prefixSum[i-1];
                if(currSum>max){
                    max=currSum;
                }
                if(currSum<min){
                    min=currSum;
                }
            }
        }
        System.out.println("maximum sum among all subarrays : "+ max);
        System.out.println("minimum sum among all subarrays : "+ min);
    }
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int [] arr= {-2,-3,4,-1,-2,1,5,-3};
        int[] prefixSum=getPrefixSum(arr);
        // System.out.print(prefixSum);
        maxSubArrSum(arr,prefixSum);
        sc.close();
        
    }
    
}
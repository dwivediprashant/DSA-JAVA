import java.util.*;
public class reverseArr {
    public static void reverse(int[] arr){
        int left=0;
        int right=arr.length-1;
        int temp;
        while(left<right){
            temp=arr[left];
            arr[left]=arr[right];
            arr[right]=temp;
            left++;
            right--;
        }
    }
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int[] arr={34,45,65,67,21};
        
        reverse(arr);
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }
    
}
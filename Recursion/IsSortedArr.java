import java.util.*;
public class IsSortedArr {
    public static boolean isSorted(int[]arr,int i){
        if(i==arr.length-1){
            return true;
        }
        if(arr[i]<=arr[i+1]){
            return isSorted(arr,i+1);
        }
        return false;
    }
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int[]arr={7,8,8,8,8};
        System.out.print(isSorted(arr,0));
    }
    
}
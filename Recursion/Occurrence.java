import java.util.*;
public class Occurrence {
    public static void getIndices(int[]nums, int idx,int key){
        if(idx==nums.length){
            return;
        }
        getIndices(nums,idx+1,key);
        if(nums[idx]==key){
            System.out.println(idx);
            return;
        }

    }
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int[] nums= {3,2,4,5,6,2,7,2,2};
        int key=2;
        getIndices(nums,0,key);
    }
    
}
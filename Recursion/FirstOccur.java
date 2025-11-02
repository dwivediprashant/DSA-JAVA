import java.util.*;
public class FirstOccur {
    public static int firstOccur(int[]arr,int key,int i){
        if(i==arr.length){
            return -1;
        }
        if(arr[i]==key){
            return i;
        }

        return firstOccur(arr,key,i+1);
    }
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int[] arr={8,5,6,7,3,12,4,5,45,3};
        int key=45;
        System.out.print(firstOccur(arr,key,0));
        sc.close();
    }
    
}
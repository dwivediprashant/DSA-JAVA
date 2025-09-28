import java.util.*;
public class counting {
    public static void countingSort(int[] arr){
        //finding max elemnt to decide size of freq array
        int max=Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++){
            if(arr[i]>max){
                max=arr[i];
            }
        }
        //freq storing
        int[] freq=new int[max+1];
        for(int i=0;i<arr.length;i++){
            freq[arr[i]]++;
        }
        //sorting
        int j=0;
        for(int i=0;i<freq.length;i++){
            while(freq[i]>0){
                arr[j]=i;
                j++;
                freq[i]--;
            }
        }
    }
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int[] arr={4,4,0,6,3,1,1,4};
        countingSort(arr);
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }
    
}
import java.util.*;
public class insertion {
    public static void insertionSort(int [] arr){
        for(int i=1;i<arr.length;i++){
            int curr=arr[i];
            int prev=i-1;
            while(prev>=0 && arr[prev]>curr){
                arr[prev+1]=arr[prev];//shifting to rightwards
                prev--;
            }
            arr[prev+1]=curr;
        }
    }
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int [] arr={4,5,-2,0,-2,3};
        insertionSort(arr);
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+ "  ");
        }
        sc.close();
    }
    
}
import java.util.*;
public class QuickSort {
    public static int partition(int[] arr,int si,int ei) {
        int pivot=arr[ei];
        int i=si-1;
        //comapring from original aray and swap in original array
        for(int j=si;j<=ei;j++){
            if(arr[j]<=pivot){
                i++;
                int temp=arr[j];
                arr[j]=arr[i];
                arr[i]=temp;
            }
        }
        return i;
    }
    public static void quickSort(int[]arr,int si,int ei){
        if(si>=ei){
            return;
        }
        int pIdx= partition(arr,si,ei);
        quickSort(arr, si, pIdx-1);
        quickSort(arr, pIdx+1, ei);
    }
    public static void printArr(int[]arr){
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
    }
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int[]arr={0,-3,-3,8,-8,8,12};
        quickSort(arr,0,arr.length-1);
        printArr(arr);
        sc.close();
    }
}

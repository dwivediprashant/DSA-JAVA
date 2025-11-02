import java.util.*;
public class binarySearch {
    public static int binSearch(int arr[],int key,int n){
        int left=0;
        int right=n-1;
        int mid= left+(right-left)/2;
        while(left<=right){
            if(arr[mid]==key){
                return mid;
            }
            if(arr[mid]>key){
                right=mid-1;
            }else{
                left=mid+1;
            }
            mid= left+(right-left)/2;
        }
        return -1;
    }
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        // int arr[]=new int[5];
        int n=5;
        int arr[]={4,7,12,32,39};
        int key=11;
        int idx=binSearch(arr,key,n);
        if(idx==-1){
            System.out.print(key+ " not found!");
        }else{
            System.out.print(key+ " found at index "+ idx);
        }
        sc.close();
    }
    
}
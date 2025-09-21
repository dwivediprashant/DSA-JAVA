import java.util.*;
public class linearSearch {
    public static int linearSearch(int arr[],int key){
        for(int i=0;i<arr.length;i++){
            if(arr[i]==key){
                return i;
            }
        }
        return -1;
    }
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int arr[]= {44,56,32,11,89,78};
        int key=78;
        System.out.print(linearSearch(arr,key));

    }
    
}
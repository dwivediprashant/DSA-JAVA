import java.util.*;
public class LastOccur {
    public static int lastOccur(int[]arr,int key,int i){
        if(i==arr.length){
            return -1;
        }
        int isFound=lastOccur(arr,key,i+1);
        if(isFound==-1 && arr[i]==key){
            return i;
        }
        return isFound;
    }
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int[]arr={5,5,5,5};
        int key=5;
        System.out.print(lastOccur(arr,key,0));
        sc.close();
    }
    
}
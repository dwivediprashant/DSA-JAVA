import java.util.*;
public class Tiling {
    public static int fillTiles(int n){
        if(n==0 || n==1){
            return 1;
        }
        //vertical filling + horizontal filling
        return fillTiles(n-1)+fillTiles(n-2);
    }
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int n=4;
        System.out.print(fillTiles(n));
        sc.close();
    }
    
}
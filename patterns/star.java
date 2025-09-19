import java.util.*;
public class star {
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.print("How many rows u want to print : ");
        int rows=sc.nextInt();
        for(int i=0;i<rows;i++){
            for(int j=i;j>=0;j--){
                System.out.print("* ");
            }
            System.out.println();
        }
    }
    
}
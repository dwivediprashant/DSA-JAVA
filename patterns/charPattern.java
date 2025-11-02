import java.util.*;
public class charPattern {
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int rows=sc.nextInt();
        // A=65 ascii value
        // char A='A';
        // System.out.println(A+1);
        // int A='A';
        // System.out.print(A);
        char A='A';
        for(int i=0;i<rows;i++){
            for(int j=0;j<=i;j++){
                System.out.print(A++ + " ");
            }
            System.out.println();
        }
        sc.close();
    }
    
}